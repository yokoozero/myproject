import com.alibaba.fastjson.JSONObject;

/**
 * Created by wb.zhengcheng on 2017/8/14.
 */
public class JsonTest {
    public static void main(String[] args) {
        String json = "{data:{}}";
        JSONObject obj = JSONObject.parseObject(json);
        JSONObject data = obj.getJSONObject("data");

        System.out.println(data.getString("a"));
    }
}
