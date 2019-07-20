package Steps;

public class Num29_divide {
	
	
	//用全负数运算来解决溢出的问题！！
	public static int divide(int dividend, int divisor) {
        if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1)
        	return Integer.MAX_VALUE;
        
        
        if(dividend == Integer.MIN_VALUE)
        	return specialMin(divisor);
        
        boolean negative = false;
        if(dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0)
        	negative = true;
        
        int result = 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        
        int step = 1;
        
        while(true) {
        	int temp = dividend - step*divisor;
        	if(temp > dividend)
        		break;
        	else
        		dividend = temp;
        	if(dividend >= 0) {
        		result += step;
        		step *= 2;
        	}
        	else {
        		if(step == 1)
        			break;
        		dividend += step*divisor;
        		step = 1;
        	}
        }
        return negative? -result:result;
    }
	
	public static int specialMin(int divisor) {
		int temp = divide(Integer.MAX_VALUE, divisor);
		int remainder = Integer.MAX_VALUE - divisor * temp;
		if(remainder + 1 == Math.abs(divisor))
			return temp <= 0? 1-temp : -1-temp;
		return -temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(Integer.MIN_VALUE,Integer.MIN_VALUE));
		System.out.println(divide(7,-3));
	}

}
