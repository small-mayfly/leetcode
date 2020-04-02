package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PAT1013 {
	
	int city_num;
	int[][] pathes;
	int toCheckCityNum;
	String[] toCheckCityId;
	
	public void getInput() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
		city_num = Integer.parseInt(temp[0]);
		toCheckCityNum = Integer.parseInt(temp[2]);
		pathes = new int[city_num+1][city_num+1];
		int pathNum = Integer.parseInt(temp[1]);
		for(int i=0;i<pathNum;i++) {
			temp = in.readLine().split(" ");
			int x = Integer.parseInt(temp[0]);
			int y = Integer.parseInt(temp[1]);
			pathes[x][y] = pathes[y][x] = 1;
		}
		toCheckCityId = in.readLine().split(" ");
		in.close();
	}
	
	public int dfs(int[] visited, int nowLoc) {
		if(visited[nowLoc]!=0)
			return 0;
		int visitedNum = 1;
		visited[nowLoc] = 1;
		for(int i=nowLoc+1;i<=city_num;i++) {
			if(pathes[nowLoc][i]==1 && visited[i]==0) {
				visitedNum += dfs(visited, i);
			}
		}
		return visitedNum;
	}
	
	
	public void magic() throws IOException {
		getInput();
		int visitedNum;
		int circleNum;
		// 建立一个表，用以记录所有的遍历过的点
		int[] checkedCity = new int[city_num+1];
		// 遍历所有要计算的城市
		for(int i=0; i<toCheckCityNum;i++) {
			int oneCity = Integer.parseInt(toCheckCityId[i]);
			visitedNum = 1;
			circleNum = 0;
			Arrays.fill(checkedCity, 0);
			checkedCity[oneCity] = 1;
			for(int iterCity=1; iterCity<=city_num;iterCity++) {
				if(checkedCity[iterCity]==0) {
					circleNum++;
					visitedNum += dfs(checkedCity, iterCity);
					if(visitedNum == city_num)
						break;
				}
			}
			System.out.println(circleNum-1);
		}
		
	}
	// 查找共有多少个联通分量
	public void magic2() throws IOException {
		getInput();
		int circleCount = city_num - 1;
		for(int j=1;j<=city_num;j++) {
			for(int k=city_num;k>j;k--) {
				if(pathes[j][k]==1){
					circleCount--;
					break;
				}
				
			}
		}
		int flag = 0;
		for(int i=0; i<toCheckCityNum;i++) {
			int oneCity = Integer.parseInt(toCheckCityId[i]);
			for(int j=1;j<=city_num;j++) {
				if(pathes[j][oneCity]==1) {
					flag = 1;
					for(int k=city_num;k>oneCity;k--) {
						if(pathes[j][k]==1) {
							flag = 0;
							break;
						}
					}
					if(flag==1) {
						
					}else {
						System.out.println(circleCount-1);
					}
				}
				System.out.println(circleCount-1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new PAT1013().magic2();
	}

}
