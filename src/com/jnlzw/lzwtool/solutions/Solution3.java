package com.jnlzw.lzwtool.Solutions;

class Solution3 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null) return null;
        ListNode temp = head;
        int size = 0;
        while (null != temp) {
            size += 1;
            temp = temp.next;
        }
        k = k % size;
        if (k == 0) return head;
        temp = head;
        int step = size - k;
        while (step-- > 1) temp = temp.next;
        ListNode temp2=temp.next;
        ListNode temp3=temp.next;
        temp.next=null;
        while (temp2.next!=null)temp2=temp2.next;
        temp2.next=head;
        return temp3;
    }
}
