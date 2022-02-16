package io.github.fastmock.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 图片格式数据
 * author: wangkun32
 * date: 2022/02/01 17:40
 */
@ToString
public class ImageProps {

    @Setter
    @Getter
    private String size;

    @Setter
    @Getter
    private String background;

    @Setter
    @Getter
    private String foreground;

    @Setter
    @Getter
    private String text;

    @Setter
    @Getter
    private String format;
}
