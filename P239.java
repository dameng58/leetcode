/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.堆;

import java.util.ArrayDeque;

public class P239 {
    /*
        疑问来了，为什么要放在堆里面做？

     */
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (k == 1){
                return nums;
            }
            int heapSize = nums.length;
            buildMaxHeap(nums, heapSize);
            int[] result = new int[nums.length + 1 - k];
            // for ()
            return nums;
        }

        private void buildMaxHeap(int[] a, int heapSize){
            for (int i = heapSize / 2; i >= 0; i--){
                adjustMaxHeap(a, i, heapSize);
            }
        }

        private void adjustMaxHeap(int[] a, int i, int heapSize){
            int l = i * 2 + 1;
            int r = i * 2 + 2;
            int largest = i;
            if (l < heapSize && a[l] > a[largest]){
                largest = l;
            }
            if (r < heapSize && a[r] > a[largest]){
                largest = r;
            }
            if (largest != i){
                swap(a, i, largest);
                adjustMaxHeap(a, largest, heapSize);
            }
        }

        private void swap(int[] a, int i, int j){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

    }

    /*
        暴力解法，超时
     */
    class Solution2 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int len = nums.length;
            if (len * k == 0){
                return new int[0];
            }
            int[] output = new int[len - k + 1];
            for (int i = 0; i < len - k + 1; i++){
                int value = Integer.MIN_VALUE;
                for (int j = i; j < i + k; j++){
                    value = Math.max(value, nums[j]);
                }
                output[i] = value;
            }
            return output;
        }
    }

    /*
        牛逼，窗口中只保留最大值，从而提高了效率，牛逼
     */
    class Solution3 {
        ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
        int [] nums;

        public void clean_deque(int i, int k) {
            // remove indexes of elements not from sliding window
            if (!deq.isEmpty() && deq.getFirst() == i - k)
                deq.removeFirst();

            // remove from deq indexes of all elements
            // which are smaller than current element nums[i]
            while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]){
                deq.removeLast();
            }
        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            if (n * k == 0) return new int[0];
            if (k == 1) return nums;

            // init deque and output
            this.nums = nums;
            int max_idx = 0;
            for (int i = 0; i < k; i++) {
                clean_deque(i, k);
                deq.addLast(i);
                // compute max in nums[:k]
                if (nums[i] > nums[max_idx]) max_idx = i;
            }
            int [] output = new int[n - k + 1];
            output[0] = nums[max_idx];

            // build output
            for (int i  = k; i < n; i++) {
                clean_deque(i, k);
                deq.addLast(i);
                output[i - k + 1] = nums[deq.getFirst()];
            }
            return output;
        }
    }

}
