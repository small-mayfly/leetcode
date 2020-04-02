package medium;
public class SearchinRotatedSortedArray {
	/**
	 * �������Ϊ������ת�ģ���δ������ת��������д���
	 * 	δ������ת�����������������ʹ�ö��ֲ���
	 * 	������ת��������Ҫ�жϱ߽�������������ת�����������и��ص����nums[0]>nums[nums.length-1]����������Ѿ�������һ����Ȼ�ķָ�
	 * 		���target>nums[0]����target��ΧΪ(nums[0], max(nums)]
	 * 		���target<nums[nums.length-1]����target�ķ�ΧΪ[min(nums), nums[nums.length-1])
	 * 		��ʱ��Ȼ�Ѿ�֪����Χ�����ǲ�֪����ת�˶��ٲ�������ֻ���ٴ�����mid���������ж�
	 * @param nums ���������
	 * @param target Ŀ����
	 * @return
	 */
	public int search(int[] nums, int target) {
		if(nums.length==0)   // ������鳤�ȣ���һ���Ҳ���Ŀ��
			return -1;
		if(nums.length==1) {   // ������鳤��Ϊ1��ֻ��Ҫ�жϵ�һ�����Ƿ��target��ȼ���
			if(nums[0]==target)
				return 0;
			else
				return -1;
		}
		int result = -1;   // �����Ҳ���������ҵ�����ͽ��и�ֵ
		int left = 0;   // ��ʼ��������߽�
		int right = nums.length-1;   // ��ʼ�������ұ߽�
		int mid;   // �����м�λ������
		if(nums[left]>nums[right]) {   // һ����������ת
			while(right>=left) {   // ֻҪ�߽绹�ھͼ�������
				if(nums[left]==target) {   // ������ڵ�ǰ��������������߽磬ֱ�Ӹ�ֵ��ֹͣ
					result = left;
					break;
				}else if(nums[right]==target) {// ������ڵ�ǰ�������������ұ߽磬ֱ�Ӹ�ֵ��ֹͣ
					result = right;
					break;
				}else if(nums[left]>nums[right]) {   // �жϵ�ǰ�������Ƿ�������ģ������������Ҫ�ж�
					mid = (left+right)/2;   // ��ȡ�м�λ��
					if(nums[mid]==target) {   // �ҵ�target����λ�ã���ֵֹͣ
						result = mid;
						break;
					}
					if(target>nums[left]) {   // ����߽��
						// ����м���ֵ����߽绹�������ֵ��(nums[left],nums[mid])֮�䣬���Խ��Ӧ����(left,mid)֮��
						if(nums[left]>nums[mid]) {   
							right = mid -1;
							left++;
						}else { // �������ֵ��mid���ұߣ���ʱ���������(��ȵ�����Ѿ���֮ǰ�ų�)
							// ��һ���������nums[mid]����˵�������(mid, right)֮��
							if(target>nums[mid]) {
								left = mid + 1;
								right--;
							}else {   // �ڶ����������nums[mid]С����ʱ�����(left,mid)֮��
								right = mid - 1;
								left++;
							}
						}
					}else {  // ��ʱ���ұ߽�С
						// ����м���ֵ���ұ߽�������ֵ��(nums[mid],nums[right])֮�䣬���Խ��Ӧ����(mid,right)֮��
						if(nums[mid]>nums[right]) {
							left = mid +1;
							right--;
						}else {  // ���������
							// ��һ���������nums[mid]��˵�������(mid, right)֮��
							if(target>nums[mid]) {
								left = mid + 1;
								right--;
							}else {   // �ڶ����������nums[mid]С����ʱ�����(left,mid)֮��
								right = mid - 1;
								left++;
							}
						}
					}
				}else {   // ��ǰС��������ģ����ж��ֲ���
					if(nums[left]==target) {
						result = left;
						break;
					}else if(nums[right]==target) {
						result = right;
						break;
					}else {
						mid = (left+right)/2;
						if(nums[mid]==target) {
							result = mid;
							break;
						}else {
							if(nums[mid]>target) {
								right = mid - 1;
								left++;
							}else {
								left = mid + 1;
								right--;
							}
						}
					}
				}
			}
		}else {   // ��ʼ״̬���򣬿����Ѿ���ת����������ת�س�ʼ״̬��
			// ˳������״̬��ֻ��Ҫ���������Ķ��ֲ��Ҽ���
			while(right>=left) {
				// ������Ƚ�������
				if(nums[left]==target) {
					result = left;
					break;
				}else if(nums[right]==target) {
					result = right;
					break;
				}else {
					// �����ȡһ�����
					mid = (left+right)/2;
					if(nums[mid]==target) {
						result = mid;
						break;
					}else {
						// ������С��������벿��
						if(nums[mid]>target) {
							right = mid - 1;
							left++;
						}else {   // �����Ĵ��������ֲ���
							left = mid + 1;
							right--;
						}
					}
				}
			}
		}
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchinRotatedSortedArray srsa = new SearchinRotatedSortedArray();
		int[] datas = {5,1,2,3,4};
		System.out.println(srsa.search(datas, 1));
	}
}
