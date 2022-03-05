package DP;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DebutAlbumTest {

    @Test
    void getNumberOfWaysToOrderSongs() {
        int n = 3;
        int a = 2;
        int b = 1;
        long expected = 3;
        long total = DebutAlbum.getNumberOfWaysToOrderSongs(n,a,b);
        assertEquals(expected, total);

        n= 50000;
        a = 300;
        b= 300;
        expected =422791438;
        total = DebutAlbum.getNumberOfWaysToOrderSongs(n,a,b);
        assertEquals(expected, total);

/*        n = 49999;
        a = 299;
        b = 299;
        expected= 505277419;
        total = DebutAlbum.getNumberOfWaysToOrderSongs(n,a,b);
        assertEquals(expected, total);

        n = 25000;
        a= 269;
        b = 222;
        expected = 716603086;
        total = DebutAlbum.getNumberOfWaysToOrderSongs(n,a,b);
        assertEquals(expected, total);

        n = 24124;
        a =131;
        b= 232;
        expected = 373638552;
        total = DebutAlbum.getNumberOfWaysToOrderSongs(n,a,b);
        assertEquals(expected, total);

        n =18000;
        a=234;
        b=279;
        expected=653833015;
        total = DebutAlbum.getNumberOfWaysToOrderSongs(n,a,b);
        assertEquals(expected, total);

        n=34000;
        a=98;
        b=162;
        expected=688357676;
        total = DebutAlbum.getNumberOfWaysToOrderSongs(n,a,b);
        assertEquals(expected, total);

        n=13452;
        a=134;
        b=245;
        expected=900436780;
        total = DebutAlbum.getNumberOfWaysToOrderSongs(n,a,b);
        assertEquals(expected, total);

        n=10306;
        a=299;
        b=207;
        expected=85275311;
        total = DebutAlbum.getNumberOfWaysToOrderSongs(n,a,b);
        assertEquals(expected, total);*/
    }

    @Test
    void FS2() {
    }

    @Test
    void FS1() {
    }
}