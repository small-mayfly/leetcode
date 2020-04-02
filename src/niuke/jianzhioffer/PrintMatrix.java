package niuke.jianzhioffer;

import java.util.ArrayList;

public class PrintMatrix {
	
	public ArrayList<Integer> printMatrix(int [][] matrix) {
		if(matrix.length==0)
			return null;
		else {
			ArrayList<Integer> results = new ArrayList<Integer>();
			int round = matrix.length/2>matrix[0].length/2?matrix[0].length/2:matrix.length/2;
			for(int i=0;i<round;i++) {
				// 向右
				for(int j=i;j<matrix[0].length-i;j++) {
					results.add(matrix[i][j]);
				}
				
				// 向下
				for(int j=i+1;j<matrix.length-i;j++) {
					results.add(matrix[j][matrix[0].length-i-1]);
				}
				
				// 向左
				for(int j=matrix[0].length-i-2;j>=i;j--) {
					results.add(matrix[matrix.length-i-1][j]);
				}
				
				// 向上
				for(int j=matrix.length-i-2;j>i;j--) {
					results.add(matrix[j][i]);
				}
			}
			if(matrix.length==matrix[0].length && matrix.length%2==1) {
				results.add(matrix[round][round]);
			}else {
				if(matrix.length<matrix[0].length && matrix.length%2==1) {
					for(int i=round;i<matrix[0].length-round;i++) {
						results.add(matrix[round][i]);
					}
				}else if(matrix[0].length%2==1) {
					for(int i=round;i<matrix.length-round;i++) {
						results.add(matrix[i][round]);
					}
				}
			}
			for (Integer integer : results) {
				System.out.println(integer);
			}
			return results;
		}
		
	       
    }
	
	public static void main(String[] args) {
		PrintMatrix pm = new PrintMatrix();
		
		int[][] datas = {{1,2},{3,4},{5,6},{7,8},{9,10}};
		
		pm.printMatrix(datas);
		
	}

}
