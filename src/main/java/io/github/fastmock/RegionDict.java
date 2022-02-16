package io.github.fastmock;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangkun23 on 2022/1/3
 *
 * @version : v1.0.0
 **/
public class RegionDict {

    /**
     * 加载classpath下的中国的区域数据
     *
     * @return load
     */
    public List<Area> load() {
        String REGION_FILE_PATH = "regions_zh_cn.json";
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream is = classLoader.getResourceAsStream(REGION_FILE_PATH);
        try {
            String plainText = IOUtils.toString(is, StandardCharsets.UTF_8);
            return JSON.parseArray(plainText).toJavaList(Area.class);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(is);
        }
        return new ArrayList<>();
    }
}
