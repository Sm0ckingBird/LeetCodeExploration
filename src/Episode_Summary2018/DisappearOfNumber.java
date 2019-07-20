package Episode_Summary2018;

import java.util.ArrayList;
import java.util.List;

public class DisappearOfNumber {
	
	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 1; i <= nums.length; i++)
            result.add(i);
        for(int i = 0; i < nums.length; i++)
            result.remove(Integer.valueOf(nums[i]));
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
