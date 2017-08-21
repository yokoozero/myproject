/**
 * Created by wb.zhengcheng on 2017/8/11.
 */
public class StringFormatTest {
    public static void main(String[] args) {
        String sql = String.format("select * from %s where ';'+suitable+';' like '%%;%d;%%'", "a",2);
        System.out.println(sql);
    }
}
