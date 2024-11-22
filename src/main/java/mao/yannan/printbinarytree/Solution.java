package mao.yannan.printbinarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

class Solution {

    public List<List<String>> printTree(TreeNode root) {
        var height = getHeight(root);
        List<List<String>> matrix = new ArrayList<>(height);
        var n = (int) Math.pow(2, height) - 1;
        for (var i = 0; i < height; i++) {
            List<String> row = new ArrayList<>();
            for (var j = 0; j < n; j++) {
                row.add("");
            }
            matrix.add(row);
        }
        bfs(root, height, 0, (n - 1) / 2, matrix);
        return matrix;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    private void bfs(TreeNode node, int height, int row, int column, List<List<String>> matrix) {
        if (node != null) {
            bfs(node.left, height, row + 1, column - (int) Math.pow(2, height - 2.0 - row), matrix);
            matrix.get(row).set(column, String.valueOf(node.val));
            bfs(node.right, height, row + 1, column + (int) Math.pow(2, height - 2.0 - row), matrix);
        }
    }

}
