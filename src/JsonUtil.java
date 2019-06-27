import com.alibaba.fastjson.JSON;

import java.util.Map;

public class JsonUtil {

    public static Map<String, Object> getMapFromJsonFile(String filePath){
        return (Map) JSON.parse(FileUtil.getTextFromFile(filePath));
    }

    public static void saveMapToJsonFile(Map<String, Object> map, String path){
        FileUtil.saveTextToFile(path, JSON.toJSONString(map));
    }

    public static void saveObjToJsonFile(Object obj, String path){
        FileUtil.saveTextToFile(path, JSON.toJSONString(obj));
    }

    public static <T>T getObjectFromJsonFile(String filePath, Class<T> clazz) {
        return JSON.parseObject(FileUtil.getTextFromFile(filePath), clazz);
    }
}
