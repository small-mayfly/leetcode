package niuke.jianzhioffer;

import java.util.HashMap;
import java.util.LinkedList;

public class Tqid11207 {
    class Node{
        char data;
        int num;
    }
    LinkedList<Node> datas = new LinkedList<Node>();
    HashMap<Character, Node> rem = new HashMap<Character, Node>();

    //Insert one char from stringstream
    public void Insert(char ch)
    {
//        rem[(ch-'a')]+=1;
        if(rem.containsKey(ch)){
            rem.get(ch).num++;
        }else{
            Node node = new Node();
            node.data = ch;
            node.num = 1;
            datas.addLast(node);
            rem.put(ch, node);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for (Node data : datas) {
            if(data.num==1)
                return data.data;
        }
        return '#';
    }

    public static void main(String[] args) {

    }
}
