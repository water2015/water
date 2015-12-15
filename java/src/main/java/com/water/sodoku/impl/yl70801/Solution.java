package com.water.sodoku.impl.yl70801;

class Solution {
	public boolean isValid(byte[][] board, int row, int col) {
		byte tmp = board[row][col]; board[row][col] = 'W';
		for (int j = 0; j < 9; j++)
			if (board[row][j] == tmp)
				return false;

		for (int i = 0; i < 9; i++)
			if (board[i][col] == tmp)
				return false;

		int gridRow = row / 3 * 3, gridCol = col / 3 * 3;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (board[gridRow + i][gridCol + j] == tmp)
					return false;
		board[row][col] = tmp;
		return true;
	}

	public boolean solve(byte[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for (int k = 1; k <= 9; k++) {
						board[i][j] = (byte) ('0' + k);
						if (isValid(board, i, j) && solve(board))
							return true;
						board[i][j] = '.';
					}
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		byte[] sudoku = "8..........36......7..9.2...5...7.......457.....1...3...1....68..85...1..9....4..".getBytes();
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
	}
}
