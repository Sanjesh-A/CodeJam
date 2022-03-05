package PracticeCoding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Pangrams {

    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int i = 0; i < nTestCases; i++) {
            long n = sc.nextLong();
            int l = sc.nextInt();
            long[] ciphertext = new long[l];
            for(int j=0; j < l; j++){
                ciphertext[j] = sc.nextLong();
            }
            String freeText = decryptPangram(n,l,ciphertext);
            System.out.println("Case #"+ (i+1) + ": " + freeText);
        }
    }

    public static String decryptPangram(long n, int l, long[] ciphertext) {
        char[] alphabet = {'A', 'B','C', 'D','E','F','G','H','I','J', 'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        long[] freetextPrimes = new long[l+1];
        List<Long> primes = new ArrayList<>();

        long primeGCD = gcd(ciphertext[0],ciphertext[1]);
        if(primeGCD == ciphertext[0])
            primeGCD = (long)Math.sqrt(primeGCD);
        freetextPrimes[0] = ciphertext[0] / primeGCD;
        freetextPrimes[1] = primeGCD;

        primes.add(freetextPrimes[0]);
        if(freetextPrimes[0] != freetextPrimes[1])
            primes.add(freetextPrimes[1]);

        for(int i=1; i<l; i++){
            primeGCD = ciphertext[i]/(primeGCD);
            freetextPrimes[i+1] = primeGCD;
            if(!primes.contains(primeGCD))
                primes.add(primeGCD);
        }
        Collections.sort(primes);
        HashMap<Long, java.lang.Character> hashMap = new HashMap<>(26);
        for (int i = 0; i<26; i++){
            hashMap.put(primes.get(i),alphabet[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (long bi : freetextPrimes) {
            java.lang.Character c = hashMap.get(bi);
            sb.append(c);
        }
        return sb.toString();

    }

    private static long gcd(long a, long b) {
        if(a==0 || b == 0)
            return 0;

        if(a == b)
            return a;

        if(a > b)
            return gcd(a-b, b);

        return gcd(a, b-a);
    }

}
