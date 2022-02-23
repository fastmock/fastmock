package io.github.fastmock.random;

import io.github.fastmock.utils.RandomUtils;
import io.github.fastmock.utils.RandomStringUtils;

/**
 * author: wangkun32
 * date: 2021/12/28 13:33
 */
public class RandomText {
    // 最常用的 500 个汉字 http://baike.baidu.com/view/568436.htm
    private static String dictHans = "的一是在不了有和人这中大为上个国我以要他时来用们生到作地于出就分对成会可主发年动同" +
            "工也能下过子说产种面而方后多定行学法所民得经十三之进着等部度家电力里如水化高自二理起小物现实加量都两体制" +
            "机当使点从业本去把性好应开它合还因由其些然前外天政四日那社义事平形相全表间样与关各重新线内数正心反你明看" +
            "原又么利比或但质气第向道命此变条只没结解问意建月公无系军很情者最立代想已通并提直题党程展五果料象员革位入" +
            "常文总次品式活设及管特件长求老头基资边流路级少图山统接知较将组见计别她手角期根论运农指几九区强放决西被干" +
            "做必战先回则任取据处队南给色光门即保治北造百规热领七海口东导器压志世金增争济阶油思术极交受联什认六共权收" +
            "证改清己美再采转更单风切打白教速花带安场身车例真务具万每目至达走积示议声报斗完类八离华名确才科张信马节话" +
            "米整空元况今集温传土许步群广石记需段研界拉林律叫且究观越织装影算低持音众书布复容儿须际商非验连断深难近矿" +
            "千周委素技备半办青省列习响约支般史感劳便团往酸历市克何除消构府称太准精值号率族维划选标写存候毛亲快效斯院" +
            "查江型眼王按格养易置派层片始却专状育厂京识适属圆包火住调满县局照参红细引听该铁价严龙飞";

    /**
     * 随机生成一段段落
     *
     * @param count count
     * @return paragraph
     */
    public static String paragraph(int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= count; i++) {
            builder.append(sentence(count));
        }
        return builder.toString();
    }

    /**
     * 随机生成一个句子，第一个单词的首字母大写
     *
     * @param count count
     * @return sentence
     */
    public static String sentence(int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= count; i++) {
            builder.append(word(count));
        }
        return builder.toString();
    }


    /**
     * 随机生成一句标题，其中每个单词的首字母大写
     *
     * @param count count
     * @return title
     */
    public static String title(int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= count; i++) {
            builder.append(word(count));
        }
        return builder.toString();
    }

    /**
     * 随机生成一个文本
     *
     * @param count count
     * @return word
     */
    public static String word(int count) {
        return RandomStringUtils.randomAlphanumeric(count);
    }

    /**
     * 随机生成一段中文段落
     *
     * @param count count
     * @return chinese paragraph
     */
    public static String cparagraph(int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= count; i++) {
            builder.append(csentence(count));
        }
        return builder.toString();
    }

    /**
     * 随机生成一个中文句子
     *
     * @param count count
     * @return chinese sentence
     */
    public static String csentence(int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= count; i++) {
            builder.append(cword(count));
        }
        return builder.toString();
    }


    /**
     * 随机生成一句中文标题
     *
     * @param count count
     * @return chinese title
     */
    public static String ctitle(int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= count; i++) {
            builder.append(cword(count));
        }
        return builder.toString();
    }

    /**
     * 随机生成一个文本
     *
     * @param count count
     * @return chinese word
     */
    public static String cword(int count) {
        return RandomStringUtils.random(count, dictHans);
    }
}
