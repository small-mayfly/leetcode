package niuke.jianzhioffer;

public class ZiFuChuanTiHuan {
	// 两个思路
	public String replaceSpace(StringBuffer str) {
		// 一个是新建一个字符串，依次添加进去，遇到空格则输入%20
//		StringBuffer sb = new StringBuffer();
//    	for(int i=0;i<str.length();i++) {
//    		if(str.charAt(i)==' ') {
//    			sb.append("%20");
//    		}else {
//    			sb.append(str.charAt(i));
//    		}
//    	}
		// 一个是直接替换
    	for(int i=0;i<str.length();i++) {
    		if(str.charAt(i)==' ') {
    			str.replace(i, i+1, "%20");
    		}
    	}
		return str.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZiFuChuanTiHuan zfcth = new ZiFuChuanTiHuan();
		StringBuffer sb = new StringBuffer();
		sb.append("abc bca");
		System.out.println(zfcth.replaceSpace(sb));
	}

}
