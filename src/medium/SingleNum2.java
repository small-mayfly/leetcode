package medium;

import java.util.HashMap;

public class SingleNum2 {
	public int singleNumber3(int[] nums) {
		
		int ones = 0;
		int twos = 0;
		for (int i : nums) {
			ones = ones ^ i;
			twos = ones | i;
		}
		
		return ones | twos;
	}
	
	public int singleNumber2(int[] nums) {
		int len = 32;
		int size = nums.length;
        int mask = 1, count = 0, ret = 0;
        for(int i = 0; i < len; ++i)
        {
            count = 0;
            for(int j = 0; j < size; ++j)
                if((mask & nums[j])==mask) 
                	count++;
            if((count%3)==1) 
            	ret |= mask;
            mask <<= 1;
        }
        return ret;
	}
	
	public int singleNumber(int[] nums) {
        
		HashMap<Integer, Integer> rems = new HashMap<Integer, Integer>();
		
		for (int num : nums) {
			if(rems.containsKey(num)) {
				rems.put(num, 2);
			}else {
				rems.put(num, 1);
			}
		}
		
		for (Integer i : rems.keySet()) {
			if(rems.get(i)==1)
				return i;
		}
		return 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleNum2 sn = new SingleNum2();
		int[] datas = {0,1,0,1,0,1,99, 99, 99, 10};
//		int[] datas2 = {};
		System.out.println(sn.singleNumber(datas));
		System.out.println(sn.singleNumber2(datas));
		System.out.println(sn.singleNumber3(datas));

	}

}
