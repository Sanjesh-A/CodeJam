package TwoSigma;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {



    // Complete the friendCircles function below.
    static int friendCircles(List<String> friends) {
        int n = friends.size();
        List<HashSet<Integer>> friendSetList = new ArrayList<HashSet<Integer>>(n);
        for(int i = 0; i < n; i++){
            HashSet<Integer> hashSet = new HashSet<Integer>();
            hashSet.add(i);
            friendSetList.add(i, hashSet);
        }

        for(int i=0; i < n; i++){
            char[] friend = friends.get(i).toCharArray();
            for(int j = 0; j < n; j++){
                if(j == i)
                    continue;

                if(friend[j] == 'Y'){
                    mergeSets(i,j, friendSetList);
                }
            }
        }

        Set<HashSet<Integer>> setOfFriendSets = new HashSet<>();
        for(HashSet<Integer> friendSet : friendSetList){
            if(!setOfFriendSets.contains(friendSet)){
                setOfFriendSets.add(friendSet);
            }
        }

        return setOfFriendSets.size();


    }

    private static void mergeSets(int i, int j, List<HashSet<Integer>> friendSetList) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.addAll(friendSetList.get(i));
        hashSet.addAll(friendSetList.get(j));
        for(int k : hashSet){
            friendSetList.remove(k);
            friendSetList.add(k, hashSet);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int friendsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> friends = new ArrayList<>();

        IntStream.range(0, friendsCount).forEach(i -> {
            try {
                friends.add(bufferedReader.readLine());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = friendCircles(friends);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
