package niuke.jianzhioffer;
/**
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 * @author mayfly
 * һά��̬�滮���⡣����ǰn����Ϊ������������k����Ϊż����Ȼ��������һ����������ʱ��ֻ��Ҫ��¼��ǰ����ֵ��Ȼ���k��ż����������ƶ�һλ��Ȼ��ѵ�ǰ����ֵ����n���������棬�������ܱ�֤ǰn+1+kλΪ���������Ĵ�
 */
public class Tiaozhengshuzushunxu {
	
	public void reOrderArray(int [] array) {
		if(array.length<=1) {
			return;
		}
		int start = 0;
		int end;
		int temp;
		while(array[start]%2==1) {
			start++;
		}
		end = start;
		while(end<array.length) {
			if(array[end]%2==1) {
				temp = array[end];
				for(int i=end-1;i>=start;i--) {
					array[i+1] = array[i];
				}
				array[start] = temp;
				start++;
			}
			end++;
		}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tiaozhengshuzushunxu t = new Tiaozhengshuzushunxu();
		int[] datas = {1,2,3,4,5,6,7};
		t.reOrderArray(datas);
		for(int i=0;i<datas.length;i++) {
			System.out.println(datas[i]);
		}
	}

}
