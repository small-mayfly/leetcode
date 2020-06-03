package niuke.S2019;

import java.util.*;

/**
 * 遇到循环后，则被除数已经在之前遇到过
 */
public class TqId32859{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        // 记录所有出现过的小于除数的被除数
        ArrayList<Integer> rems = new ArrayList<>();
        // 处理可以整除的情况
        if(a%b==0){
            System.out.println(a/b);
        }else{
            // 计算出整数部分
            int t = a/b;
            StringBuilder sb = new StringBuilder();
            sb.append(t+".");
            // 取得小数部分开始位置
            t = sb.length();
            a %= b;
            rems.add(a);
            a *= 10;
            while(true){
                if(a==0){
                    break;
                }else if(a<b){
                    if(rems.contains(a)){   // 遇到循环
                        // 判断是从小数位置开始的，所以要加上小数开始的偏移量
                        sb.insert(rems.indexOf(a)+t, '(');
                        sb.append(')');
                        break;
                    }
                    rems.add(a);
                    a *= 10;
                    sb.append("0");
                }else{
                    if(rems.contains(a)){   // 遇到循环
                        sb.insert(rems.indexOf(a)+t, '(');
                        sb.append(')');
                        break;
                    }else{
                        sb.append(a/b+"");
                        a %= b;
                        if(rems.contains(a)){   // 遇到循环
                            sb.insert(rems.indexOf(a)+t, '(');
                            sb.append(')');
                            break;
                        }
                        rems.add(a);
                        a *= 10;
                        // 防止出现*10后正好遇到循环而导致最后少一个0的情况
                        if(rems.contains(a)){   // 遇到循环
                            sb.append("0");
                            sb.insert(rems.indexOf(a)+t, '(');
                            sb.append(')');
                            break;
                        }
                    }
                }
            }
            System.out.println(sb.toString());
        }

    }
}