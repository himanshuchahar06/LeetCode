
class Solution {
    public ListNode middleNode(ListNode head) {

        ListNode curr = head;

        int size = 0;

        while (curr != null) {
            size++;
            curr = curr.next;
        }

      
        curr = head;

        for (int i = 0; i < size / 2; i++) {
            curr = curr.next;
        }

        return curr;
    }
}
