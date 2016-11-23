package com.junmeng.tools.androidutils;

import com.junmeng.tools.utils.date.DateUtil;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {

       // int d=DateUtil.getBetweenDays(DateUtil.stringToDate("2016-11-24 00:00:00"));
        boolean  d=DateUtil.isCurrentDay(DateUtil.stringToDate("2016-11-23 23:00:00"));
        assertEquals(4,d);
    }


}