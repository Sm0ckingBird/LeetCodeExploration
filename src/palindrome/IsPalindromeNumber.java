package palindrome;

public class IsPalindromeNumber {
	
	//判断一个数是否为回文数
	public static boolean isPalindromeNumber(int n) {
		if(n < 0 || n % 10 == 0 && n != 0)
			return false;
		int mirror = 0;
		while(n > mirror) {
			mirror = 10 * mirror + (n % 10);
			n /= 10;
		}
		if(n == mirror || mirror / 10 == n)
			return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isPalindromeNumber(121);
	}

}
