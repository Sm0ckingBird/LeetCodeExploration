package palindrome;

public class IsPalindromeString2 {
	
	//判断是否是回文
	
	public static boolean isPalindromeString(String s) {
		char[] chars = s.toCharArray();
		
		int left = 0;
		int right = chars.length - 1;
		boolean delete = false;
		boolean first = false;
		int save_left = 0;
		int save_right = 0;
		
		while(left < right) {
			if(chars[left] == chars[right]) {
				left++;
				right--;
			}
			else {
				if(!delete) {
					if(!first) {
						save_left = left;
						save_right = right;
						right--;
						delete = true;
					}
					else {
						left++;
						delete = true;
					}
				}
				else {
					if(first == true)
						return false;
					else {
						first = true;
						left = save_left;
						right = save_right;
						delete = false;
					}
				}
			}
		}
		
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindromeString("abc"));
	}
}
