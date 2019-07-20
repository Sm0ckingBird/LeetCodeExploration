package Episode_Summary2018;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
	
	public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String>();
        if(board == null || board.length ==0 || board[0].length == 0 || 
            words == null || words.length == 0)
			return result;
        
        for(int z = 0; z < words.length; z++){
            boolean found = false;
            char first = words[z].charAt(0);
            for(int i = 0; i < board.length; i++) {
                if(found)
                    break;
        	    for(int j = 0; j < board[0].length; j++) {
        		    if(board[i][j] == first) {
        			    boolean[][] visited = new boolean[board.length][board[0].length];
        			    if(dfs(board, i, j, words[z], 0, visited)){
                            result.add(0,words[z]);
                            found = true;
                            break;
                        }
        		    }
        	    }
            }
        }
        return result;
    }
    
    public static boolean dfs(char[][] board, int i, int j, String s, int index, boolean[][] visited) {
		if(index == s.length())
			return true;
		char check = s.charAt(index);
		if(i == -1 || i == board.length || j == -1 || j == board[0].length)
			return false;
		if(board[i][j] == check  && visited[i][j] == false) {
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

	}

}
