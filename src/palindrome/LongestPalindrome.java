package palindrome;

public class LongestPalindrome {
	
	//找出最长的回文的长度
	//input:"abccccdd"
	//output:"7"
	
	public static int longestPalindrome(String s) {
		if(s == null || s.length() == 0)
			return 0;
		
		int result = 0;
		int[] store = new int[58];
		char[] chars = s.toCharArray();
		boolean odd = false;
		
		for(char c: chars) {
			store[c-'A']++;
		}
		
		for(int item: store) {
			if(item % 2 == 0)
				result += item;
			else {
				odd = true;
				result += (item - 1); 
			}
		}
		
		return odd == true? result + 1 : result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("ccccdd"));
	}

}
