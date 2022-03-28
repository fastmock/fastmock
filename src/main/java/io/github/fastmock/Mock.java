package io.github.fastmock;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.github.fastmock.service.MockValueService;
import io.github.fastmock.service.RandomService;
import io.github.fastmock.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * author: wangkun32
 * date: 2021/12/27 16:29
 */
@Slf4j
public class Mock {
    private final TypeHandler typeHandler;
    private final RandomService randomService;
    private final MockValueService mockValueService;


    public Mock() {
        this.typeHandler = new TypeHandler(this);
        this.randomService = new RandomService();
        mockValueService = new MockValueService(randomService);
    }

    /**
     * 输入一个json格式模板文件,输出mock之后的json对象
     *
     * @param template json模板
     * @return 输出mock之后的json对象
     */
    public JSONObject mock(String template) {
        if (StringUtils.isEmpty(template)) {
            return null;
        }
        JSONObject jsonObject = JSON.parseObject(template, JSONObject.class);
        return typeHandler.resolve(jsonObject);
    }

    /**
     * 注册自定义的实现
     *
     * @param adapter adapter
     */
    public void register(StringTypeAdapter adapter) {
        if (adapter == null) {
            throw new IllegalArgumentException("adapter can not null...");
        }
        mockValueService.register(adapter);
    }

    public boolean nextBoolean() {
        return randomService.nextBoolean();
    }

    public String cname() {
        return mockValueService.resolve("@cname");
    }

    public String cFirstname() {
        return mockValueService.resolve("@cfirstname");
    }

    public String cLastname() {
        return mockValueService.resolve("@clastname");
    }

    public String color() {
        return mockValueService.resolve("@color");
    }

    public String county() {
        return mockValueService.resolve("@county");
    }

    public String cparagraph() {
        return mockValueService.resolve("@cparagraph");
    }

    public String cparagraph(int min, int max) {
        return mockValueService.resolve(String.format("@cparagraph(%s,%s)", min, max));
    }

    public String csentence() {
        return mockValueService.resolve("@csentence");
    }

    public String csentence(int min, int max) {
        return mockValueService.resolve(String.format("@csentence(%s,%s)", min, max));
    }

    public String ctitle() {
        return mockValueService.resolve("@ctitle");
    }

    public String ctitle(int min, int max) {
        return mockValueService.resolve(String.format("@ctitle(%s,%s)", min, max));
    }

    public String cword() {
        return mockValueService.resolve("@cword");
    }

    public String cword(int min, int max) {
        return mockValueService.resolve(String.format("@cword(%s,%s)", min, max));
    }

    public String date() {
        return mockValueService.resolve("@date");
    }

    public String datetime() {
        return mockValueService.resolve("@datetime");
    }

    public String decimal() {
        return mockValueService.resolve("@decimal");
    }

    public String decimal(int min, int max, int dmin, int dmax) {
        return mockValueService.resolve(String.format("@decimal(%s,%s,%s,%s)", min, max, dmin, dmax));
    }

    public String firstname() {
        return mockValueService.resolve("@firstname");
    }

    public String guid() {
        return mockValueService.resolve("@guid");
    }

    public String id() {
        return mockValueService.resolve("@id");
    }

    public String image() {
        return mockValueService.resolve("@image");
    }

    public String ipv4() {
        return mockValueService.resolve("@ipv4");
    }

    public String ipv6() {
        return mockValueService.resolve("@ipv6");
    }

    public String lastname() {
        return mockValueService.resolve("@lastname");
    }

    public String name() {
        return mockValueService.resolve("@name");
    }

    // TODO.. 指定时间格式化
    public String now() {
        return mockValueService.resolve("@now");
    }

    public String paragraph() {
        return mockValueService.resolve("@paragraph");
    }

    public String paragraph(int min, int max) {
        return mockValueService.resolve(String.format("@paragraph(%s,%s)", min, max));
    }

    public String pick(String... args) {
        return mockValueService.resolve(String.format("@pick(%s)", JSON.toJSONString(Arrays.asList(args))));
    }

    public String pick(int... args) {
        return mockValueService.resolve(String.format("@pick(%s)", JSON.toJSONString(Arrays.asList(args))));
    }

    public String province() {
        return mockValueService.resolve("@province");
    }

    public String rgba() {
        return mockValueService.resolve("@rgba");
    }

    public String sentence() {
        return mockValueService.resolve("@sentence");
    }

    public String string() {
        return mockValueService.resolve("@string");
    }

    public String string(int min, int max) {
        return mockValueService.resolve(String.format("@string(%s,%s)", min, max));
    }

    public String time() {
        return mockValueService.resolve("@time");
    }

    public String title() {
        return mockValueService.resolve("@title");
    }

    public String title(int min, int max) {
        return mockValueService.resolve(String.format("@title(%s,%s)", min, max));
    }

    public String uuid() {
        return mockValueService.resolve("@uuid");
    }

    public String word() {
        return mockValueService.resolve("@word");
    }

    public int nextInt() {
        return randomService.nextInt(100);
    }

    public int nextInt(int max) {
        return randomService.nextInt(max);
    }

    public int nextInt(int min, int max) {
        return randomService.nextInt(min, max);
    }

    public double nextDouble() {
        return randomService.nextDouble();
    }

    public long nextLong() {
        return randomService.nextLong();
    }

    public long nextLong(int max) {
        return randomService.nextLong(max);
    }

    public String hex() {
        return mockValueService.resolve("@hex");
    }

    /**
     * 随机生成服务
     *
     * @return RandomService
     */
    public RandomService random() {
        return this.randomService;
    }

    /**
     * 随机生成服务
     *
     * @return mockValueService
     */
    public MockValueService mockValueService() {
        return this.mockValueService;
    }
}
