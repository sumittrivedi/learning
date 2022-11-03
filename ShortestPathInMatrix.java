import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInMatrix {
	
	public static void main(String args[]) {
		int[][] grid =  {
				{1,0,1},
				{1,1,0},
				{1,1,9}} ;
		System.out.println(new ShortestPathInMatrix().shortestPath(grid));
	}

	private int shortestPath(int[][] grid) {
		boolean[][] isVisited = new boolean[grid.length][grid[0].length];
		Queue<Qitem> queue = new LinkedList<>();
		queue.add(new Qitem(0, 0, 0));
		isVisited[0][0] = true;
		while (queue.isEmpty() == false) {
			Qitem currentGrid = queue.remove();
			int row = currentGrid.row;
			int col = currentGrid.col;
			
			if (grid[row][col] == 9)
				return currentGrid.dist;
			
			if (isValidPath(grid, row + 1, col, isVisited)) {
				queue.add(new Qitem(row + 1, col, currentGrid.dist + 1));
				isVisited[row + 1][col] = true;
			}
			
			if (isValidPath(grid, row - 1, col, isVisited)) {
				queue.add(new Qitem(row - 1, col, currentGrid.dist + 1));
				isVisited[row - 1][col] = true;
			}
			
			if (isValidPath(grid, row, col + 1, isVisited)) {
				queue.add(new Qitem(row, col + 1, currentGrid.dist + 1));
				isVisited[row][col + 1] = true;
			}
			
			if (isValidPath(grid, row, col - 1, isVisited)) {
				queue.add(new Qitem(row, col - 1, currentGrid.dist + 1));
				isVisited[row][col -1] = true;
			}
		}
		
		return -1;
	}
	
	private boolean isValidPath(int[][] grid, int row, int col, boolean[][] isVisited) {
		if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] != 0 && isVisited[row][col] == false) 
			return true;
		return false;
	}

}

class Qitem {
	int row;
	int col;
	int dist;
	public Qitem(int row, int col, int dist) {
		super();
		this.row = row;
		this.col = col;
		this.dist = dist;
	}
	
}
