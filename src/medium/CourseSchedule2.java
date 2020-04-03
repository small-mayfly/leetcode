package medium;

import java.util.LinkedList;
import java.util.List;

public class CourseSchedule2 {
	
	class GNode{
		int val=0;
		List<Integer> next = new LinkedList<Integer>();
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
        GNode[] nodes = new GNode[numCourses];
        int[] results = new int[numCourses];

		for(int i=0;i<numCourses;i++){
			nodes[i] = new GNode();
		}
        for(int i=0;i<prerequisites.length;i++) {
        	nodes[prerequisites[i][1]].val++;
        	nodes[prerequisites[i][0]].next.add(prerequisites[i][1]);
        }
        boolean flag = true;
        int count = 0;
        while(flag) {
        	flag=false;
        	for(int i=0;i<numCourses;i++) {
        		if(nodes[i].val==0) {
        			flag=true;
					nodes[i].val=-1;
					results[numCourses-1-count] = i;
					count++;
					for (Integer index:nodes[i].next
						 ) {
						nodes[index].val--;
					}
        		}
        	}
        }
        if(count==numCourses)
        	return results;
        
		return new int[0];
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] data = {{1,0},{2,0},{3,1},{3,2}};
		int[] results = new CourseSchedule2().findOrder(4, data);
		for(int i=0;i<4;i++){
			System.out.println(results[i]);
		}
	}

}
