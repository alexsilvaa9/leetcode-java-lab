package graphs;

public class NumberOfIslands {
    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 0},
            {1, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };

        System.out.println(numIslands(grid));
    }

    private static int numIslands(int[][] grid) {
        int islands = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    dfs(grid, row, col);
                    islands++;
                }
            }
        }

        return islands;
    }

    private static void dfs(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == 0) {
            return;
        }

        grid[row][col] = 0;
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}