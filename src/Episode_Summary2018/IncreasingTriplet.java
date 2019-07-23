package Episode_Summary2018;

public class IncreasingTriplet {
	
	public static boolean increasingTriplet(int[] nums) {
		if(nums == null || nums.length <= 2)
			return false;
		//For temporary triplet.
        int[] temp = new int[3];
        int index = -1;
        
        for(int i = 0; i < nums.length; i++) {
        	if(index == -1 || temp[index] <= nums[i]) {
        		index++;
        		if(index == 2)
        			return true;
        		temp[index] = nums[i];
        	}
        	else {
        		index = -1;
        		i--;
        	}
        }
        
        
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(increasingTriplet(new int[] {5,1,5,5,2,5,4}));
	}

}
