package medium;

public class NumberOfIslands200 {
    public static int numIslands(char[][] grid) {
        int islandCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    searchIsland(grid, i, j);
                }
            }
        }
        return islandCount;
    }

    private static void searchIsland(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0';

        searchIsland(grid, i+1, j); //up
        searchIsland(grid, i-1, j); //down
        searchIsland(grid, i, j-1); //left
        searchIsland(grid, i, j+1); //right
    }
}
