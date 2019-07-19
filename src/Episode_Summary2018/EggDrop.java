package Episode_Summary2018;

import java.util.Arrays;

public class EggDrop {
	
	// 2 6 3
	// 3 14 4
	public static int superEggDrop(int K, int N) {
		if(K == 1)
			return N;
		int[][] array = new int[K][N + 1]; 
		for(int z = 0; z < array.length; z++)
			Arrays.fill(array[z], -1);
		for(int i = 0; i < N + 1; i++)
			array[0][i] = i;
		for(int j = 1; j < K; j++) {
			array[j][0] = 0;
			array[j][1] = 1;
		}
		return superEggDrop_2(K, N, array);
	}
	
	public static int superEggDrop_2(int K, int N, int[][] array) {
		int[] steps = new int[N];
		
		for(int i = 0; i < steps.length; i++) {
			if(array[K-2][i] == -1)
				array[K-2][i] = superEggDrop_2(K - 1,i, array);
			int left = array[K-2][i];
			if(array[K-1][N - i - 1] == -1)
				array[K-1][N - i - 1] = superEggDrop_2(K, N - i - 1, array);
			int right = array[K-1][N - i - 1];
			steps[i] = 1 + Math.max(left, right);
		}
		
		return min(steps);
	}
	
	public static int min(int[] steps) {
		int min = Integer.MAX_VALUE;
		for(int item:steps) {
			if(item < min)
				min = item;
		}
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(superEggDrop(4,10000));
	}

}
