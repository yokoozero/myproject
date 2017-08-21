import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wb.zhengcheng on 2017/8/10.
 */
public class Regexp {
    public static void main(String[] args) {

//        String r = ";1;";
//        String s = ";"+null+";";
//
//        Pattern pattern = Pattern.compile(r);
//        Matcher matcher = pattern.matcher(s);
//        boolean rs = matcher.find();
//        System.out.println(rs);

        System.out.println(isArrayStr("111,33331,333,d222"));
    }

    private static boolean isArrayStr(String content) {
        if (content == null || content.length() == 0) return false;
        String regexp = "([0-9]+[,]?)+";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(content);
        return matcher.matches();
    }
}
