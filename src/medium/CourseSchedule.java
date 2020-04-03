package medium;

import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {
	
	class GNode{
		int val=0;
		List<Integer> next = new LinkedList<Integer>();
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
        GNode[] nodes = new GNode[numCourses];

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
					count++;
					for (Integer index:nodes[i].next
						 ) {
						nodes[index].val--;
					}
        		}
        	}
        }
        if(count==numCourses)
        	return true;
        
		return false;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] data = {{0,1}};
		System.out.println(new CourseSchedule().canFinish(2, data));
	}

}
