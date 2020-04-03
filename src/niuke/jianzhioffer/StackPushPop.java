package niuke.jianzhioffer;

import java.util.LinkedList;

/**
 * 使用linkedlist模拟队列的入队和出队
 */
public class StackPushPop {


    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int start = 0;
        LinkedList<Integer> rem = new LinkedList<>();
        for(int i=0;i<pushA.length;i++){   // 依次遍历
            if(pushA[i]==popA[start]){   // 如果相等则省去一个如队步骤
                start++;
                while (!rem.isEmpty() && start<popA.length && rem.getFirst()==popA[start]){   // 并依次判断之前的入队数据是否可以出队，如果可以则执行
                    rem.removeFirst();
                    start++;
                }
            }else{
//                rem.addLast(pushA[i]);
                rem.addFirst(pushA[i]);
            }
        }
        // 判断是否还有队列没有出来，如果有以此判断
        if(!rem.isEmpty()){
            while (rem.getFirst()==popA[start]){
                start++;
                rem.removeFirst();
            }
        }
        // 如果所有数据都符合排序，则判断为真
        if(start==popA.length)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] pusha = {1,2,3,4,5};
        int[] popa = {4,5,3,2,1};
        System.out.println(new StackPushPop().IsPopOrder(pusha, popa));
    }

}
