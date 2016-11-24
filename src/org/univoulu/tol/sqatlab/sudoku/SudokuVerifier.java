package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {

	SudokuVerifier() {
	};

	public int verify(String candidateSolution) {
		int ris = 0;

		boolean validInput = SudokuVerifier.areNumbersOfSolutionCorrect(candidateSolution);
		if (!validInput) {
			return -1;
		}

		boolean controlRow = true;
		controlRow = SudokuVerifier.isCorrectRow(candidateSolution);
		boolean controlColumn = true;
		controlColumn = SudokuVerifier.isCorrectColumn(candidateSolution);
		boolean controlSubGrid = true;
		controlSubGrid = SudokuVerifier.isCorrectSubGrid(candidateSolution);

		if (controlRow == true && controlColumn == true && controlSubGrid == true) {
			ris = 0;
		}

		if (controlRow == false) {
			ris = -3;
		} else if (controlColumn == false) {
			ris = -4;
		} else if (controlSubGrid == false) {
			ris = -2;
		}

		return ris;

	}

	private static boolean isCorrectRow(String candidateSolution) {
		int j = 0;
		while (j < 80) {
			String oneRow = candidateSolution.substring(j, j += 9);
			char[] row = oneRow.toCharArray();
			for (int i = 0; i < 8; i++) {
				if (row[i] == row[i + 1]) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isCorrectColumn(String candidateSolution) {
		int j = 0;
		int counter = 0;
		char[] solution = candidateSolution.toCharArray();
		char[] oneColumn = new char[9];

		while (counter < 9) {
			for (int i = 0; i < 9; i++) {
				oneColumn[i] = solution[j];
				j += 9;
			}
			for (int i = 0; i < 8; i++) {
				if (oneColumn[i] == oneColumn[i + 1]) {
					return false;
				}
			}
			counter++;
			j = counter;
		}
		return true;
	}

	private static boolean isCorrectSubGrid(String candidateSolution) {
		int j = 0;
		int i = 0;
		int counter = 0;
		char[] solution = candidateSolution.toCharArray();
		char[] charsInOneGrid = new char[9];

		while (counter < 9) {
			for (i = 0; i < 3; i++) {
				j = i;
				charsInOneGrid[i] = solution[j];
				++counter;
			}
			j += 6;
			for (i = counter; i < 6; i++) {
				charsInOneGrid[i] = solution[j++];
				counter++;
			}
			j += 6;
			for (i = counter; i < 9; i++) {
				charsInOneGrid[i] = solution[j++];
				counter++;
			}
		}

		for (int a = 0; a < 8; a++) {
			if (charsInOneGrid[a] == charsInOneGrid[a + 1]) {
				return false;
			}
		}

		return true;

	}

	private static boolean areNumbersOfSolutionCorrect(String candidateSolution) {
		char[] solution = candidateSolution.toCharArray();
		for (char c : solution) {
			int n = Character.getNumericValue(c);
			if (n == 0 /* || solution.length != 81 */) {
				return false;
			}
		}

		return true;
	}
}
