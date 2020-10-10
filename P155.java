/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.栈;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    这里使用minList来维护最小值的变化情况
    官方使用另一个栈来记录每个元素插入后对应的当前的最小值。
 */
public class P155 {
    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private List<Integer> minList;//记录最小值的变化情况
    public P155() {
        stack = new Stack<>();
        minList = new ArrayList<>();
        //这里要注意初始化第一个值，并且设置为Integer的最小值
        minList.add(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        setMinAndPriMin(x);
    }

    private void setMinAndPriMin(int x){
        if (x <= minList.get(minList.size()-1)){
            minList.add(x);
        }
    }

    public void pop() {
        if (stack.size() > 0){
            if (stack.peek().compareTo(minList.get(minList.size()-1)) == 0){
                minList.remove(minList.size()-1);
            }
            stack.pop();
        }
    }

    public int top() {
        try {
            return stack.peek();
        }catch (StackOverflowError stackOverflowError){
            throw stackOverflowError;
        }
    }

    public int getMin() {
        return minList.get(minList.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
