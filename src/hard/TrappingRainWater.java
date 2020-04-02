package hard;

/**
 * �����ˮ��
 * @author mayfly
 *
 */
public class TrappingRainWater {
	/**
	 * �����������ÿ�����ӵĸ߶ȣ�������������м��п�϶���ˮ�������ܵĴ�ˮ��
	 * @param height ÿ�����ӵĸ߶�
	 * @return
	 */
	public int trap(int[] height) {
		// ���ֻ�в������������ӣ���һ�������ˮ������ֱ�ӷ���0����
		if(height.length<=2)   
			return 0;
		// ��¼�ܵĴ�ˮ��
        int result = 0;
        // ��¼�����������ӵ�����
        int index = 0;
        // �������ұ��������һ��ʼ�����Ӹ߶�Ϊ0����һ�������ˮ���ȹ��˵�
        while(height[index]==0 && index<height.length) {
        	index++;
        }
        // �ҵ���һ���и߶ȵ����ӣ���¼���ĸ߶�
        int oldHeight = height[index++];
        // ��¼������ӵ�����
        int oldIndex = index;
        // �������ұ���������������ӱȵ�ǰ���Ӹ߻��ߣ����������һ���ߣ����м���ܻ��ˮ��Ȼ��ֻ��Ҫ�������д��ڶ���ˮ�Ϳ�����
        for(;index<height.length;index++) {
        	// �ҵ����ܴ�ˮ������
        	if(height[index]>=oldHeight) {
        		int nowHeight = Math.min(oldHeight, height[index]);   // ��¼���������еĽϵ��ߣ�������������ܴ����ˮ
        		while(oldIndex<index) {   // ��ʼ����ˮ�Ķ��ټ�¼��ֵ
        			result += (nowHeight-height[oldIndex++]);
        		}
        		oldIndex = index+1;   // ��¼֮����µ�ǰ��¼
        		oldHeight = height[index];
        	}
        }
        // �����ұ������󻹴���һ�����������������ӱ��ұ����Ӹߵ������û�м�¼���еĴ�ˮ��������һ����˼·�ٴ���������һ��
        index = height.length-1;
        while(height[index]==0 && index>=0) {
        	index--;
        }
        oldHeight = height[index--];
        oldIndex = index;
        for(;index>=0;index--) {
        	if(height[index]>oldHeight) {   // ��Ϊ��������һ���ߵ�����Ѿ���¼���ˣ�����ֻ��Ҫ�ж���߱��ұ߸ߵ�����Ϳ�����
        		int nowHeight = Math.min(oldHeight, height[index]);
        		while(oldIndex>index) {
        			result += (nowHeight-height[oldIndex--]);
        		}
        		oldIndex = index-1;
        		oldHeight = height[index];
        	}
        }
        // �������������ؽ��
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrappingRainWater trw = new TrappingRainWater();
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trw.trap(height));

	}

}
