package medium;

public class UniqueBinarySearchTrees {
	
	
	public int numTrees(int n) {
        if(n<1) {   // û�нڵ��ʱ�򣬲����ڶ���������
        	return 0;
        }else if(n==1) {   // ֻ��һ���ڵ�
        	return  1;
        }else if(n==2) {   // �����ڵ��ʱ�������ֶ���������
        	return 2;
        }else {
        	// ���ڼ�¼��k���ڵ�ʱ�������������ж�������̨
        	int[] rem = new int[n+1];
        	rem[0] = 1;
        	rem[1] = 1;
        	rem[2] = 2;
        	// ��������������
        	for(int i=3;i<=n;i++) {
        		// ����Ϊn�����֣������м�ڵ�Ϊ��k�������������k-1���ڵ㣬�ұ���n-k���ڵ㣬�������Ҹ���rem[k-1] rem[n-k]�ֶ�����������̬
        		for(int j=1;j<=i;j++) {
        			rem[i] += (rem[j-1]*rem[i-j]);
        		}
        	}
        	return rem[n];
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new UniqueBinarySearchTrees().numTrees(5));
	}

}
