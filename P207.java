/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.搜索算法;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class P207 {
    // 33/46
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (prerequisites.length < 1){
                return false;
            }
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> set = new HashSet<>();
            queue.add(prerequisites[0][0]);
            int result = 1;
            while (!queue.isEmpty()){
                int course = queue.poll();
                result = core(course, prerequisites, queue, set, result);
            }
            return result <= numCourses;
        }

        /*
            queue:待学习队列
            set:已学习队列
         */
        private int core(int course, int[][] prerequisites, Queue<Integer> queue, Set<Integer> set, int result){
            for (int i = 0; i < prerequisites.length; i++){
                if (course == prerequisites[i][0] && !set.contains(prerequisites[i][1])){
                    queue.add(prerequisites[i][1]);
                    set.add(prerequisites[i][1]);
                    result++;
                }
            }
            return result;
        }

        // private boolean existHuan(int[][] prerequisites){
        //     for (int i = 0; i < prerequisites.length; i++){
        //
        //     }
        // }

    }

    //dfs
    class Solution2 {
        List<List<Integer>> edges;
        int[] visited;
        boolean valid = true;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<>();
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<>());
            }
            visited = new int[numCourses];
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
            }
            for (int i = 0; i < numCourses && valid; ++i) {
                if (visited[i] == 0) {
                    dfs(i);
                }
            }
            return valid;
        }

        public void dfs(int u) {
            visited[u] = 1;
            for (int v: edges.get(u)) {
                if (visited[v] == 0) {
                    dfs(v);
                    if (!valid) {
                        return;
                    }
                } else if (visited[v] == 1) {
                    valid = false;
                    return;
                }
            }
            visited[u] = 2;
        }
    }

    //bfs
    class Solution3 {
        List<List<Integer>> edges;
        int[] indeg;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<List<Integer>>();
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<Integer>());
            }
            indeg = new int[numCourses];
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
                ++indeg[info[0]];
            }

            Queue<Integer> queue = new LinkedList<Integer>();
            for (int i = 0; i < numCourses; ++i) {
                if (indeg[i] == 0) {
                    queue.offer(i);
                }
            }

            int visited = 0;
            while (!queue.isEmpty()) {
                ++visited;
                int u = queue.poll();
                for (int v: edges.get(u)) {
                    --indeg[v];
                    if (indeg[v] == 0) {
                        queue.offer(v);
                    }
                }
            }

            return visited == numCourses;
        }
    }
}
