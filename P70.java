/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.迭代递归;

public class P70 {
    public int climbStairs(int n) {
        return core2(n);
    }

    /*
        超时了
     */
    private int core(int n){
        if (n <= 2){
            return n;
        }else {
            return 1 + core(n - 1) + core(n - 2);
        }
    }

    /*
        通过了
     */
    private int core2(int n){
        if (n <= 2){
            return n;
        }
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        for (int i = 3; i < array.length; i++){
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }



}
