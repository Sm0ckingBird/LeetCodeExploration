package May28;

import java.util.HashSet;
import java.util.Set;

public class Num72_SetZeros {
	
	public static void setZeroes(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;
        Set<Integer> row = new HashSet<Integer>();
        Set<Integer> col = new HashSet<Integer>();
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0) {
                	row.add(i);
                	col.add(j);
                }
            }
        }
        
        for(Integer item: row) {
        	for(int i = 0; i < matrix[item].length; i++)
        		matrix[item][i] = 0;
        }
        
        for(Integer item: col) {
        	for(int i = 0; i < matrix.length; i++)
        		matrix[i][item] = 0;
        }
        
    }
	
	public static void setZeroes_Advanced(int[][] matrix) {
		boolean rowFlag = false;
        //判断首行
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                rowFlag = true;
                break;
            }
        }

        boolean colFlag = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowFlag){
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (colFlag){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
