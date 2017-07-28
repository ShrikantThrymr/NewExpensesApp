package com.example.thrymr.newexpensesapp.Utils;

import android.content.Context;
import android.graphics.Typeface;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;


import com.example.thrymr.newexpensesapp.R;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;


public class CalenderUtils {


    public static String date(String dat) {

        DateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm aa", Locale.US);
        DateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm aa", Locale.US);
        Date parsed = new Date();
        try {
            if (dat != null)
                parsed = inputFormat.parse(dat);
        } catch (Exception e) {

            e.printStackTrace();
        }

        return outputFormat.format(parsed);
    }


    public static String date(Long datLong) {
        DateFormat outputFormat = new SimpleDateFormat("dd MMM,yyyy hh:mm aa", Locale.US);
        Date date = new Date(datLong);
        return outputFormat.format(date);
    }

    public static String onlyDate(Long datLong) {
        DateFormat outputFormat = new SimpleDateFormat("MMM dd,yyyy", Locale.US);
        Date date = new Date(datLong);
        return outputFormat.format(date);
    }

    public static String onlyDate1(Long datLong) {
        DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Date date = new Date(datLong);
        return outputFormat.format(date);
    }

    public static String onlyTime(Long datLong) {
        DateFormat outputFormat = new SimpleDateFormat("hh:mm aa", Locale.US);
        Date date = new Date(datLong);
        return outputFormat.format(date);
    }

    public static String reverseDate(String dat) {
        DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        DateFormat inputFormat = new SimpleDateFormat("dd MMM, yyyy hh:mm aa", Locale.US);
        Date parsed = new Date();
        try {
            parsed = inputFormat.parse(dat);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return outputFormat.format(parsed);
    }

    public static String date2(String dat) {
        DateFormat inputFormat = new SimpleDateFormat("MMM dd, yyyy hh:mm aa", Locale.US);
        DateFormat outputFormat = new SimpleDateFormat("dd MMM,yyyy", Locale.US);
        Date parsed = new Date();
        try {
            parsed = inputFormat.parse(dat);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return outputFormat.format(parsed);
    }

    public static String date3(String dat) {

        DateFormat inputFormat = new SimpleDateFormat("MMM dd, yyyy hh:mm aa", Locale.US);
        DateFormat outputFormat = new SimpleDateFormat("hh:mm aa", Locale.US);
        Date parsed = new Date();
        try {
            if (dat != null)
                parsed = inputFormat.parse(dat);
        } catch (Exception e) {

            e.printStackTrace();
        }

        return outputFormat.format(parsed);
    }

    public static String date4(String dat) {

        DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DateFormat outputFormat = new SimpleDateFormat("dd MMM,yyyy", Locale.US);
        Date parsed = new Date();
        try {
            if (dat != null)
                parsed = inputFormat.parse(dat);
        } catch (Exception e) {

            e.printStackTrace();
        }

        return outputFormat.format(parsed);
    }

    public static String createJobFormat(String dat) {
        DateFormat outFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        Date parsed = new Date();
        try {
            parsed = outFormat.parse(dat);
        } catch (ParseException e) {

            e.printStackTrace();
        }
        String us = sdf.format(parsed);
        Log.i(us, sdf.format(parsed));
        return us;
    }

    public static String ddMMyyyFormat(String dat) {
        DateFormat outFormat = new SimpleDateFormat("dd MMM,yyyy", Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
        Date parsed = new Date();
        try {
            parsed = outFormat.parse(dat);
        } catch (ParseException e) {

            e.printStackTrace();
        }
        String us = sdf.format(parsed);
        Log.i(us, sdf.format(parsed));
        return us;
    }

    public static String getTimeWithZone(String from, String zone, String time) {
        SimpleDateFormat sourceFormat = new SimpleDateFormat("HHmm");
        sourceFormat.setTimeZone(TimeZone.getTimeZone(from));
        Date parsed = null;
        try {
            parsed = sourceFormat.parse(time);
        } catch (ParseException e) {

            e.printStackTrace();
        } // => Date is in UTC now

        TimeZone tz = TimeZone.getTimeZone(zone);
        SimpleDateFormat destFormat = new SimpleDateFormat("hh:mm aa");
        destFormat.setTimeZone(tz);

        return destFormat.format(parsed);
    }

    public static String changeTo24hour(String time) {
        SimpleDateFormat sourceFormat = new SimpleDateFormat("hh:mm aa");
        //sourceFormat.setTimeZone(TimeZone.getTimeZone(from));
        Date parsed = null;
        try {
            parsed = sourceFormat.parse(time);
        } catch (ParseException e) {

            e.printStackTrace();
        } // => Date is in UTC now

        //TimeZone tz = TimeZone.getTimeZone(to);
        SimpleDateFormat destFormat = new SimpleDateFormat("HH:mm");
        //destFormat.setTimeZone(tz);

        return destFormat.format(parsed);
    }

    public static String changeTo12hour(String time) {
        time = time.replaceAll(":", "");
        SimpleDateFormat sourceFormat = new SimpleDateFormat("HHmm");
        //sourceFormat.setTimeZone(TimeZone.getTimeZone(from));
        Date parsed = null;
        try {
            parsed = sourceFormat.parse(time);
        } catch (ParseException e) {

            e.printStackTrace();
        } // => Date is in UTC now

        //TimeZone tz = TimeZone.getTimeZone(to);
        SimpleDateFormat destFormat = new SimpleDateFormat("hh:mm aa");
        //destFormat.setTimeZone(tz);

        return destFormat.format(parsed);
    }

    public String SpeciesDescriptiondate(String dat) {
        DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DateFormat outputFormat = new SimpleDateFormat("dd-MMM", Locale.US);
        Date parsed = new Date();
        try {
            parsed = inputFormat.parse(dat);
        } catch (ParseException e) {

            e.printStackTrace();
        }
        return outputFormat.format(parsed);
    }

    public String dateServerFormat(String dat) {
        DateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss +SSS", Locale.US);
        Date parsed = new Date();
        try {
            parsed = inputFormat.parse(dat);
        } catch (ParseException e) {

            e.printStackTrace();
        }
        String us = sdf.format(parsed);
        Log.i(us, sdf.format(parsed));
        return us;
    }

    public static String toadayDateAsServerFormat() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss +SSS", Locale.US);
        Calendar cal = Calendar.getInstance();
        Log.i("formated", dateFormat.format(cal.getTime()));
        return dateFormat.format(cal.getTime());
    }

    public String servertoNormalDate(String dat) {
        DateFormat outFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss +SSS", Locale.US);
        Date parsed = new Date();
        try {
            parsed = sdf.parse(dat);
        } catch (ParseException e) {

            e.printStackTrace();
        }
        String us = outFormat.format(parsed);
        Log.i(us, outFormat.format(parsed));
        return us;
    }

    public long getDaysDifference(String date) {
        long milli = expDateConvert(date).getTime() - todayDate().getTime();
        return milli / (24 * 60 * 60 * 1000);
    }

    private Date todayDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss +SSS", Locale.US);
        Calendar cal = Calendar.getInstance();
        Log.i("formated", dateFormat.format(cal.getTime()));
        return cal.getTime();
    }

    private Date expDateConvert(String dat) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss +SSS", Locale.US);
        Date parsed = new Date();
        try {
            parsed = sdf.parse(dat);
        } catch (ParseException e) {

            e.printStackTrace();
        }
        return parsed;
    }

    public static String toadayforWeatherForamte() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Calendar cal = Calendar.getInstance();
        Log.i("formated", dateFormat.format(cal.getTime()));
        return dateFormat.format(cal.getTime());
    }

    public boolean dateChecker(String from, String to) {
        SimpleDateFormat fromFormat = new SimpleDateFormat("dd-MMM", Locale.US);
        Date fromDate;
        Date toDate;
        Date todayDate;
        Calendar ca = Calendar.getInstance();
        todayDate = ca.getTime();
        String temp = fromFormat.format(todayDate);
        try {
            fromDate = fromFormat.parse(from);
            toDate = fromFormat.parse(to);
            todayDate = fromFormat.parse(temp);
            if ((todayDate.compareTo(fromDate) > 0) && (todayDate.compareTo(toDate) < 0))
                return true;
        } catch (ParseException e) {

            e.printStackTrace();
        }

        return false;

    }

    public boolean dateCheckerWithYear(String from, String to) {
        SimpleDateFormat fromFormat = new SimpleDateFormat("dd/MM/yy", Locale.US);
        Date fromDate;
        Date toDate;
        Date todayDate;
        Calendar ca = Calendar.getInstance();
        todayDate = ca.getTime();
        String temp = fromFormat.format(todayDate);
        try {
            fromDate = fromFormat.parse(from);
            toDate = fromFormat.parse(to);
            todayDate = fromFormat.parse(temp);
            if ((todayDate.compareTo(fromDate) > 0) && (todayDate.compareTo(toDate) < 0))
                return true;
        } catch (ParseException e) {

            e.printStackTrace();
        }

        return false;

    }

    public static SpannableString getBoldString(String str) {
        SpannableString bold;
        if (str != null) {
            bold = new SpannableString(str);
            bold.setSpan(new StyleSpan(Typeface.BOLD), 0, str.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        } else
            bold = new SpannableString("");
        return bold;
    }

    public static SpannableStringBuilder getUnderline(String str) {
        SpannableStringBuilder bold = new SpannableStringBuilder(str);
        bold.setSpan(new UnderlineSpan(), 0, str.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return bold;
    }

    public static SpannableStringBuilder getBlueText(String str, Context c) {
        if (str != null) {
            int color = c.getResources().getColor(R.color.colorAccent);
            SpannableStringBuilder bold = new SpannableStringBuilder(str);
            bold.setSpan(new ForegroundColorSpan(color), 0, str.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            return bold;
        }
        return new SpannableStringBuilder();
    }

    public static SpannableStringBuilder getGreenText(String str, Context c) {
        int color = c.getResources().getColor(R.color.green);
        SpannableStringBuilder bold = new SpannableStringBuilder(str);
        bold.setSpan(new ForegroundColorSpan(color), 0, str.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return bold;
    }

    public static SpannableStringBuilder getRedText(String str, Context c) {
        int color = c.getResources().getColor(R.color.colorAccent);
        SpannableStringBuilder bold = new SpannableStringBuilder(getBoldString(str));
        bold.setSpan(new ForegroundColorSpan(color), 0, str.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return bold;
    }

    public static String getUsCurrency(Object val) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        return format.format(val);
    }

    @SuppressWarnings("deprecation")
    public static String getUsPhone(String str) {
        Editable editable = new SpannableStringBuilder(str);

        PhoneNumberUtils.formatNumber(editable, PhoneNumberUtils.getFormatTypeForLocale(Locale.US));
        return editable.toString();
    }

    public static String getDateInStringFormat() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return String.valueOf(year) + "-" +
                (month + 1) + "-" + day;
    }

    public static String getTimeInStringFormat() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        return updateTime(hour, min);
    }

    // Used to convert 24hr format to 12hr format with AM/PM values
    public static String updateTime(int hours, int mins) {

        String timeSet = "";
        if (hours > 12) {
            hours -= 12;
            timeSet = "PM";
        } else if (hours == 0) {
            hours += 12;
            timeSet = "AM";
        } else if (hours == 12)
            timeSet = "PM";
        else
            timeSet = "AM";
        String minutes = "";
        String _hours = "";

        if (hours < 10) {
            _hours = "0" + hours;
        } else {
            _hours = String.valueOf(hours);
        }

        if (mins < 10)
            minutes = "0" + mins;
        else
            minutes = String.valueOf(mins);

        // Append in a StringBuilder
        String aTime = new StringBuilder().append(_hours).append(':').append(minutes).append(" ").append(timeSet).toString();
        return aTime;

    }


    /**
     * Function to convert milliseconds time to
     * Timer Format
     * Hours:Minutes:Seconds
     */
    public static String milliSecondsToTimer(long milliseconds) {
        String finalTimerString = "";
        String secondsString = "";

        // Convert total duration into time
        int hours = (int) (milliseconds / (1000 * 60 * 60));
        int minutes = (int) (milliseconds % (1000 * 60 * 60)) / (1000 * 60);
        int seconds = (int) ((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);
        // Add hours if there
        if (hours > 0) {
            finalTimerString = hours + ":";
        }

        // Prepending 0 to seconds if it is one digit
        if (seconds < 10) {
            secondsString = "0" + seconds;
        } else {
            secondsString = "" + seconds;
        }

        finalTimerString = finalTimerString + minutes + ":" + secondsString;

        // return timer string
        return finalTimerString;
    }


    public static String endsInTime(Long time) {
        long millis = time - Calendar.getInstance().getTimeInMillis();
        long hour = TimeUnit.MILLISECONDS.toHours(millis);
        long minits = TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis));

        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis));


        StringBuilder stringBuilder = new StringBuilder();
        if (hour != 0) {
            stringBuilder.append(hour + " hrs ");
        }
        if (minits != 0) {
            stringBuilder.append(minits + " mins ");
        }
        if (seconds != 0) {
            stringBuilder.append(seconds + " sec ");
        }

        if (hour > 0 || minits > 0 || seconds > 0) {

            return stringBuilder.toString();
        } else {
            return "Survey Ends";
        }
    }


    public static String getMonth(int month) {
        String monthValue = null;
        if (month == 1) {
            monthValue = "Jan";
        } else if (month == 2) {
            monthValue = "Feb";
        } else if (month == 3) {
            monthValue = "Mar";
        } else if (month == 4) {
            monthValue = "Apr";
        } else if (month == 5) {
            monthValue = "May";
        } else if (month == 6) {
            monthValue = "Jun";
        } else if (month == 7) {
            monthValue = "Jul";

        } else if (month == 8) {
            monthValue = "Aug";

        } else if (month == 9) {
            monthValue = "Sep";

        } else if (month == 10) {
            monthValue = "Oct";

        } else if (month == 11) {
            monthValue = "Nov";

        } else if (month == 12) {
            monthValue = "Dec";

        }


        return monthValue;
    }


    public static String todayDD_MMM_YYYY_Formate() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }


    public static String getMode() {
        Calendar c = Calendar.getInstance();
        String mode = null;
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 0 && timeOfDay < 12) {
            mode = "Good Morning";
        } else if (timeOfDay >= 12 && timeOfDay < 16) {
            mode = "Good Afternoon";
        } else if (timeOfDay >= 16 && timeOfDay < 21) {
            mode = "Good Evening";
        } else if (timeOfDay >= 21 && timeOfDay < 24) {
            mode = "Good Night";
        }
        return mode;
    }

    public static String timeDifference(Long startDate, Long endDate) {

        //milliseconds
        long different = endDate - startDate;

        System.out.println("startDate : " + startDate);
        System.out.println("endDate : " + endDate);
        System.out.println("different : " + different);

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;

        System.out.printf(
                "%d days, %d hours, %d minutes, %d seconds%n",
                elapsedDays,
                elapsedHours, elapsedMinutes, elapsedSeconds);
        return elapsedDays + " " + elapsedHours + " " + elapsedMinutes + " " + elapsedSeconds;

    }
}