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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<>();
        int i = 0;//initiate it here
        
        while(i<intervals.size() && intervals.get(i).end<newInterval.start){ //here it use linkedlist.size() method
           result.add(intervals.get(i));
           i++;
        }
        
        while(i<intervals.size() && intervals.get(i).start<=newInterval.end){
        //注意这里是原list的start<新元素的end时，也就是有overlap，就合并这俩
            newInterval = new Interval(
                Math.min(newInterval.start, intervals.get(i).start),
                Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        result.add(newInterval);
        while(i<intervals.size()) result.add(intervals.get(i++));
        return result;
    }
}
