/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.队列;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
    因此我们得到了一种安排的方法：我们规定 n + 1 个任务为一轮，这样的好处是同一轮中一个任务最多只能被安排一次。
    在每一轮中，我们将当前的任务按照它们剩余的次数降序排序，并选择剩余次数最多的 n + 1 个任务依次执行。
    如果任务的种类 t 少于 n + 1 个，就只选择全部的 t 种任务，其余的时间空闲。
    这样做的正确性在于，由于冷却时间的存在，出现次数较多的那些任务如果不尽早安排，将会导致大量空闲时间的出现，
    因此贪心地将出现次数较多的任务安排在前面是合理的。同时我们可以保证，这一轮的第 k 个任务距离上一次执行至少有 n 个单位的冷却时间。
    我们可以使用逆向思维来证明：假设第 r 轮中某个任务在第 k 个执行，那么说明它在第 r 轮时为数量第 k 多的任务。
    在第 r 轮结束后，第 1 多到第 k 多的任务的数量都会减少 1，因此在第 r + 1 轮，这个任务最多也只能是数量第 k 多，因此它如果被执行，
    一定满足冷却时间的要求。根据上面的安排方法，我们每一轮选择不超过 n + 1 个任务执行，直到所有的任务被执行。
 */

/*
    1、简单排序，使用数组实现
    2、使用优先队列，该solution推荐
 */
public class P621Smart {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        PriorityQueue< Integer > queue = new PriorityQueue < > (26, Collections.reverseOrder());
        for (int f: map) {
            if (f > 0)
                queue.add(f);
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            List< Integer > temp = new ArrayList< >();
            while (i <= n) {
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1)
                        temp.add(queue.poll() - 1);
                    else
                        queue.poll();
                }
                time++;
                if (queue.isEmpty() && temp.size() == 0)
                    break;
                i++;
            }
            queue.addAll(temp);
        }
        return time;
    }
}

