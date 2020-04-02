package niuke.jianzhioffer;

public class NIUKE11193 {
	
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int index = 1;
        int rem = 0;
        for(int i=0;i<array.length;i++)
        	rem ^= array[i];
        while((rem & index)==0)
        	index <<= 1;
        num1[0] = 0;
        num2[0] = 0;
        for(int i=0;i<array.length;i++) {
        	if((array[i] & index)==0) {
        		num1[0] ^= array[i];
        	}else {
        		num2[0] ^= array[i];
        	}
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
