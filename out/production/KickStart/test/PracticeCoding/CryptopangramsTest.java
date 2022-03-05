package PracticeCoding;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class CryptopangramsTest {

    @Test
    void main() {
    }

    @Test
    void decryptPangram() {
        BigInteger n = BigInteger.valueOf(103);
        int l = 31;
        int[] input = {217, 1891, 4819, 2291, 2987, 3811, 1739, 2491, 4717, 445, 65, 1079, 8383, 5353, 901, 187, 649, 1003, 697, 3239, 7663, 291, 123, 779, 1007, 3551, 1943,
                2117, 1679,989,3053};
        BigInteger[] cipherText = new BigInteger[l];
        for(int i=0; i<input.length; i++){
            cipherText[i] = BigInteger.valueOf(input[i]);
        }
        String freeText = Cryptopangrams.decryptPangram(n,l,cipherText);
        assertEquals("CJQUIZKNOWBEVYOFDPFLUXALGORITHMS", freeText);

        n = BigInteger.valueOf(103);
        l = 42;
        int[] input2 = {10609, 10609, 721, 49, 49, 49, 49, 217, 217, 217,  1891, 4819, 2291, 2987, 3811, 1739, 2491, 4717, 445, 65, 1079, 8383, 5353, 901, 187, 649, 1003, 697, 3239, 7663, 291, 123, 779, 1007, 3551, 1943,
                2117, 1679,989,3053, 3053, 3053};
        cipherText = new BigInteger[l];
        for(int i=0; i<input2.length; i++){
            cipherText[i] = BigInteger.valueOf(input2[i]);
        }
        freeText = Cryptopangrams.decryptPangram(n,l,cipherText);
        assertEquals("ZZZCCCCCJCJQUIZKNOWBEVYOFDPFLUXALGORITHMSMS", freeText);

        n = BigInteger.valueOf(103);
        l = 35;
        int[] input3 = {217, 217, 217,  1891, 4819, 2291, 2987, 3811, 1739, 2491, 4717, 445, 65, 1079, 8383, 5353, 901, 187, 649, 1003, 697, 3239, 7663, 291, 123, 779, 1007, 3551, 1943,
                2117, 1679,989,3053, 3053, 3053};
        cipherText = new BigInteger[l];
        for(int i=0; i<input3.length; i++){
            cipherText[i] = BigInteger.valueOf(input3[i]);
        }
        freeText = Cryptopangrams.decryptPangram(n,l,cipherText);
        assertEquals("CJCJQUIZKNOWBEVYOFDPFLUXALGORITHMSMS", freeText);


    }
}