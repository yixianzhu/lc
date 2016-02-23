/*
Given an array of meeting time intervals consisting of start and end times 
[[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.
*/

//correct solution
//learn the Comparator method
public boolean canAttendMeetings(Interval[] intervals) {
  if (intervals == null)
    return false;

  // Sort the intervals by start time
  Arrays.sort(intervals, new Comparator<Interval>() {
    @Override//should mark this line
    public int compare(Interval a, Interval b) { return a.start - b.start; }
  });

  for (int i = 1; i < intervals.length; i++)
    if (intervals[i].start < intervals[i - 1].end)
      return false;

  return true;
}

//another interesting and also tim saving method
private boolean canAttendMeetings(Interval[] intervals) {
    try {
        Arrays.sort(intervals, new IntervalComparator());
    } catch (Exception e) {
        return false;
    }
    return true;
}

private class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval o1, Interval o2) {
        if (o1.start < o2.start && o1.end <= o2.start)
            return -1;
        else if (o1.start > o2.start && o1.start >= o2.end)
            return 1;
        throw new RuntimeException();
    }
}

//another thought
public boolean canAttendMeetings(Interval[] intervals) {
        int len=intervals.length;
        if(len==0){
            return true;
        }
        int[]begin=new int[len];
        int[]stop=new int[len];
        for(int i=0;i<len;i++){
            begin[i]=intervals[i].start;
            stop[i]=intervals[i].end;
        }
        Arrays.sort(begin);
        Arrays.sort(stop);
        int endT=0;
        for(int i=1;i<len;i++){
            if(begin[i]<stop[i-1]){
                return false;
            }
        }
        return true;
}
