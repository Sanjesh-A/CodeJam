package Qual2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Esabatad {
    public static void main(String[] args) {


        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();
        int b = sc.nextInt();

        for (int i = 0; i < nTestCases; i++) {
            String num = getNumber(sc, b);
            System.out.println(num);
            String result = sc.next();
            if(result.equals("N"))
                break;

               // System.out.println("Case #"+ (i+1) + ": " + new String(order) );

        }
    }

    public static String getNumber(Scanner sc, int b) {
        int[] number = new int[b];
        int[] operation = new int[150];
        int front=0;
        int back = b-1;
        int opcount = 1;
        int bitNum = front;
        boolean frontpart = true;
        while(opcount <= 150 && front <= back){
            if(opcount % 10 == 1 && opcount > 1){
                    //findOpandApply(operation, number);
                    //find complementary pair
                int bit = getBit(sc, 1);
                opcount++;
                    if(number[0] == number[b-1] ){
                        if(number[0] != bit){
                            //Complement or complement + reverse
                            int j =0;
                            for( j=1; j<front; j++){
                                if(number[j] != number[b-j-1] )
                                    break;
                            }
                            if(j<front){
                                int bit1 = getBit(sc, j + 1);
                                opcount++;
                                if(bit1 != number[j]){
                                    //complement
                                    complement(number, b, front);
                                } else {
                                    //complment and reverse
                                    complement(number,b,front);
                                    reverse(number,b, front);

                                }
                            } else {
                                int bit1 = getBit(sc,  1);
                                opcount++;
                                //complement and compl-rev will give same result
                                complement(number,b,front);
                            }
                        } else {
                            //same or reversal
                            int j =0;
                            for( j=1; j<front; j++){
                                if(number[j] != number[b-j-1] )
                                    break;
                            }
                            if(j<front){
                                int bit1 = getBit(sc, j + 1);
                                opcount++;
                                if(bit1 != number[j]){
                                    //reversal
                                    reverse(number, b, front);
                                } else {
                                    //no-op

                                }
                            } else {
                                // getting a bit to keep forward and back pointers aligned at the point of trasnformation
                                int bit1 = getBit(sc,  1);
                                opcount++;
                                //no-op and rev will give same result
                                //no-op
                            }

                        }
                    } else {
                        if(number[0] != bit){
                            //Complement or  reverse
                            int j =0;
                            for( j=1; j<front; j++){
                                if(number[j] == number[b-j-1] )
                                    break;
                            }
                            if(j<front){
                                int bit1 = getBit(sc, j + 1);
                                opcount++;
                                if(bit1 != number[j]){
                                    //complement
                                    complement(number, b, front);
                                } else {
                                    //reverse
                                    reverse(number,b, front);
                                }
                            } else {
                                int bit1 = getBit(sc,  1);
                                opcount++;
                                //complement and rev will give same result
                                complement(number,b,front);
                            }
                        } else {
                            //same or comp-reversal
                            int j =0;
                            for( j=1; j<front; j++){
                                if(number[j] == number[b-j-1] )
                                    break;
                            }
                            if(j<front){
                                int bit1 = getBit(sc, j + 1);
                                opcount++;
                                if(bit1 != number[j]){
                                    //comp-reversal
                                    complement(number,b,front);
                                    reverse(number, b, front);
                                } else {
                                    //no-op

                                }
                            } else {
                                int bit1 = getBit(sc,  1);
                                opcount++;
                                //no-op and comp-rev will give same result
                                //no-op
                            }

                        }
                    }

            } else {
                if (frontpart) {
                    number[front] = getBit(sc, front+1);
                    front++;
                    frontpart = false;

                } else {
                    number[back] = getBit(sc, back+1);
                    back--;
                    frontpart = true;
                }

                opcount++;
            }


        }

        //System.out.println(Arrays.toString(number));
        StringBuilder num = new StringBuilder();
        for(int j=0; j<b; j++){
            num.append(number[j]);
        }
        return num.toString();
    }

    public static int getBit(Scanner sc, int i2) {
        System.out.println(i2);
        return sc.nextInt();
    }



    public static void reverse(int[] number, int b, int front) {
        int i = 0;
        int j = b-1;
        while (i < j && i< front){
            int t = number[i];
            number[i] = number[j];
            number[j] = t;
            i++;
            j--;
        }
    }

    public static void complement(int[] number, int b, int front) {
        int i = 0;
        int j = b-1;
        while (i < j && i< front){
            number[i] = 1 - number[i];
            number[j] = 1 - number[j];
            i++;
            j--;
        }
    }


}


