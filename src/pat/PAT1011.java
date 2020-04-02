package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 无坑
 * @author mayfly
 *
 */
public class PAT1011 {
	
	public void magic() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[][] datas = new String[3][3];
		
		datas[0] = in.readLine().split(" ");
		datas[1] = in.readLine().split(" ");
		datas[2] = in.readLine().split(" ");
		
		String[] labels = {"W", "T", "L"};
		
		float result = 1.0f;
		
		int[] remIndex = new int[3];
		for(int i=0;i<3;i++) {
			remIndex[i] = getMaxIndex(datas[i]);
			result *= Float.valueOf(datas[i][remIndex[i]]);
			System.out.print(labels[remIndex[i]]+ " ");
		}
		result = (result * 0.65f -1) * 2;
		
		System.out.format("%.2f", result);
		
		in.close();
	}
	
	public int getMaxIndex(String[] data) {
		
		float rem = 0;
		int remIndex = -1;
		float t;
		for(int i=0;i<data.length;i++) {
			t = Float.valueOf(data[i]);
			if(rem<t) {
				rem = t;
				remIndex = i;
			}
		}
		
		return remIndex;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new PAT1011().magic();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
