public class SplitLinkedListinParts {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode a = new ListNode(1);
        a.next= new ListNode(2);
        a.next.next= new ListNode(3);
        a.next.next.next= new ListNode(4);
        solution.splitListToParts(a, 5);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private  static  class Solution {
        public ListNode[] splitListToParts(ListNode root, int k) {
            int toGive;
            int count=0;
            ListNode[] listNodes = new ListNode[k];
            ListNode listNode = root;
            while (root != null){
                count+=1;
                root=root.next;
            }

            int minimumParts=count/k;
            int remaining = count - minimumParts*k;
            ListNode prev = listNode;

            for(int i=0; i<k; i++){
                ListNode h= prev;

                if(remaining>0){
                    toGive=minimumParts + 1;
                    remaining-=1;
                }
                else {
                    toGive=minimumParts;
                }

                for(int j=1; j<toGive; j++){
                    prev=prev.next;
                }
                if(toGive>0) {
                    listNodes[i] = h;
                    ListNode m = prev;
                    prev = prev.next;
                    m.next = null;
                }
            }

            return listNodes;
        }
    }
}
