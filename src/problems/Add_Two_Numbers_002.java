package problems;

import Tools.ListNode;

/*
You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain 
a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8


 */
public class Add_Two_Numbers_002 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // Check base case
    if(l1 == null && l2 == null) {
      return null;
    }
    
    int carry = 0;
    ListNode head = new ListNode(0);
    ListNode point = head;
    
    while(l1 != null && l2 != null) {
      int sum = l1.val + l2.val + carry;
      point.next = new ListNode(sum % 10);
      point = point.next;
      carry = sum / 10;
      l1 = l1.next;
      l2 = l2.next;
    }
    
    if(l1 != null)
      point.next = addListNode(l1, carry);
    else 
      point.next = addListNode(l2, carry);
      
    return head.next;
    
  }

  public ListNode addListNode(ListNode head, int carry) {
    ListNode newhead = new ListNode(0);
    ListNode point = newhead;
    
    while(head != null) {
      int sum = head.val + carry;
      point.next = new ListNode(sum % 10);
      point = point.next;
      head = head.next;
      carry = sum / 10;
    }
    
    if(carry != 0){
      point.next = new ListNode(carry);
    }
    
     return newhead.next;
  }
}
