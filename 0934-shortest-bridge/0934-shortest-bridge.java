import java.util.*;
class Solution {
    int[][] directions = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
                    found = true;
                    break;
                }
            }
        }
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow < 0 || newRow >= n ||
                        newCol < 0 || newCol >= n) {
                        continue;
                    }
                      if (grid[newRow][newCol] == 1) {
                        return distance;
                    }
                    if (grid[newRow][newCol] == 0) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
            distance++;
        }
        return -1;
    }
    private void dfs(int[][] grid, int row, int col,
                     Queue<int[]> queue) {
        int n = grid.length;
        if (row < 0 || row >= n ||
            col < 0 || col >= n ||
            grid[row][col] != 1) {
            return;
        }
        grid[row][col] = 2;
        queue.offer(new int[]{row, col});
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            dfs(grid, newRow, newCol, queue);
        }
    }
}