/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P144 {
    //超时了
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode node = root;
            while (node != null){
                list.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                if (queue.size() > 0){
                    node = queue.poll();
                }

            }
            return list;
        }

    }

    class Solution2 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root != null){
                core(root, list);
            }
            return list;
        }

        private void core(TreeNode treeNode, List<Integer> list){
            if (treeNode == null){
                return;
            }
            list.add(treeNode.val);
            if (treeNode.left != null){
                core(treeNode.left, list);
            }
            if (treeNode.right != null){
                core(treeNode.right, list);
            }
        }

    }

}
