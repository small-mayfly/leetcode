package niuke.jianzhioffer;

import java.util.Stack;

public class Stack2Queue {
	// Ĭ���ṩ����ջ������ջ���Ƚ�����ģ����Դӵ�һ��ջ�������������ڶ���ջ���ٴӵڶ���ջ�����������������
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    // ֻ�����ݲ����һ��ջ
    public void push(int node) {
        stack1.push(node);
    }
    // ����ڶ���ջΪ�գ��򽫵�һ��ջ������ȫ������ڶ���ջ�У�����ֱ�Ӵӵڶ���ջ�е�������
    public int pop() {
    	if(stack2.size()==0) {
    		// ����һ��ջ���������ݵ���ڶ���ջ
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
