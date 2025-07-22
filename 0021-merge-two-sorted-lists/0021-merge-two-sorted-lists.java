/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(-1);
        ListNode finalPtr = ans;

        ListNode ptr1 = list1;
        ListNode ptr2 = list2;

        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val < ptr2.val) {
                ans.next = new ListNode(ptr1.val);
                ptr1 = ptr1.next;
            } else {
                ans.next = new ListNode(ptr2.val);
                ptr2 = ptr2.next;
            }

            ans = ans.next;
        }

        if (ptr1 != null) {
            ans.next = ptr1;
        }

        if (ptr2 != null) {
            ans.next = ptr2;
        }

        return finalPtr.next;
        
    }
}