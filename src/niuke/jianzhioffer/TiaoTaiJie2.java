package niuke.jianzhioffer;

/**
 * F_n = F_(n-1) + F_(n-2) + ... + F_2 + F_1 + 1
 * 可以推出
 * F_(n+1) = F_n + F_(n-1) + F_(n-2) + ... + F_2 + F_1 + 1 = 2F_n
 * F_1 = 1 
 * @author mayfly
 *
 */
public class TiaoTaiJie2 {

	public int JumpFloorII(int n) {
		if(n==1) {   // 第一项为1
			return 1;
		}else {   // 之后每一项都有F_n = F_(n-1) + F_(n-2) + ... + F_2 + F_1 + 1
			return 2<<(n-2);
		}
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TiaoTaiJie2 ttj = new TiaoTaiJie2();
		System.out.println(ttj.JumpFloorII(6));
	}

}
