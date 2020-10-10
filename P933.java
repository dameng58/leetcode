/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.队列;

import java.util.LinkedList;
import java.util.Queue;

//RecentCounter
public class P933 {
    Queue<Integer> queue;
    public P933() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.size() > 0 && queue.peek() < t - 3000){
            queue.poll();
        }
        return queue.size();
    }
}
