package mao.yannan._0200_number_of_islands;

class Solution {

    public int numIslands(char[][] grid) {
        var count = 0;
        for (var r = 0; r < grid.length; r++) {
            for (var c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    fill(grid, r, c);
                }
            }
        }
        return count;
    }

    void fill(char[][] g, int r, int c) {
        if (r < 0 || r >= g.length || c < 0 || c >= g[0].length || g[r][c] == '0') {
            return;
        }
        g[r][c] = '0';
        fill(g, r + 1, c);
        fill(g, r - 1, c);
        fill(g, r, c + 1);
        fill(g, r, c - 1);
    }

}
