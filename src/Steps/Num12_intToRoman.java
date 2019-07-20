package Steps;

public class Num12_intToRoman {
	
	public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] array = new int[] {1,5,10,50,100,500,1000};
        String[] map = new String[] {"I","V","X","L","C","D","M"};
        
        int temp = num;
        
        while(temp != 0) {
        	int index = getIndex(array, temp);
        	if(index == 7 || temp != array[index]) {
        		int base = (index-1)/2*2;
        		int times = temp / array[base];
        		if(times <= 4) {
        			if(times == 4)
        				sb.append(map[base]+map[base+1]);
        			else {
        				while(times > 0) {
        					sb.append(map[base]);
        					times--;
        				}
        			}
        		}
        		else {
        			if(times == 9)
        				sb.append(map[base]+map[base+2]);
        			else {
        				sb.append(map[base+1]);
        				while(times > 5) {
        					sb.append(map[base]);
        					times--;
        				}
        			}
        		}
        		temp %= array[base];
        	}
        	else {
        		sb.append(map[index]);
        		break;
        	}
        }
        
        
        return sb.toString();
    }
	
	
	public static int getIndex(int[] array, int target) {
		int low = 0;
		int high = array.length;
		while(low < high) {
			int mid = (low + high) / 2;
			if(array[mid] == target)
				return mid;
			else if(array[mid] > target)
				high = mid;
			else
				low = mid + 1;
		}
		return low;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(intToRoman(1994));
	}

}
