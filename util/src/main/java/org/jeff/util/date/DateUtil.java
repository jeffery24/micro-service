package org.jeff.util.date;

import java.time.*;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期时间工具类
 * <p>
 * 1.日期时间API的迭代：
 * 第一代：jdk 1.0 Date类
 * 第二代：jdk 1.1 Calendar类，一定程度上替换Date类
 * 第三代：jdk 1.8 提出了新的一套API
 * <p>
 * 2.前两代存在的问题举例：
 * 可变性：像日期和时间这样的类应该是不可变的。
 * 偏移性：Date中的年份是从1900开始的，而月份都从0开始。
 * 格式化：格式化只对Date用，Calendar则不行。
 * 此外，它们也不是线程安全的；不能处理闰秒等。
 * <p>
 * 本地日期、本地时间、本地日期时间的使用：LocalDate / LocalTime / LocalDateTime
 * 分别表示使用 ISO-8601日历系统的日期、时间、日期和时间。它们提供了简单的本地日期或时间，并不包含当前的时间信息，也不包含与时区相关的信息。
 * LocalDateTime相较于LocalDate、LocalTime，使用频率要高,类似于Calendar
 *
 * @author jeff
 * @since 1.0.0
 */
public class DateUtil {

    /**
     * 日期时间格式 example 2021-12-05 14:21:04
     */
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd hh:mm:ss";

    /**
     * 日期时间格式 example 2021-12-05
     */
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    /**
     * UTC 时间格式,世界标准时
     */
    public static final String DATE_TIME_UTC_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";


    /**
     * 获取某天的最小时间 eg: 2021:03:31 00:00:00
     *
     * @param date 日期参数
     * @return
     */
    public static Date getStartOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获得某天最大时间 eg: 2021-03-31 23:59:59
     *
     * @param date 日期参数
     */
    public static Date getEndOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 日期加减天数
     * eg.往后加n天: today, n
     * eg.往后减n填: today,-n
     *
     * @param date   日期参数
     * @param amount 加减天数
     * @return 结果日期
     */
    public static Date addDay(Date date, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, amount);
        return calendar.getTime();
    }

    /**
     * 判断给定的日期是否在指定的时间段内
     *
     * @param dateTime  当前时间
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return true Or false
     */
    public static boolean belongCalendar(Date dateTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(dateTime);
        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);
        if (date.after(begin) && date.before(end)) {
            return true;
        } else if (dateTime.compareTo(beginTime) == 0 || dateTime.compareTo(endTime) == 0) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Date convert LocalDateTime
     *
     * @param date
     * @return
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * LocalDateTime convert Date
     *
     * @param date
     * @return
     */
    public static Date localDateTime2Date(LocalDateTime date) {
        return Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
    }


    public static LocalDate date2LocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * 获取年|月|日的间隔天数 eg: 2018-7-23 2021-8-25
     * getDays() 获取天数 2
     * period.getMonths() 获取月数 1
     * period.getYears() 获取年数 3
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static long betweenDays(Date startDate, Date endDate) {
        Period period = Period.between(date2LocalDate(startDate), date2LocalDate(endDate));
        return period.getDays();
    }

    public static long betweenDays(LocalDate startDate, LocalDate endDate) {
        Period period = Period.between(startDate, endDate);
        return period.getDays();
    }

    public static long betweenDateDays(LocalDateTime startDate, LocalDateTime endDate) {
        Duration duration1 = Duration.between(startDate, endDate);
        return duration1.toDays();
    }

    public static long betweenMinutes(LocalDateTime startDate, LocalDateTime endDate) {
        Duration duration1 = Duration.between(startDate, endDate);
        return duration1.toMinutes();
    }

    public static long betweenHours(LocalDateTime startDate, LocalDateTime endDate) {
        Duration duration1 = Duration.between(startDate, endDate);
        return duration1.toHours();
    }


    public static void main(String[] args) {
        //LocalTime localTime = LocalTime.now();
        //LocalTime localTime1 = LocalTime.of(15, 23, 32);
        ////between():静态方法，返回Duration对象，表示两个时间的间隔
        //Duration duration = Duration.between(localTime1, localTime);
        //System.out.println(duration);
        //
        //System.out.println(duration.getSeconds());
        //System.out.println(duration.getNano());

        //LocalDateTime localDateTime = LocalDateTime.of(2016, 6, 12, 15, 23, 32);
        //LocalDateTime localDateTime1 = LocalDateTime.of(2017, 6, 12, 15, 23, 32);
        //
        //Duration duration1 = Duration.between(localDateTime1, localDateTime);
        //System.out.println(duration1.toDays());
        //
        //System.out.println("=================");
        //long betweenDays = betweenDays(LocalDate.of(2018, 9, 17), LocalDate.now());
        //System.out.println(betweenDays);
        //System.out.println("=================");
        //long dateDays = betweenDateDays(LocalDate.of(2018, 9, 17), LocalDate.now());
        //System.out.println(dateDays);
        //日期间隔：Period --用于计算两个“日期”间隔，以年、月、日衡量

        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = LocalTime.of(15, 23, 32);
        //between():静态方法，返回Duration对象，表示两个时间的间隔
        Duration duration = Duration.between(localTime1, localTime);
        System.out.println(duration);

        System.out.println(duration.getSeconds());
        System.out.println(duration.getNano());

        LocalDateTime localDateTime = LocalDateTime.of(2016, 6, 12, 15, 23, 32);
        LocalDateTime localDateTime1 = LocalDateTime.of(2017, 6, 12, 15, 23, 32);

        Duration duration1 = Duration.between(localDateTime1, localDateTime);
        System.out.println("====================");
        System.out.println(LocalDate.now());
        Duration between = Duration.between(LocalDateTime.of(2018, 9, 17, 12, 3, 4), LocalDateTime.now());
        System.out.println(between.toDays());
        System.out.println(between.toHours());
        System.out.println(between);
        //System.out.println(duration1.toDays());

        //Period period1 = period.withYears(2);
        //System.out.println(period1);

    }


}
