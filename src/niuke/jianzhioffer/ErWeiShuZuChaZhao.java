package niuke.jianzhioffer;
/**
 * ��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 * @author mayfly
 *
 */
public class ErWeiShuZuChaZhao {
	/**
	 * ��Ϊÿһ�У�ÿһ�зֱ���˳�����Կ����ȴӵ�һ�п�ʼ�ҵ���ӽ�target��С��target��ֵ����ʼ����
	 * @param target
	 * @param array
	 * @return
	 */
	public boolean Find(int target, int [][] array) {
		// �������Ϊ�գ���ֱ�ӷ���false
		int yLen = array.length;
		if(yLen==0)
			return false;
		int xLen = array[0].length;
		if(xLen==0)
			return false;
		// �ҵ���һ����С��target�����ֵ����λ��
		int index = -1;
		for(int i=0;i<xLen-1;i++) {
			if(array[0][i]==target)   // ����ҵ�targetֱ�ӷ��ؼ���
				return true;
			if(array[0][i]<target && array[0][i+1]>=target) {
				if(array[0][i+1]==target)   // ����ҵ�targetֱ�ӷ��ؼ���
					return true;
				else {
					index = i;
					break;
				}
			}
		}
		// ���û���ҵ���Ӧ��λ�ã�����Ϊ��һ��������ҲС��target
		if(index==-1) {   // target�ȵ�һ�����ұߵ��������Դ����λ�ÿ�ʼ����
			index = xLen-1;
		}
		
		int flag;   // ���ڱ���Ƿ��Ǹտ�ʼ���Լ��ƶ�����
		for(int i=1;i<yLen;i++) {
			flag = 0;    // Ĭ��Ϊ0
			while(true) {
				if(array[i][index]>target) { // ����ҵ�����target��ֵ
					if(index==0) {   // target����Сֵ����һ���Ҳ���
						return false;
					}
					// ����������ƶ�����idnex--
					if(flag==0 || flag==-1) {
						index--;
						flag = -1;   // �ӱ�ǣ���ֹ��������
					}else {
						break;   // �����򷴷����ƶ���������һ��
					}
				}else if(array[i][index]<target) {
					if(index==xLen-1) {   // target�����ֵС����һ���Ҳ���
						break;
					}
					if(flag==0 || flag==1) {
						index++;
						flag = 1;
					}else {
						break;
					}
				}else {
					return true;   // ����ҵ������ֱ�ӷ���
				}
			}
		}
		return false;   // �Ҳ������������fals
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ErWeiShuZuChaZhao ewszcz = new ErWeiShuZuChaZhao();
		int[][] datas = {{1,2,3},{4,5,6},{7,8,9}};
		ewszcz.Find(6, datas);
	}

}
