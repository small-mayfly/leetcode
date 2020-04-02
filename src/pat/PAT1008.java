package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 使用BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));从控制台获取输入，无坑
 * 但是使用Scanner获取控制台输入会超时
 * @author mayfly
 *
 */
public class PAT1008 {
	
	public void magic() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		String[] datas = reader.readLine().split(" ");
		int num = Integer.valueOf(datas[0]);
		int cost = num * 5;
		int nowLoc = 0;
		int tLoc;
		for(int i=1;i<=num;i++) {
			tLoc = Integer.valueOf(datas[i]);
			
			if(nowLoc>tLoc) {
				cost += (4 * (nowLoc - tLoc));
			}else {
				cost += (6 * (tLoc - nowLoc));
			}
			nowLoc = tLoc;
		}
		System.out.print(cost);
		
		reader.close();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new PAT1008().magic();
	}

}
