package Episode_Summary2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
	
	//带截断的深度优先算法，效率比较低下
	public static boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0)
        	return true;
        
        boolean[] validation = new boolean[s.length() + 1];
        Arrays.fill(validation, true);
        
        dfs(s,0, validation, wordDict);
        
        return validation[0];
    }
	
	public static boolean dfs(String s, int position, boolean[] validation, List<String> wordDict) {
		if(position == s.length())
			return true;
		boolean flag = false;
		if(validation[position]) {
			for(int i = 1; i + position <= s.length(); i++) {
				String cur = s.substring(position, i+position);
				if(wordDict.contains(cur)) {
					if(dfs(s,position+i,validation,wordDict))
						flag = true;
				}
			}
			if(flag == false)
				validation[position] = false;
		}
		return flag;
	}
	
	//动态规划
	public static boolean wordBreak_2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && wordDict.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> temp = new ArrayList<String>();
		temp.add("leet");temp.add("code");
		System.out.println(wordBreak("leetcode",temp));
//		String s = "abc";
//		System.out.println(s.substring(1));
	}

}
