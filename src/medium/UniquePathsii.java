package medium;
/**
 * ʹ�ö�̬�滮�㷨
 * result[x][y]=(1-obstacleGrid[x][y])*((1-obstacleGrid[x][y-1])*result[x][y-1]+(1-obstacleGrid[x-1][y])*result[x-1][y])
 * @author mayfly
 *
 */
public class UniquePathsii {
	// ����1�������࣬�����Ƚ�����ĺ���2��˼·��ȫһ����������������㣬�����ȼ���������
	public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
		if(obstacleGrid.length==0)   // ����Ϊ0�򷵻�0
			return 0;
		else if(obstacleGrid.length==1 && obstacleGrid[0].length<2) 
			if(obstacleGrid[0].length==0) {   // û�����ַ���0
				return 0;
			}else {   // ֻ��һ�����ֵ����
				if(obstacleGrid[0][0]==1) {   // ֻ��һ���ռ仹���ϰ���
					return 0;
				}else {
					return 1;
				}
			}
		else {
			if(obstacleGrid[0][0]==1)
				return 0;
			// ���ɼ�¼����
			int[][] results = new int[obstacleGrid.length][obstacleGrid[0].length];
			// ���Ͻ�Ϊ1����Ϊ��ʼ�ص㲻����Ϊ�ϰ���
			results[0][0]=1;
			// ��ȡ���εĽ϶̱�
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
		if(obstacleGrid.length==0)   // ����Ϊ0�򷵻�0
			return 0;
		else if(obstacleGrid.length==1 && obstacleGrid[0].length<2) 
			if(obstacleGrid[0].length==0) {   // û�����ַ���0
				return 0;
			}else {   // ֻ��һ�����ֵ����
				if(obstacleGrid[0][0]==1) {   // ֻ��һ���ռ仹���ϰ���
					return 0;
				}else {
					return 1;
				}
			}
		else {
			if(obstacleGrid[0][0]==1)   // �����ʼ��Ϊ�ϰ���򲻴��ں������
				return 0;
			// ���ɼ�¼����
			int[][] results = new int[obstacleGrid.length][obstacleGrid[0].length];
			// ���Ͻ�Ϊ1����Ϊ��ʼ�ص㲻����Ϊ�ϰ���
			results[0][0]=1;
			// ��ȡ���εĽ϶̱�
			int minSize = obstacleGrid.length<obstacleGrid[0].length?obstacleGrid.length:obstacleGrid[0].length;
			// ���ݽ϶̱��������������������·������
			for(int i=0;i<minSize;i++) {
				if(i>0) {
					results[i][i] = (1-obstacleGrid[i][i])*((1-obstacleGrid[i][i-1])*results[i][i-1]+(1-obstacleGrid[i-1][i])*results[i-1][i]);
				}
				for(int j=i+1;j<minSize;j++) {
					// �����ƶ�
					// �����ƶ�
					if(i==0) {
						results[i][j] = (1-obstacleGrid[i][j])*(1-obstacleGrid[i][j-1])*results[i][j-1];
						results[j][i] = (1-obstacleGrid[j][i])*(1-obstacleGrid[j-1][i])*results[j-1][i];
					}else {
						results[i][j] = (1-obstacleGrid[i][j])*(1-obstacleGrid[i][j-1])*results[i][j-1]+(1-obstacleGrid[i][j])*(1-obstacleGrid[i-1][j])*results[i-1][j];
						results[j][i] = (1-obstacleGrid[j][i])*(1-obstacleGrid[j-1][i])*results[j-1][i]+(1-obstacleGrid[j][i])*(1-obstacleGrid[j][i-1])*results[j][i-1];
						
					}
				}
			}
			// ���ݽ϶̱ߵó��Ľ������ϳ��ߵ�·������
			if(minSize==obstacleGrid.length) {
				for(int i=0;i<minSize;i++) {
					for(int j=minSize;j<obstacleGrid[0].length;j++) {
						// �����ƶ�
						// �����ƶ�
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
			// �������½ǽ��
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
