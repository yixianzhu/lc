/*
Pattern.compile("\.");   // Java syntax error

// A regex that matches a (any) character
Pattern.compile(".");  

// A regex that matches a literal '.' character
Pattern.compile("\\.");  

// A regex that matches a literal '\' followed by one character
Pattern.compile("\\\\.");
*/


public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");//be careful!
        String[] v2 = version2.split("\\.");
        
        for(int i=0; i<Math.max(v1.length, v2.length); i++){//the "Math.max(x,y)" function
            int a = i<v1.length ? Integer.parseInt(v1[i]):0; //the decision function
            int b = i<v2.length ? Integer.parseInt(v2[i]):0;
            if(a<b){
                return -1;
            }else if(a>b){
                return 1;
            }
            //if a == b, it will go into next loop until return 0
        }
        return 0;
    }
}
