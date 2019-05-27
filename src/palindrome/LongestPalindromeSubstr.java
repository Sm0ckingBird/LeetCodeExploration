package palindrome;

public class LongestPalindromeSubstr {
	
	//找出最长回文字串
	//input:"abbad"
	//output:"abba"
	
	//1.暴力法_遍历所有可能结果  时间效率O(n^3)
	//pass
	
	//2.最长公共子串法          时间效率O(n^2)
	public static String longestPalindromeSubstr_Reverse(String s) {
		if(s == null || s.length() == 0)
			return s;
		StringBuilder sb = new StringBuilder(s);
		String reverse = sb.reverse().toString();
		String result = "";
		
		
		for(int i = 0; i < s.length(); i++) {
			for(int j = s.length(); j > i; j--) {
				String temp1 = s.substring(i, j);
				String temp2 = reverse.substring(s.length() - j, s.length() - i);
				if(temp1.equals(temp2)) {
					if(temp1.length() > result.length())
						result = temp1;
				}
			}
		}
		
		return result;
	}
	
	//3.动态规划
	//dp[i][i]=1;  单个字符是回文串
	//dp[i][i+1]=1 if s[i]=s[i+1];  连续两个相同字符是回文串
	//dp[i][j] = dp[i+1][j-1] || s[i]==s[j]
	public static String longestPalindromeSubstr_DP(String s) {
		if(s == null || s.length() == 0 || s.length() == 1)
			return s;
		
		char[] chars = s.toCharArray();
		boolean[][] p_matrix = new boolean[s.length()][s.length()];
		int max = 1;
		int start = 0;
		
		//Initialization
		for(int i = 0; i < s.length(); i++) {
			p_matrix[i][i] = true;
			if(i < s.length() - 1) {
				if(chars[i] == chars[i+1])
					p_matrix[i][i+1] = true;
				else
					p_matrix[i][i+1] = false;
			}
		}
		
		for(int l = 3; l <= s.length(); l++) {
			for(int i = 0; i < s.length() - l + 1; i++) {
				int j=l+i-1;//终止字符位置
                if(chars[i]==chars[j] && p_matrix[i+1][j-1]==true)//状态转移
                {
                	p_matrix[i][j]=true;
                    start=i;
                    max=l;
                }
                else
                	p_matrix[i][j]=false;
			}
		}
		
		return s.substring(start,max);
	}
	
	//4.中心扩展算法
	public static String longestPalindromeSubstr_Ex(String s) {
		char[] chars = s.toCharArray();
		int start = 0;
		int end = 0;
		int len = 0;
		
		for(int i = 0; i < s.length(); i++) {
			int len1 = expandFromCenter(chars,i,i);    //1,3,5,7..
			int len2 = expandFromCenter(chars,i,i+1);  //0,2,4,6..
			int temp = Math.max(len1, len2);
			
			if(temp > len) {
				len = temp;
				start = i - (temp-1) / 2;
				end = i + temp / 2 + 1;
			}
		}
		
		return s.substring(start, end);
	}
	
	private static int expandFromCenter(char[] chars, int start, int end) {
		if(start > end)
			return 0;
		while(start>-1&&end<chars.length&&chars[start] == chars[end]) {
			start--;
			end++;
		}
		return end-start-1;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindromeSubstr_Ex("abbad"));
	}

}
