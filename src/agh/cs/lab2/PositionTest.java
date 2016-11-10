package agh.cs.lab2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kanes on 21.10.2016.
 */
public class PositionTest {

    @Test
    public void testToString() throws Exception {
        assertEquals("(1, 2)", new Position(1, 2).toString());
    }
/*
    @Test
    public void testSmaller(){
        assertTrue(new Position(1, 2).smaller(new Position(3, 4)));
        assertFalse(new Position(3, 4).smaller(new Position(1, 2)));
    }

    @Test
    public void testLarger(){
        assertFalse(new Position(1, 2).larger(new Position(3, 4)));
        assertTrue(new Position(3, 4).larger(new Position(1, 2)));
    }

    @Test
    public void testEquals(Position pos){
        assertEquals(pos, new Position(pos.x, pos.y));
    }
*/
}