/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.队列;

import java.util.Deque;
import java.util.LinkedList;

public class P225 {
    private Deque<Integer> queue;
    /** Initialize your data structure here. */
    public P225() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.push(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.pop();
    }

    /** Get the top element. */
    public int top() {
        // return queue.peek() != null ? queue.peek() : -1;
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.size() == 0;
    }
}
