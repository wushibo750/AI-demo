package com.wushibo.aidemo.utils;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.HashMap;
import com.baidu.aip.ocr.AipOcr;
import org.springframework.web.multipart.MultipartFile;
public class AiUtils {
    //设置APPID/AK/SK
    public static final String APP_ID = "25485784";
    public static final String API_KEY = "vUFNi1nXbyxGiLSH9hXpIUsh";
    public static final String SECRET_KEY = "ZD7B3MToXX6izCm08xEQ2BMASSbqG2OD";
    public static String picToWords(MultipartFile file) throws IOException {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        String path = "/Users/31593/Desktop/test.png";  //绝对路径
        JSONObject res = client.basicGeneral(file.getBytes(), new HashMap<String, String>());
        JSONArray words_result = res.getJSONArray("words_result");
        String result="";
        for(int i=0;i<words_result.length();i++){
            JSONObject jsonObject = words_result.getJSONObject(i);
            Object words = jsonObject.get("words");
            String s=(String)words;
            result+=s+"";
        }
        System.out.println(result);
        return result;
    }

}
