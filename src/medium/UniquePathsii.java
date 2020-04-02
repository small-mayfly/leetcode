package medium;
/**
 * 使用动态规划算法
 * result[x][y]=(1-obstacleGrid[x][y])*((1-obstacleGrid[x][y-1])*result[x][y-1]+(1-obstacleGrid[x-1][y])*result[x-1][y])
 * @author mayfly
 *
 */
public class UniquePathsii {
	// 函数1不够整洁，来个比较整洁的函数2，思路完全一样，不过是整体计算，不是先计算正方形
	public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
		if(obstacleGrid.length==0)   // 长度为0则返回0
			return 0;
		else if(obstacleGrid.length==1 && obstacleGrid[0].length<2) 
			if(obstacleGrid[0].length==0) {   // 没有数字返回0
				return 0;
			}else {   // 只有一个数字的情况
				if(obstacleGrid[0][0]==1) {   // 只有一个空间还是障碍物
					return 0;
				}else {
					return 1;
				}
			}
		else {
			if(obstacleGrid[0][0]==1)
				return 0;
			// 生成记录矩阵
			int[][] results = new int[obstacleGrid.length][obstacleGrid[0].length];
			// 左上角为1，因为起始地点不可能为障碍物
			results[0][0]=1;
			// 获取矩形的较短边
			int minSize = obstacleGrid.length<obstacleGrid[0].length?obstacleGrid.length:obstacleGrid[0].length;
						
			for(int i=1;i<minSize;i++) {
				results[0][i] = (1-obstacleGrid[0][i])*results[0][i-1];
				results[i][0] = (1-obstacleGrid[i][0])*results[i-1][0];
			}
			if(minSize<obstacleGrid.length) {
				for(int i=minSize;i<obstacleGrid.length;i++) {
					results[i][0] = (1-obstacleGrid[i][0])*results[i-1][0];
					
				}
			}else {
				for(int i=minSize;i<obstacleGrid[0].length;i++) {
					results[0][i] = (1-obstacleGrid[0][i])*results[0][i-1];
				}
			}
			for(int i=1;i<obstacleGrid.length;i++) {
				for(int j=1;j<obstacleGrid[0].length;j++) {
					results[i][j] = (1-obstacleGrid[i][j])*((1-obstacleGrid[i][j-1])*results[i][j-1]+(1-obstacleGrid[i-1][j])*results[i-1][j]);
				}
			}
			return results[obstacleGrid.length-1][obstacleGrid[0].length-1];
			
			
		}
	}
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid.length==0)   // 长度为0则返回0
			return 0;
		else if(obstacleGrid.length==1 && obstacleGrid[0].length<2) 
			if(obstacleGrid[0].length==0) {   // 没有数字返回0
				return 0;
			}else {   // 只有一个数字的情况
				if(obstacleGrid[0][0]==1) {   // 只有一个空间还是障碍物
					return 0;
				}else {
					return 1;
				}
			}
		else {
			if(obstacleGrid[0][0]==1)   // 如果初始点为障碍物，则不存在后续结果
				return 0;
			// 生成记录矩阵
			int[][] results = new int[obstacleGrid.length][obstacleGrid[0].length];
			// 左上角为1，因为起始地点不可能为障碍物
			results[0][0]=1;
			// 获取矩形的较短边
			int minSize = obstacleGrid.length<obstacleGrid[0].length?obstacleGrid.length:obstacleGrid[0].length;
			// 依据较短边生成正方形区域的所有路径个数
			for(int i=0;i<minSize;i++) {
				if(i>0) {
					results[i][i] = (1-obstacleGrid[i][i])*((1-obstacleGrid[i][i-1])*results[i][i-1]+(1-obstacleGrid[i-1][i])*results[i-1][i]);
				}
				for(int j=i+1;j<minSize;j++) {
					// 向右移动
					// 向下移动
					if(i==0) {
						results[i][j] = (1-obstacleGrid[i][j])*(1-obstacleGrid[i][j-1])*results[i][j-1];
						results[j][i] = (1-obstacleGrid[j][i])*(1-obstacleGrid[j-1][i])*results[j-1][i];
					}else {
						results[i][j] = (1-obstacleGrid[i][j])*(1-obstacleGrid[i][j-1])*results[i][j-1]+(1-obstacleGrid[i][j])*(1-obstacleGrid[i-1][j])*results[i-1][j];
						results[j][i] = (1-obstacleGrid[j][i])*(1-obstacleGrid[j-1][i])*results[j-1][i]+(1-obstacleGrid[j][i])*(1-obstacleGrid[j][i-1])*results[j][i-1];
						
					}
				}
			}
			// 根据较短边得出的结果计算较长边的路径条数
			if(minSize==obstacleGrid.length) {
				for(int i=0;i<minSize;i++) {
					for(int j=minSize;j<obstacleGrid[0].length;j++) {
						// 向右移动
						// 向下移动
						if(i==0) {
							results[i][j] = (1-obstacleGrid[i][j])*(1-obstacleGrid[i][j-1])*results[i][j-1];
						}else {
							results[i][j] = (1-obstacleGrid[i][j])*(1-obstacleGrid[i][j-1])*results[i][j-1]+(1-obstacleGrid[i-1][j])*results[i-1][j];
						}
					}
				}
			}else {
				for(int i=minSize;i<obstacleGrid.length;i++) {
					for(int j=0;j<minSize;j++) {
						if(j==0) {
							results[i][j] = (1-obstacleGrid[i][j])*(1-obstacleGrid[i-1][j])*results[i-1][j];
						}else {
							results[i][j] = (1-obstacleGrid[i][j])*(1-obstacleGrid[i][j-1])*results[i][j-1]+(1-obstacleGrid[i-1][j])*results[i-1][j];
						}
					}
				}
			}
			// 返回右下角结果
			return results[obstacleGrid.length-1][obstacleGrid[0].length-1];
		}
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] datas = {{0,0,0},{0,1,0},{0,0,0}};
		int[][] datas = {{0,0}};
		System.out.println(new UniquePathsii().uniquePathsWithObstacles2(datas));

	}

}
