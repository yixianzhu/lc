/*
将每个list的最小节点放入一个priority queue (min heap)中。
之后每从queue中取出一个节点，则将该节点在其list中的下一个节点插入，
以此类推直到全部节点都经过priority queue。由于priority queue的大小为始终为k，
而每次插入的复杂度是log k，一共插入过nk个节点。
时间复杂度为O(nk logk)，空间复杂度为O(k)。
*/
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else 
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}
