package PracticeCoding;


public class EditDistance {
    public static int solve(String str1, String str2){
        return getEditDistance(str1, str1.length(), str2, str2.length());
    }

    public static int getEditDistance(String str1, int len1, String str2, int len2) {
        if(len2 == 0)
            return len1;

        if(len1 == 0)
            return len2;

        int l1 = getEditDistance(str1, len1 -1, str2, len2) + 1;
        int l2 = getEditDistance(str1, len1, str2, len2 - 1) + 1;
        int l3 = getEditDistance(str1, len1 - 1, str2, len2 - 1);
        if(str1.charAt(len1-1) != str2.charAt(len2-1)) {
            l3 = l3 + 1;
        }

        return Math.min(Math.min(l1, l2), l3);

    }

}
