package May28;

import java.util.LinkedList;
import java.util.List;

public class Num56_MergeIntervals {
	
	//input:[[1,3],[2,6],[8,10],[15,18]]
	//output:[[1,6],[8,10],[15,18]]
	//desp:将区间合并
	
	//先排序
	
	public static int[][] merge(int[][] intervals) {
		if(intervals == null || intervals.length == 0 || intervals[0].length == 0)
        	return new int[0][2];
        
        List<int[]> l = new LinkedList<int[]>();
		
        for(int[] item: intervals)
        	l.add(item);
        
        boolean merged = false;
        while(true) {
        	merged = false;
        	for(int i = 0; i < l.size() - 1; i++) {
        		for(int j = i + 1; j < l.size(); j++) {
        			int[] temp = mergeTwo(l.get(i),l.get(j));
            		if(temp != null) {
            			l.remove(i);
            			l.remove(j-1);
            			l.add(temp);
            			merged = true;
            			break;
            		}
        		}
        	}
        	
        	if(merged == false)
        		break;
        }
        
        int[][] result = new int[l.size()][2];
        for(int i = 0; i < l.size(); i++)
        	result[i] = l.get(i);
        
		return result;
    }
	
	private static int[] mergeTwo(int[] interval1, int[] interval2) {
		int start1 = interval1[0];
		int end1 = interval1[1];
		int start2 = interval2[0];
		int end2 = interval2[1];
		
		if(start1 > end2 || end1 < start2)
			return null;
		
		int[] result = new int[2];
		result[0] = start1 < start2? start1:start2;
		result[1] = end1 > end2? end1:end2;
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] temp = new int[][] {new int[] {2,3},
			new int[] {5,5},new int[] {2,2},new int[] {3,4}
		,new int[] {3,4}};
		merge(temp);
	}

}
