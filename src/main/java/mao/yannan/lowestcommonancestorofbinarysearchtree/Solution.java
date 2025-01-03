package mao.yannan.lowestcommonancestorofbinarysearchtree;

/**
 * Definition for a binary tree node.
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

}

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - (long) p.val) * (root.val - (long) q.val) > 0) {
            root = p.val < root.val ? root.left : root.right;
        }
        return root;
    }

}
