package niuke.jianzhioffer;

import java.util.Stack;

public class Stack2Queue {
	// 默认提供两个栈，由于栈是先进后出的，所以从第一个栈出来后将输入插入第二个栈，再从第二个栈出来的数据是正序的
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    // 只将数据插入第一个栈
    public void push(int node) {
        stack1.push(node);
    }
    // 如果第二个栈为空，则将第一个栈的数据全部导入第二个栈中，否则直接从第二个栈中弹出数据
    public int pop() {
    	if(stack2.size()==0) {
    		// 将第一个栈的所有数据导入第二个栈
    		int tnode;
    		while(stack1.size()>0) {
    			tnode = stack1.pop();
    			stack2.push(tnode);
    		}
    	}
    	return stack2.pop();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] datas = {1,2,3,4,5,6,7,8,9};
	}
}
