package medium;

public class UTF8Validation {
	
	public boolean validUtf82(int[] data) {
		if(data.length==0) {
			return false;
		}
		int rem = 0;
		for (int num : data) {
			if(rem==0) {
				if(num >> 3 == 30)
					rem = 3;
				else if(num >> 4 == 14)
					rem = 2;
				else if(num >> 5 == 6)
					rem = 1;
				else if(num >> 7 != 0)
					return false; 
			}else {
				if(num>>6 == 2) {
					rem--;
				}else {
					return false;
				}
			}
		}
		return rem==0;
	}
	
	
	
	public boolean validUtf8(int[] data) {
		if(data.length==0) {
			return false;
		}
		int[] val = {0, 6, 14, 30};
		boolean flag;
        int rem;
        int startIndex = 0;
//        while()
        while(startIndex<data.length) {
        	rem = data[startIndex]>>3;
        	flag = false;
            for(int i=4;i>0;i--) {
            	if(rem==val[i-1] || (i==1 && rem==1)) {
            		if(data.length-startIndex<i)
            			return false;
            		
            		for(int j=1;j<i && j<data.length;j++) {
//            			System.out.println(data[j+startIndex]>>6);
            			if((data[j+startIndex]>>6) != 2) {
            				return false;
            			}
            		}
            		startIndex += i;
            		flag = true;
            		break;
            	}
            	rem >>= 1;
            	
            }
            if(!flag)
            	return false;
        }
        
		return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {197, 130, 1};
		System.out.println(new UTF8Validation().validUtf8(data));
	}

}
