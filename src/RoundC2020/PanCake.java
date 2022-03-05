package RoundC2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class PanCake {

    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int i = 0; i < nTestCases; i++) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            long[] sectors = new long[n];
            Map<Long, Integer> freq = new HashMap<>();

            for(int j=0; j<n; j++){
                long angle = sc.nextLong();
                sectors[j] = angle;
                int count = freq.containsKey(angle) ? freq.get(angle) : 0;
                freq.put(angle, count + 1);
            }

            Map<Integer, Long> countSect = invert(freq);

            countSect.entrySet()
                    .stream()
                    .sorted(Map.Entry.<Integer, Long>comparingByKey().reversed());

            int mostSects = countSect.keySet()
                                .stream()
                                .findFirst()
                                .get();
            int numCuts = 0;
            Map<Long, Map<Long, Integer>> multiples = new HashMap<>();
            if(mostSects < d){
                int x =0;
                int y = 0;
                for (long isect: countSect.values()) {
                    y =0;
                    Map<Long, Integer> hm = new HashMap<>();
                    multiples.put(isect, hm);
                    for(Map.Entry<Integer, Long> entry : countSect.entrySet()){
                        long val = entry.getValue();
                        if(val % isect == 0){
                            hm.put(val/isect, entry.getKey());
                        }

                        y++;
                    }
                    x++;
                }
            }
            System.out.println("Case #"+ (i+1) + ": " + numCuts );
        }
    }

    public static <V, K> Map<V, K> invert(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }
}
