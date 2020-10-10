/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.链表;

/*
    自己这里，只能找出重合的点，既第一次重合的点，但并不一定是环的点

    还有另一种idea，也就是利用Set的不重复性来解决
 */
public class P142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode resultListNode = getIntersect(head);
        if (resultListNode == null){
            return null;
        }
        /*
            这里即可以找回入环点
         */
        ListNode ptr1 = head;
        ListNode ptr2 = resultListNode;
        while (ptr1 != ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return  ptr1;
    }

    public ListNode getIntersect(ListNode head) {
        ListNode quickListNode = head;
        ListNode slowListNode = head;
        while (quickListNode != null && slowListNode != null && quickListNode.next != null){
            quickListNode = quickListNode.next.next;
            slowListNode = slowListNode.next;
            if (quickListNode == slowListNode){
                return quickListNode;
            }
        }
        return null;

    }
}
