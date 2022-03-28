package io.github.fastmock;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * 正则表达式匹配测试
 * author wangkun23
 * date 2/22/22 22:52
 * version 1.0.0
 */
public class MatchesRegularExpression extends TypeSafeMatcher<String> {

    private final String regularExpression;

    public MatchesRegularExpression(String regularExpression) {
        this.regularExpression = regularExpression;
    }

    @Override
    protected boolean matchesSafely(String item) {
        return item.matches(regularExpression);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("to match the regular expression " + regularExpression);
    }

    @Factory
    public static <T> Matcher<String> matchesRegularExpression(String regularExpression) {
        return new MatchesRegularExpression(regularExpression);
    }
}
