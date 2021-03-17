package bing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class testeFluxoDeDados {
    @Test
    public void allCUsesPositionPeca() throws ExceptionInvalidPosition {
        // All-c-uses (positionPeca) and also All-p-uses/Some-c-uses (peca):
        // caminho 0: 1-2-3-4-5-6-7-8
        var puzzle = new PuzzleGame(3, new ShufflePuzzleForTesting());
        //1 - 3
        //4 2 5
        //7 8 6
        assertEquals("3", puzzle.getTile(1, 3));
        puzzle.moveTile(1, 3);
        assertEquals(" ", puzzle.getTile(1, 3));
        assertEquals("3", puzzle.getTile(1, 2));
    }
}
