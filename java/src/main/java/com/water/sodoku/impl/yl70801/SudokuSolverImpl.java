package com.water.sodoku.impl.yl70801;

import com.water.sodoku.SudokuSolver;

public class SudokuSolverImpl implements SudokuSolver {

	@Override
	public byte[] solve(byte[] sudoku) {
		byte[][] board = new byte[9][9];

		for (int i = 0; i < sudoku.length; i++) {
			board[i / 9][i % 9] = sudoku[i];
		}

		boolean resolve = new Solution().solve(board);

		System.out.println("\n===========================" + resolve);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print((board[i][j] - '0') + " ");
				sudoku[i * 9 + j] = board[i][j];
			}
			System.out.println();
		}

		return sudoku;
	}
}
