//my wrong solution
//didn't concider the situation when they are not overlapped
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int overlap = 0;
        if()
        int overlap = ((C<=G? C:G)-(E>=A? E:A))*((H<=D? H:D)-(B>=F? B:F));
        return (G-E)*(H-F)+(C-A)*(D-B)-overlap;
    }
}

//correct solution
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int firstrec = (C-A)*(D-B);
        int secondrec = (G-E)*(H-F);
        
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        
        int overlap = 0;
        if(left<right && bottom<top){
            overlap = (right-left)*(top-bottom);
        }
        
        return firstrec+secondrec-overlap;
    }
}
