package niuke.jianzhioffer;

public class Tqid11197 {
    public String ReverseSentence(String str) {
        if("".equals(str.trim()))
            return str;
        String[] s = str.split(" ");
        if(s.length==1)
            return str;
        StringBuilder result = new StringBuilder(s[s.length-1]);

        for (int i = s.length-2; i>=0; i--) {
            result.append(" ");
            result.append(s[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Tqid11197 tqid11197 = new Tqid11197();
        String data = "i am a student.";
        System.out.println(tqid11197.ReverseSentence(data));
    }
}
