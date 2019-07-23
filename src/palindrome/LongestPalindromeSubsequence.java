package palindrome;

public class LongestPalindromeSubsequence {
	
	//easy递归
	public static int longestPalindromeSubseq(String s) {
		return longestPalindromeSubseq(s.toCharArray(),0,s.length()-1);
	}
	
	private static int longestPalindromeSubseq(char[] chars, int start, int end) {
		if(end - start == 0)
			return 1;
		int curLength = 0;
		int left = start;
		int right = end;
		
		while(left < right && chars[left] == chars[right]) {
			curLength += 2;
			left++;
			right--;
		}
		
		if(left == right)
			return curLength + 1;
		else if(left > right)
			return curLength;
		else {
			int temp1 = longestPalindromeSubseq(chars,left, right - 1);
			int temp2 = longestPalindromeSubseq(chars,left+1, right);
			return curLength + Math.max(temp1, temp2);
		}
	}
	
	//动态规划
	public static int longestPalindromeSubseq_DP(String s) {
		if(s == null || s.length() == 0)
			return 0;
		//int[][] p_matrix = new int[s.length()][s.length()];
		//pass
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindromeSubseq(""));
	}

}
