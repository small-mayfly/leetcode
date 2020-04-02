package zhousai.weeklycom.c180;

import java.util.ArrayList;

public class TopicTwo {

    public int nowSize;
    public int maxSize;
    public ArrayList<Integer> datas;

    public TopicTwo(int maxSize) {
        this.maxSize = maxSize;
        this.nowSize = 0;
        this.datas = new ArrayList<>(maxSize);
        for(int i=0;i<maxSize;i++)
            datas.add(i);
    }

    public void push(int x) {
        if(nowSize<maxSize){
//            datas.add(nowSize, x);
            datas.set(nowSize, x);
            nowSize++;
        }
    }

    public int pop() {
        if(nowSize==0)
            return -1;
        nowSize--;
        return datas.get(nowSize);
    }

    public void increment(int k, int val) {
        if(nowSize<=k){
            for(int i=0;i<nowSize;i++){
                datas.set(i, datas.get(i)+val);
            }
        }else{
            for(int i=0;i<k;i++){
                datas.set(i, datas.get(i)+val);
            }
        }
    }

    public static void main(String[] args) {
        TopicTwo topicTwo = new TopicTwo(3); // 栈是空的 []
        topicTwo.push(1);                          // 栈变为 [1]
        topicTwo.push(2);                          // 栈变为 [1, 2]
        topicTwo.pop();                            // 返回 2 --> 返回栈顶值 2，栈变为 [1]
        topicTwo.push(2);                          // 栈变为 [1, 2]
        topicTwo.push(3);                          // 栈变为 [1, 2, 3]
        topicTwo.push(4);                          // 栈仍然是 [1, 2, 3]，不能添加其他元素使栈大小变为 4
        topicTwo.increment(5, 100);                // 栈变为 [101, 102, 103]
        topicTwo.increment(2, 100);                // 栈变为 [201, 202, 103]
        topicTwo.pop();                            // 返回 103 --> 返回栈顶值 103，栈变为 [201, 202]
        topicTwo.pop();                            // 返回 202 --> 返回栈顶值 102，栈变为 [201]
        topicTwo.pop();                            // 返回 201 --> 返回栈顶值 101，栈变为 []
        topicTwo.pop();                            // 返回 -1 --> 栈为空，返回 -1
    }
}
