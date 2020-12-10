package com.shaip27.algo.array.twopointer;




 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }


public class LinkedListCycle {
	
	public boolean hasCycle(ListNode head) {
		
		if (head ==null) return false;
	    if (head.next ==null) return false;
		
		ListNode fast = head.next, slow = head;
		while(slow!=fast) {
			if(fast==null || fast.next == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
    }

	public static void main(String[] args) {
		

	}

}
