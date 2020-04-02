package pat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 深搜和广搜都可以解决问题。
 * 但我写的时候使用了新建的node节点，不知道哪有错，用这种方法写一遍过。
 * @author mayfly
 *
 */
public class PAT1004 {

	int n,m;
	HashMap<Integer, ArrayList<Integer>> nodes;
	HashMap<Integer, Integer> countRem;
	
	public void magic() {
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		while(n>0) {
			m = in.nextInt();
			nodes = new HashMap<Integer, ArrayList<Integer>>();
			for(int i=0;i<m;i++) {
				ArrayList<Integer> sons = new ArrayList<Integer>();
				int id = in.nextInt();
				int num = in.nextInt();
				for(int j=0;j<num;j++) {
					sons.add(in.nextInt());
				}
				nodes.put(id, sons);
			}
			countRem = new HashMap<Integer, Integer>();
			int height = dfs(1, 0);
			
			if(m==0) {
				System.out.print(1);
			}else {
				System.out.print(0);
				for(int i=1;i<=height;i++) {
					System.out.print(" "+countRem.getOrDefault(i, 0));
				}
			}
			
		}
		in.close();
	}
	
	public int dfs(int id, int nowLevel) {
		int height = nowLevel;
		
		if(nodes.get(id)==null) {
			countRem.put(nowLevel, countRem.getOrDefault(nowLevel, 0)+1);
		}else {
			for(int i=0;i<nodes.get(id).size();i++) {
				int theight = dfs(nodes.get(id).get(i), nowLevel+1);
				if(theight>height)
					height = theight;
			}
		}
		return height;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PAT1004().magic();
	}

}
