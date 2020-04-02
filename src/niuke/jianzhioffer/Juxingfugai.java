package niuke.jianzhioffer;
/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法
 * 当n==0时，直接返回0
 * 当n==1时，只有使用一块砖两种方法
 * 当n==2时，有两块砖横排列和两块砖纵排列两种方法
 * 当n>2时，假设有A(n)种方法,A(n)=A(n-1)+A(n-2)种方法，因为A(n-1)变为A(n)只有一种方法，A(n-2)变为A(n)在不变成n-1的状态下，只有两块砖纵排列一种方法
 * @author mayfly
 *
 */
public class Juxingfugai {
	
	public int RectCover(int target) {
        if(target==0) return 0;
        else if(target==1) return 1;
        else if(target==2) return 2;
        else{
            int a=1;
            int b=2;
            int flag = 0;
            for(int i=2;i<target;i++){
                if(flag==0){
                    a += b;
                }else{
                    b += a;
                }
                flag = 1-flag;
            }
            return flag==0?b:a;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.SIZE);

	}

}
