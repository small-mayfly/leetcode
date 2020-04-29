package zs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class ZSOne {
    public static int magic(ArrayList<int[]> rems, ArrayList<int[]> datas, int loch, int locw){
        if(datas.size()<=loch){
            return 0;
        }
        if(locw>loch+1){
            return 0;
        }
        if(rems.get(loch)[locw]>0){
            return rems.get(loch)[locw];
        }
        int left, right;
        if(loch+1<rems.size() && rems.get(loch+1)[locw]>0){
            left = rems.get(loch+1)[locw];
        }else{
            left = magic(rems, datas, loch+1, locw);
        }
        if(loch+1<rems.size() && locw+1<rems.get(loch).length && rems.get(loch+1)[locw+1]>0){
            right = rems.get(loch+1)[locw+1];
        }else{
            right = magic(rems, datas, loch+1, locw+1);
        }
        int max = (left>right?left:right) + datas.get(loch)[locw];
        rems.get(loch)[locw] = max;

        return max;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        n = Integer.parseInt(in.readLine());
        ArrayList<int[]> datas = new ArrayList<>();
        ArrayList<int[]> rems = new ArrayList<>();
        for(int i=0;i<n;i++){
            String[] dataLine = in.readLine().split(" ");
            int[] data = new int[i+1];
            for(int j=0;j<i+1;j++){
                data[j] = Integer.parseInt(dataLine[j]);
            }
            datas.add(data);
            rems.add(new int[i+1]);
        }
        if(n==0){
            System.out.println(0);
        }else if(n==1){
            System.out.println(datas.get(0)[0]);
        }else {

            System.out.println(magic(rems, datas, 0, 0));
        }
    }
}
