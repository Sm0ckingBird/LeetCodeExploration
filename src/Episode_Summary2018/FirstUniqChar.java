package Episode_Summary2018;

public class FirstUniqChar {
	
	//哈希表解法  70%
	public int firstUniqChar(String s) {
		if(s.length() == 0 || s == null)
			return -1;
		
		int[] counter = new int[26];
		for(int i = 0; i < s.length(); i++)
			counter[s.charAt(i)-'a']++;
		
		int min_index = Integer.MAX_VALUE;
		for(int i = 0; i < counter.length; i++)
			if(counter[i] == 1) {
				int index = s.indexOf((char)i+'a');
				min_index = Math.min(index, min_index);
			}
		if(min_index == Integer.MAX_VALUE)
			return -1;
		else
			return min_index;
	}
	
	//trick解法  100%
	public int firstUniqChar_2(String s) {
		int index = -1;
        for(char ch='a'; ch<='z'; ch++){
            int beginIndex = s.indexOf(ch);
            if(beginIndex != -1 && beginIndex == s.lastIndexOf(ch)){//存在但有相同的
                index = (index==-1||index>beginIndex)? beginIndex:index;
            }
        }
        return index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
