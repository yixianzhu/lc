//to do the calculation, use double

public class Solution {
	public static double[] averagewindow(double[] nums, double window){
		double len = nums.length;
		double[] average = new double[(int) (len+2-window)];
		if(len == 0|| nums == null) return average;
		if(window>len) return average;
		
		double temp=0;
		for(int j=0; j<window-1; j++){
			temp +=nums[j];
		}
		average[0] = temp/window;

		for(int i=0; i<len-window+1; i++){
			double temp2 = nums[i];
			for(int j=1; j<window; j++){
				temp2 +=nums[i+j];
			}
			average[i+1] = temp2/window;
		}
		return average;
	}

	public static void main(String[] args){
		double[] a = new double[] {1,2,3,4};
		double window = 2;
		for(double i : averagewindow(a, window))
			System.out.println(i);
	}
}
