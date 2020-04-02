package pat;

import java.util.HashSet;
import java.util.Scanner;
/**
 * 主要思路是深搜加剪枝。实际上复杂度不比迪杰斯特拉算法高
 * 这个题有以下几个坑
 * 1. 所有的路都是无向的，所以判断的时候要注意
 * 2. 要考虑leader就在救援目的地的情况
 * @author mayfly
 *
 */
public class PAT1003 {
	int city_num;
	int road_num;
	int location;
	int target;
	int[] team_num;
	int[][] roads;
	int minCosts;
	int maxTeamNum;
	int shortestNum;
	
	public void method() {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			city_num = in.nextInt();
			road_num = in.nextInt();
			location = in.nextInt();
			target = in.nextInt();
			team_num = new int[city_num];
			for(int i=0;i<city_num;i++) {
				team_num[i] = in.nextInt();
			}
			roads = new int[city_num][city_num];
			int x,y,cost;
			for(int i=0;i<road_num;i++) {
				x = in.nextInt();
				y = in.nextInt();
				cost = in.nextInt();
				roads[x][y] = cost;
				roads[y][x] = cost;
			}
			
			// 初始化环境
			minCosts = Integer.MAX_VALUE;
			maxTeamNum = 0;
			shortestNum = 0;
			HashSet<Integer> onRoads = new HashSet<Integer>();
			onRoads.add(location);
			search(location, 0, onRoads);
			System.out.format("%d %d", shortestNum, maxTeamNum);
		}
		
		
		in.close();
	}
	
	public int getTeamNum(HashSet<Integer> onRoads) {
		int tteam = 0;
		for(Integer t: onRoads) {
			tteam += team_num[t];
		}
		return tteam;
	}
	
	public void search(int nowLocation, int nowCost, HashSet<Integer> onRoads) {
		if(nowCost>minCosts) {
			return;
		}	
		// 如果已经找到目的地，则返回
		if(nowLocation==target) {
			if(nowCost<minCosts) {
				minCosts = nowCost;
				maxTeamNum = getTeamNum(onRoads);
				shortestNum = 1;
			}else if(nowCost==minCosts){
				shortestNum++;
				int tteam = getTeamNum(onRoads);
				if(tteam>maxTeamNum)
					maxTeamNum = tteam;
			}
			return;
		}
		for(int i=0;i<city_num;i++) {
			if(roads[nowLocation][i]!=0 && !onRoads.contains(i)) {
				onRoads.add(i);
				search(i, nowCost+roads[nowLocation][i], onRoads);
				onRoads.remove(i);
			}
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PAT1003().method();
	}

}
