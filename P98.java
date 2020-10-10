/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.树;

import java.util.Stack;

public class P98 {
    public static void main(String[] args) {
        System.out.println(13245.123124f);
    }
    // 70/75,没有考虑到具体情况
    class Solution {
        public boolean isValidBST(TreeNode root) {
            if (root != null){
                boolean flag1 = true;
                boolean flag2 = true;
                if (root.right != null){
                    flag1 &= root.right.val > root.val && isValidBST(root.right);
                }
                if (root.left != null){
                    flag2 &= root.left.val < root.val && isValidBST(root.left);
                }
                return flag1 & flag2;
            }
            return true;
        }

    }

    //暴力解法
    class Solution2 {
        public boolean isValidBST(TreeNode root) {
            return core(root, null, null);
        }

        //这里需要用Integer而不是Int，因为第一次root进来的时候是不需要比较的，所以你懂得
        private boolean core(TreeNode treeNode, Integer low, Integer high){
            if (treeNode == null){
                return true;
            }

            int val = treeNode.val;
            if (low != null && val <= low){
                return false;
            }

            if (high != null && val >= high){
                return false;
            }

            if (!core(treeNode.left, low, val)){
                return false;
            }

            if (!core(treeNode.right, val, high)){
                return false;
            }

            return true;

        }

    }

    //最聪明的做法
    class Solution3 {
        public boolean isValidBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            Long previousValue = -Long.MAX_VALUE;

            while (stack.size() > 0 || root != null){
                while (root != null){
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.val <= previousValue){
                    return false;
                }
                previousValue = (long) root.val;
                root = root.right;
            }
            return true;

        }
    }

}
