package niuke.jianzhioffer;

public class ZiFuChuanTiHuan {
	// ����˼·
	public String replaceSpace(StringBuffer str) {
		// һ�����½�һ���ַ�����������ӽ�ȥ�������ո�������%20
//		StringBuffer sb = new StringBuffer();
//    	for(int i=0;i<str.length();i++) {
//    		if(str.charAt(i)==' ') {
//    			sb.append("%20");
//    		}else {
//    			sb.append(str.charAt(i));
//    		}
//    	}
		// һ����ֱ���滻
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
