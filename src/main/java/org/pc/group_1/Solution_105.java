package org.pc.group_1;

import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 前序遍历 preorder = [3,1,9,20,15,7]
 * 中序遍历 inorder = [9,1,3,15,20,7]
 *
 * 1.前序遍历的首个元素即为根节点 root 的值；
 * 2.在中序遍历中搜索根节点 root 的索引 ，可将中序遍历划分为 [ 左子树 | 根节点 | 右子树 ] 。
 * 3.根据中序遍历中的左（右）子树的节点数量，可将前序遍历划分为 [ 根节点 | 左子树 | 右子树 ] 。
 *
 */
public class Solution_105 {
    HashMap<Integer, Integer> dic = new HashMap<>();
    int[] po;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }


    /**
     *
     * @param pre_root  根节点的位置
     * @param in_left   左边界
     * @param in_right  右边界
     * @return
     */
    TreeNode recur(int pre_root, int in_left, int in_right) {
        if(in_left > in_right) return null;
        TreeNode root = new TreeNode(po[pre_root]);// 初始化根节点 po 为 前序
        int i = dic.get(po[pre_root]); // root 节点的位置 ,在 中序 寻找 根节点 // 2
        root.left = recur(pre_root + 1, in_left, i - 1); // recur(1,0,1)
        root.right = recur(pre_root + i - in_left + 1, i + 1, in_right); // recur(3,3,5)
        return root;
    }

}


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
