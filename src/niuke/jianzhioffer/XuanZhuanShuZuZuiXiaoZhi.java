package niuke.jianzhioffer;
/**
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
 * ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
 * NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 * @author mayfly
 *
 */
public class XuanZhuanShuZuZuiXiaoZhi {
	public int minNumberInRotateArray(int [] array) {
		// �������СΪ0������0
		if(array.length==0)
			return 0;
		// ������һ�����ֲ����ڵ�һ�����֣�˵����������ת�������������ֶ����
		if(array[0]>=array[array.length-1]) {
			int index = array.length-1;   // ��ȡ���һλ���ֵ�����
			while(array[index]>=array[index-1] && index>0) {   // ��ǰ���α�����֪������ǰһ�����ִ��ں�һ�����ֵ��������ʱ�����һ�����־�����Сֵ
				index--;
			}
			return array[index];
		}else {   // û�з�������ת��һ���ǵ�һ��������С
			return array[0];
		}
	    
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
