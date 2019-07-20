package Steps;

public class Num91_numDecodings {
	
	public static int numDecodings(String s) {
        if(s.length() == 0)
        	return 1;
        int result = 0;
        if(s.length() == 1)
        	return s.charAt(0) != '0'? 1 : 0;
        else {
        	char decade = s.charAt(0);
        	char unit = s.charAt(1);
        	if(decade != '0')
        		result += numDecodings(s.substring(1, s.length()));
        	int code = (decade-'0')*10 + unit-'0';
        	if(code >= 10 && code <= 26)
        		result += numDecodings(s.substring(2, s.length()));
        }
		return result;
    }
	
	public static int numDecodings_DP(String s) {
        if(s.length() == 1)
        	return s.charAt(0) == '0'? 0 : 1;
        int[] temp = new int[s.length()+1];
        char decade = s.charAt(0);
    	char unit = s.charAt(1);
        temp[0] = decade != '0'? 1 : 0;
        int code = (decade-'0')*10 + unit-'0';
        if(unit != '0')
        	temp[1] += temp[0];
        temp[1] += (code >= 10 && code <= 26)? 1 : 0;
        
        for(int i = 2; i < s.length(); i++) {
        	char last = s.charAt(i);
        	char prev = s.charAt(i - 1);
        	if(last != '0')
        		temp[i] += temp[i - 1];
        	code = (prev-'0')*10 + last-'0';
        	if(code >= 10 && code <= 26)
        		temp[i] += temp[i - 2];
        }
        
        return temp[s.length() - 1];
    }
	
//	public boolean checkValidation(String[] s) {
//		for(String item:s) {
//			if(item.length() == 1) {
//				char cur = item.charAt(0);
//				if(cur >= '1' && cur <= '9')
//					continue;
//				return false;
//			}
//			else {
//				char decade = item.charAt(0);
//				char unit = item.charAt(1);
//				int code = 0;
//				code += (decade+unit-2*'0');
//				if(code >= 10 && code <= 26)
//					continue;
//				return false;
//			}
//		}
//		return true;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDecodings_DP("226"));
	}

}
