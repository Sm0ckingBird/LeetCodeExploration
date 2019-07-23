package Episode_Summary2018;

public class ProductExecptSelf {
	
	public static int[] productExceptSelf(int[] nums) {
		int[] result = new int[nums.length];
        int[] right = new int[nums.length];
        int[] left = new int[nums.length];
        
        int temp = 1;
        right[nums.length-1] = 1;
        left[0] = 1;
        for(int i = 1; i < nums.length; i++) {
        	temp *= nums[i - 1];
        	left[i] = temp;
        }
        
        temp = 1;
        for(int i = nums.length - 2; i > -1; i--) {
        	temp *= nums[i + 1];
        	right[i] = temp;
        }
        
        for(int i = 0; i < result.length; i++)
        	result[i] = left[i] * right[i];
        
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		productExceptSelf(new int[] {1,2,3,4});
	}

}
