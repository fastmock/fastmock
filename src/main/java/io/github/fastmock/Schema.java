package io.github.fastmock;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * ######@pick(['abcd',1,3,4,6])######
 * ######@email('string',2,3,3,4)@user######
 * type1 email
 * type2 user
 * <p>
 * author wangkun23
 * version 1.0.0
 * date 2022/1/26 22:49
 */
@ToString
@NoArgsConstructor
public class Schema {

    @Setter
    @Getter
    private String type;

    @Setter
    @Getter
    private String parameters = "";


    public Schema(String type) {
        this.type = type;
    }

    public Schema(String type, String parameters) {
        this.type = type;
        this.parameters = parameters;
    }
}
