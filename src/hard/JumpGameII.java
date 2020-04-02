package hard;

public class JumpGameII {
	
	public int jump2(int[] nums) {
		if(nums.length<=1)   // �������Ϊ1�����ʼ״̬����ĩβ��ֱ�ӷ���
			return 0;
		
		// ��Ϊ��������index=0��λ�ã�����ֱ�Ӵ�step=1�������ʼ����
		// step����1�Ĺ�������Ϊ1~nums[0]֮��
		int nextStart = 1;   // ��¼��ǰ�����п���λ�õ���Сֵ
		int nextEnd = nums[0];   // ��¼��ǰ�����п��ܵ�λ�õ����ֵ
		int index = nextStart;   // �ӵ�ǰ����λ����Сֵ��ʼ���������ֵ���ҵ���һ�����п��ܵ���λ�õ�����
		int result = nextEnd;   // ��¼��ǰ����������λ��
		int step = 1;   // ��step1��ʼ����
		while(true) {   // һֱѭ�������������һ�����ֽ���
			if(result>=nums.length-1)   // ���������һ�����֣��������򣬷������˶��ٲ�
				return step;
			for(;index<=nextEnd;index++) {   // �ӿ�ʼλ�ÿ�ʼ������һֱ����������λ�õ����ֵ����
				if(index+nums[index]>result)   // ����ӵ�ǰλ�ó�������һ�����ܵ�������λ�ñ�result��������������߸�Զ�������滻result
					result = index+nums[index];
			}
			// ����һ�ֱ��������ҵ���һ�����ܵ����λ�õ����ֵ
			
			// ��һ�������Ŀ�ʼλ��Ϊ��ǰ�����ܵ���λ�õ����ֵ����һ��λ�ã��������Լ����ظ�������ͬʱ��һ���ܵ����λ��С�ڱ��ֿ��ܵ�������ֵ�Ļ�����������㣬����ж���·�����
			nextStart = nextEnd + 1;
			// ������һ�����ܵ�������λ��
			nextEnd = result;
			// ������һ�ֱ����Ŀ�ʼλ��
			index = nextStart;
			// �������˶��ٲ�
			step++;
		}
	}
	
	/**
	 * ���ù�����ȱ����ķ�����ǰ��������ߣ�ʱ�临�Ӷ�Ϊn^2
	 * ͬʱʹ��ͬһ�������¼���ﵱǰ������step�������������step��֮ǰ��Ҫ�࣬���֦����֦������һ�����͸��Ӷ�
	 * @param nums
	 * @return
	 */
	public int jump(int[] nums) {
		if(nums.length<=1)   // �������Ϊ1�����ʼ״̬����ĩβ��ֱ�ӷ���
			return 0;
		// �½����飬���Լ�¼�ǵڼ������ﵱǰλ��
		int[] rem = new int[nums.length];
		// ��ʼ״̬Ϊ���ɴ�
		for(int i=0;i<nums.length;i++)
			rem[i]=Integer.MAX_VALUE;
		// ��ʼ״̬�ڵ�һ��������
		rem[0] = 0;
		int step = 1;   // ��¼�ǵڼ����ߵ��ĵ�ǰλ��
		for(int i=0;i<nums.length;i++) {
			step = rem[i]+1;   // �ӵ�ǰλ�ó���������һ�οɵ��ĵ����в���Ϊ��ǰ����
			for(int j=i+1;j<=i+nums[i] && j<nums.length;j++) {   // �鿴���д���һ�����һ���ɴ�ĵ�
				if(rem[j]>step) {   // �����һ��֮ǰû�е����������Ϊ�ӳ�ʼ�㵽��ǰ��������Ҫstep��
					rem[j]=step;
				}
			}
			// ����Ѿ��ҵ����һ�㣬��ֱ�ӷ��أ���Ϊ��һ��һ������������ߣ����Ե�һ�������һ���ǲ������ٵ�
			if(rem[nums.length-1]!=Integer.MAX_VALUE)
				return step;
		}
		return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpGameII jgii = new JumpGameII();
		int[] datas = {2,3,1,1,4};
		System.out.println(jgii.jump(datas));
		System.out.println(jgii.jump2(datas));
	}

}
