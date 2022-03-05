package TwoSigma2;

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



class Result {

    /*
     * Complete the 'longestChain' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY words as parameter.
     */

    private static Map<String, Integer> cache = new HashMap<>();
    public static int longestChain(List<String> words) {
        int n = words.size();
        List<String> sortedWords = new ArrayList<>();
        for(String word: words){
            char[] cstr = word.toCharArray();
            Arrays.sort(cstr);
            String sortedWord = new String(cstr);
            sortedWords.add(sortedWord);
        }

        sortedWords.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        int max = 0;
        for(String word: sortedWords){
            int len = getChainLength(word);
            if(len > max)
                max = len;
        }

        // Write your code here
        return max;

    }

    public static int getChainLength(String word){
        if(word.length() == 1){
            cache.put(word,1);
            return 1;
        }

        char[] cstr = word.toCharArray();
        Arrays.sort(cstr);
        for(int i=0; i< word.length(); i++){
            String newWord = remove(cstr,i);
            if(cache.containsKey(newWord)){
                int len = cache.get(newWord);
                cache.put(word, len+1);
                return len +1;
            }
        }

        return 0;

    }

    private static String remove(char[] cstr, int i) {
        String str = "";
        for(int x = 0; x< cstr.length; x++){
            if(x == i)
                continue;
            str = str + cstr[x];
        }
        return str;
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int wordsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> words = IntStream.range(0, wordsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int result = Result.longestChain(words);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

