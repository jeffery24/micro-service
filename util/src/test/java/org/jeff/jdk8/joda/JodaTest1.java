package org.jeff.jdk8.joda;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

/**
 * 服务端采取 UTC 无时区时间存储,由客户端根据时区显示最终正确时间,国际化友好
 *
 * @author jeff
 * @since 1.0.0
 */
public class JodaTest1 {

    /**
     * 将字符串UTC日期转换成Date
     *
     * @param utcDate utc date String
     * @return utc Date
     */
    public static Date convertUTC2Date(String utcDate) {
        DateTime datetime = DateTime.parse(utcDate, DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
        return datetime.toDate();
    }

    public static String convertDate2UTC(Date javaDate) {
        DateTime datetime = new DateTime(javaDate, DateTimeZone.UTC);
        return datetime.toString();
    }

    public static String convertDate2LocalByDateFormat(Date javaDate, String dateFormat) {
        DateTime dateTime = new DateTime(javaDate);
        return dateTime.toString(dateFormat);
    }


    public static void main(String[] args) {
        DateTime dateTime = new DateTime();
        DateTime tomorrow = dateTime.plusDays(1);
        DateTime yesterday = dateTime.minusDays(1);
        System.out.println(tomorrow);
        System.out.println(yesterday);
        System.out.println("==============================");

        System.out.println(convertDate2UTC(new Date()));
        System.out.println(convertUTC2Date("2022-01-18T13:47:09.376z"));
        System.out.println(convertDate2LocalByDateFormat(new Date(), "yyyy-MM-dd HH:mm:ss"));
    }
}
