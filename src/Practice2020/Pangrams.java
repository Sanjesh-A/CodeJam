package Practice2020;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;


public class Pangrams {

    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        Long nTestCases = sc.nextLong();

        for (Long i = 0L; i < nTestCases; i++) {
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
        char[] alphabet = {'A', 'B','C', 'D','E','F','G','H','I','J', 'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        BigInteger[] plaintextPrime = new BigInteger[l+1];
        SortedSet<BigInteger> primes = new TreeSet<>();
        BigInteger[] alphabetPrimes = new BigInteger[26];

        primes.clear();


        BigInteger x = ciphertext[0];
        int k = 1;
        while(ciphertext[k].equals(x)){
            k++;
        }
        BigInteger y = ciphertext[k];
       // long z = gcd(start,end);
        BigInteger z = x.gcd(y);

        //edge case : first three chars are the same


        plaintextPrime[k-1] = x.divide(z);
        plaintextPrime[k] = z;
        plaintextPrime[k+1] = y.divide(z);

        for(int i=k-1; i > 0; i--){
            plaintextPrime[i-1] = ciphertext[i].divide(plaintextPrime[i]);
        }


        for(int i=k+1; i<l; i++){
            plaintextPrime[i+1] = ciphertext[i].divide(plaintextPrime[i]);
        }


        for(int i = 0; i<l+1; i++){
            primes.add(plaintextPrime[i]);
        }

        primes.toArray(alphabetPrimes);


        HashMap<BigInteger, Character> hashMap = new HashMap<>(26);
        for (int i = 0; i<26; i++){
            hashMap.put(alphabetPrimes[i],alphabet[i]);
           // System.out.println(alphabet[i] + " " + alphabetPrimes[i] );
        }
        StringBuilder sb = new StringBuilder();
        for (BigInteger bi : plaintextPrime) {
            java.lang.Character c = hashMap.get(bi);
            sb.append(c);
        }
        return sb.toString();

    }

//    private static BigInteger gcd(BigInteger a, BigInteger b) {
//        while(!a.equals(b)){
//            if(a > b)
//                a = a-b;
//            else
//                b = b-a;
//        }
//        return a;
//
//    }

}

