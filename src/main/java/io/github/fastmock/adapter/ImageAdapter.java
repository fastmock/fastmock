package io.github.fastmock.adapter;

import io.github.fastmock.ParseResult;
import io.github.fastmock.StringTypeAdapter;
import io.github.fastmock.StringTypes;
import io.github.fastmock.model.ImageProps;
import io.github.fastmock.utils.StringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;

/**
 * 随机图片类型的数据
 * author: wangkun32
 * date: 2022/02/01 17:23
 */
public class ImageAdapter implements StringTypeAdapter {

    // 常见的广告宽高
    private String[] adSizeList = {
            "300x250", "250x250", "240x400", "336x280", "180x150",
            "720x300", "468x60", "234x60", "88x31", "120x90",
            "120x60", "120x240", "125x125", "728x90", "160x600",
            "120x600", "300x600"
    };

    @Override
    public boolean supports(StringTypes type) {
        return type.equals(StringTypes.image);
    }

    @Override
    public Object random(ParseResult rules, String key, Object value) {
        // Random.image( size, background, foreground, text )
        ImageProps imageProps = new ImageProps();
//        List<String> parameters = rules.getParameters();
//        if (parameters.size() == 5) {
//            imageProps.setSize(parameters.get(0));
//            imageProps.setForeground(parameters.get(1));
//            imageProps.setBackground(parameters.get(2));
//            imageProps.setFormat(parameters.get(3));
//            imageProps.setText(parameters.get(4));
//        }
//        if (parameters.size() == 4) {
//            imageProps.setSize(parameters.get(0));
//            imageProps.setForeground(parameters.get(1));
//            imageProps.setBackground(parameters.get(2));
//            imageProps.setText(parameters.get(3));
//        }
//        // Random.image( size, background, text )
//        if (parameters.size() == 3) {
//            imageProps.setSize(parameters.get(0));
//            imageProps.setBackground(parameters.get(1));
//            // default text 前景色
//            imageProps.setFormat(parameters.get(2));
//            imageProps.setText(imageProps.getForeground());
//        }
//        // Random.image()
//        if (StringUtils.isEmpty(imageProps.getSize())) {
//            int nextInt = RandomUtils.nextInt(0, this.adSizeList.length);
//            imageProps.setSize(this.adSizeList[nextInt]);
//        }
        // http://dummyimage.com/600x400/cc00cc/470047.png&text=hello
        StringBuilder builder = new StringBuilder("http://dummyimage.com/");
        builder.append(imageProps.getSize())
                .append("/").append(imageProps.getBackground())
                .append("/").append(imageProps.getForeground())
                .append("/").append(imageProps.getFormat())
                .append("&text=").append(imageProps.getText());
        return builder.toString();
    }
}
