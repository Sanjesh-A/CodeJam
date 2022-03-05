package Practice2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderStatisticTest {

    @Test
    void getOS() throws Exception {
        OrderStatistic os = new OrderStatistic();
        int[] A = {2, 4, 1,3,0,10};
        int val = os.getOS(A, 3);
        assertEquals(3,val);

        val = os.getOS(A, 5);
        assertEquals(10,val);
    }
}