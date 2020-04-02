package hard;

public class SudokuSolver {
	
	/**
	 * DFS搜索所有可能，遇到满足条件结束程序
	 * @param board 棋盘
	 * @param i 当前要赋值的坐标x
	 * @param j 当前要赋值的坐标y
	 * @return 找到一个结果，则返回-1， 没结束返回0， 已经无数可填返回1
	 */
	public int judge(char[][] board, int i, int j) {
		int blankNum = 0;
		int data = board[i][j] - '0';
		int[] rem = new int[9];
		for(int k=0;k<9;k++)
			rem[k]=0;
		// 判断行
		for(int k=0;k<9;k++) {
			if(board[i][k]!='.') {
				data = board[i][k]-'0';
				rem[data-1]++;
			}
		}
		// 判断列
		for(int k=0;k<9;k++) {
			if(board[k][j]!='.') {
				data = board[k][j]-'0';
				rem[data-1]++;
			}
			
		}
		// 判断九宫格
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
		// 判断有几个值可以尝试
		for(int k=0;k<9;k++) {
			if(rem[k]==0)
				blankNum++;
		}
		// 如果无值可试直接返回
		if(blankNum==0) {
			return 1;
		}
		
		// 记录当前位置
		int x = i;
		int y = j;
		for(int k=0;k<9;k++) {
			blankNum = 0;   // 判断是否还有空值空值进行DFS的下一个迭代
			for(i=0;i<9;i++) {
				for(j=0;j<9;j++) {
					if(board[i][j]=='.') {
						blankNum++;
					}
				}
			}
			if(rem[k]==0) {   // 找到一个可用值
				board[x][y] = (char)(k+'1');   // 付给当前位置
				
				if(blankNum-1==0)   // 如果所有位置都有值，则可以结束遍历，已经找到结果
					return -1;
				else {   // 否则，开始下一步查找
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
