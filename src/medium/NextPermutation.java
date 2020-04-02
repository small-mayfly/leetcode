package medium;

public class NextPermutation {
	/**
	 * �����ѧȫ������
	 * ��ȡ�������е�ĳһ�����е���һ�����У�������������е����һ������������򷵻��������еĵ�һ�����
	 * �������ֻ��Ҫ�Ӻ���ǰ���γ��ң��ҳ��Ƿ����˳���������������������ǰλ�ý����޸���һ��Ӱ��������С��Ҳ�͵�ǰλ��ֵa��С����a���a�����Сֵ����λ�ã�Ȼ��a֮���������ֵ˳�����У���ʱ��ֵһ������һ������
	 * 
	 * @param nums ��ǰ��������
	 */
	public void nextPermutation(int[] nums) {
		int flag = -1;   // ���Ա�־������ǰ�����Ƿ�����Ҫ�����ĵ�һ�����֣���������Ϊ�����-1ֵ
		int fIndex = nums.length-2;   // ��¼��ǰ�����Ŀ�ʼλ��
		int tIndex = 0;   // ��ʱ��¼��ǰ����ѯλ��
		int rem = 0;   // ��¼��fIndexλ�õ�ֵ�����Сֵ�Ĵ�С
		int remIndex = 0;  // ��¼rem��λ��
		while(fIndex>=0) {   // �Ӻ���ǰ�����α�����������ͷ��λ��
			tIndex = fIndex + 1;   // ��findex��ʼ����ұ�nums[fIndex]�����Сֵ
			while(tIndex<nums.length) {   // ����β����ʼ��һ�ֲ���
				if(nums[fIndex]<nums[tIndex]) {   // ��������˳�������������һ��Ӧ�ý������ֽ���
					if(flag==-1) {   // �ж��Ƿ����ҵ��ĵ�һ������nums[fIndex]����Сֵ
						rem = nums[tIndex];   // ��¼��ǰ��֪�Ĵ���nums[fIndex]����Сֵ
						remIndex = tIndex;   // ��¼remλ��
					}
					else {
						if(rem>nums[tIndex]) {   // �µĴ���nums[fIndex]����Сֵ����֪��ҪС����и���
							rem = nums[tIndex];   // ���µ�ǰ��֪�Ĵ���nums[fIndex]����Сֵ
							remIndex = tIndex;   // ����remλ��
						}
					}
					flag = 0;   // �޸ı�־λ
				}
				tIndex++;   // ���������һ�飬����֪���Ƿ���fIndex֮�����nums[fIndex]����Сֵ
			}
			if(flag==0) {   // ��ǰ�ִΣ��Ѿ��ҵ���һ�����������ֵ������Ҫ�������²���
				break;
			}
			fIndex--;   // ���û�в��ҵ���һ�����������ֵ���������²���
		}
		if(flag==-1) {   // ����һ�鶼�ǵ���ģ�˵���Ѿ����������е����һ�����������Ҫ�����������еĵ�һ�����
			// ��Ϊ�������е����һ��������������еĵ�һ�������һ����1 to n��һ����n to 1 ����λ�����滻�����Բ���Ҫ����ֱ����β��λ�ü���
			fIndex = 0;   // ��¼ͷָ��
			tIndex = nums.length-1;   // ��¼βָ��
			while(fIndex<tIndex && tIndex-fIndex>0) {   // ������ָ����ײ��˵���Ѿ�����һ�飬����
				// ����λ��
				flag = nums[fIndex];
				nums[fIndex] = nums[tIndex];
				nums[tIndex] = flag;
				// ͷָ�������һ��
				fIndex++;
				// βָ����ǰ��һ��
				tIndex--;
			}
		}else {
			tIndex = remIndex;   // ��¼��fIndex�����Сֵ��λ��
			// ���Ƚ�����һλ
			flag = nums[fIndex];
			nums[fIndex] = nums[tIndex];
			nums[tIndex] = flag;
			// Ȼ�󽻻�ʣ��λ��,ʣ��λ������ð�����򣬲���ע����
			fIndex++;
			for(int i=fIndex;i<nums.length;i++) {
				for(int j=i+1;j<nums.length;j++) {
					if(nums[i]>nums[j]) {
						flag = nums[i];
						nums[i] = nums[j];
						nums[j] = flag;
					}
				}
			}
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextPermutation np = new NextPermutation();
		int[] nums = {1, 3, 2};
		np.nextPermutation(nums);
		for(int i=0; i<nums.length; i++)
			System.out.println(nums[i]);
	}
}
