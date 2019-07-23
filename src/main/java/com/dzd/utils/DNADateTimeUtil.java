package com.dzd.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期工具类
 * author 费秀伟
 * date 2016-12-13
 */
public class DNADateTimeUtil {
    public static String PATTERN_HHmmss ="HHmmss"; // 时间格式：121212
    public static String PATTERN_yyyyMMdd ="yyyyMMdd"; // 日期格式：20161212
    public static String PATTERN_yyyy_MM_dd ="yyyy-MM-dd"; // 日期格式：2016-12-12
    public static String PATTERN_yyyyMMddHHmmss ="yyyyMMddHHmmss";  // 日期格式：20161212111111
    public static String PATTERN_yyyyMMdd_HHmmss ="yyyy-MM-dd HH:mm:ss"; // 日期格式：2016-12-12 11:11:11
    public static String PATTERN_yyyyMMdd_ZH ="yyyy年MM月dd日"; // 中文日期格式：2016年12月12日


    /**
    * @Author:diaozhende
    * @Description: //TODO Date类型转换成字符串
    * @CreateDate:  2019/7/22 17:44
    *@param:  [time]
    *@return: java.lang.String
    */
    public static  String dateToString(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_yyyy_MM_dd);
        return sdf.format(time);
    }


    /**
    * @Author:diaozhende
    * @Description: //TODO Date类型转换成字符串
    * @CreateDate:  2019/6/13 16:40
    *@param:  [time]
    *@return: java.lang.String
    */
    public static  String getDateToString(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_yyyyMMdd_HHmmss);
        return sdf.format(time);
    }
    /**
     * 同步，根据定义格式取得当前日期时间，不会受对象创建时间影响
     * param format 自定义格式
     * return
     */
    public static final synchronized String getCurrDateForFormat(String format){
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    /**
     *
     * 将Excel中日期格式转换为String(yyyy-MM-dd)格式
     * author 唐仲钰
     * date 2017-5-22
     * param excelDate 接受的数据为String类型的距离1900年1月1日的天数
     * return String 返回类型
     */
    public static final synchronized String getExcelDateToString(String excelDate){
        Calendar cal = Calendar.getInstance();
        cal.set(1900, 0, 0);
        cal.add(Calendar.DAY_OF_MONTH, Integer.parseInt(excelDate));
        String yearNew = cal.get(Calendar.YEAR)+"";
        String monthNew = (cal.get(Calendar.MONTH) + 1)<=9?"0"+(cal.get(Calendar.MONTH) + 1):""+(cal.get(Calendar.MONTH) + 1);
        String dayNew = (cal.get(Calendar.DAY_OF_MONTH)-1)<=9?"0"+(cal.get(Calendar.DAY_OF_MONTH)-1):""+(cal.get(Calendar.DAY_OF_MONTH)-1);
        String createrTime = yearNew+"-"+monthNew+"-"+dayNew;
        return createrTime;
    }
    /**
     * [转型]String类型转日期时间格式
     * param dateString(2016-01-02)
     * return
     */
    public static Date transferStringToDate(String dateString){
        Date date=new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_yyyy_MM_dd);
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return date;
    }

    /**
     * [转型]long类型转日期时间格式
     * param longDate(毫秒数)
     * return
     */
    public static String transferLongToString(Long longDate){
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_yyyy_MM_dd);
        Date date= new Date(longDate);
        return sdf.format(date);
    }

    /**
     * [转型]long类型转日期时间格式
     * param longDate(毫秒数)
     * return
     */
    public static String transferLongToDate(Long longDate){
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_yyyyMMdd_HHmmss);
        Date date= new Date(longDate);
        return sdf.format(date);
    }

    /**
     * [转型String类型转日期时间格式
     * param strDate 字符串类型的毫秒数
     * return String 返回类型
     */
    public static String transferStringToString(String strDate){
        SimpleDateFormat sdf=new SimpleDateFormat(PATTERN_yyyyMMdd_ZH);
        Date date = new Date(Long.parseLong(strDate));
        return sdf.format(date);
    }

    public static String transferDateToString(Date strDate){
        SimpleDateFormat sdf=new SimpleDateFormat(PATTERN_yyyyMMdd_ZH);
        return sdf.format(strDate);
    }
    /**
     * [转型]long类型转日期时间格式
     * param longDate(毫秒数)
     * return 包含时分秒的字符串类型日期
     */
    public static String getCurrentDate(){
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_yyyy_MM_dd);
        return sdf.format(new Date());
    }

    /**
     * [转型]long类型转日期格式
     * param longDate(毫秒数)
     * return
     */
    public static String transferLongToDateNoTime(Long longDate){
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_yyyy_MM_dd);
        Date date= new Date(longDate);
        return sdf.format(date);
    }

    /**
     * 计算日期第n天后的日期
     * param beginDate  传递日期 Date
     * param datas 参数值
     * return
     */
    public static Date getBeginDateForDatasCalculationDate(Date beginDate, int datas) {
        Calendar beginCal = Calendar.getInstance();
        beginCal.setTime(beginDate);
        GregorianCalendar calendar = new GregorianCalendar(beginCal
                .get(Calendar.YEAR), beginCal.get(Calendar.MONTH), beginCal
                .get(Calendar.DATE));
        calendar.add(GregorianCalendar.DATE, datas);
        String begin = new java.sql.Date(calendar.getTime().getTime())
                .toString();
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_yyyy_MM_dd);
        Date endDate = null;
        try {
            endDate = sdf.parse(begin);
        } catch (ParseException e) {
        }
        return endDate;
    }

    /**
     * 计算日期第n天后的日期
     * param  传递日期String
     * param datas 第N天
     * return
     */
    public static String getBeginDateForDatasCalculationDate(String begindate, int datas) {
        if(begindate==null){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_yyyy_MM_dd);
        Date date = null;
        try {
            date = sdf.parse(begindate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdf.format(getBeginDateForDatasCalculationDate(date,datas));
    }

    /**
     * 计算日期第n天后的日期,并格式化
     * param beginDate 传递日期
     * param datas 第N天
     * param format 格式化样式
     * return
     */
    public static String getBeginDateForDatasCalculationDate(String begindate, int datas, String format) {
        if(begindate==null){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_yyyyMMdd);
        Date date = null;
        try {
            date = sdf.parse(begindate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdf.format(getBeginDateForDatasCalculationDate(date,datas));
    }

    /**
     * 起-日期起止日处理
     * param begindate
     * param enddate
     * return
     */
    public static String beginDateFormat(String begindate,String enddate){
        String date = null;
        boolean begin = DNAStringUtil.isEmptyString(begindate); // 判断日期是否为空
        if(begin==true){
            date = DNADateTimeUtil.getBeginDateForDatasCalculationDate("1900-01-01", -1);
        }
        else{
            date = begindate;
        }
        return date;
    }

    /**
     * 止-日期起止日处理
     * param begindate
     * param enddate
     * return
     */
    public static String endDateFormat(String begindate,String enddate){
        String date = null;
        boolean end = DNAStringUtil.isEmptyString(enddate);  // 判断日期是否为空
        if(end == true){
            date = DNADateTimeUtil.getBeginDateForDatasCalculationDate("2099-01-01", 1);
        }
        else{
            date = enddate;
        }
        return date;
    }

    /**
     * 比较开始日期和结束日期，如果开始日期早于结束日期返回true，其他情况为false
     * param begindate 开始日期
     * param enddate 结束日期
     * return
     */
    public static boolean compareBeginAndEndDate(String begindate,String enddate){
        SimpleDateFormat df=new SimpleDateFormat(PATTERN_yyyy_MM_dd);
        Calendar c1=Calendar.getInstance();
        Calendar c2=Calendar.getInstance();

        try
        {
            c1.setTime(df.parse(begindate));
            c2.setTime(df.parse(enddate));
        }catch(ParseException e){
            System.err.println("格式不正确");
        }
        int result=c1.compareTo(c2);
        // c1相等c2
        if(result==0){
            return false;
        }
        else if(result<0){  // c1小于c2
            return false;
        }
        else{ // c1大于c2
            return true;
        }
    }

    /**
     * 传递一个日期，从一种格式转换为另外一种格式
     * param dateS 需要转换前的日期  如：20160101
     * param formatB 需要转换前的日期格式 如： yyyyMMdd
     * param formatE 需要转换后的日期格式 如： yyyy-MM-dd
     * return
     */
    public static String getFormatBToFormatE(String dateS, String formatB,String formatE){
        SimpleDateFormat sdf1 = new SimpleDateFormat(formatB);
        SimpleDateFormat sdf2 = new SimpleDateFormat(formatE);
        Date date = null;
        try {
            date = sdf1.parse(dateS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String dateStr = sdf2.format(date);
        return dateStr;
    }

    /**
     * 获得当前时间前n小时的时间，根据传入格式进行格式化format
     * param n 前n小时，传-n 例如：前一小时传-1
     * param format 格式化样式
     * return
     */
    public static String getParamHoursAgoHour(int n,String format){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR_OF_DAY, n);
        String oneHoursAgo = new SimpleDateFormat(format).format(cal.getTime());
        return oneHoursAgo;
    }

    // 取系统时间的年
    public static int getYear() {
        Calendar calendar = new GregorianCalendar();
        return calendar.get(Calendar.YEAR);
    }

    // 取系统时间的月
    public static int getMonth() {
        Calendar calendar = new GregorianCalendar();
        return calendar.get(Calendar.MONTH) + 1;
    }

    // 取系统时间的日
    public static int getDay() {
        Calendar calendar = new GregorianCalendar();
        return calendar.get(calendar.DATE);
    }

    // 取系统时间的小时
    public static int getHour() {
        Calendar calendar = new GregorianCalendar();
        return calendar.get(calendar.HOUR_OF_DAY);
    }

    // 取系统时间的分
    public static int getMinute() {
        Calendar calendar = new GregorianCalendar();
        return calendar.get(calendar.MINUTE);
    }

    // 取系统时间的秒
    public static int getSecond() {
        Calendar calendar = new GregorianCalendar();
        return calendar.get(calendar.SECOND);
    }

    /**
     * 取指定月份的天数
     * param year_month 传递格式：2016-12
     * return
     */
    public static int getMonthDayNum(String year_month) {
        int year = Integer.parseInt(year_month.substring(0,year_month.indexOf("-")));
        int month = Integer.parseInt(year_month.substring(year_month.indexOf("-") + 1));
        Calendar date = Calendar.getInstance();
        date.clear();
        date.set(Calendar.YEAR, year);
        date.set(Calendar.MONTH, month - 1);

        return date.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 将字符串yyyy-mm-dd转换成日期类型
     * param date yyyy-mm-dd
     * return
     * @throws Exception
     */
    public static Date formatStringToDate(String date) throws Exception {
        SimpleDateFormat day = new SimpleDateFormat(PATTERN_yyyy_MM_dd);
        return day.parse(date);
    }

    public static String formatDateToString(long date){
        SimpleDateFormat day = new SimpleDateFormat(PATTERN_yyyyMMdd_ZH);
        return day.format(new Date(date));
    }
    public static Date formatStringToDate2(String date) throws Exception {
        SimpleDateFormat day = new SimpleDateFormat(PATTERN_yyyyMMdd_ZH);
        return day.parse(date);
    }

    /**
     * * 获取指定日期是星期几 参数为null时表示获取当前日期是星期几
     *
     * param date
     * return
     */
    public static String getWeekOfDate(Date date) {
        String[] weekOfDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekOfDays[w];
    }

    public static void main(String[] args) {
        DNADateTimeUtil  dnaUtilDateTime = new DNADateTimeUtil();
        System.out.println("getCurrDateString()>>"+dnaUtilDateTime.getCurrDateForFormat("yyyyMMdd"));
        System.out.println("getDateByCustomFormat()>>"+dnaUtilDateTime.getBeginDateForDatasCalculationDate(new Date(),2));
        System.out.println("getWeekOfDate()>>"+dnaUtilDateTime.getWeekOfDate(new Date()));
        System.out.println(dnaUtilDateTime.transferLongToString(1495468800000L));
    }
}
