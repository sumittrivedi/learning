import java.util.*;

class Sudoku { 
	public static void main(String args[]) {
		ArrayList<Integer> row0 = new ArrayList<>(Arrays.asList(0, 4, 0, 0, 0, 0, 0, 0, 0));
		ArrayList<Integer> row1 = new ArrayList<>(Arrays.asList(0, 3, 0, 5, 0, 0, 6, 0, 7));
		ArrayList<Integer> row2 = new ArrayList<>(Arrays.asList(7, 0, 9, 0, 0, 0, 0, 2, 0));
		ArrayList<Integer> row3 = new ArrayList<>(Arrays.asList(0, 0, 0, 2, 1, 8, 4, 0, 0));
		ArrayList<Integer> row4 = new ArrayList<>(Arrays.asList(0, 0, 0, 4, 0, 5, 7, 0, 0));
		ArrayList<Integer> row5 = new ArrayList<>(Arrays.asList(0, 0, 1, 3, 7, 9, 0, 0, 0));
		ArrayList<Integer> row6 = new ArrayList<>(Arrays.asList(0, 1, 0, 0, 0, 0, 2, 0, 6));
		ArrayList<Integer> row7 = new ArrayList<>(Arrays.asList(6, 0, 8, 0, 0, 1, 0, 5, 0));
		ArrayList<Integer> row8 = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 7, 0));
		ArrayList<ArrayList<Integer>> board = new ArrayList<>();
		board.add(row0);
		board.add(row1);
		board.add(row2);
		board.add(row3);
		board.add(row4);
		board.add(row5);
		board.add(row6);
		board.add(row7);
		board.add(row8);
		solveSudoku(board).forEach(System.out::println);
	}

	private static int size = 0;

	public static ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
		size = board.size();
		sudokuByBacktracking(board, 0, 0);
		return board;
	}

	private static boolean sudokuByBacktracking(ArrayList<ArrayList<Integer>> board, int i, int j) {
		if (i == size)
			return true;
		int ni = 0;
		int nj = 0;
		if (j == size - 1) {
			ni = i + 1;
			nj = 0;
		} else {
			ni = i;
			nj = j + 1;
		}
		if (board.get(i).get(j) == 0) {
			for (int k = 1; k <= 9; k++) {
				if (isValidNum(board, i, j, k)) {
					board.get(i).set(j, k);
					if (sudokuByBacktracking(board, ni, nj)) {
						return true;
					}
				}
			}
			board.get(i).set(j, 0);
			return false;
		} else
			return sudokuByBacktracking(board, ni, nj);
	}

	private static boolean isValidNum(ArrayList<ArrayList<Integer>> board, int row, int col, int num) {
		if (board.get(row).contains(num))
			return false;
		for (int i = 0; i < 9; i++) {
			if (board.get(i).get(col) == num)
				return false;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board.get(i + 3 * (row / 3)).get(j + 3 * (col / 3)) == num)
					return false;
			}
		}
		return true;
	}
}
