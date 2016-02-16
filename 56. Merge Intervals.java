/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
//my wrong solution
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals==null||intervals.size()==0) return intervals;
        if(intervals.size()==1) return intervals;
        //以上两行可以合并的
        List<Interval> result = new ArrayList<Interval>();
        for(int i=0; i<intervals.size(); i++){
            Interval newInterval = intervals.get(i);
            while(i+1<intervals.size() && newInterval.end>=intervals.get(i+1).start){
                newInterval = new Interval(newInterval.start, intervals.get(i+1).end);
                i++;
            }
            result.add(newInterval);
        }
        return result;
    }
}

//correct solution
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals==null||intervals.size()==0) return intervals;
        if(intervals.size()==1) return intervals;
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                return Integer.compare(i1.start, i2.start);
            }
        });
        
        List<Interval> result = new ArrayList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for(Interval interval: intervals){
            if(interval.start<=end){//overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            }else{ // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        
        retult.add(new Interval(start, end));//别忘了加上最后一个interval
        return result;
    }
}
