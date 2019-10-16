package daily;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
	
	public void nextStep(int[] steps, int now_value, int now_x, int now_step, int all_num, List<String> results) {
		if(now_x>all_num)
			return;
		if(now_value<0)
			return;
		if(now_step==all_num*2) {
			if(now_value==0) {
				StringBuilder tresult = new StringBuilder();
				for(int i=0;i<2*all_num;i++) {
					tresult.append(steps[i]==1?"(":")");
				}
				results.add(tresult.toString());
				System.out.println(tresult.toString());
			}
			return;
		}
		// x²½
		steps[now_step] = 1;
		nextStep(steps, now_value+1, now_x+1, now_step+1, all_num, results);
		// y²½
		steps[now_step] = -1;
		nextStep(steps, now_value-1, now_x, now_step+1, all_num, results);

	}
	
	public List<String> generateParenthesis(int n) {
		List<String> results = new LinkedList<String>();
		int[] steps = new int[2*n];
		for(int i=0; i<2*n; i++)
			steps[i]=0;
		nextStep(steps, 0, 0, 0, n, results);
		System.out.println(results);
        return results;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParentheses gp = new GenerateParentheses();
		gp.generateParenthesis(3);

	}

}
