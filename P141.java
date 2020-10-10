/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.链表;

public class P141 {
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode quickListNode = head;
        ListNode slowListNode = head;
        while (quickListNode != null && slowListNode != null && quickListNode.next != null){
            quickListNode = quickListNode.next.next;
            slowListNode = slowListNode.next;
            if (quickListNode == slowListNode){
                return true;
            }
        }
        return false;

    }
}
