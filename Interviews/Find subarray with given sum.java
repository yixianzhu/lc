//O(n^2)
public class Solution {
	public static int[] subarray(int[] array, int sum){
		
		for(int i=0; i<array.length; i++){
			int curr_sum = array[i];
			int[] result = new int[2];
			for(int j=i+1; i<array.length && curr_sum<=sum; j++){
				if(curr_sum == sum){
					result[0] = i;
					result[1] = j;
					return result;
				}
				else curr_sum += array[j];
			}
		}
		int[] notfound = new int[2];
		return notfound;
	}

	public static void main(String[] args){
	int[] test1 = new int[] {1, 4, 20, 3, 10, 5};
	int sum1 = 33;
	System.out.println(subarray(test1,sum1)[0]+" to "+subarray(test1,sum1)[1]);

	}
}

//O(n)
public class solution2{
	public static boolean subsum(int[] array, int sum){
		if(array == null || array.length == 0) return false;

		int start = 0;
		int end = 1;
		int curr_sum = array[start];
		while(curr_sum <= sum){
			if(curr_sum == sum) return true;

			while(curr_sum<sum && end<array.length){
				curr_sum += array[end];
				end++;
			}

			while(curr_sum>sum && start<array.length){
				curr_sum -= array[start];
				start++;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
	int[] test1 = new int[] {1, 4, 20, 3, 10, 5};
	int sum1 = 33;
	System.out.println(subsum(test1,sum1));

	}
}
