/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P230 {
    class Solution {
        List<Integer> list = new ArrayList<>();

        public int kthSmallest(TreeNode root, int k) {
            boolean flag = true;
            if (flag){
                getAllValue(root);
                flag = false;
            }
            return list.get(k-1);
        }

        private void getAllValue(TreeNode root){
            Stack<TreeNode> stack = new Stack<>();
            while (stack.size() > 0 || root != null){
                while (root != null){
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }

    }
}
