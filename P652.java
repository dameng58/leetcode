/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.哈希表;

import lettcode.树.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P652 {
    List<TreeNode> list;
    HashMap<String, Integer> hashMap;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        list = new ArrayList<>();
        hashMap = new HashMap<>();
        getTreeNodeStr(root);
        return list;
    }

    public String getTreeNodeStr(TreeNode node){
        if(node == null) {
            return null;
        }
        String str = node.val + "," + getTreeNodeStr(node.left) + "," + getTreeNodeStr(node.right);
        hashMap.put(str, hashMap.getOrDefault(str, 0) + 1);
        //这里大于1和等于2是俩个概念，为了去重
        // if (hashMap.get(str) > 1){
        if (hashMap.get(str) == 2){
            list.add(node);
        }
        return str;
    }

}
