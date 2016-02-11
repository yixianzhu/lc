//my wrong solution
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m-1; i>=0; i--){
            for(int j = n-1; j>=0; j--){
                if(nums1[0]<=nums1[m-1] && nums2[0]<=nums2[n-1]){
                    if(nums1[i] > nums2[j] && i >= 0){
                        nums1[m+n-(m-i)-(n-j)+1] = nums1[i];
                        i--;
                        j++;
                    }else{
                        nums1[m+n-(m-i)-(n-j)+1] = nums2[j];
                    }
                }else{
                    if(nums1[i] < nums2[j] && i >= 0){
                        nums1[m+n-(m-i)-(n-j)+1] = nums1[i];
                        i--;
                        j++;
                    }else{
                        nums1[m+n-(m-i)-(n-j)+1] = nums2[j];
                    }
                }
                
            }
        }
    }
}

//correct solution
//可以自己改写成自己习惯的样子
public void merge(int A[], int m, int B[], int n) {
    int i=m-1, j=n-1, k=m+n-1;
    while (i>-1 && j>-1) A[k--]= (A[i]>B[j]) ? A[i--] : B[j--];
    while (j>-1)         A[k--]=B[j--];//j>-1是说i先到达0了
                                       //如果j先到达0的话，原来的元素就留着不动即可
                                       //如果i先到达0的话，其实就是把剩下的j的元素拷贝过去
}



