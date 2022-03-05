package PracticeCoding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.sqrt;


public class Cryptopangrams {

    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int i = 0; i < nTestCases; i++) {
            BigInteger n = sc.nextBigInteger();
            int l = sc.nextInt();
            BigInteger[] ciphertext = new BigInteger[l];
            for(int j=0; j < l; j++){
                ciphertext[j] = sc.nextBigInteger();
            }
            String freeText = decryptPangram(n,l,ciphertext);
            System.out.println("Case #"+ (i+1) + ": " + freeText);
        }
    }

    public static String decryptPangram(BigInteger n, int l, BigInteger[] ciphertext) {
        java.lang.Character[] alphabet = {'A', 'B','C', 'D','E','F','G','H','I','J', 'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        BigInteger[] freetextPrimes = new BigInteger[l+1];
        List<BigInteger> primes = new ArrayList<>();

        BigInteger primeGCD = ciphertext[0].gcd(ciphertext[1]);
        if(primeGCD.equals(ciphertext[0])) {
            primeGCD = BigInteger.valueOf((long) Math.sqrt(primeGCD.doubleValue()));
            if(!primeGCD.multiply(primeGCD).equals(ciphertext[0])){
                int i = 1;
                while(ciphertext[i] == ciphertext[0])
                    i++;
                primeGCD = ciphertext[0].gcd(ciphertext[i]);
                for(int j = i-1; j > 0 ; j--){
                    
                }
            }

        }


        freetextPrimes[0] = ciphertext[0].divide(primeGCD);
        freetextPrimes[1] = primeGCD;

        primes.add(freetextPrimes[0]);
        if(!freetextPrimes[0].equals(freetextPrimes[1]))
            primes.add(freetextPrimes[1]);

        for(int i=1; i<l; i++){
            primeGCD = ciphertext[i].divide(primeGCD);
            freetextPrimes[i+1] = primeGCD;
            if(!primes.contains(primeGCD))
                primes.add(primeGCD);
        }
        Collections.sort(primes);
        HashMap<BigInteger, java.lang.Character> hashMap = new HashMap<BigInteger, java.lang.Character>();
        for (int i = 0; i<26; i++){
            hashMap.put(primes.get(i),alphabet[i]);
        }
        String freeText = "";
        StringBuilder sb = new StringBuilder();
        for (BigInteger bi : freetextPrimes) {
            java.lang.Character c = hashMap.get(bi);
            sb.append(c);
        }
        return sb.toString();

    }
}
