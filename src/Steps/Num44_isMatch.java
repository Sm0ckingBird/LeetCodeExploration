package Steps;

import java.util.ArrayList;
import java.util.List;

public class Num44_isMatch {
	
	//这种思路是错的。。 还是需要用动态规划
	public static boolean isMatch(String s, String p) {
		if(p.equals("*"))
			return true;
        String[] subPatterns = newSplitter(p);
        if(subPatterns.length == 1)
        	return isMatchWithoutStarOrOneStar(s,p);
        
        for(int i = 0; i < subPatterns.length; i++) {
        	String subPattern = subPatterns[i];
        	List<Integer> result = containsSpecificPattern(s,subPattern);
        	if(result.isEmpty())
        		return false;
        	else {
        		String pattern = newPattern(subPatterns, i);
        		for(int item: result) {
        			if(isMatch(s.substring(item),pattern)){
        				if(i == subPatterns.length - 1)
        					return true;
        				continue;
        			}
        		}
        	}
        }
        
        return true;
    }
	
	public static String[] newSplitter(String s) {
		List<String> result = new ArrayList<String>();
		for(String item: s.split("\\*"))
			result.add(item);
		if(s.charAt(s.length() - 1) == '*')
			result.add("");
		String[] temp = new String[result.size()];
		return result.toArray(temp);
	}
	
	
	public static String newPattern(String[] subPatterns, int index) {
		StringBuilder sb = new StringBuilder();
		for(int i = index + 1; i < subPatterns.length - 1; i++)
			sb.append(subPatterns[i] + "*");
		if(index != subPatterns.length - 1)
			sb.append(subPatterns[subPatterns.length - 1]);
		return sb.toString();
	}
	
	public static boolean isMatchWithoutStarOrOneStar(String s, String p) {
		int ps = 0;
		int pp = 0;
		while(ps < s.length() && pp < p.length()) {
			if(s.charAt(ps) == p.charAt(pp) || p.charAt(pp) == '?') {
				ps++;
				pp++;
			}
			else {
				break;
			}
		}
		if(ps == s.length() && pp == p.length())
			return true;
		else if(ps == s.length())
			return p.charAt(pp) == '*';
		else {
			return p.charAt(p.length() - 1) == '*';
		}
	}
	
	public static List<Integer> containsSpecificPattern(String s, String p) {
		List<Integer> result = new ArrayList<Integer>();
		if(p.length() == 0) {
			result.add(0);
			return result;
		}
		int ps = 0;
		int pp = 0;
		
		char cur_s = '#';
		char cur_p = '#';

		while(ps < s.length()) {
			cur_s = s.charAt(ps);
			cur_p = p.charAt(pp);
			if(cur_p == '?' || cur_s == cur_p)
				pp++;
			else
				pp = 0;
			ps++;
			if(pp == p.length()) {
				result.add(ps);
				pp = 0;
			}
		}
		
		return result;
	}

	public static boolean isMatch_DP(String s, String p) {
		boolean[][] value = new boolean[p.length()+1][s.length()+1];
        value[0][0] = true;
        for(int i = 1;i <= s.length();i++){
            value[0][i] = false;
        }
        for(int i = 1;i <= p.length(); i++){
            if(p.charAt(i-1) == '*'){
                value[i][0] = value[i-1][0];
                for(int j = 1;j <= s.length(); j++){
                    value[i][j] = (value[i][j-1] || value[i-1][j]);
                }
            }else if(p.charAt(i-1) == '?'){
                value[i][0] = false;
                for(int j = 1;j <= s.length(); j++){
                    value[i][j] = value[i-1][j-1];
                }
            }else {
                value[i][0] = false;
                for(int j = 1;j <= s.length(); j++){
                    value[i][j] = s.charAt(j-1) == p.charAt(i-1) && value[i-1][j-1];
                }
            }

        }
        return value[p.length()][s.length()];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatch_DP("adcb","a*b"));
//		System.out.println(newPattern(new String[] {"a","b","c?"},2));
	}

}
