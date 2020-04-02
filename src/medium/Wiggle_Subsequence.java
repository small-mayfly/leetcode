package medium;

/**
 * 
 * 1. Ŀ��⣺����һϵ������A������������µ�崵����е���󳤶�
 * 2. ���賤��ΪN��result(N) = maxLen(sequence)
 * 3. result(N) = maxLen{result(N-1), result(N-1)+A[N]}����ǰ�����󳤶ȵ�����һ���������󳤶Ⱥ���һ���������󳤶ȵ����м��ϵ�ǰ������ɵ��������ó�����󳤶ȣ�������󳤶ȵ����ֵ
 * 4. ���������е�N���������
 * @author mayfly
 *
 */
public class Wiggle_Subsequence {

	public int wiggleMaxLength(int[] nums) {
		if(nums.length==0)
			return 0;
		else if(nums.length==1) {
			return 1;
		}else if(nums.length==2) {
			if(nums[0]==nums[1])
				return 1;
			else {
				return 2;
			}
		}
		WiggleNode[] wns = new WiggleNode[nums.length];
		wns[0] = new WiggleNode(0, nums[0], 1);   // ��һ�����ֿ�����Ϊһ����������ս��������
		int flag;
		for(int i=1;i<nums.length;i++) {
			flag = nums[i]-wns[i-1].value;   // �жϵ�ǰֵ����һ��ֵ�Ĳ�ֵ
			if(flag>0) {   // �����ǰֵ������һ��ֵ
				if(wns[i-1].direct==1) {   // ��������������������ľ��棬���õ�ǰֵ�������������һ��ֵ���������Ȳ���
					wns[i] = new WiggleNode(1, nums[i], wns[i-1].len);
				}else if(wns[i-1].direct==-1) {   // ��������˰��ͣ�����������
					wns[i] = new WiggleNode(1, nums[i], wns[i-1].len+1);
				}else {   // �����ظ���ֱ�Ӻ���
					wns[i] = new WiggleNode(1, nums[i], wns[i-1].len+1);
				}
			}else if(flag<0) {   // �����ǰֵС����һ��ֵ
				if(wns[i-1].direct==1) {   // ����͹�ͣ���������
					wns[i] = new WiggleNode(-1, nums[i], wns[i-1].len+1);
				}else if(wns[i-1].direct==-1) {   // ���������½������õ�ǰֵ�������������һ��ֵ���������Ȳ���
					wns[i] = new WiggleNode(-1, nums[i], wns[i-1].len);
				}else {   // �����ظ���ֱ�Ӻ���
					wns[i] = new WiggleNode(-1, nums[i], wns[i-1].len+1);
				}
			}else {   // �����ǰֵ������һ��ֵ����Ϊ���ս�������в������ظ�ֵ�����Կ���ֱ�Ӻ���
				wns[i] = new WiggleNode(wns[i-1].direct, wns[i-1].value, wns[i-1].len);
			}
		}
		// �������һ��ֵ��������������������ĵ������
		return wns[wns.length-1].len;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Wiggle_Subsequence ws = new Wiggle_Subsequence();
		int[] datas = {1,1,1};
		System.out.println(ws.wiggleMaxLength(datas));
	}

}

class WiggleNode{
	int direct;   // ���Լ�¼��ǰ����е����һ���¶����ϻ����£�����Ϊ1���½�Ϊ-1���տ�ʼ��֪������Ϊ0
	int value;   // ���Լ�¼��ǰ�ֵ���һ������
	int len;   // ��¼��ǰ��󳤶�
	public WiggleNode(int direct, int value, int len) {
		this.direct = direct;
		this.value = value;
		this.len = len;
	}
}
