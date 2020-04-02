package medium;

/**
 * 整体思路为sum(m,n) = min{sum(m-1,n),sum(m,n-1)}+grid(m,n)
 * @author cloud
 *
 */
public class MinimumPathSum {
	/**
	 * 从左上到右下依次计算最小代价路径的总代价
	 * @param grid 点矩阵
	 * @param sums 代价矩阵
	 * @param x，y为点坐标
	 */
	public void magic(int[][] grid, int[][] sums, int x, int y) {
		if(x>0 && y>0) {
			if(x>0 && sums[x-1][y]==0) {
				magic(grid, sums, x-1, y);
			}
			if(y>0 && sums[x][y-1]==0) {
				magic(grid, sums, x, y-1);
			}
			sums[x][y] = Math.min(sums[x-1][y], sums[x][y-1]) + grid[x][y];
		}
		
	}
	
	public int minPathSum(int[][] grid) {
		if(grid.length==0)
			return 0;
		if(grid[0].length==0)
			return 0;
        int x = grid.length;
        int y = grid[0].length; 
        int[][] sums = new int[x][y];
        
        sums[0][0] = grid[0][0];
        
        for(int i=1;i<x;i++) {
        	sums[i][0] = sums[i-1][0] + grid[i][0];
        }
        for(int j=1;j<y;j++) {
        	sums[0][j] = sums[0][j-1] + grid[0][j];
        }
        magic(grid, sums, x-1, y-1);
        
        return sums[x-1][y-1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] datas = {
				  {1,3,1},
				  {1,5,1},
				  {4,2,1}
				};
		MinimumPathSum mps = new MinimumPathSum();
		System.out.println(mps.minPathSum(datas));
	}

}
