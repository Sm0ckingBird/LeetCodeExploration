package Episode_Summary2018;

import java.util.ArrayList;
import java.util.List;

public class WordBreakII {
	
	public static List<String> wordBreak(String s, List<String> wordDict) {
        
		List<List<Integer>> positionResult = new ArrayList<List<Integer>>();
		List<String> result = new ArrayList<String>();
		
		boolean[] dp = new boolean[s.length() + 1];
		List<List<Integer>> segmentation = new ArrayList<List<Integer>>();
		for(int i = 0; i < s.length() + 1; i++)
			segmentation.add(new ArrayList<Integer>());
		dp[0] = true;
		
		for(int i = 1; i <= s.length(); i++) {
			for(int j = 0; j < i; j++) {
				if(dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					segmentation.get(i).add(j);
				}
			}
		}
		
		List<Integer> midResult = new ArrayList<Integer>();
		dps(s.length(), midResult, segmentation, positionResult);
		
		for(List<Integer> positions: positionResult) {
			StringBuilder temp = new StringBuilder("");
			int next = 0;
			for(int i = 1; i < positions.size(); i++) {
				temp.append(s.substring(next,positions.get(i)));
				temp.append(" ");
				next = positions.get(i);
			}
			temp.append(s.substring(next,s.length()));
			result.add(temp.toString());
		}
		
		return result;
    }
	
	public static void dps(int item, List<Integer> midResult, List<List<Integer>> segmentation, 
			List<List<Integer>> result) {
		if(item == 0) {
			List<Integer> part = new ArrayList<Integer>();
			part.addAll(midResult);
			result.add(part);
		}
		List<Integer> cur = segmentation.get(item);
		for(Integer position: cur) {
			midResult.add(0,position);
			dps(position,midResult,segmentation,result);
			midResult.remove(position);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> temp = new ArrayList<String>();
		temp.add("leet");temp.add("code");
		System.out.println(wordBreak("leetcode",temp));
	}

}
