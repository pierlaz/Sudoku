package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestSudokuVerifier {

	SudokuVerifier sudoku;
	String correct;
	String incorrect;

	@Before
	public void setUp() {
		sudoku = new SudokuVerifier();
		correct = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		incorrect = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
	}

	@Test
	public void everyNumberIsBetween1And9() {
		String wrongSolution = "417369825632158947958724310825437169791586432346912758289643571573291684164875293"
;		// Assert
		assertEquals(-1, sudoku.verify(wrongSolution));
	}
	
	@Test
	public void candidateRowsAreCorrect() {
		// Arrange
		String wrongRow = "117369825632158947958724316825437169791586432346912758289643571573291684164875293";
		// Assert
		assertEquals(-3, sudoku.verify(wrongRow));

	}
	
	@Test
	public void candidateColumnsAreCorrect() {
		// Arrange
		String wrongColumn = "417369825432158947958724316825437169791586432346912758289643571573291684164875293";
		// Assert
		assertEquals(-4, sudoku.verify(wrongColumn));

	}
	
	@Test
	public void candidateSubGridsAreCorrect() {
		// Arrange
		// Assert
		assertEquals(-2, sudoku.verify(incorrect));

	}
	
	@Test
	public void isCorrectSolution(){
		assertEquals(0, sudoku.verify(correct));
	}

}
