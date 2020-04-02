package easy;

public class RemoveDuplicatesfromSortedArray {
	/**
	 * ����ǵݼ������飬���������һ��Ԫ�غ͵�ǰԪ����ͬ�������ظ�ֵ��ֻ��Ҫ�������ֵǰ�Ƽ���
	 * @param nums ����ǵݼ�������
	 * @return ��������Ԫ�ظ�������������Ԫ�ذ������nums��ǰ����λ��
	 */
	public int removeDuplicates(int[] nums) {
		int result = nums.length;    // ���ȼ����������أ��������ظ��ټ�
		if(result==0)   // ������鳤��Ϊ0������һ��Ϊ0��ֱ�ӷ��ؼ���
			return 0;
		// ��Ϊ����Ԫ����Ҫ�ŵ�����ǰ�棬������һ����ʶλ����¼��ǰȷ�ϵ��˵ڼ���λ��
		// ��ʵ���ִֵ�е��������λ�þ��������з��ظ�Ԫ�صĸ�����ֱ�ӷ������ֵ����
		int confirmIndex = 1;   
		int now_num = nums[0];   // �����趨��ǰ�Ѿ�ȷ���ĵ�һ����Ϊ����ĵ�һ����
		for(int i=1; i<nums.length; i++) {   // ����������һ��
			if(nums[i]>now_num) {   // �����ǰλ�ñ�ǰ������ִ���һ���Ƿ��ظ��ģ��ƶ���ȷ�ϵ�λ��
				nums[confirmIndex] = nums[i];   // �ƶ���ȷ�ϵ�λ��
				confirmIndex++;   // ��ȡ��һ��Ҫȷ�ϵ�λ��
				now_num = nums[i];   // ���µ�ǰ�Ѿ�ȷ��������
			}else {
				result--;   // �����ظ����֣����ظ�Ԫ�ظ���-1
			}
		}
        return result;   // ���ط���Ԫ�ظ���
    }
	
	public int removeDuplicates2(int[] nums) 
	{
        if(nums.length==0)
			return 0;
		int confirmIndex = 1;
		for(int i=1; i<nums.length; i++) {
			if(nums[i]>nums[i-1]) {
				nums[confirmIndex++] = nums[i];
			}
		}
        return confirmIndex;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesfromSortedArray rdfsa = new RemoveDuplicatesfromSortedArray();
		int[] datas = {0,0,1,1,1,2,2,3,3,4};
		int result = rdfsa.removeDuplicates(datas);
		System.out.println(result);
		System.out.println("----------------");
		for(int i=0;i<result;i++) {
			System.out.println(datas[i]);
		}

	}

}
