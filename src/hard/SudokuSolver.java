package hard;

public class SudokuSolver {
	
	/**
	 * DFS�������п��ܣ���������������������
	 * @param board ����
	 * @param i ��ǰҪ��ֵ������x
	 * @param j ��ǰҪ��ֵ������y
	 * @return �ҵ�һ��������򷵻�-1�� û��������0�� �Ѿ����������1
	 */
	public int judge(char[][] board, int i, int j) {
		int blankNum = 0;
		int data = board[i][j] - '0';
		int[] rem = new int[9];
		for(int k=0;k<9;k++)
			rem[k]=0;
		// �ж���
		for(int k=0;k<9;k++) {
			if(board[i][k]!='.') {
				data = board[i][k]-'0';
				rem[data-1]++;
			}
		}
		// �ж���
		for(int k=0;k<9;k++) {
			if(board[k][j]!='.') {
				data = board[k][j]-'0';
				rem[data-1]++;
			}
			
		}
		// �жϾŹ���
		int startX = (i/3)*3;
		int startY = (j/3)*3;
		for(int x=startX;x<startX+3;x++) {
			for(int y=startY;y<startY+3;y++) {
				if(board[x][y]!='.') {
					data = board[x][y] - '0';
					rem[data-1]++;
				}
				
			}
		}
		// �ж��м���ֵ���Գ���
		for(int k=0;k<9;k++) {
			if(rem[k]==0)
				blankNum++;
		}
		// �����ֵ����ֱ�ӷ���
		if(blankNum==0) {
			return 1;
		}
		
		// ��¼��ǰλ��
		int x = i;
		int y = j;
		for(int k=0;k<9;k++) {
			blankNum = 0;   // �ж��Ƿ��п�ֵ��ֵ����DFS����һ������
			for(i=0;i<9;i++) {
				for(j=0;j<9;j++) {
					if(board[i][j]=='.') {
						blankNum++;
					}
				}
			}
			if(rem[k]==0) {   // �ҵ�һ������ֵ
				board[x][y] = (char)(k+'1');   // ������ǰλ��
				
				if(blankNum-1==0)   // �������λ�ö���ֵ������Խ����������Ѿ��ҵ����
					return -1;
				else {   // ���򣬿�ʼ��һ������
					for(i=0;i<9;i++) {
						for(j=0;j<9;j++) {
							if(board[i][j]=='.' && judge(board, i, j)==-1) {
								return -1;
							}
						}
					}
				}
				board[x][y] = '.';
			}
		}
		return 0;
	}
	
    public void solveSudoku(char[][] board) {
    	int data = 0;
        for(int i=0;i<9;i++) {
        	for(int j=0;j<9;j++) {
        		if(board[i][j]!='.')
        			continue;
        		if(judge(board, i, j)==-1) {
        			data = -1;
        			break;
        		}
        		if(data==-1)
        			break;
        	}
        	if(data==-1)
    			break;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SudokuSolver ss = new SudokuSolver();
		char[][] datas = {
				  {'5','3','.','.','7','.','.','.','.'},
				  {'6','.','.','1','9','5','.','.','.'},
				  {'.','9','8','.','.','.','.','6','.'},
				  {'8','.','.','.','6','.','.','.','3'},
				  {'4','.','.','8','.','3','.','.','1'},
				  {'7','.','.','.','2','.','.','.','6'},
				  {'.','6','.','.','.','.','2','8','.'},
				  {'.','.','.','4','1','9','.','.','5'},
				  {'.','.','.','.','8','.','.','7','9'}
				};
		ss.solveSudoku(datas);
		for(int i=0;i<datas.length;i++) {
			for(int j=0;j<datas.length;j++) {
				System.out.print(datas[i][j]);
				System.out.print(",");
			}
			System.out.println();
		}
		
		
	}

}
