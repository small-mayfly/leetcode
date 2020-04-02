package medium;

import java.util.HashSet;

public class SingleNum3 {
	
	public int[] singleNumber(int[] nums) {
        int[] results = new int[2];
		
        HashSet<Integer> rem = new HashSet<Integer>();
        for (int integer : nums) {
			if(!rem.add(integer)) {
				rem.remove(integer);
			}
		}
        int i = 0;
        for (Integer integer : rem) {
			results[i++] = integer;
		}
		return results;
    }
	
	public int[] singleNumber2(int[] nums) {
        int[] results = {0, 0};
        
        int rem = 0;
		
        for (int i : nums) {
			rem ^= i;
		}
        
        int index = rem & (~rem+1);
        
        for (int i : nums) {
        	if((index&i)== 0) {
        		results[0] ^= i;
        	}else {
        		results[1] ^= i;
        	}
        	
        }
        
        
		return results;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] datas= {1,2,1,3,2,5};
		
		int[] results = new SingleNum3().singleNumber2(datas);
		
		for (int i : results) {
			System.out.println(i);
		}
	}

}
