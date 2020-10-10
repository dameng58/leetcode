/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.堆;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P692 {

    /*
        暴力解法
     */
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> count = new HashMap<>();
            for (String str : words){
                count.put(str, count.getOrDefault(str, 1) + 1);
            }

            List<String> result = new ArrayList<>(count.keySet());
            /*
                还能这么用
             */
            result.sort((w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w1.compareTo(w2) : count.get(w2) - count.get(w1));
            return result.subList(0, k);
        }
    }

    /*
        计算每个单词的频率，然后将其添加到存储到大小为 k 的小根堆中。它将频率最小的候选项放在堆的顶部。
        最后，我们从堆中弹出最多 k 次，并反转结果，就可以得到前 k 个高频单词。

        感觉其实和暴力没什么区别

     */
    class Solution2 {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> count = new HashMap<>();
            for (String word: words) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
            PriorityQueue<String> heap = new PriorityQueue<>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                    w2.compareTo(w1) : count.get(w1) - count.get(w2) );

            for (String word: count.keySet()) {
                heap.offer(word);
                if (heap.size() > k) heap.poll();
            }

            List<String> ans = new ArrayList<>();
            while (!heap.isEmpty()) ans.add(heap.poll());
            Collections.reverse(ans);
            return ans;
        }
    }

}


