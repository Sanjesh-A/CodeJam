package Practice2020;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ngram {
    int getMatchingCount(String str1, String str2, int n){
        HashSet<String> hset = new HashSet<>();
        String[] ngrams2 = str2.split(" ");
        for(int i=0; i + n -1 < ngrams2.length; i++ ){
            String ngram = getNgram(n, ngrams2, i);
            hset.add(ngram);
        }

        String[] ngrams1 = str1.split(" ");
        int count =0;
        for(int i=0; i + n -1 < ngrams1.length; i++ ){
            String ngram = getNgram(n, ngrams1, i);
            if(hset.contains(ngram))
                count++;
        }

        return count;

    }

    private String getNgram(int n, String[] ngrams2, int i) {
        String ngram = "";
        for (int j = 0; j < n; j++) {
            ngram += ngrams2[i + j];
        }
        return ngram;
    }
}
