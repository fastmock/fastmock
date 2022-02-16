package io.github.fastmock;

import io.github.fastmock.utils.StringUtils;
import io.github.fastmock.adapter.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据数据和字符串分别处理不同的数据
 * <p>
 * author: wangkun32
 * date: 2022/01/03 17:39
 */
@Slf4j
public class TypeHandler {

    private final List<StringTypeAdapter> adapters = new ArrayList<>();

    /**
     * 写完适配类之后,一定要注册到adapters中
     */
    public TypeHandler() {
        // 基本类型
        adapters.add(new BoolAdapter());
        adapters.add(new NumberAdapter());
        adapters.add(new DecimalAdapter());

        // 字符串类型
        adapters.add(new CNameAdapter());
        adapters.add(new CFirstNameAdapter());
        adapters.add(new CLastNameAdapter());
        adapters.add(new NameAdapter());
        adapters.add(new LastNameAdapter());
        adapters.add(new FirstNameAdapter());
        // date
        adapters.add(new DateAdapter());
        adapters.add(new DateTimeAdapter());
        adapters.add(new TimeAdapter());
        adapters.add(new NowAdapter());
        // misc
        adapters.add(new GuidAdapter());
        adapters.add(new UuidAdapter());
        // address
        adapters.add(new ProvinceAdapter());
        adapters.add(new CityAdapter());
        adapters.add(new CountyAdapter());
        // text 中文
        adapters.add(new CParagraphAdapter());
        adapters.add(new CSentenceAdapter());
        adapters.add(new CTitleAdapter());
        adapters.add(new CWordAdapter());
        // text english
        adapters.add(new ParagraphAdapter());
        adapters.add(new SentenceAdapter());
        adapters.add(new TitleAdapter());
        adapters.add(new WordAdapter());

        // color
        adapters.add(new ColorAdapter());
        adapters.add(new ColorHexAdapter());
        adapters.add(new RGBAdapter());
        adapters.add(new RGBAAdapter());
        // 图片
        adapters.add(new ImageAdapter());

        // MISC 通用辅助生成
        adapters.add(new PickAdapter());
    }


    /**
     * 处理字符串类型的数据
     *
     * @param key   key
     * @param value value
     * @return string
     */
    public Object string(String key, Object value) {
        ParseResult rules = Parser.parseKey(key);
        String val = (String) value;
        List<Schema> schemas = Parser.parseValue(val);
        if (!StringUtils.isEmpty(value) && schemas.size() > 0) {
            // @xxxx  > xxxx
            // TODO.. 如果value中空格,应该在处理空格
            StringBuilder result = new StringBuilder();
            for (Schema schema : schemas) {
                String type = schema.getType();
                StringTypes stringType = StringTypes.valueOfNone(type);
                rules.setParameters(schema.getParameters());
                // ParseResult parseResult = ParametersParser.parse(rules, schema.getParameters());
                for (StringTypeAdapter stringTypeAdapter : adapters) {
                    if (stringTypeAdapter.supports(stringType)) {
                        Object random = stringTypeAdapter.random(rules, key, value);
                        result.append(random);
                        break;
                    }
                }
            }
            // 判断是否已经存在的函数类型,如@none 不存在则原样返回
            if (StringUtils.isEmpty(result.toString())) {
                return value;
            }
            return result.toString();
        }
        // 如果不是@开头的,则算字符串处理
        return value;
    }
}
