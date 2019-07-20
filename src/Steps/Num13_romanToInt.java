package Steps;

import java.util.HashMap;
import java.util.Map;

public class Num13_romanToInt {
	
	public static int romanToInt(String s) {
		int result = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1); map.put('V', 5); map.put('X', 10); map.put('L', 50);
        map.put('C', 100); map.put('D', 500); map.put('M', 1000);
        
        for(int i = 0; i < s.length();) {
        	char cur = s.charAt(i);
        	char next = i+1 == s.length()? '#':s.charAt(i+1);
        	if(cur == 'I' && (next == 'V' || next == 'X') ||
        	   cur == 'X' && (next == 'L' || next == 'C') ||
        	   cur == 'C' && (next == 'D' || next == 'M')) {
        		result += (map.get(next) - map.get(cur));
        		i += 2;
        	}
        	else {
        		result += map.get(cur);
        		i++;
        	}
        }
        
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
