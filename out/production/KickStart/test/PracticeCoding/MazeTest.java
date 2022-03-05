package PracticeCoding;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {

    @Test
    void main() {
    }

    @Test
    void findMirrorPath() {
        int n = 5;
        String path = "EESSSESE";
        String mirrorPath = Maze.findMirrorPath(n,path);
        assertEquals("SSEEESES", mirrorPath);

    }
}