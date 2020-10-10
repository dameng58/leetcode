/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.哈希表;

/*
    内部使用数组来实现，如果可能的话考虑使用数组链表实现。
 */
public class P705 {
    /** Initialize your data structure here. */
    private int[] array;
    private boolean[] arrayFlags;
    public P705() {
        array = new int[10000];
        arrayFlags = new boolean[10000];
    }

    public void add(int key) {
        int hashKey = key % 100;
        array[hashKey] = key;
        arrayFlags[hashKey] = true;
    }

    public void remove(int key) {
        int hashKey = key % 100;
        if (arrayFlags[hashKey]){
            array[hashKey] = key + 1;
            arrayFlags[hashKey] = false;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashKey = key % 100;
        return arrayFlags[hashKey] && array[hashKey] == key;
    }

    public static void main(String[] args) {

         //Your MyHashSet object will be instantiated and called as such:
        P705 obj = new P705();
        obj.add(1);
        obj.add(2);
        obj.remove(1);
        boolean param_3 = obj.contains(1);
        System.out.println(param_3);
    }

}
