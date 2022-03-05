package PracticeCoding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AlienRythm {

    private static class TrieNode {
        TrieNode[] alphabet = new TrieNode[26];
        char value;
        int count;
        boolean endOfString;
    }

    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int i = 0; i < nTestCases; i++) {
            int n = sc.nextInt();
            String[] input = new String[n];
            for(int j=0; j < n; j++){
                input[j] = sc.next();
            }
            int np = solve(input, n);
            System.out.println("Case #"+ (i+1) + ": " + np);
        }
    }

    public static int solve(String[] input, int n) {
        TrieNode suffixTrie = new TrieNode();
        for (String str : input) {
            String rev = new StringBuilder(str).reverse().toString();
            TrieNode trieNode = suffixTrie;
            for (char c: rev.toUpperCase().toCharArray()) {
                if(trieNode.alphabet[c-'A'] == null) {
                    trieNode.alphabet[c - 'A'] = new TrieNode();
                }
                trieNode.alphabet[c-'A'].value = c;
                trieNode.alphabet[c-'A'].count++;
                trieNode = trieNode.alphabet[c-'A'];
            }
            trieNode.endOfString = true;
        }
        int sum = preOrder(suffixTrie);

        return sum;
    }

    private static int preOrder(TrieNode suffixTrie) {
        int sum = 0;
        for(TrieNode tnode: suffixTrie.alphabet){
            if(tnode != null){
                if(tnode.count >= 4) {
                    int t = preOrder(tnode);
                    if(tnode.count - t >= 2 ){
                        sum = sum + t + 2;
                    } else {
                        sum = sum + t;
                    }
                } else if (tnode.count >= 2){
                    sum = sum +2;
                }

            }
        }
        return sum;
    }

}



