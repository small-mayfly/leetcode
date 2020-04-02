package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
/**
 * 卡了好久，虽然是一道水题，难受
 * 使用Arrays.sort时，如果自定义比较强，一定要返回==0的情况，否则会报错
 * 尽量将输入的结果直接运算输出结果，少存中间变量，减少时间和空间复杂度
 * @author mayfly
 *
 */
public class PAT1012 {
	// 使用student类记录数据
	class Student{
		String name;
		double[] grades;
		String bestName;
		int bestRank;
		public Student(String[] datas, int gradeNum) {
			this.name = datas[0];
			this.bestRank = gradeNum+1;
			double tsum = 0.0;
			this.grades = new double[datas.length];
			for(int i=1;i<datas.length;i++) {
				this.grades[i] = Double.valueOf(datas[i]);
				tsum += this.grades[i]/3.0;
			}
			this.grades[0] = tsum;
		}
	}
	
	public void magic() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n, m;
		String[] temp2;
		temp2 = in.readLine().split(" ");
		n = Integer.valueOf(temp2[0]);
		m = Integer.valueOf(temp2[1]);
		// 如果没有成绩输入，直接返回
		if(n==0) {
			for(int i=0;i<m;i++)
				System.out.println("N/A");
			return;
		}
		// 使用学生数组来记录所有的有成绩的学生
		Student[] students = new Student[n];
//		String[] names = new String[m];
		for(int i=0;i<n;i++) {
			String[] temp = in.readLine().split(" ");
			students[i] = new Student(temp, n);
		}
		// 获取所有的有成绩和无成绩的学生姓名
//		for(int i=0;i<m;i++)
//			names[i] = in.readLine();
		
		int index = 1;
		double nowValue = 0;
	
		// 获取数据完毕，开始计算
		int[] sortIndexes = {0,1,2,3};
		String[] sortNames = {"A", "C", "M", "E"};
		for(int si=0;si<4;si++) {
			int sortIndex = sortIndexes[si];
			String sortName = sortNames[si];
			Arrays.sort(students, new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					if(o1.grades[sortIndex]==o2.grades[sortIndex])
						return 0;
					else 
						return o1.grades[sortIndex]<o2.grades[sortIndex]?1:-1;
				}
			});
			

			index = 1;
			nowValue = -1;
			for(int i=0;i<n;i++) {
				if(students[i].grades[sortIndex]==nowValue) {
					if(students[i].bestRank>index) {
						students[i].bestRank = index;
						students[i].bestName = sortName;
					}
				}else {
					nowValue = students[i].grades[sortIndex];
					if(students[i].bestRank>i+1) {
						students[i].bestRank = i+1;
						students[i].bestName = sortName;
					}
					index = i+1;
				}
			}
		}
		
		HashMap<String, Student> rems = new HashMap<String, Student>();
		for(int i=0;i<n;i++) {
			rems.put(students[i].name, students[i]);
		}
		
		for(int i=0;i<m;i++) {
			String printName = in.readLine();
			if(rems.containsKey(printName)) {
				System.out.println(rems.get(printName).bestRank+" "+rems.get(printName).bestName);
			}else {
				System.out.println("N/A");
			}
		}
		in.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new PAT1012().magic();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
