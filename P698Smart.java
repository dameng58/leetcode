/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.迭代递归;

/*
    回溯
    注意到这个时候的递归函数backtracking是有返回值的，为什么有的递归函数没有返回值，有的需要返回值呢？
    因为本题只要找到一个结果就行了，需要在找到这个结果的时候就立刻返回，也就是本题的
    if (backtracking(nums, k, target, cur+nums[i], i+1, used)) return true;
    如果需要找到所有的结果（所有的划分），那么这个时候的backtracking( )不需要返回值，这个时候添加一个参数ans（一个容器），
    用来装全部的结果。


 */
public class P698Smart {
    class Solution {
        private boolean backtracking(int[] nums, int k, int target, int cur, int start, boolean[] used) {
            // 返回条件
            if (k == 0) return true;
            if (cur == target) {
                // 构建下一个集合
                return backtracking(nums, k-1, target, 0, 0, used);
            }
            for (int i = start; i < nums.length; i++) {
                if (!used[i] && cur+nums[i] <= target) {
                    used[i] = true;
                    if (backtracking(nums, k, target, cur+nums[i], i+1, used)) return true;
                    used[i] = false;
                }
            }
            return false;
        }

        public boolean canPartitionKSubsets(int[] nums, int k) {
            // 注意nums[i] > 0
            int sum = 0, maxNum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (maxNum < nums[i]) maxNum = nums[i];
            }
            if (sum % k != 0 || maxNum > sum/k) return false;
            boolean[] used = new boolean[nums.length];
            return backtracking(nums, k, sum/k, 0, 0, used);
        }
    }
}
