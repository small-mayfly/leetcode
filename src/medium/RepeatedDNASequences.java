package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class RepeatedDNASequences {
	
	public List<String> findRepeatedDnaSequences3(String s){
		if(s.length()<11)
			return new ArrayList<String>();
		int remLen = s.length()-9;
		List<String> results = new LinkedList<String>();
		HashSet<String> rems = new HashSet<String>();
		for(int i=0;i<remLen;i++) {
			if(!rems.add((String) s.subSequence(i, i+10)) && !results.contains(s.subSequence(i, i+10))) {
				results.add((String) s.subSequence(i, i+10));
			}
		}
		return results;
	}
	
	public List<String> findRepeatedDnaSequences2(String s){
		if(s.length()<11)
			return new ArrayList<String>();
		int remLen = s.length()-9;
		HashMap<String, Integer> rems = new HashMap<String, Integer>();
		for(int i=0;i<remLen;i++) {
			if(rems.containsKey(s.subSequence(i, i+10))) {
				rems.put((String)s.subSequence(i, i+10), 2);
			}else {
				rems.put((String)s.subSequence(i, i+10), 1);
			}
		}
		List<String> results = new LinkedList<String>();
		for (String result : rems.keySet()) {
			if(rems.get(result)>1) {
				results.add(result);
//				System.out.println(remIndex.get(result) + ", " + s.substring(remIndex.get(result), remIndex.get(result)+10));
			}
		}
		return results;
	}
	
	public List<String> findRepeatedDnaSequences(String s) {
		if(s.length()<11)
			return new ArrayList<String>();
		int remLen = s.length()-9;
		HashMap<Integer, Integer> rems = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> remIndex = new HashMap<Integer, Integer>();
		int rem=0;
		int temp=0;
		for(int j=0;j<10;j++) {
			if(s.charAt(remLen-1+j)=='A') {
				temp=0;
			}else if(s.charAt(remLen-1+j)=='C') {
				temp=1;
			}else if(s.charAt(remLen-1+j)=='G') {
				temp=2;
			}else if(s.charAt(remLen-1+j)=='T') {
				temp=3;
			}
			rem = rem << 2;
			rem += temp;
			
		}
//		System.out.println(remLen-1 + ", " +s.substring(remLen-1, remLen+9));
		rems.put(rem, 1);
		remIndex.put(rem, remLen-1);
		for(int i=remLen-2;i>=0;i--) {
//			System.out.println(i + ", " + s.substring(i, i+10));
			if(s.charAt(i)=='A') {
				temp=0;
			}else if(s.charAt(i)=='C') {
				temp=1;
			}else if(s.charAt(i)=='G') {
				temp=2;
			}else if(s.charAt(i)=='T') {
				temp=3;
			}
			rem = rem >> 2;
			if(temp>0) {
				rem += temp<<18;
			}
			if(rems.containsKey(rem)) {
//				if(remIndex.get(rem)-i>=10) {
//					rems.put(rem, 2);
//					remIndex.put(rem, i);
//				}
				rems.put(rem, 2);
				remIndex.put(rem, i);
				
			}else {
				rems.put(rem, 1);
				remIndex.put(rem, i);
			}
			
		}
//		System.out.println("---------------");
		List<String> results = new LinkedList<String>();
		for (Integer result : rems.keySet()) {
			if(rems.get(result)>1) {
				results.add(s.substring(remIndex.get(result), remIndex.get(result)+10));
//				System.out.println(remIndex.get(result) + ", " + s.substring(remIndex.get(result), remIndex.get(result)+10));
			}
		}
		
//		System.out.println("-------------------------");
        return results;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		
		for (String string : new RepeatedDNASequences().findRepeatedDnaSequences3(data)) {
			System.out.println(string);
		}
		
	}

}
