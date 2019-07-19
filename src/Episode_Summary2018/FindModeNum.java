package Episode_Summary2018;

public class FindModeNum {
	
	public static int majorityElement(int[] nums) {
		if(nums.length == 0)
			return Integer.MIN_VALUE;
        int mode = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
        	int cur = nums[i];
        	if(cur == mode)
        		count++;
        	else {
        		count--;
        		if(count == 0) {
        			mode = cur;
        			count = 1;
        		}
        	}
        }
        return mode;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(majorityElement(new int[] {1,2,1,4,1,1}));
	}

}
