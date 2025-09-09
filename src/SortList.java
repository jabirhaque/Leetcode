class SortList {
    public static void main(String[] args){
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3, null))));
        sortList(head);
    }

    public static ListNode sortList(ListNode head) {
        if (head == null){
            return head;
        }
        boolean swapped = true;
        while (swapped){
            swapped = false;
            ListNode prev = null;
            ListNode current = head;
            ListNode next = head.next;
            while (next!=null){
                ListNode grandnext = next.next;
                if (current.val > next.val){
                    swapped = true;
                    if (prev != null){
                        prev.next = next;
                    }else{
                        head = next;
                    }
                    next.next = current;
                    current.next = grandnext;
                    ListNode prevNext = next;
                    next = grandnext;
                    prev = prevNext;
                }else{
                    prev = current;
                    current = next;
                    next = grandnext;
                }
            }
        }
        return head;
    }
}