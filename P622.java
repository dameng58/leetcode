/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.队列;

public class P622 {
    public static void main(String[] args) {

    }
}

/*
    idea:使用一个int数组来实现，下标操作方式使用模运算
 */
class MyCircularQueue {
    private int[] array;
    private boolean[] arrayFlag;
    //当前队尾下标
    private int endIndex;
    private int startIndex;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        array = new int[k];
        arrayFlag = new boolean[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (!this.isFull()){
            array[endIndex] = value;
            arrayFlag[endIndex] = true;
            endIndex = (endIndex + 1) % this.array.length;
            return true;
        }else {
            return false;
        }
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (!this.isEmpty()){
            // endIndex = (endIndex + this.array.length - 1) % this.array.length;
            startIndex = getStartIndex();
            array[startIndex] = 0;
            arrayFlag[startIndex] = false;
            return true;
        }else {
            return false;
        }
    }

    private int getStartIndex(){
        for (int i = 0; i < this.arrayFlag.length; i++){
            if (arrayFlag[i]){
                return i;
            }
        }
        return -1;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (!this.isEmpty()){
            // for (int i = 0 ; i < array.length; i++){
            //     if (arrayFlag[i]){
            //         return array[i];
            //     }
            // }
            startIndex = getStartIndex();
            return this.array[startIndex];
        }
        return -1;

    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (!this.isEmpty()){
            // for (int i = array.length - 1 ; i >= 0; i--){
            //     if (arrayFlag[i]){
            //         return array[i];
            //     }
            // }
            return this.array[endIndex];
        }
        return -1;

    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        for (boolean flag : arrayFlag){
            if (flag){
                return false;
            }
        }
        return true;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        for (boolean flag : arrayFlag){
            if (!flag){
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
