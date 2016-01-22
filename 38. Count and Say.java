public class Solution {
    public String countAndSay(int n) {
        
        if(n <= 0) return "";
        if(n == 1) return "1";
        if(n == 2) return "11";
        
        String str = "11";
        
        for(int i=3; i<=n; i++){
            String temp = "";
            //刚开始我用当前的第j个和j+1个相比，这样的话最后一个很难处理
            //正确做法是先把第一个存出来，然后那之后的和之前的相比 
            int num = Character.getNumericValue(str.charAt(0));
            int count = 1;
            for(int j=1; j<str.length(); j++){
                if (Character.getNumericValue(str.charAt(j))!=num){
                    temp = temp + count + num;
                    count=1;
                    num = Character.getNumericValue(str.charAt(j));
                }
                else count++;
            }
            temp = temp + count + num;//这句一定要有，处理最后一位的
            str = temp;
        }
        return str;
    }
}

//correct solution using StringBuilder
public class Solution {
    public String countAndSay(int n) {
            StringBuilder curr=new StringBuilder("1");
            StringBuilder prev;
            int count;
            char say;
            for (int i=1;i<n;i++){
                prev=curr;
                curr=new StringBuilder();       
                count=1;
                say=prev.charAt(0);

                for (int j=1,len=prev.length();j<len;j++){
                    if (prev.charAt(j)!=say){
                        curr.append(count).append(say);
                        count=1;
                        say=prev.charAt(j);
                    }
                    else count++;
                }
                curr.append(count).append(say);
            }                   
            return curr.toString();

    }
}
