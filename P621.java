/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.队列;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class P621 {
    public int leastInterval(char[] tasks, int n) {
        if (n <= 0 || tasks == null || tasks.length <= 0){
            return -1;
        }
        Queue<Character> queue1 = new LinkedList<>();
        Queue<Character> queue2 = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (char cha : tasks){
            queue1.offer(cha);
        }
        while (!queue1.isEmpty() || !queue2.isEmpty()){
            count = core(queue1, queue2, map, n, count);
        }
        return count;
    }

    private int core(Queue<Character> queue1, Queue<Character> queue2, Map<Character, Integer> map, int n,
        int count){
        Queue<Character> taskQueue = queue1.size() == 0 ? queue2 : queue1;
        Queue<Character> emptyQueue = queue1.size() == 0 ? queue1 : queue2;
        for (char cha : taskQueue){
            if(!map.containsKey(cha)){
                map.put(cha, n);
            }
            decOfTime(taskQueue, emptyQueue, map, n, count);
        }
        return count;
    }

    private void decOfTime(Queue<Character> taskQueue, Queue<Character> emptyQueue, Map<Character, Integer> map,
        int n, int count){
        boolean flag1 = false;
        boolean flag2 = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            int times = entry.getValue();
            if (times >= 1 && taskQueue.size() >= 1){
                char cha = taskQueue.remove();
                emptyQueue.add(cha);
                flag1 = true;
            }else if (times - 1 <= -1){
                map.put(entry.getKey(), n);
            }else {
                flag2 = true;
                map.put(entry.getKey(), --times);
            }
        }
        if (flag1 || flag2){
            ++count;
        }
    }

    public static void main(String[] args) {
        P621 p621 = new P621();
        int result = p621.leastInterval(new char[]{'A','A','A','B','B','B'}, 2);
        System.out.println(result);
    }

}
