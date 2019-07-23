package Episode_Summary2018;

public class SameZeroAndOne {
	
	public static int[] longestSubarray(int[] array) {
		int length = array.length;
		int[][]dp = new int[length][length];
		
		for(int i = 0; i < array.length; i++)
			dp[i][i] = array[i] == 1? 1:-1;
		
		for(int i = 0; i < array.length; i++) {
			for(int j = i + 1; j < array.length; j++) {
				if(array[j] == 1)
					dp[i][j] = dp[i][j-1] + 1;
				else
					dp[i][j] = dp[i][j-1] - 1;
			}
		}
		
		int index_i = -1;
		int index_j = -1;
		int max = 0;
		
		for(int i = 0; i < array.length; i++) {
			for(int j = i + 1; j < array.length; j++) {
				if(dp[i][j] == 0) {
					if(j-i+1 > max) {
						index_i = i;
						index_j = j;
						max = j-i+1;
					}
				}
			}
		}
		
		int[] result = new int[index_j-index_i+1];
		for(int i = index_i; i <= index_j; i++)
			result[i] = array[i];
		
		return result;
	}
	
	public static void print(int[] result) {
		for(int n: result)
			System.out.print(n+" ");
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(longestSubarray(new int[] {0,1,1,0}));
	}

}
