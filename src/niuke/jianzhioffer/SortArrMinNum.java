package niuke.jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortArrMinNum {
    public String PrintMinNumber(int [] numbers) {

        ArrayList<Integer> datas = new ArrayList<>();
        for (int number : numbers) {
            datas.add(number);
        }
        Collections.sort(datas, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1+""+o2;
                String s2 = o2+""+o1;

                return s1.compareTo(s2);
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer data : datas) {
            stringBuilder.append(data);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int[] datas={3,32,321};
        System.out.println(new SortArrMinNum().PrintMinNumber(datas));
    }
}
