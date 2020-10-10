/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.链表;

/*
    思想：一快一慢，双指针思想
 */
public class P19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
            注意这里，需要虚拟一个头，从而避免空链表或者链表长度与n的值相同的情况。

         */
        ListNode realListNode = new ListNode(0);
        realListNode.next = head;
        ListNode quickNode = realListNode;
        ListNode slowNode = realListNode;
        int count = 0;
        while (quickNode.next != null){
            if (count < n){
                quickNode = quickNode.next;
            }else {
                quickNode = quickNode.next;
                slowNode = slowNode.next;
            }
            count++;
        }
        if (slowNode.next != null){
            slowNode.next = slowNode.next.next;
        }
        return realListNode.next;
    }
}

