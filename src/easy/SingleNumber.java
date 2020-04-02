package easy;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
	
	public int singleNumber2(int[] nums) {
		
		int rem = 0;
		for (int i : nums) {
			rem = rem ^ i;
		}
		
		return rem;
	}
	
	public int singleNumber(int[] nums) {
				
        Set<Integer> rems = new HashSet<Integer>();
        for (int num : nums) {
        	
			if(rems.contains(num)) {
				rems.remove(num);
			}else {
				rems.add(num);
			}
		}
		return (int)(rems.toArray())[0];
		
//		return 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
