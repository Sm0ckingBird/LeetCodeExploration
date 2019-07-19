package Episode_Summary2018;

import java.util.ArrayList;
import java.util.List;

public class Partition {
	
	
	// 回溯问题最好不要传入整个String，直接传入下标就好
	// "aab"
	// [
	//  ["aa","b"],
	//  ["a","a","b"]
	// ]
	
	
	public static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
        if(s == null || s.length() == 0)
        	return result;
        
        List<String> part = new ArrayList<String>();
        
        partition_recursion(s, part, result);
		
		return result;
    }
	
	public static void partition_recursion(String s, List<String> midResult, List<List<String>> result){
		if(s.length() == 0) {
			List<String> part = new ArrayList<String>();
			part.addAll(midResult);			
			result.add(part);
			return;
		}
		
		for(int i = 1; i <= s.length(); i++) {
        	String first = s.substring(0,i);
        	if(isPalindrome(first)) {
        		midResult.add(first);
        		
        		partition_recursion(s.substring(i), midResult, result);
        		
        		midResult.remove(midResult.size() - 1);
        	}
        }
	}
	
	public static boolean isPalindrome(String s) {
		if(s.length() == 0 || s == null)
			return false;
		int low = 0;
		int high = s.length() - 1;
		while(low < high) {
			if(s.charAt(low) != s.charAt(high))
				break;
			low++;
			high--;
		}
		return low >= high;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		partition("cbbbcc");
	}

}
