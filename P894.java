/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.迭代递归;

import lettcode.树.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
    入门级应该不考，考了我认了
 */
public class P894 {
    class Solution {
        Map<Integer, List<TreeNode>> memo = new HashMap();

        public List<TreeNode> allPossibleFBT(int N) {
            if (!memo.containsKey(N)) {
                List<TreeNode> ans = new LinkedList();
                if (N == 1) {
                    ans.add(new TreeNode(0));
                } else if (N % 2 == 1) {
                    for (int x = 0; x < N; ++x) {
                        int y = N - 1 - x;
                        for (TreeNode left: allPossibleFBT(x))
                            for (TreeNode right: allPossibleFBT(y)) {
                                TreeNode bns = new TreeNode(0);
                                bns.left = left;
                                bns.right = right;
                                ans.add(bns);
                            }
                    }
                }
                memo.put(N, ans);
            }

            return memo.get(N);
        }
    }

}
