package PracticeCoding;

public class RegexMatch {

        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public int isMatch(final String A, final String B) {


            char[] cA = A.toCharArray();
            char[] cB;

            if(B.contains("**")){
                String C = removeConsecutiveStars(new StringBuilder(B));
                cB = C.toCharArray();
            } else
               cB = B.toCharArray();

            if(!B.contains("*")){
                if(cA.length != cB.length)
                    return 0;
            }

            Boolean[][] cache = new Boolean[cA.length][cB.length];

            if(isCharArrayMatch(cA, cB, 0,0, cache))
                return 1;
            else
                return 0;
        }

    private String removeConsecutiveStars(StringBuilder stringBuilder) {
            int i;

            while( (i = stringBuilder.indexOf("**")) != -1) {
                stringBuilder.deleteCharAt(i + 1);
            }
            return stringBuilder.toString();
    }

    public boolean isCharArrayMatch(char[] A, char[] B, int i, int j, Boolean[][] cache){

            if(i == A.length && j == B.length){
                return true;
            }

            if(j == B.length - 1 && B[j] == '*')
                return true;

            if(i ==A.length || j == B.length){
                return false;
            }

            if(cache[i][j] != null){
                return cache[i][j];
            }



            if(B[j] == '?'){
                cache[i][j] = isCharArrayMatch(A,B,i+1, j+1, cache);
                return cache[i][j];
            }

            if(B[j] == '*'){
                cache[i][j] = isCharArrayMatch(A,B,i+1,j, cache) || isCharArrayMatch(A,B,i,j+1, cache);
                return cache[i][j];
            }

            if(A[i] == B[j])
                cache[i][j] = isCharArrayMatch(A,B,i+1,j+1, cache);
            else
                cache[i][j] = false;

            return cache[i][j];
        }


}
