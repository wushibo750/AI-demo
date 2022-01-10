# AI-demo
Springboot+Vue 调用百度云接口，实现OCR文字识别
# AI-demo 百度云SDK（Java实现+Vue）

#### 不管是工具类utils还是controller，本质上都是函数的调用！！

```java
@RestController
public class HelloController {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String Hello(){
        return "hello world";
    }
}
```



#### 百度API地址：

#### https://console.bce.baidu.com/ai/?_=1597892791979#/ai/ocr/overview/index

![image-20220110231528977](C:\Users\31593\AppData\Roaming\Typora\typora-user-images\image-20220110231528977.png)



### 实例图片（复制后可以用来测试效果）：

![test](C:\Users\31593\Desktop\test.png)

代码：

```java
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
```

