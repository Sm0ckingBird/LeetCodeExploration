package palindrome;

public class IsPalindromeString {
	
	//判断是否是回文
	
	public static boolean isPalindromeString(String s) {
		char[] chars = s.toCharArray();
		
		int left = 0;
		int right = s.length() - 1;
		
		while(left < right) {
			while(left < right && !isValid(chars[left]))
				left++;
			while(left < right && !isValid(chars[right]))
				right--;
			if(Character.toLowerCase(chars[left]) == Character.toLowerCase(chars[right])) {
				left++;
				right--;
			}
			else
				return false;
		}
		
		return true;
	}
	
	private static boolean isValid(char c) {
		return isDigit(c) || isAlpha(c);
	}
	
	private static boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}
	
	private static boolean isAlpha(char c) {
		return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindromeString("0P"));
	}

}
