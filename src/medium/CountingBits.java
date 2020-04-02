package medium;

public class CountingBits {
	
	public int[] countBits(int num) {
		
		if(num==0) {
			int[] results = {0};
			return results;
		}else if(num==1) {
			int[] results = {0,1};
			return results;
		}
		
		int[] results = new int[num+1];
		results[0] = 0;
		results[1] = 1;
		int rem=num;
		int circle = 0;
		while(rem>0) {
			circle ++;
			rem /=2;
		}
		int index = 2;
		int nowStart;
		for(int i=1;i<circle-1;i++) {
			nowStart = 1<<i;
			while(index<(nowStart<<1)) {
				results[index] = results[(index-nowStart)]+1;
				index++;
			}
		}
		nowStart = 1<<(circle-1);
		while(index<=num) {
			results[index] = results[(index-nowStart)]+1;
			index++;
		}
		
		
        return results;
    }
	
	public int[] countBits2(int num) {
		
		if(num==0) {
			int[] results = {0};
			return results;
		}else if(num==1) {
			int[] results = {0,1};
			return results;
		}
		
		int[] results = new int[num+1];
		results[0] = 0;
		results[1] = 1;
		int circle = 1;
		int start;
		int rem;
		while((2<<circle) <= num) {
			start = 1<<circle;
			rem = start;
			while(rem<2<<circle) {
				results[rem] = results[rem-start] + 1;
				
				
				rem++;
			}
			circle++;
		}
		start = 1<<circle;
		rem = start;
		while(rem<=num) {
			results[rem] = results[rem-start] + 1;
			
			
			rem++;
		}
		
		
		
		return results;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data = 5;
		new CountingBits().countBits2(data);
	}

}
