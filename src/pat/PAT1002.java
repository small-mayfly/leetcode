package pat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * 这里的多项式相加时只需要单纯的考虑同指数的系数相加即可
 * 有个坑是如果系数变为0则不能输出，否则判为输出错误
 * 输出精确度.1f
 * @author mayfly
 *
 */
public class PAT1002 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			HashMap<Integer, Double> rems = new HashMap<Integer, Double>();
			int m, e;
			double c;
			m = in.nextInt();
			for(int i=0;i<m;i++) {
				e = in.nextInt();
				c = in.nextDouble();
				rems.put(e, rems.getOrDefault(e, 0.0)+c);
			}
			m = in.nextInt();
			for(int i=0;i<m;i++) {
				e = in.nextInt();
				c = in.nextDouble();
				rems.put(e, rems.getOrDefault(e, 0.0)+c);
			}
			Iterator<Integer> iter = rems.keySet().iterator();
			while(iter.hasNext()) {
				int key = iter.next();
				if(rems.get(key)==0.0){
//					rems.remove(key);
					iter.remove();
				}
			}
			if(rems.size()>0){
				System.out.print(rems.size());
				Set<Integer> keys = rems.keySet();
				ArrayList<Integer> remKeys = new ArrayList<Integer>();
				for(Integer key: keys) {
					remKeys.add(key);
				}
				Collections.sort(remKeys, new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						return o1>o2?-1:1;
					}
					
				});
				for(Integer key: remKeys) {
					System.out.format(" %d %.1f", key, rems.get(key));
				}
			}else {
				System.out.print(rems.size());
			}
		}

	}

}
