package lettcode.哈希表;

//MyHashMap
public class P706 {
    private int[] array;
    private boolean[] arrayFlag;
    private int keyRange;

    /** Initialize your data structure here. */
    public P706() {
        // this.keyRange = 769;
        this.keyRange = 10000;
        // this.bucketArray = new Bucket[this.keyRange];
        // for (int i = 0; i < this.keyRange; ++i)
        //     this.bucketArray[i] = new Bucket();
        this.array = new int[this.keyRange];
        this.arrayFlag = new boolean[this.keyRange];
    }

    protected int _hash(int key) {
        return (key % this.keyRange);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = this._hash(key);
        if (!this.arrayFlag[index]){
            this.arrayFlag[index] = true;
        }

        this.array[index] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = this._hash(key);
        if (this.arrayFlag[index]){
            return this.array[index];
        }

        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = this._hash(key);
        if (this.arrayFlag[index]){
            this.arrayFlag[index] = false;
        }
    }

}


// class Bucket2 {
//     private LinkedList<Integer> container;
//
//     public Bucket2() {
//         container = new LinkedList<Integer>();
//     }
//
//     public void insert(Integer key) {
//         int index = this.container.indexOf(key);
//         if (index == -1) {
//             this.container.addFirst(key);
//         }
//     }
//
//     public void delete(Integer key) {
//         this.container.remove(key);
//     }
//
//     public boolean exists(Integer key) {
//         int index = this.container.indexOf(key);
//         return (index != -1);
//     }
// }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
