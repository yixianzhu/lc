public class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        注意这个格式
        for (int i:nums) {
            if (!set.contains(i)) {
                pq.offer(i);
                set.add(i);
                if (pq.size() > 3) {
                注意这里要remove掉poll出来的
                    set.remove(pq.poll());
                }
            }
        }
        if (pq.size() < 3) {
            while(pq.size() > 1) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
