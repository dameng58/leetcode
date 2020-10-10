/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.栈;

/*
    每日温度
 */
public class P739 {

    public static void main(String[] args) {
        P739 p739 = new P739();
        // int[] input = {73, 74, 75, 71, 69, 72, 76, 73};
        //[89,62,70,58,47,47,46,76,100,70]
        int[] input = {89,62,70,58,47,47,46,76,100,70};
        int[] results = p739.dailyTemperatures(input);
        for (int result : results){
            System.out.print(result + ",");
        }
    }

    /*
        最蠢的办法
     */
    public int[] dailyTemperatures(int[] T) {
        if (T == null){
            return new int[]{};
        }
        int len = T.length - 1;
        int[] result = new int[len+1];
        int index = -1;
        for (int i = 0, j = i + 1; i <= len; i++, j = i + 1){
            //这里是小于和等于
            while (j <= len && T[j] <= T[i]){
                j++;
            }
            //这里是需要判断，因为有可能后面没有比这个数大的了
            if (j <= len && T[j] > T[i]){
                result[++index] = j - i;
            }else {
                result[++index] = 0;
            }

        }
        return result;

    }
}
