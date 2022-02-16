package io.github.fastmock.random;

import org.apache.commons.lang3.RandomUtils;

/**
 * author: wangkun32
 * date: 2021/12/28 13:10
 */
public class RandomName {

    private final String[] firstNames = {
            "James", "John", "Robert", "Michael", "William",
            "David", "Richard", "Charles", "Joseph", "Thomas",
            "Christopher", "Daniel", "Paul", "Mark", "Donald",
            "George", "Kenneth", "Steven", "Edward", "Brian",
            "Ronald", "Anthony", "Kevin", "Jason", "Matthew",
            "Gary", "Timothy", "Jose", "Larry", "Jeffrey",
            "Frank", "Scott", "Eric",
            // female
            "Mary", "Patricia", "Linda", "Barbara", "Elizabeth",
            "Jennifer", "Maria", "Susan", "Margaret", "Dorothy",
            "Lisa", "Nancy", "Karen", "Betty", "Helen",
            "Sandra", "Donna", "Carol", "Ruth", "Sharon",
            "Michelle", "Laura", "Sarah", "Kimberly", "Deborah",
            "Jessica", "Shirley", "Cynthia", "Angela", "Melissa",
            "Brenda", "Amy", "Anna"
    };

    private final String[] lastNames = {
            "Smith", "Johnson", "Williams", "Brown", "Jones",
            "Miller", "Davis", "Garcia", "Rodriguez", "Wilson",
            "Martinez", "Anderson", "Taylor", "Thomas", "Hernandez",
            "Moore", "Martin", "Jackson", "Thompson", "White",
            "Lopez", "Lee", "Gonzalez", "Harris", "Clark",
            "Lewis", "Robinson", "Walker", "Perez", "Hall",
            "Young", "Allen"
    };

    // 随机生成一个常见的英文名。
    public String first() {
        return this.pick(firstNames);
    }

    // 随机生成一个常见的英文姓。
    public String last() {
        return this.pick(lastNames);
    }

    /**
     * 随机选择数组中一个字符串
     *
     * @param names names
     * @return pick result
     */
    public String pick(String[] names) {
        int anInt = RandomUtils.nextInt(0, names.length);
        return names[anInt];
    }

    // 随机生成一个常见的英文姓名。
    public String name(boolean middle) {
        return this.first() + " " +
                (middle ? this.first() + " " : this.last());
    }

    // 随机生成一个常见的英文姓名。没有之间名
    public String name() {
        return this.name(false);
    }

    public String cfirst() {
        String srcFirstnames = "王 李 张 刘 陈 杨 赵 黄 周 吴 " +
                "徐 孙 胡 朱 高 林 何 郭 马 罗 " +
                "梁 宋 郑 谢 韩 唐 冯 于 董 萧 " +
                "程 曹 袁 邓 许 傅 沈 曾 彭 吕 " +
                "苏 卢 蒋 蔡 贾 丁 魏 薛 叶 阎 " +
                "余 潘 杜 戴 夏 锺 汪 田 任 姜 " +
                "范 方 石 姚 谭 廖 邹 熊 金 陆 " +
                "郝 孔 白 崔 康 毛 邱 秦 江 史 " +
                "顾 侯 邵 孟 龙 万 段 雷 钱 汤 " +
                "尹 黎 易 常 武 乔 贺 赖 龚 文";
        String[] names = srcFirstnames.split(" ");
        return this.pick(names);
    }

    /*
        随机生成一个常见的中文名。
        [中国最常见名字前50名_三九算命网](http://www.name999.net/xingming/xingshi/20131004/48.html)
     */
    public String clast() {
        String clastNames = "伟 芳 娜 秀英 敏 静 丽 强 磊 军 " +
                "洋 勇 艳 杰 娟 涛 明 超 秀兰 霞 " +
                "平 刚 桂英";
        String[] names = clastNames.split(" ");
        return this.pick(names);
    }

    // 随机生成一个常见的中文姓名。
    public String cname() {
        return this.cfirst() + this.clast();
    }
}
