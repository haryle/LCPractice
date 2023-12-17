public class SurfaceAreaOf3DShapes {
    public int getAdjacentArea(int[][] grid, int i, int j, int rowSize, int colSize){
        int contribution = 0;
        // i + 1, j
        if (i + 1 >= rowSize)
            contribution += grid[i][j];
        else
            contribution += Math.max(0, grid[i][j] - grid[i+1][j]);
        // i - 1, j
        if (i - 1 < 0)
            contribution += grid[i][j];
        else
            contribution += Math.max(0, grid[i][j] - grid[i-1][j]);
        // i, j + 1
        if (j + 1 >= colSize)
            contribution += grid[i][j];
        else
            contribution += Math.max(0, grid[i][j] - grid[i][j+1]);
        //i, j - 1
        if (j - 1 < 0)
            contribution += grid[i][j];
        else
            contribution += Math.max(0, grid[i][j] - grid[i][j-1]);
        return contribution;
    }
    public int surfaceArea(int[][] grid) {
        int totalSum = 0;
        int rowSize = grid.length;
        int colSize = grid[0].length;
        for (int i = 0; i < rowSize; i++){
            for (int j = 0; j < colSize; j++){
                if (grid[i][j] != 0)
                    totalSum += 2; // Top surface area
                totalSum += getAdjacentArea(grid, i, j, rowSize, colSize);
            }
        }
        return totalSum;
    }
}
