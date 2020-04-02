package niuke.jianzhioffer;
/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author mayfly
 *
 */
public class ErWeiShuZuChaZhao {
	/**
	 * 因为每一行，每一列分别有顺序，所以可以先从第一行开始找到最接近target的小于target的值来开始遍历
	 * @param target
	 * @param array
	 * @return
	 */
	public boolean Find(int target, int [][] array) {
		// 如果数组为空，则直接返回false
		int yLen = array.length;
		if(yLen==0)
			return false;
		int xLen = array[0].length;
		if(xLen==0)
			return false;
		// 找到第一行中小于target的最大值的列位置
		int index = -1;
		for(int i=0;i<xLen-1;i++) {
			if(array[0][i]==target)   // 如果找到target直接返回即可
				return true;
			if(array[0][i]<target && array[0][i+1]>=target) {
				if(array[0][i+1]==target)   // 如果找到target直接返回即可
					return true;
				else {
					index = i;
					break;
				}
			}
		}
		// 如果没有找到对应的位置，则认为第一行最大的数也小于target
		if(index==-1) {   // target比第一行最右边的数大，所以从这个位置开始查找
			index = xLen-1;
		}
		
		int flag;   // 用于标记是否是刚开始，以及移动方向
		for(int i=1;i<yLen;i++) {
			flag = 0;    // 默认为0
			while(true) {
				if(array[i][index]>target) { // 如果找到大于target的值
					if(index==0) {   // target比最小值大，则一定找不到
						return false;
					}
					// 如果是向左移动，则idnex--
					if(flag==0 || flag==-1) {
						index--;
						flag = -1;   // 加标记，防止再向右走
					}else {
						break;   // 不能向反方向移动，尝试下一行
					}
				}else if(array[i][index]<target) {
					if(index==xLen-1) {   // target比最大值小，则一定找不到
						break;
					}
					if(flag==0 || flag==1) {
						index++;
						flag = 1;
					}else {
						break;
					}
				}else {
					return true;   // 如果找到结果则直接返回
				}
			}
		}
		return false;   // 找不到结果，返回fals
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ErWeiShuZuChaZhao ewszcz = new ErWeiShuZuChaZhao();
		int[][] datas = {{1,2,3},{4,5,6},{7,8,9}};
		ewszcz.Find(6, datas);
	}

}
