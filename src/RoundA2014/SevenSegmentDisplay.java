package RoundA2014;

import java.util.Scanner;

public class SevenSegmentDisplay {
    public static final int[] digits = {126, 48, 109,121,51,91, 95, 112, 127, 123 };

    public static void main(String[] args) {
        //System.out.printf("Case #%d : %s : %d\n", 1, getBinaryString(~0), ~0);
/*        for(int i = 0; i< 10; i++){
            System.out.printf("Case #%d: %s\n", i, getBinaryString(digits[i]));
        }*/

        Scanner sc = new Scanner(System.in);
        int nTestCases = sc.nextInt();

        for (int i = 0; i< nTestCases; i++){
            int nStates = sc.nextInt();
            //System.out.printf("%d ",nStates);
            int[] state = new int[nStates];
            for(int j = 0; j < nStates; j++){
                state[j] = sc.nextInt(2);
              //  System.out.printf("%s ",getBinaryString(state[j]));
            }
          //  System.out.printf("\n");
            int nextState = getNextState(nStates, state);

            if(nextState < 0)
                System.out.printf("Case #%d: %s\n", i+1, "ERROR!");
            else
                System.out.printf("Case #%d: %s\n", i+1, getBinaryString(nextState));
        }
    }

    public static String getBinaryString(int number) {
        String s = Integer.toBinaryString(number);
        int len = s.length();
        if(len < 7 ){
            for(int i=0; i< 7-len; i++){
                s = "0" + s;
            }
        }
        return s;
    }

    public static int getNextState(int nStates, int[] state) {
        int workingLEDs = 0;
        for(int i = 0; i < nStates; i++){
            workingLEDs = workingLEDs | state[i];
        }

/*        if(workingLEDs == 0){
            if(nStates >= 4)
                return  0;
            else
                return -1;
        }*/

        int[][] possibleDigits = new int[nStates][10];
        for(int i = 0; i < nStates; i++){
            fillPossibleDigits(possibleDigits,workingLEDs, i, state[i]);
        }
 /*       for(int i = 0; i< nStates; i++){
            for (int j=0 ;j<10;j++){
                System.out.print(possibleDigits[i][j]);
            }
            System.out.println();
        }*/

        int countOfPossibleDigits = 0;
        int lastState = 0;
        int nextState = 0;
        int prevNextState = -1;
        for(int i=0; i<10; i++){
            nextState = 0;
            if(possibleDigits[nStates - 1][i] == 1) {
                lastState = i;
                countOfPossibleDigits++;

                if (isNextStatePredictable(nStates, state, lastState, workingLEDs)) {

                    nextState = digits[(lastState + 9) % 10] & workingLEDs;
                    if (prevNextState == -1) {
                        prevNextState = nextState;
                    }
                    if (nextState != prevNextState) {
                        return -1;
                    }
                } else
                    return -1;
            }
        }

        if(countOfPossibleDigits > 0 && prevNextState != -1 )
            return prevNextState;
        else
            return -1;

/*        if(countOfPossibleDigits == 1 && isNextStatePredictable(nStates, state, lastState, workingLEDs)) {
          //  System.out.println(workingLEDs);
          //  System.out.println(lastState);
            return digits[(lastState + 9) % 10] & workingLEDs;
        }
        else {
        //    System.out.println("countOfPossibleDigits : " + countOfPossibleDigits);
            return -1;
        }*/

    }

    public static boolean isNextStatePredictable(int nStates, int[] state, int lastState, int workingLEDs) {
        if(nStates == 1 && workingLEDs != 127)
            return false;

        int testedLEDs = 0;
        for(int i = 0; i<nStates; i++){
            testedLEDs = testedLEDs | digits[(lastState + i)%10];
        }
        if(testedLEDs != 127){
            int nextState = digits[(lastState + 9) % 10];
            if( (testedLEDs | digits[(lastState + 9) % 10]) > testedLEDs)
                return false;

        }
        return true;
    }

    public static void fillPossibleDigits(int[][] possibleDigits, int workingLEDs, int index, int state) {
        if(index == 0){
            for(int i = 0; i<10; i++){
                if((digits[i] & workingLEDs) == state){
                    possibleDigits[index][i] = 1;
                }
            }
        } else {
            for(int i = 0; i<10; i++){
                if(possibleDigits[index -1][(i+1)%10] == 1){
                    if((digits[i] & workingLEDs) == state){
                        possibleDigits[index][i] = 1;
                    }
                }
            }
        }

    }


}
