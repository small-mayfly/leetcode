package niuke.jianzhioffer;

import java.util.*;

/**
 * https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163
 * 首先生成简单排列，然后用hashset去重
 */
public class StringSort {

    public ArrayList<String> Permutation(String str) {
        if(str==null || str.length()<1)
            return new ArrayList<>();

        LinkedList<String> tresults = new LinkedList<>();
        tresults.addLast(str.substring(0, 1));
        int tresultsLen = 0;
        for(int i=1;i<str.length();i++){
            tresultsLen = tresults.size();
            char nowValue = str.charAt(i);
            for(int j=0;j<tresultsLen;j++){
                String temp = tresults.removeFirst();
                tresults.addLast(nowValue + temp);
                for(int k=0;k<temp.length();k++){
                    if(temp.charAt(k)!=nowValue){
                        tresults.addLast(temp.substring(0, k+1) + nowValue + temp.substring(k+1));
                    }
                }
            }
        }
        HashSet<String> results = new HashSet<>(tresults);
        ArrayList<String> rresults = new ArrayList<>(results);
        rresults.sort(String::compareTo);
        return rresults;
    }

    /**
     * 首先得出无重char，然后再将重复char插入
     * @param str
     * @return
     */
    public ArrayList<String> Permutation2(String str) {
        ArrayList<String> results = new ArrayList<>();
        if(str==null || str.length()==1)
            return results;
        // 首先利用hashmap得到无重字符
        HashMap<Character, Integer> rem = new HashMap<>();
        for(int i=0;i<str.length();i++){
            rem.put(str.charAt(i), rem.getOrDefault(str.charAt(i), 0)+1);
        }
        Character[] chars = (Character[]) rem.keySet().toArray();

        // 找出每个重复字符的重复个数
        for (Character character : chars) {
            if(rem.get(character)==1)
                rem.remove(character);
            else{
                rem.put(character, rem.get(character)-1);
            }
        }



        // 根据无重字符计算出无重字符的全排列



        return results;
    }


    public static void main(String[] args) {
        StringSort stringSort = new StringSort();
        String data = "abc";
        ArrayList<String> results = stringSort.Permutation(data);
        System.out.println(results.size());
        for (String result : results) {
            System.out.println(result);
        }
    }
}
