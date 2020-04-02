package pat;

import java.util.Scanner;
/**
 * 依次判断输入的开门关门时间就行，还有就是判断时间的大小
 * @author mayfly
 *
 */
public class PAT1006 {
	
	public void magic() {
		
		Scanner in = new Scanner(System.in);
		int n;
		n = Integer.valueOf(in.nextLine());
		if(n==0)
			return;
		
		String startTime;
		String endTime;
		String unlockName, lockName;
		String[] temp;
		temp = in.nextLine().split(" ");
		unlockName = lockName = temp[0];
		startTime = temp[1];
		endTime = temp[2];
		for(int i=1;i<n;i++) {
			temp = in.nextLine().split(" ");
			// 如果进去的当前时间小于输入时间，说明比当前这个人进去的早，不需要改变
			if(timeCompare(startTime, temp[1])) {
				startTime = temp[1];
				unlockName = temp[0];
			}
			// 如果出去的当前时间比输入时间小，说明输入的这个人出来的晚
			if(timeCompare(temp[2], endTime)) {
				endTime = temp[2];
				lockName = temp[0];
			}
		}
		System.out.print(unlockName+" "+lockName);
		
		
		in.close();
		
	}
	/**
	 * 判断time1是否比time2大
	 * @param time1
	 * @param time2
	 * @return
	 */
	public boolean timeCompare(String time1, String time2) {
		String[] rtime1 = time1.split(":");
		String[] rtime2 = time2.split(":");
		
		if(Integer.valueOf(rtime1[0])>Integer.valueOf(rtime2[0])) {
			return true;
		}else if(Integer.valueOf(rtime1[0])<Integer.valueOf(rtime2[0])) {
			return false;
		} else {
			if(Integer.valueOf(rtime1[1])>Integer.valueOf(rtime2[1])) {
				return true;
			}else if(Integer.valueOf(rtime1[1])<Integer.valueOf(rtime2[1])) {
				return false;
			}else {
				if(Integer.valueOf(rtime1[2])>Integer.valueOf(rtime2[2])) {
					return true;
				}else {
					return false;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PAT1006().magic();
	}

}
