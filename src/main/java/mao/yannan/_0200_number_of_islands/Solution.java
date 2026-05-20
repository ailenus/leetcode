package mao.yannan._0200_number_of_islands;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {

    static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        var islands = 0;
        var rows = grid.length;
        var cols = grid[0].length;
        Set<String> visited = new HashSet<>();
        for (var row = 0; row < rows; row++) {
            for (var col = 0; col < cols; col++) {
                if (grid[row][col] == '1' && !visited.contains(row + "," + col)) {
                    islands++;
                    bfs(grid, row, col, visited, rows, cols);
                }
            }
        }
        return islands;
    }

    private static void bfs(char[][] grid, int row, int col, Set<String> visited, int rows, int cols) {
        Queue<int[]> queue = new LinkedList<>();
        visited.add(row + "," + col);
        queue.add(new int[] {row, col});
        while (!queue.isEmpty()) {
            var point = queue.poll();
            var r = point[0];
            var c = point[1];
            for (var direction : DIRECTIONS) {
                var newRow = r + direction[0];
                var newCol = c + direction[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == '1' && !visited.contains(newRow + "," + newCol)) {
                    queue.add(new int[] {newRow, newCol});
                    visited.add(newRow + "," + newCol);
                }
            }
        }
    }

}
