/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.堆;

import java.util.HashSet;
import java.util.PriorityQueue;

public class P264 {


}

class Ugly {
    public int[] nums = new int[1690];
    Ugly() {
        HashSet<Long> seen = new HashSet();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        seen.add(1L);
        heap.add(1L);

        long currUgly, newUgly;
        int[] primes = new int[]{2, 3, 5};
        for(int i = 0; i < 1690; ++i) {
            currUgly = heap.poll();
            nums[i] = (int)currUgly;
            for(int j : primes) {
                newUgly = currUgly * j;
                if (!seen.contains(newUgly)) {
                    seen.add(newUgly);
                    heap.add(newUgly);
                }
            }
        }
    }
}

class Solution {
    public static Ugly u = new Ugly();
    public int nthUglyNumber(int n) {
        return u.nums[n - 1];
    }
}
