/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
*/


//The problem can be also transformed as max number of overlaps. 
//Analysis: Sorting two arrays take O(nlogn) time. Compare takes O(n) time. 
//So the overall time complexity is still bounded by O(nlogn). 
//总的来说算overlap就是要先排序，在算overlap
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
         
        int len = intervals.length;
        int[] startTime = new int[len];
        int[] endTime = new int[len];
         
        for (int i = 0; i < len; i++) {
            Interval curr = intervals[i];
            startTime[i] = curr.start;
            endTime[i] = curr.end;
        }
         
        // Sort the start and end time
        Arrays.sort(startTime);
        Arrays.sort(endTime);
         
        int activeMeetings = 0;//to record current overlap
        int numMeetingRooms = 0;
         
        int i = 0;
        int j = 0;
         
        while (i < len && j < len) {
            if (startTime[i] < endTime[j]) {
                activeMeetings++;
                numMeetingRooms = Math.max(numMeetingRooms, activeMeetings);//compare to check if there is a new max overlap number
                i++;
            } else {
                activeMeetings--;//change to update current overlap
                j++;
            }
        }
         
        return numMeetingRooms;
    }
}


//another method
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
         
        Arrays.sort(intervals, new IntervalComparator());
         
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int numRooms = 1;
         
        pq.offer(intervals[0].end);
         
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < pq.peek()) {
                numRooms++;
                pq.offer(intervals[i].end);
            } else {
                pq.poll();
                pq.offer(intervals[i].end);
            }
        }
         
        return numRooms;
         
    }
     
    public class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
}


