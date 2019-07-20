package Episode_Summary2018;

public class WordSearch {
	
	//回溯题，切记用index，不要用subString
	
	public static boolean exist(char[][] board, String word) {
		if(board == null || board.length ==0 || board[0].length == 0)
			return false;
        if(word == null || word.length() == 0)
        	return true;
        
        char first = word.charAt(0);
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[0].length; j++) {
        		if(board[i][j] == first) {
        			boolean[][] visited = new boolean[board.length][board[0].length];
        			if(dfs(board, i, j, word, 0, visited))
        				return true;
        		}
        	}
        }
        return false;
    }
	
	public static boolean dfs(char[][] board, int i, int j, String s, int index, boolean[][] visited) {
		if(index == s.length())
			return true;
		char check = s.charAt(index);
		if(i == -1 || i == board.length || j == -1 || j == board[0].length)
			return false;
		if(board[i][j] == check && visited[i][j] == false) {
			visited[i][j] = true;
			if( dfs(board, i-1, j, s, index + 1, visited) || 
				dfs(board, i+1, j, s, index + 1, visited) ||
				dfs(board, i, j-1, s, index + 1, visited) ||
				dfs(board, i, j+1, s, index + 1, visited))
				return true;
			visited[i][j] = false;
		}
		return false;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] r1 = new char[] {'A','B','C','E'};
		char[] r2 = new char[] {'S','F','E','S'};
		char[] r3 = new char[] {'A','D','E','E'};
		char[] r4 = new char[] {'a','a'};
		
		char[][] board = new char[3][4];
		board[0] = r1; board[1] = r2; board[2] = r3;
		
		char[][] board2 = new char[1][2];
		board2[0] = r4;
		
		exist(board2,"aaa");
	}

}
