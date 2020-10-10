/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class P236 {
    /*
        思想：通过中序来生成list，将list转为数组，通过数组下标来判断
     */
    class Solution {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null){
                return null;
            }
            Map<Integer, TreeNode> map = new HashMap<>();
            List<Integer> valueList = getTreeNodeValue(root, map);
            int pIndex = valueList.indexOf(p.val);
            int qIndex = valueList.indexOf(q.val);
            TreeNode result = getResult(root, p, pIndex, qIndex, valueList, map);
            return result;

        }

        private TreeNode getResult(TreeNode root,
            TreeNode p, int pIndex, int qIndex, List<Integer> list, Map<Integer, TreeNode> map){
            if (pIndex != qIndex){
                if (pIndex < qIndex){
                    while (pIndex < qIndex){
                        qIndex = core(qIndex);
                    }
                }else {
                    while (pIndex > qIndex){
                        pIndex = core(pIndex);
                    }
                }

                if (pIndex == qIndex){
                    return map.get(list.get(pIndex));
                }

                return root;
            }else {
                return p;
            }
        }

        private int core(int num){
            if (num % 2 == 0){
                return (num - 1) / 2;
            }else {
                return num / 2;
            }
        }

        private List<Integer> getTreeNodeValue(TreeNode root, Map<Integer, TreeNode> map){
            List<Integer> list = new ArrayList<>();
            if (root != null){
                Queue<TreeNode> queue = new LinkedList<>();
                queue.offer(root);
                while (queue.size() > 0){
                    int count = queue.size();
                    while (count > 0){
                        TreeNode treeNode = queue.poll();
                        list.add(treeNode.val);
                        map.put(treeNode.val, treeNode);
                        if (treeNode.left != null){
                            queue.offer(treeNode.left);
                        }
                        if (treeNode.right != null){
                            queue.offer(treeNode.right);
                        }
                        count--;
                    }
                }
            }
            return list;
        }

    }

    /*
        正解：递归，正规的解法
     */
    class Solution2 {

        private TreeNode ans;

        public Solution2() {
            this.ans = null;
        }

        private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return false;
            boolean lson = dfs(root.left, p, q);
            boolean rson = dfs(root.right, p, q);
            if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
                ans = root;
            }
            return lson || rson || (root.val == p.val || root.val == q.val);
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            this.dfs(root, p, q);
            return this.ans;
        }
    }

    /*
        正解：存储父节点，聪明的解法
     */
    class Solution3 {
        Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
        Set<Integer> visited = new HashSet<Integer>();

        public void dfs(TreeNode root) {
            if (root.left != null) {
                parent.put(root.left.val, root);
                dfs(root.left);
            }
            if (root.right != null) {
                parent.put(root.right.val, root);
                dfs(root.right);
            }
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            dfs(root);
            while (p != null) {
                visited.add(p.val);
                p = parent.get(p.val);
            }
            while (q != null) {
                if (visited.contains(q.val)) {
                    return q;
                }
                q = parent.get(q.val);
            }
            return null;
        }
    }


}
