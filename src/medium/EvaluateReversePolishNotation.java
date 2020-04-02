package medium;

import java.util.LinkedList;

public class EvaluateReversePolishNotation {
	// 使用队列模拟栈来进行入栈出栈操作
	LinkedList<Integer> rem = new LinkedList<Integer>();
	public int evalRPN(String[] tokens) {
		if(tokens.length==0)
			return 0;
		for (String str : tokens) {
			if("+".equals(str)) {
				int a = rem.removeFirst();
				int b = rem.removeFirst();
				rem.addFirst(a+b);
			}else if("-".equals(str)) {
				int a = rem.removeFirst();
				int b = rem.removeFirst();
				rem.addFirst(b-a);
			}else if("*".equals(str)) {
				int a = rem.removeFirst();
				int b = rem.removeFirst();
				rem.addFirst(a*b);
			}else if("/".equals(str)) {
				int a = rem.removeFirst();
				int b = rem.removeFirst();
				rem.addFirst(b/a);
			}else {
				rem.addFirst(Integer.parseInt(str));
			}
		}
		return rem.removeFirst();
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] data = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		System.out.println(new EvaluateReversePolishNotation().evalRPN(data));
	}

}
