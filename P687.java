/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.迭代递归;
import lettcode.树.TreeNode;

/*
    需要先理解题目，最长路径时什么意思
 */
public class P687 {
    int result;
    public int longestUnivaluePath(TreeNode root) {
        result = 0;
        core(root);
        return result;
    }

    private int core(TreeNode start){
        if (start == null){
            return 0;
        }
        int left = core(start.left);
        int right = core(start.right);
        int arrowLeft = 0;
        int arrowRight = 0;
        if (start.left != null && start.val == start.left.val){
            arrowLeft += left + 1;
        }
        if (start.right != null && start.val == start.right.val){
            arrowRight += right + 1;
        }
        result = Math.max(result, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }

}
