package medium;

import java.util.LinkedList;

public class SimplifyPath {

	public String simplifyPath(String path) {
		String[] datas = path.split("/");
		LinkedList<String> rem = new LinkedList<String>();
		
		for(int i=1;i<datas.length;i++) {
			if(".".equals(datas[i]) || "".equals(datas[i])) {
				continue;
			}else if("..".equals(datas[i])) {
				if(rem.size()>0)
					rem.removeLast();
			}else {
				rem.addLast(datas[i]);
			}
		}
		
		if(rem.size()>0) {
			StringBuffer sqqsb = new StringBuffer();
			for (String string : rem) {
				sqqsb.append("/");
				sqqsb.append(string);
			}
	      
			return sqqsb.toString();
		}else {
			return "/";
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "/a//b////c/d//././/..";
		System.out.println(new SimplifyPath().simplifyPath(data));
	}

}
