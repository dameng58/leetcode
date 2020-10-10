/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.排序;

/*
    感觉官方解释的比较难以理解，这道题可以理解为折线图，求波峰+波谷的数量
    例如题目的例子 1,7,4,9,2,5，波峰是7,9,5，波谷是1,4,2，结果是3+3=6；
    对于平峰，只会当做一个波峰或者波谷
    所以问题转化为求波峰波谷的数量和
    那么题解就比较简单了，只需要在相邻点发生差值变化的时候，结果集++即可

    pre = 0 初始解释：我认为没有统计的时候是平峰（可以这么想，在前面补1个跟nums[0]一样的数据，由于是平峰，不会影响结果）
    result = 1 初始解释：平峰的时候，结果是1（同上）

    (cur > 0 && pre <= 0) || (cur < 0 && pre >= 0) 这个判断条件，发生波峰下降或者波谷上升的时候，
    进入累加的逻辑里面，并且我们除了一开始的平峰会记录pre=0，其他时候，平峰都不会统计，所以发生一次变化之后，pre不再可能为0了。
    所以pre<=0 pre>=0,那个等于号只有第一次变化的时候才有生效

 */
public class P376Real {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        // 计算方法应该比较简单，先确定一个顺序，当出现变化时，结果++
        int pre = 0;
        int result = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            int cur = nums[i + 1] - nums[i];
            // 如果出现交替，则结果长度+1，并且将cur 替换 pre
            if ((cur > 0 && pre <= 0) || (cur < 0 && pre >= 0)) {
                result++;
                pre = cur;
            }
        }

        return result;
    }
}
