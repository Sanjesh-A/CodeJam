package PracticeCoding;

import java.util.Scanner;

public class Maze {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int nTestCases = sc.nextInt();

        for (int i = 0; i < nTestCases; i++) {
            int n = sc.nextInt();
            String path = sc.next();
            String mirrorPath = findMirrorPath(n,path);
            System.out.println("Case #"+ (i+1) + ": " + mirrorPath);
        }
    }

    public static String findMirrorPath(int n, String path) {
        String mirrorPath = "";
        for(char c: path.toCharArray()){
            if(c == 'S'){
                mirrorPath += 'E';
            } else {
                mirrorPath += 'S';
            }
        }
        return mirrorPath;
    }
}
