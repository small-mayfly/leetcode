package medium;

import java.util.HashSet;
/**
 * 两个函数效果一样，但第一个小队较优
 * @author mayfly
 *
 */
public class SetMatrixZeroes {
	public void setZeroes2(int[][] matrix) {
		if(matrix.length==0)
			return ;
        HashSet<Integer> rows = new HashSet<Integer>();
        HashSet<Integer> cols = new HashSet<Integer>();
        for(int i=0;i<matrix.length;i++) {
        	for(int j=0;j<matrix[i].length;j++) {
        		if(matrix[i][j]==0) {
        			rows.add(i);
        			cols.add(j);
        		}
        	}
        }
        boolean flag = false;
        for (int integer=0;integer<matrix.length;integer++) {
        	if(rows.contains(integer))
        		flag = true;
			for(int j=0;j<matrix[integer].length;j++) {
				if(!flag) {
					if(cols.contains(j))
						matrix[integer][j]=0;
				}else {
					matrix[integer][j]=0;
				}
			}
			flag = false;
		}
        
    }
	
	public void setZeroes(int[][] matrix) {
		if(matrix.length==0)
			return ;
        HashSet<Integer> rows = new HashSet<Integer>();
        HashSet<Integer> cols = new HashSet<Integer>();
        for(int i=0;i<matrix.length;i++) {
        	for(int j=0;j<matrix[i].length;j++) {
        		if(matrix[i][j]==0) {
        			rows.add(i);
        			cols.add(j);
        		}
        	}
        }
        for (Integer integer : rows) {
			for(int j=0;j<matrix[integer].length;j++) {
				matrix[integer][j]=0;
			}
		}
        for (Integer integer : cols) {
			for(int j=0;j<matrix.length;j++) {
				matrix[j][integer]=0;
			}
		}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] datas = {{1,1,1}, {1,0,1}, {1,1,1}};
		new SetMatrixZeroes().setZeroes2(datas);
	}

}
