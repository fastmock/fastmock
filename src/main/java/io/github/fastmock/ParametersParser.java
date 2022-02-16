package io.github.fastmock;

import io.github.fastmock.utils.RandomUtils;
import io.github.fastmock.utils.StringUtils;

import java.util.List;

/**
 * author wangkun23
 * version 1.0.0
 * date 2022/1/27 23:25
 */
public class ParametersParser {

    /**
     * 组装一下函数名带的参数
     *
     * @param parseResult parseResult
     * @param parameters  parameters
     * @return ParseResult
     */
    public static ParseResult parse(ParseResult parseResult, List<String> parameters) {
        if (parameters.size() == 1) {
            int max = !StringUtils.isEmpty(parameters.get(0)) ? Integer.parseInt(parameters.get(0)) : 0;
            int count = RandomUtils.nextInt(0, max);
            parseResult.setMax(max);
            parseResult.setCount(count);
        }
        if (parameters.size() == 2) {
            int min = !StringUtils.isEmpty(parameters.get(0)) ? Integer.parseInt(parameters.get(0)) : 0;
            int max = !StringUtils.isEmpty(parameters.get(1)) ? Integer.parseInt(parameters.get(1)) : 0;
            int count = RandomUtils.nextInt(min, max);
            parseResult.setMin(min);
            parseResult.setMax(max);
            parseResult.setCount(count);
        }
        if (parameters.size() == 3) {
            int max = !StringUtils.isEmpty(parameters.get(2)) ? Integer.parseInt(parameters.get(2)) : 0;
            int count = RandomUtils.nextInt(0, max);
            parseResult.setMax(max);
            parseResult.setCount(count);


            int dmin = !StringUtils.isEmpty(parameters.get(2)) ? Integer.parseInt(parameters.get(2)) : 0;
            int dmax = !StringUtils.isEmpty(parameters.get(3)) ? Integer.parseInt(parameters.get(3)) : 0;
            int dcount = RandomUtils.nextInt(dmin, dmax);
            parseResult.setDmin(dmin);
            parseResult.setDmax(dmax);
            parseResult.setDcount(dcount);
        }

        if (parameters.size() == 4) {
            int min = !StringUtils.isEmpty(parameters.get(0)) ? Integer.parseInt(parameters.get(0)) : 0;
            int max = !StringUtils.isEmpty(parameters.get(1)) ? Integer.parseInt(parameters.get(1)) : 0;
            int count = RandomUtils.nextInt(min, max);
            parseResult.setMin(min);
            parseResult.setMax(max);
            parseResult.setCount(count);

            int dmin = !StringUtils.isEmpty(parameters.get(2)) ? Integer.parseInt(parameters.get(2)) : 0;
            int dmax = !StringUtils.isEmpty(parameters.get(3)) ? Integer.parseInt(parameters.get(3)) : 0;
            int dcount = RandomUtils.nextInt(dmin, dmax);
            parseResult.setDmin(dmin);
            parseResult.setDmax(dmax);
            parseResult.setDcount(dcount);
        }
        // parseResult.setParameters(parameters);
        return parseResult;
    }
}
