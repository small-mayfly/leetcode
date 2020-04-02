package medium;

public class ValidSudoku {
	/**
	 * 判断当前数独盘是否合法
	 * @param board 数独盘组成的二维数组
	 * @return 返回是否合法
	 */
	public boolean isValidSudoku(char[][] board) {
		int size = board.length;   // 棋盘是正方形的，获取棋盘的宽度
		int[] rem = new int[9];   // 创建1-9的数组，用来判断是否出现重复值
		int data;   // 临时记录变量
		for(int i=0;i<9;i++)   // 初始化记录数组
			rem[i]=0;
		if(size<4) {   // 如果数独盘的长度小于4，则只可能存在一个3*3的九宫格，只需要判断是否其中出现重复数字即可知道是否合法，不需要单独判断行和列
			for(int i=0;i<size;i++) {
				for(int j=0;j<size;j++) {
					if(board[i][j]!='.') {
						data = board[i][j]-'1';   // 获取当前非空数值-1的数，出现一次在rem数组中+1
						rem[data]++;
						if(rem[data]>1)   // >1说明出现不止一次，非法
							return false;
					}
				}
			}
			return true;   // 排除非法情况，剩下的肯定是合法的情况
		}else {
			// 判断所有行
			for(int i=0;i<size;i++) {
				for(int j=0;j<9;j++)   // 初始化记录数组
					rem[j]=0;
				for(int j=0;j<size;j++) {   // 判断当前行是否有重复的数值出现
					if(board[i][j]!='.') {
						data = board[i][j]-'1';
						rem[data]++;
						if(rem[data]>1)
							return false;
					}
				}
			}
			//判断所有列，是否有重复数值出现
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
			// 判断所有3*3大小方格
			// 先上->下，然后左->右，依次遍历
			for(int i=0;i<size-2;i+=3) {   // left -> right
				// 如果长度越界，直接退出
				if(i+2>=size)
					break;
				for(int j=0;j<size-2;j+=3) {   // up -> down
					// 如果长度越界，直接退出
					if(j+2>=size)
						break;
					for(int k=0;k<9;k++)
						rem[k]=0;
					// 判断当前九宫格是否有重复数值出现
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
