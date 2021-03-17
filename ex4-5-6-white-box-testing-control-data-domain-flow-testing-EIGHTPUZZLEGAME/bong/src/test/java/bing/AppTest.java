package bing;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.graalvm.compiler.hotspot.stubs.OutOfBoundsExceptionStub;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void shouldSuccessfullyMoveTile() throws ExceptionInvalidPosition {
        // Considerando o critério de cobertura de comandos:
        // Caminho 1: 1-2(T)-3(T)-4(T)-5(T)-6-7(T)-8-9(T)-10-11
        var puzzle = new PuzzleGame(3, new ShufflePuzzleForTesting());
        //1 - 3
        //4 2 5
        //7 8 6
        assertEquals("1", puzzle.getTile(1, 1));
        puzzle.moveTile(1, 1);
        assertEquals(" ", puzzle.getTile(1, 1));
        assertEquals("1", puzzle.getTile(1, 2));
    }
	
    @Test
    public void shouldNOTSuccessfulyMoveTileDueToNonAdjacency() throws ExceptionInvalidPosition {
        // Considerando o critério cobertura de ramos:
        // Caminho 2: 1-2(T)-3(T)-4(T)-5(T)-6-7(F)-11
        var puzzle = new PuzzleGame(3, new ShufflePuzzleForTesting());
        //1 - 3
        //4 2 5
        //7 8 6
        assertEquals("7", puzzle.getTile(3, 1));
        puzzle.moveTile(3, 1);
        assertEquals("7", puzzle.getTile(3, 1));
    }

    @Test
    public void shouldNOTSuccessfulyMoveTileDueToLargerXDimensionThanBoard() throws ExceptionInvalidPosition {
        // Considerando o critério cobertura de ramos:
        // Caminho 5: 1-2(T)-3(F)-11
        var puzzle = new PuzzleGame(3, new ShufflePuzzleForTesting());
        //1 - 3
        //4 2 5
        //7 8 6
        assertEquals(" ", puzzle.getTile(1, 2));
        puzzle.moveTile(4, 1);
        assertEquals(" ", puzzle.getTile(1, 2));
    }

    @Test
    public void shouldNOTSuccessfulyMoveTileDueToSmallerXDimensionThanZero() throws ExceptionInvalidPosition {
        // Considerando o critério cobertura de ramos:
        // Caminho 6: 1-2(F)-11
        var puzzle = new PuzzleGame(3, new ShufflePuzzleForTesting());
        //1 - 3
        //4 2 5
        //7 8 6
        assertEquals(" ", puzzle.getTile(1, 2));
        puzzle.moveTile(-1, 1);
        assertEquals(" ", puzzle.getTile(1, 2));
    }

    @Test
    public void shouldNOTSuccessfulyMoveTileDueToLargerYDimensionThanBoard() throws ExceptionInvalidPosition {
        // Considerando o critério cobertura de ramos:
        // Caminho 3: 1-2(T)-3(T)-4(T)-5(F)-11
        var puzzle = new PuzzleGame(3, new ShufflePuzzleForTesting());
        //1 - 3
        //4 2 5
        //7 8 6
        assertEquals(" ", puzzle.getTile(1, 2));
        puzzle.moveTile(1, 4);
        assertEquals(" ", puzzle.getTile(1, 2));
    }

    @Test
    public void shouldNOTSuccessfulyMoveTileDueToSmallerYDimensionThanZero() throws ExceptionInvalidPosition {
        // Considerando o critério cobertura de ramos:
        // Caminho 4: 1-2(T)-3(T)-4(F)-11
        var puzzle = new PuzzleGame(3, new ShufflePuzzleForTesting());
        //1 - 3
        //4 2 5
        //7 8 6
        assertEquals(" ", puzzle.getTile(1, 2));
        puzzle.moveTile(1, -1);
        assertEquals(" ", puzzle.getTile(1, 2));
    }

    //##################### New tests to kill mutations ##############################
    @Test
    public void testGetTileFromPuzzleWithIndexZero() throws ExceptionInvalidPosition {
        var puzzle = new PuzzleGame(3, new ShufflePuzzleForTesting());

        assertThrows(ExceptionInvalidPosition.class, () -> {puzzle.getTile(0, 1);});
        assertThrows(ExceptionInvalidPosition.class, () -> {puzzle.getTile(1, 0);});
    }

    @Test
    public void testPutElemtsWithInvalidIndexIntoGrid() throws ExceptionInvalidPosition {
        var grid = new Grid<String>(1,1);

        assertDoesNotThrow(() -> {grid.put(0, 1, "stop");});
        assertDoesNotThrow(() -> {grid.put(1, 0, "stop");});
    }

    @Test
    public void testGetElemtsWithInvalidIndexFromGrid() throws ExceptionInvalidPosition {
        var grid = new Grid<String>(1,1);

        assertDoesNotThrow(() -> {grid.get(0, 1);});
        assertDoesNotThrow(() -> {grid.get(1, 0);});
    }

}
