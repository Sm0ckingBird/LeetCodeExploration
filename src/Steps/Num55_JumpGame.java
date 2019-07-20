package May28;

public class Num55_JumpGame {
	
	//input:[2,3,1,1,4]
	//output:true
	//input:[3,2,1,0,4]
	//output:false
	
	//MyInitialSolution
	public static boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0)
        	return false;
        int length = nums.length;
        
        int cur = 0;
        int range = nums[cur];
        int max = range;
        
        while(true) {
        	int temp = cur;
        	int temp2 = range;
        	for(int i = 1; i <= temp2 && i < length; i++) {
        		if(temp+i+nums[temp+i] >= max) {
        			max = temp+i + nums[temp+i];
        			cur = temp + i;
        			range = nums[cur];
        		}
        	}
        	if(nums[cur] == 0 && cur != length - 1)
        		return false;
        	if(max >= length - 1)
        		return true;
        }
    }
	
	//贪心算法(从后往前跳)
	public static boolean canJump_greedy(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
	
	//动态规划   canJump[i] = canJump[i+1]||canJump[i+2]||...canJump[i+nums[i]]
	public static boolean canJump_DP(int[] nums) {
		if(nums == null || nums.length == 0)
			return false;
		
		int[] canJump = new int[nums.length];
		for(int i = nums.length - 1; i >= 0; i--) {
			if(nums[i] + i >= nums.length - 1)
				canJump[i] = 1;
			else {
				for(int j = 1; j <= nums[i]; j++) {
					if(canJump[i+j] == 1) {
						canJump[i] = 1;
						break;
					}
				}
			}
		}
		
		return canJump[0] == 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canJump_DP(new int[] {1,1,2,2,0,1,1}));
		System.out.println(canJump_DP(new int[] {1}));
	}

}
