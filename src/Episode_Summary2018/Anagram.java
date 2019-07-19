package Episode_Summary2018;

import java.util.Arrays;

public class Anagram {
	
	public boolean isAnagram(String s, String t) {
		if(s.length() != t.length())
			return false;
        int[] counter =  new int[26];
        for(int i = 0; i < s.length(); i++)
        	counter[s.charAt(i)-'a']++;
		for(int j = 0; j < t.length(); j++)
			counter[t.charAt(j)-'a']--;
		for(int item: counter)
			if(item != 0)
				return false;
		return true;
    }
	
	public boolean isAnagram_2(String s, String t) {
		if(s.length() != t.length())
			return false;
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        
        Arrays.sort(S);
        Arrays.sort(T);
        
        for(int i = 0; i < s.length(); i++)
        	if(S[i] != T[i])
        		return false;
		
		return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
