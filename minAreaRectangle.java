
public class minAreaRectangle {

	public static void main(String[] args) {

	}

	public int minimumAreaRectangle(int[][] points) {
		int minArea = Integer.MAX_VALUE;
		int row = points.length;
		for (int i = 0; i < row; i++) {
			for (int j = i + 1; j < row; j++) {
				int x1 = points[i][0];
				int x2 = points[j][0];
				int y1 = points[i][1];
				int y2 = points[j][1];
				if (x1 != x2 && y1 != y2) {
					if (search(x1, y2, points) && search(x2, y1, points)) {
					int area = Math.abs((x2 - x1) * (y1 - y2));
					minArea = Math.min(minArea, area);
					}
				}
			}
		}
		if (minArea == Integer.MAX_VALUE)
			return 0;
		return minArea;

	}

	private boolean search(int x, int y, int[][] points) {
		int row = points.length;
		for (int i = 0; i < row; i++) {
			if (points[i][0] == x && points[i][1] == y)
				return true;
		}
		return false;
	}

}
