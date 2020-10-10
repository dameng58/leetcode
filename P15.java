/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.线性表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15 {
    /*
        自己想的思路:固定左右俩个，来找中间那一个
        人家的思路：先排序，固定左边那个，找右边的俩个!!!!!!还是双指针，用到死！
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums == null || nums.length <= 2){
            return resultList;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            //高效条件
            if (nums[i] > 0){
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int middle = i + 1;
            int rightPK = nums.length - 1;
            while (middle < rightPK){
                int target = nums[i] + nums[middle] + nums[rightPK];
                if (target == 0){
                    resultList.add(Arrays.asList(nums[i], nums[middle], nums[rightPK]));
                    while (middle < rightPK && nums[middle] == nums[middle + 1]){
                        middle++;
                    }
                    while (middle < rightPK && nums[rightPK] == nums[rightPK - 1]){
                        rightPK--;
                    }
                    /*
                        我人都傻了？
                     */
                    middle++;
                    rightPK--;
                }else if (target < 0){
                    middle++;
                }else {
                    rightPK--;
                }
            }
        }

        return resultList;
    }

}
