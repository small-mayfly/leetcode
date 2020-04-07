package niuke.jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Tqid11216 {

    ArrayList<Integer> queue = new ArrayList<Integer>();

    public void Insert(Integer num) {
        if(queue.size()==0){
            queue.add(num);
        }else{
            int index = 0;
            while (index<queue.size() && num>queue.get(index)){
                index++;

            }
            if(index<queue.size())
                queue.add(index, num);
            else
                queue.add(num);
        }
    }

    public Double GetMedian() {

        if(queue.size()%2==0){
            double first = queue.get((queue.size() - 1) / 2);
            double second = queue.get(queue.size() / 2);
            return (first+second)/2;
        }else{
            return (double)queue.get(queue.size()/2);
        }
    }

    public static void main(String[] args) {
        Tqid11216 tqid11216 = new Tqid11216();
        int[] datas = {5,2,3,4,1,6,7,0,8};
        for (int data : datas) {
            tqid11216.Insert(data);
            System.out.println(tqid11216.GetMedian());
        }
    }

}
