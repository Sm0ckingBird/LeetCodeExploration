package Steps;

import java.util.Stack;

public class Num71_SimplifyPath {
	
	public static String simplifyPath(String path) {
        String[] segments = path.split("/");
        Stack<String> s = new Stack<String>();
        
        for(String item: segments) {
        	if(item.equals("") || item.equals("."))
        		continue;
        	else if(item.equals("..")) {
        		if(!s.isEmpty())
        			s.pop();
        	}
        	else
        		s.push(item);
        }
        
        StringBuilder sb = new StringBuilder();
        if(!s.isEmpty())
        	sb.insert(0, s.pop());
        while(!s.isEmpty())
        	sb.insert(0, s.pop()+"/");
        sb.insert(0, "/");
        
        return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(simplifyPath("/a//b////c/d//././/.."));
	}

}
