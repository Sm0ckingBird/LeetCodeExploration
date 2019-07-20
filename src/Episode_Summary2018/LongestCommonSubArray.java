package Episode_Summary2018;

public class LongestCommonSubArray {
	
	public static int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        for(int i = B.length - 1; i > 0; i--){
            if(A[A.length - 1] == B[i])
                dp[A.length - 1][i] = 1;
        }
        for(int i = A.length - 1; i > 0; i--){
            if(B[B.length - 1] == A[i])
                dp[i][B.length - 1] = 1;
        }
        
        for(int i = B.length - 2; i > -1; i--){
            for(int j = A.length - 2; j > -1; j--){
                if(A[j] == B[i])
                    dp[j][i] = dp[j+1][i+1] + 1;
                else
                    dp[j][i] = 0;
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++)
                max = Math.max(max,dp[i][j]);
        }
        
        return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findLength(new int[] {1,2,3,2,1}, new int[] {3,2,1,4,7});
	}

}
