/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P173 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        root.left = treeNode3;
        root.right = treeNode15;
        treeNode15.left = treeNode9;
        treeNode15.right = treeNode20;
        BSTIterator iterator = new BSTIterator(root);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }

    /*
        即通过中序遍历，来找到
     */
    static class BSTIterator {
        List<Integer> list;
        int index;

        public BSTIterator(TreeNode root) {
            list = new ArrayList<>();
            index = 0;
            getALLValue(root);
        }


        /** @return the next smallest number */
        public int next() {
            if (hasNext()){
                return list.get(index++);
            }
            return -1;
        }

        private void getALLValue(TreeNode root){
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

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return list.size() > index;
        }
    }
}
