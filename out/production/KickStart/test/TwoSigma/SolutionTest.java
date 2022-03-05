package TwoSigma;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void friendCircles() {
        char[] str = new char[300];
        for(int i=0; i<300; i++){
            str[i] = 'Y';
        }
        String s = new String(str);
        System.out.println(s);
        List<String> friends = new ArrayList<>(300);
        for(int i = 0; i<300; i++) {
            friends.add(i,s);
        }
        int k = Solution.friendCircles(friends);
        assertEquals(1,k);
    }

    @Test
    void friendCircles1() {

        List<String> friends = new ArrayList<>(4);
        friends.add(0,"YYNN");
        friends.add(1,"YYYN");
        friends.add(2,"NYYN");
        friends.add(3,"NNNY");
        int k = Solution.friendCircles(friends);
        assertEquals(2,k);
    }
}