package hard;

/**
 * ����˼·Ϊÿ�ζ������ҵ�������k���ڶ�Ӧ��λ��k-1��
 * ����˼·��һ���������
 * 	ÿ���ҵ�һ����������������������������Ҳ����˾ͽ���
 * 	��Ȼ�������Ƹ��Ӷ�ΪO(n^2)����������λ����ȷ�Ͳ���Ҫ����������1��n��������������ŵ���Ӧλ�����ֻ��Ҫ����n�Σ������ܵĽ�������������n��
 * @author mayfly
 *
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		// �������Ϊ�գ���ȱʧ����СֵΪ1
		if(nums.length==0)
			return 1;
		int temp=-1;   // ��¼��ʱ����
		int nowIndex;   // ��¼��ѭ��ʱ������λ��
		// ������������ÿ���ҵ�λ�������ֲ���Ӧ������ͽ���ѭ���޸�λ��
		for(int i=0;i<nums.length;i++) {
			nowIndex=i;   // ��ǰ�ڵ�i��λ��
			// �����ǰλ�õ�ֵ����1~nums.length֮�䣬���޷����ڶ�Ӧλ�ã�����ѭ��
			while(nums[nowIndex]>0 && nums[nowIndex]<=nums.length) {
				// ��ֹ����λ��k��λ��m���ֶ���k+1��������ѭ�������
				if(nums[nowIndex]==temp) {
					break;
				}
				// �ҵ�һ��λ�ò���Ӧ�����֣�ֱ�ӽ���
				if(nums[nowIndex]-1!=i) {
					temp = nums[nowIndex];
					nums[nowIndex] = nums[nums[nowIndex]-1];
					nums[temp-1] = temp;
				}else {
					break;   // ��ǰλ�������ֶ�Ӧ���������һ��ѭ�����ж���һ��index
				}
			}
		}
		for(int i = 0;i<nums.length;i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        return nums.length+1;
		
	}

	public static void main(String[] args) {
		
		FirstMissingPositive fmp = new FirstMissingPositive();
		int[] data = {1,1};
		
		System.out.println(fmp.firstMissingPositive(data));

	}

}
