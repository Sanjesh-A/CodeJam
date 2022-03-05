package DP;

public class LCS {

    int[][] cache;
    public int solve(String A, String B) {
        int alen = A.length();
        int blen = B.length();
        cache = new int[alen][blen];
        for(int i=0; i<alen; i++){
            for(int j=0; j<blen; j++){
                cache[i][j] = -1;
            }
        }
        char[] aStr = A.toCharArray();
        char[] bStr = B.toCharArray();
        return LCS(aStr,alen-1, bStr, blen-1);

    }

    public int LCS(char[] a, int i, char[] b,  int j){
        if(i==-1 || j==-1)
            return 0;

        if(cache[i][j] !=-1)
            return cache[i][j];

        if(a[i] == b[j]){
          int lcs = 1 + LCS(a,i-1,b,j-1);
          cache[i][j] = lcs;
        } else {
            int lcs1 = LCS(a, i, b, j - 1);
            int lcs2 = LCS(a, i - 1, b, j);

            cache[i][j] = lcs1 > lcs2 ? lcs1 : lcs2;
        }

        return cache[i][j];

    }
}
