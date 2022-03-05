package RoundA2014;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SevenSegmentDisplayTest {

    @Test
    public void main() {
    }

    @Test
    public void getBinaryString() {
    }

    @Test
    public void getNextState() {
        int nStates = 7;
        int[] state = new int[nStates];

        for(int i = 127; i > 0; i--){
            state[0] = SevenSegmentDisplay.digits[4] & i;
            state[1] = SevenSegmentDisplay.digits[3] & i;
            state[2] = SevenSegmentDisplay.digits[2] & i;
            state[3] = SevenSegmentDisplay.digits[1] & i;
            state[4] = SevenSegmentDisplay.digits[0] & i;

            int nextState = SevenSegmentDisplay.getNextState(nStates,state);
            System.out.println("i=" + i);
            if(nextState != -1)
                assertEquals(SevenSegmentDisplay.digits[9] & i, nextState);
        }

        nStates = 2;
        for(int i = 127; i > 0; i--){
            state[0] = SevenSegmentDisplay.digits[1] & i;
            state[1] = SevenSegmentDisplay.digits[0] & i;

            int nextState = SevenSegmentDisplay.getNextState(nStates,state);
            System.out.println("i=" + i);
            if(nextState != -1)
                assertEquals(SevenSegmentDisplay.digits[9] & i, nextState);
        }

        int max = 0;
        for (int i=9; i>=0;i--){
            int startDigit = i+1;
            int digitsORed =0;
            int count =0;
            while(digitsORed != 127){
                startDigit = (startDigit + 9)% 10;
                digitsORed = digitsORed | SevenSegmentDisplay.digits[startDigit];
                count++;
            }
            if(count > max)
                max = count;
        }
        System.out.println("max = " + max);

    }

    @Test
    public void fillPossibleDigits() {
    }
}
