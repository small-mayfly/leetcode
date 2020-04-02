package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class PAT1009 {
	
	public void magic() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


		
		String[] dataa = in.readLine().split(" ");
		String[] datab = in.readLine().split(" ");
		
		HashMap<Integer, Double> rems = new HashMap<Integer, Double>();
		ArrayList<Integer> keys = new ArrayList<Integer>();
		
		if(dataa.length>1 && datab.length>1) {
			int a, c;
			double b, d;
			for(int i=1;i<dataa.length;i+=2) {
				for(int j=1;j<datab.length;j+=2) {
					a = Integer.valueOf(dataa[i]);
					b = Float.valueOf(dataa[i+1]);
					c = Integer.valueOf(datab[j]);
					d = Float.valueOf(datab[j+1]);
					rems.put(a+c, rems.getOrDefault(a+c, 0.0)+b*d);
					if(!keys.contains(a+c)) {
						keys.add(a+c);
					}
				}
			}
		}else {
			// 总有一个长度为0
			if(dataa.length==1)
				dataa = datab;
			int a;
			float b;
			for(int i=1;i<dataa.length;i+=2) {
				a = Integer.valueOf(dataa[i]);
				b = Float.valueOf(dataa[i+1]);
				rems.put(a, rems.getOrDefault(a, 0.0)+b);
				if(!keys.contains(a)) {
					keys.add(a);
				}
			}
			
		}
		int count = 0;
		for(Integer key: keys) {
			if(rems.get(key)!=0)
				count++;
		}
		if(count>0)
			System.out.print(count);
		// 将指数按照逆序排序
		keys.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(o1==o2)
					return 0;
				else
					return o1<o2?1:-1;
			}
		});
		for(Integer key: keys) {
			if(rems.get(key)!=0)
				System.out.format(" %d %.1f", key, rems.get(key));
		}

		
		in.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new PAT1009().magic();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
