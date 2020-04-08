package zhousai.doublecom.c23;

public class C233 {
    /**
     * 要判断是否有重叠可以充分利用矩形平行于坐标轴的条件
     * 首先可以将圆和矩形平移一下，将圆的圆心平移到坐标原点，这样便于思考
     * 首先如果矩形只出现在坐标系的一个象限中，则距离原点最近的点一定是矩形的顶点，所以只需要判断绝顶点距离原点的距离是否不大于圆的半径即可
     * 如果矩形出现在两个象限中，则一定会跨x轴或y轴，当跨x轴，则离原点最近的点距离一定在x轴上，且距离为矩形顶点的x值；当跨y轴同理
     * 如果矩形有一条边出现在x轴或y轴上，则距离原点最近的距离一定在顶点，且距离为x/y的最小值
     * 如果矩形出现在四个象限中，则矩形一定包含坐标原点，返回true即可
     * @param radius
     * @param x_center
     * @param y_center
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        if(radius==0)
            return false;
        x1 = x1 - x_center;
        x2 = x2 - x_center;
        y1 = y1 - y_center;
        y2 = y2 - y_center;

        if(x1*x2>0 && y1 * y2>0){   // 在同一个象限的，离原点最近的一定是顶点
            x1 = Math.abs(x1);
            x2 = Math.abs(x2);
            y1 = Math.abs(y1);
            y2 = Math.abs(y2);
            int x = x1<x2?x1:x2;
            int y = y1<y2?y1:y2;
            int rem = x*x + y*y;
            if(rem>radius*radius){
                return false;
            }else{
                return true;
            }
        }else if((x1*x2>0 && y1*y2!=0) || (y1*y2>0 && x1*x2!=0)){   // 经过两个象限的
            if(x1*x2>0 && y1*y2!=0){
                x1 = Math.abs(x1);
                x2 = Math.abs(x2);
                int t = x1<x2?x1:x2;
                return t<=radius;
            }else{
                y1 = Math.abs(y1);
                y2 = Math.abs(y2);
                int t = y1<y2?y1:y2;
                return t<=radius;
            }
        }else if(x1*x2==0 || y1*y2==0){   // 有一条边在坐标轴上的
            if(x1*x2==0 && y1*y2>0){
                y1 = Math.abs(y1);
                y2 = Math.abs(y2);
                int t = y1<y2?y1:y2;
                return t<=radius;
            }else if(y1*y2==0 && x1*x2>0){
                x1 = Math.abs(x1);
                x2 = Math.abs(x2);
                int t = x1<x2?x1:x2;
                return t<=radius;
            }else{
                return true;
            }
        }else{   // 经过圆心的
            return true;
        }



    }

    public static void main(String[] args) {
        C233 c233 = new C233();
        int radius = 1, x_center = 0, y_center =0, x1 = 1, y1 = -1, x2 = 3, y2 = 1;
        System.out.println(c233.checkOverlap(radius, x_center, y_center, x1, y1, x2, y2));
    }
}
