package io.github.fastmock;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.github.fastmock.random.RandomBasic;
import io.github.fastmock.utils.MockUtils;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * 根据数据和字符串分别处理不同的数据
 * <p>
 * author: wangkun32
 * date: 2022/01/03 17:39
 */
@Slf4j
public class TypeHandler {

    private final Mock mock;

    public TypeHandler(final Mock mock) {
        this.mock = mock;
    }

    /**
     * 输入一个json格式模板文件,输出mock之后的json对象
     *
     * @param jsonObject jsonObject
     * @return 输出mock之后的json对象
     */
    public JSONObject resolve(JSONObject jsonObject) {
        JSONObject root = new JSONObject();
        for (String key : jsonObject.keySet()) {
            Object result = resolve(root, key, jsonObject.get(key));
            root.put(MockUtils.parsedName(key), result);
        }
        return root;
    }

    /**
     * 递归处理对象的数据
     *
     * @param parent root
     * @param key    key
     * @param obj    obj
     * @return Object
     */
    private Object resolve(JSONObject parent, String key, Object obj) {
        // string
        if (obj instanceof String) {
            String value = (String) obj;
            return mock.mockValueService().string(key, value);
        }
        // 如果是基础数据类型 则原样输出
        if (obj instanceof Integer
                || obj instanceof Double
                || obj instanceof Float
                || obj instanceof BigDecimal) {
            return mock.mockValueService().number(key, obj);
        }
        if (obj instanceof Boolean) {
            return mock.mockValueService().bool(key, obj);
        }
        // object
        if (obj instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject result = new JSONObject();
            for (String keySet : jsonObject.keySet()) {
                Object target = resolve(result, keySet, jsonObject.get(keySet));
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
                // 数组很多用户习惯是不写这参数,默认应该有一条记录
                if (rules.getRange().size() == 0) {
                    rules.setCount(1);
                }
                for (int i = 1; i <= rules.getCount(); i++) {
                    if (item instanceof JSONObject) {
                        Object target = resolve(parent, key, item);
                        result.add(target);
                    } else {
                        // 处理普通类型
                        String value = (String) item;
                        Object target = mock.mockValueService().string(StringTypes.string.name(), value);
                        result.add(target);
                    }
                }
            } else {
                // 如果有多个字符串,则规则定义是随机选取数组中的随机几个
                // 以下逻辑很关键,要根据设置的参数重新计算数组的长度,不能使用原始模板的的数组长度
                // 处理随机选择,如果在数组只是普通数据类型,则在随机一次
                if (rules.getRange().size() == 0) {
                    for (Object item : jsonArray) {
                        // 处理普通类型
                        Object target = resolve(parent, key, item);
                        // String value = (String) item;
                        // Object target = mock.mockValueService().string("name", value);
                        result.add(target);
                    }
                } else {
                    for (int i = 1; i <= rules.getCount(); i++) {
                        int nextInt = RandomBasic.nextInt(0, jsonArray.size() - 1);
                        result.add(jsonArray.get(nextInt));
                    }
                }
            }
            return result;
        }
        return null;
    }
}
