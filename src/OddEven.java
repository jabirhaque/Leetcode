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
class OddEven {
    public static void main(String[] args){
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(oddEvenList(head));
    }

    public static ListNode oddEvenList(ListNode head) {
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = head.next;
        while (odd != null && odd.next != null && odd.next.next != null || even != null && even.next != null && even.next.next != null){
            if (odd != null && odd.next != null && odd.next.next != null){
                odd.next = odd.next.next;
                odd = odd.next;
            }
            if (even != null && even.next != null && even.next.next != null){
                even.next = even.next.next;
                even = even.next;
            }
        }
        odd.next = evenHead;
        return oddHead;
    }
}