package io.github.fastmock.random;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 随机生成日期相关的数据
 * <p>
 * author: wangkun32
 * date: 2021/1/3 20:43
 */
public class RandomDate {

    /**
     * 返回一个随机的日期字符串
     *
     * @return date
     */
    public String date() {
        String format = "yyyy-MM-dd";
        return this.formatDate(randomDate(), format);
    }

    /**
     * 返回一个随机的时间字符串
     *
     * @return time
     */
    public String time() {
        String format = "HH:mm:ss";
        return this.formatDate(randomDate(), format);
    }

    /**
     * 返回一个随机的时间字符串
     *
     * @return datetime
     */
    public String datetime() {
        String format = "yyyy-MM-dd HH:mm:ss";
        return this.formatDate(randomDate(), format);
    }

    /**
     * 随机当前时间
     *
     * @return now
     */
    public String now() {
        String format = "yyyy-MM-dd HH:mm:ss";
        return this.formatDate(new Date(), format);
    }

    /**
     * 格式化日期
     *
     * @param date   date
     * @param format format
     * @return formatDate
     */
    private String formatDate(Date date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        // 格式化时间
        return formatter.format(localDateTime);
    }

    /**
     * 生成指定范围的随机时间
     *
     * @param startDate startDate
     * @param endDate   endDate
     * @return randomDate
     */
    private Date randomDate(Date startDate, Date endDate) {
        if (startDate.getTime() >= endDate.getTime()) {
            return new Date();
        }
        long timestamp = randomTimestamp(startDate.getTime(), endDate.getTime());
        return new Date(timestamp);
    }

    /**
     * 没有指定时间范围随机时间
     *
     * @return randomDate
     */
    private Date randomDate() {
        long timestamp = randomTimestamp(0, new Date().getTime());
        return new Date(timestamp);
    }

    /**
     * 生成随机时间
     *
     * @param begin begin
     * @param end   end
     * @return randomTimestamp
     */
    private long randomTimestamp(long begin, long end) {
        long timestamp = begin + (long) (Math.random() * (end - begin));
        if (timestamp == begin || timestamp == end) {
            return randomTimestamp(begin, end);
        }
        return timestamp;
    }
}
