/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.迭代递归;

import lettcode.链表.ListNode;


public class P24 {
    public ListNode swapPairs(ListNode head) {
        ListNode vHead = new ListNode(-1, head);
        ListNode nowListNode = vHead;
        while (nowListNode.next != null && nowListNode.next.next != null){
            // ListNode tempListNode = nowListNode.next.next;
            // nowListNode.next.next = nowListNode;
            // nowListNode.next = tempListNode;

            ListNode tempListNode = nowListNode.next.next;
            ListNode nextListNode = tempListNode.next;
            tempListNode.next = nowListNode.next;
            nowListNode.next.next = nextListNode;
            nowListNode.next = tempListNode;

            nowListNode = nowListNode.next.next;
        }
        return vHead.next;
    }
}
