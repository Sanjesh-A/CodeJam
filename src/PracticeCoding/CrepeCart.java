package PracticeCoding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CrepeCart {
    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int i = 0; i < nTestCases; i++) {
            int P = sc.nextInt();
            int Q = sc.nextInt();
            int[] X = new int[Q+1];
            int[] Y = new int[Q+1];
            int maxX = 0;
            int maxY = 0;
            int Xmax = 0;
            int Ymax = 0;
            for(int j=0; j<P; j++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                String d = sc.next();
                //people[j] = new People(start,end, Direction.valueOf(d));
                switch(d) {
                    case "N" :
                        for(int k = y+1; k <= Q; k++){
                            Y[k]= Y[k]+1;
                            if(Y[k] > Ymax){
                                Ymax = Y[k];
                                maxY = k;
                            }
                        }

                        break;

                    case "S" :
                        for(int k = y-1; k >= 0; k--){
                            Y[k]= Y[k]+1;
                            if(Y[k] >= Ymax){
                                Ymax = Y[k];
                                maxY = k;
                            }
                        };
                        break;

                    case "E" :
                        for(int k = x+1; k <= Q; k++){
                            X[k]= X[k]+1;
                            if(X[k] > Xmax){
                                Xmax = X[k];
                                maxX = k;
                            }
                        };
                        break;

                    case "W" :
                        for(int k = x-1; k >= 0 ; k--){
                            X[k]= X[k]+1;
                            if(X[k] >= Xmax){
                                Xmax = X[k];
                                maxX = k;
                            }
                        };
                        break;
                }

            }
            System.out.println("Case #"+ (i+1) + ": " + maxX + " " + maxY);


        }

    }
}

