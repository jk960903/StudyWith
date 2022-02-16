package swapNodesinpairs;

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode temp = head;
        while(temp != null){
            int swap = temp.val;
            if(temp.next != null){
                temp.val = temp.next.val;
                temp.next.val = swap;
            }
            temp = temp.next;
            if(temp != null){
                temp = temp.next;
            }
        }
        
        return head;
    }
}
public class Main {

}
