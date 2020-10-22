/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.搜索算法;

import java.util.HashMap;

public class P105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            hashMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length, hashMap);
    }

    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end,
        int[] inorder, int i_start, int i_end,
        HashMap<Integer, Integer> hashMap) {
        // preorder 为空，直接返回 null
        if (p_start == p_end) {
            return null;
        }
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        //在中序遍历中找到根节点的位置
        int i_root_index = hashMap.get(root_val);
        int leftNum = i_root_index - i_start;
        //递归的构造左子树
        root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1,
            inorder, i_start, i_root_index,
            hashMap);
        //递归的构造右子树
        root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end,
            inorder, i_root_index + 1, i_end,
            hashMap);
        return root;
    }
}
