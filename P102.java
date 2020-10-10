/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P102 {
    //超时了
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<>();
            Queue<TreeNode> queue1 = new LinkedList<>();
            Queue<TreeNode> queue2 = new LinkedList<>();
            TreeNode treeNode = root;
            queue1.offer(treeNode);
            while (queue1.size() > 0 || queue2.size() > 0){
                Queue<TreeNode> queue3 = queue1.size() == 0 ? queue1 : queue2;
                Queue<TreeNode> queue4 = queue1.size() != 0 ? queue1 : queue2;
                List<Integer> list = new ArrayList<>();

                while (queue4.size() > 0){
                    TreeNode tempNode = queue4.poll();
                    list.add(tempNode.val);
                    if (treeNode.right != null){
                        queue3.offer(treeNode.right);
                    }
                    if (treeNode.left != null){
                        queue3.offer(treeNode.left);
                    }
                }

                lists.add(list);
            }
            return lists;

        }

    }

    class Solution2 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<>();
            if (root != null){
                Queue<TreeNode> queue = new LinkedList<>();
                queue.offer(root);
                while (queue.size() > 0){
                    lists.add(core(queue));
                }
            }
            return lists;
        }

        private List<Integer> core(Queue<TreeNode> queue){
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0){
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if (treeNode.left != null){
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null){
                    queue.offer(treeNode.right);
                }
                --count;
            }
            return list;
        }

    }

}
