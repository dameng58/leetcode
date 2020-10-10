/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.链表;

public class ListNode {
      int val;
      public ListNode next;
      public ListNode(int x) {
          this.val = x;
      }
      public ListNode(int x, ListNode next){
          this.val = x;
          this.next = next;
      }
  }
