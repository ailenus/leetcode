package mao.yannan.floodfill;

class Solution {

    private int[][] image;
    private int m;
    private int n;
    private int oldColor;
    private int newColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.image = image;
        m = image.length;
        n = image[0].length;
        oldColor = image[sr][sc];
        newColor = color;
        fill(sr, sc);
        return image;
    }

    private void fill(int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || image[i][j] == newColor || image[i][j] != oldColor) {
            return;
        }
        image[i][j] = newColor;
        fill(i - 1, j);
        fill(i + 1, j);
        fill(i, j - 1);
        fill(i, j + 1);
    }

}
