package medium;
/**
 * 1. 目标：求出一组数字串功能解码出多少种字母串
 * 2. 递推公式：result(n) = judge(n-1) * result(n-1) + judge(n-2) * result(n-2)，其中judge为判断当前字母能否拼接上去，如果不能则结果为0，能则结果为1
 * 3. 迭代向后进行到字符串长度N，求出最后解
 * @author cloud
 *
 */
public class DecodeWays {
	public int numDecodings(String s) {
		if("".equals(s))   // 如果是空字符串，则不存在数字
			return 0;
		if(s.length()==1) {   // 长度为1时，如果是0则返回0不存在这样的子母，如果不是0，则一定是子母，返回1
			if("0".equals(s))
				return 0;
			else
				return 1;
		}
		// 创建记录本，来记录中间结果
		int[] rem = new int[s.length()+1];
		if('0'==s.charAt(0))   // 如果字符串开头为0，则一定是非法的
			return 0;
		else {   // 不是非法的字符串则开始计算
			rem[0] = 1;   // 记事本的第一个位置不记录值，只用来初始化，设置为1是为了在字符串长度为2时得到正常结果
			rem[1] = 1;   // 记录本的第二个位置记录第一个子母
		}
		int result1;
		int result2;
		int temp;
		for(int i=2;i<rem.length;i++) {
			// 首先判断第i个数字能否自己组成一个字母，如果不是0就能，如果是0则不能
			result1 = '0'==s.charAt(i-1)?0:rem[i-1];   // 能单独组成字母，则它可以和前面的i-1个字母组成一个串
			if('0'==s.charAt(i-2)) {   // 如果前一个数字是0，则当前第i个数不可能和前面的一个数组成一个字母
				result2 = 0;
			}else {
				// 如果签名数字非0，说明存在组合成字母的可能
				temp = Integer.parseInt(s.substring(i-2, i));
				// 能组成字母，则第二个结果赋值
				if(temp>0 && temp<27) {
					result2 = rem[i-2];
				}else {   // 不能组成字母
					result2 = 0;
				}
			}
			// 从开头到当前数字组成的字符串，共有这么多种组合成字母的情况
			rem[i] = result1 + result2;
		}
		return rem[rem.length-1];
    }
	public static void main(String[] args) {
		String data = "226";
		System.out.println(new DecodeWays().numDecodings(data));
	}
}
