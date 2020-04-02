package medium;

public class ValidSudoku {
	/**
	 * �жϵ�ǰ�������Ƿ�Ϸ�
	 * @param board ��������ɵĶ�ά����
	 * @return �����Ƿ�Ϸ�
	 */
	public boolean isValidSudoku(char[][] board) {
		int size = board.length;   // �����������εģ���ȡ���̵Ŀ��
		int[] rem = new int[9];   // ����1-9�����飬�����ж��Ƿ�����ظ�ֵ
		int data;   // ��ʱ��¼����
		for(int i=0;i<9;i++)   // ��ʼ����¼����
			rem[i]=0;
		if(size<4) {   // ��������̵ĳ���С��4����ֻ���ܴ���һ��3*3�ľŹ���ֻ��Ҫ�ж��Ƿ����г����ظ����ּ���֪���Ƿ�Ϸ�������Ҫ�����ж��к���
			for(int i=0;i<size;i++) {
				for(int j=0;j<size;j++) {
					if(board[i][j]!='.') {
						data = board[i][j]-'1';   // ��ȡ��ǰ�ǿ���ֵ-1����������һ����rem������+1
						rem[data]++;
						if(rem[data]>1)   // >1˵�����ֲ�ֹһ�Σ��Ƿ�
							return false;
					}
				}
			}
			return true;   // �ų��Ƿ������ʣ�µĿ϶��ǺϷ������
		}else {
			// �ж�������
			for(int i=0;i<size;i++) {
				for(int j=0;j<9;j++)   // ��ʼ����¼����
					rem[j]=0;
				for(int j=0;j<size;j++) {   // �жϵ�ǰ���Ƿ����ظ�����ֵ����
					if(board[i][j]!='.') {
						data = board[i][j]-'1';
						rem[data]++;
						if(rem[data]>1)
							return false;
					}
				}
			}
			//�ж������У��Ƿ����ظ���ֵ����
			for(int i=0;i<size;i++) {
				for(int j=0;j<9;j++)
					rem[j]=0;
				for(int j=0;j<size;j++) {
					if(board[j][i]!='.') {
						data = board[j][i]-'1';
						rem[data]++;
						if(rem[data]>1)
							return false;
					}
				}
			}
			// �ж�����3*3��С����
			// ����->�£�Ȼ����->�ң����α���
			for(int i=0;i<size-2;i+=3) {   // left -> right
				// �������Խ�磬ֱ���˳�
				if(i+2>=size)
					break;
				for(int j=0;j<size-2;j+=3) {   // up -> down
					// �������Խ�磬ֱ���˳�
					if(j+2>=size)
						break;
					for(int k=0;k<9;k++)
						rem[k]=0;
					// �жϵ�ǰ�Ź����Ƿ����ظ���ֵ����
					for(int x=0;x<3;x++) {
						for(int y=0;y<3;y++) {
							if(board[i+x][j+y]!='.') {
								data = board[i+x][j+y]-'1';
								rem[data]++;
								if(rem[data]>1)
									return false;
							}
						}
					}
				}
			}
			return true;
		}
    }
	public static void main(String[] args) {
		char[][] datas = {
				  {'8','3','.','.','7','.','.','.','.'},
				  {'6','.','.','1','9','5','.','.','.'},
				  {'.','9','8','.','.','.','.','6','.'},
				  {'8','.','.','.','6','.','.','.','3'},
				  {'4','.','.','8','.','3','.','.','1'},
				  {'7','.','.','.','2','.','.','.','6'},
				  {'.','6','.','.','.','.','2','8','.'},
				  {'.','.','.','4','1','9','.','.','5'},
				  {'.','.','.','.','8','.','.','7','9'}
				};
		ValidSudoku vs = new ValidSudoku();
		System.out.println(vs.isValidSudoku(datas));
	}
}
