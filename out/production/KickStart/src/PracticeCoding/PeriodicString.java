package PracticeCoding;

public class PeriodicString {
    public static boolean  check(String str){
        int n=0;
        String rotatedStr = str;
        while(n < str.length()){
            n++;
            rotatedStr = rotateString(rotatedStr);

            if(rotatedStr.equals(str)){
                break;
            }
        }
        if(n < str.length()){
            System.out.println("String is periodic, n = " + (str.length()/n) + ", P = " + str.substring(0,n));
            return true;
        }

        return false;
    }

    public static String rotateString(String str) {
        char c = str.charAt(0);
        String s = str.substring(1, str.length());
        s = s + c;
        return s;
    }


}
