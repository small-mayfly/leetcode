package niuke.jianzhioffer;
/**
 * ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ���
 * ��n==0ʱ��ֱ�ӷ���0
 * ��n==1ʱ��ֻ��ʹ��һ��ש���ַ���
 * ��n==2ʱ��������ש�����к�����ש���������ַ���
 * ��n>2ʱ��������A(n)�ַ���,A(n)=A(n-1)+A(n-2)�ַ�������ΪA(n-1)��ΪA(n)ֻ��һ�ַ�����A(n-2)��ΪA(n)�ڲ����n-1��״̬�£�ֻ������ש������һ�ַ���
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
