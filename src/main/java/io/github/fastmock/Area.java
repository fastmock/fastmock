package io.github.fastmock;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by wangkun23 on 2022/1/3
 *
 * @version : v1.0.0
 **/
@ToString
public class Area {

    @Setter
    @Getter
    private String id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private List<Area> children;
}
