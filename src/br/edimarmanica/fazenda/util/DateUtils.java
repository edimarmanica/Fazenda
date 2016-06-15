/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author edimar
 */
public class DateUtils {

    public static int getYears(Date dob) {
        Calendar dateOfBirth = new GregorianCalendar();
        dateOfBirth.setTime(dob);
        Calendar today = Calendar.getInstance();
        int years = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
        dateOfBirth.add(Calendar.YEAR, years);
        if (today.before(dateOfBirth)) {
            years--;
        }
        return years;
    }

    public static int getMonths(Date dob) {
        Calendar dateOfBirth = new GregorianCalendar();
        dateOfBirth.setTime(dob);
        Calendar today = Calendar.getInstance();
        int months = today.get(Calendar.MONTH) - dateOfBirth.get(Calendar.MONTH);

        if (months >= 0) {
            return months;
        } else {
            return months + 12;
        }
    }

    public static Date addDays(Date date, int year, int month, int day, boolean greaterThanToday) {
        if (date == null){
            return null;
        }
        
        Calendar newDate = new GregorianCalendar();
        newDate.setTime(date);
        newDate.add(Calendar.YEAR, year);
        newDate.add(Calendar.MONTH, month);
        newDate.add(Calendar.DAY_OF_MONTH, day);

        if (greaterThanToday) {
            if (newDate.after(new GregorianCalendar())) {
                return newDate.getTime();
            }
        }
        return null;
    }
}
