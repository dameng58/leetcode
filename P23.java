/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.链表;

/*
    这种想法是暴力
    还可以通过俩俩合并的方法来进行解
 */
public class P23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        ListNode head = new ListNode(0);
        ListNode nowListNode = head;
        while (true){

            ListNode tempListNode = null;
            int index = -1; // 判断哪个链表中最小，从而后移一步
            for (int i = 0; i < len; i++){
                if (lists[i] == null){
                    continue;
                }
                if (tempListNode == null || lists[i].val < tempListNode.val){
                    tempListNode = lists[i];
                    index = i;
                }
            }
            if (index == -1){
                break;
            }

            nowListNode.next = tempListNode;
            nowListNode = nowListNode.next;
            lists[index] = lists[index].next;
        }
        return head.next;

    }

}
