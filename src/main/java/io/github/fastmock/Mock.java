package io.github.fastmock;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.github.fastmock.random.RandomBasic;
import io.github.fastmock.utils.MockUtils;
import io.github.fastmock.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * author: wangkun32
 * date: 2021/12/27 16:29
 */
@Slf4j
public class Mock {

    private JSONObject mocked;
    private final TypeHandler typeHandler;

    public Mock() {
        this.mocked = new JSONObject();
        this.typeHandler = new TypeHandler();
    }

    public JSONObject mock(String template) {
        if (StringUtils.isEmpty(template)) {
            return null;
        }
        JSONObject jsonObject = JSON.parseObject(template, JSONObject.class);
        // 最外层格式解析出来
        mocked = parse(jsonObject);
        return mocked;
    }

    private JSONObject parse(JSONObject jsonObject) {
        JSONObject root = new JSONObject();
        for (String key : jsonObject.keySet()) {
            Object result = parse(root, key, jsonObject.get(key));
            root.put(MockUtils.parsedName(key), result);
        }
        return root;
    }

    /**
     * 递归处理对象的数据
     *
     * @param parent
     * @param key
     * @param obj
     * @return
     */
    private Object parse(JSONObject parent, String key, Object obj) {
        // string
        if (obj instanceof String) {
            String value = (String) obj;
            return this.typeHandler.string(key, value);
        }
        // 如果是基础数据类型 则原样输出
        if (obj instanceof Integer
                || obj instanceof Double
                || obj instanceof Float
                || obj instanceof Boolean) {
            return obj;
        }
        // object
        if (obj instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject result = new JSONObject();
            for (String keySet : jsonObject.keySet()) {
                Object target = parse(result, keySet, jsonObject.get(keySet));
                result.put(MockUtils.parsedName(keySet), target);
            }
            return result;
        }
        // array
        if (obj instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) obj;
            JSONArray result = new JSONArray();
            ParseResult rules = Parser.parseKey(key);
            // 只有一个对象 需要mock的object对象数据
            if (jsonArray.size() == 1) {
                Object item = jsonArray.get(0);
                for (int i = 1; i <= rules.getRangeCount(); i++) {
                    if (item instanceof JSONObject) {
                        Object target = parse(parent, key, item);
                        result.add(target);
                    } else {
                        // 处理普通类型
                        String value = (String) item;
                        Object target = this.typeHandler.string("name", value);
                        result.add(target);
                    }
                }
            } else {
                // 如果有多个字符串,则规则定义是随机选取数组中的随机几个
                // 以下逻辑很关键,要根据设置的参数重新计算数组的长度,不能使用原始模板的的数组长度
                // 处理随机选择,如果在数组只是普通数据类型,则在随机一次
                for (int i = 1; i <= rules.getRangeCount(); i++) {
                    int nextInt = RandomBasic.nextInt(0, jsonArray.size() - 1);
                    result.add(jsonArray.get(nextInt));
                }
            }
            return result;
        }
        return null;
    }
}
