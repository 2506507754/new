package cn.eight.homemaking.util;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DemoTest {

    @Test
    public void test(){

        DateFormat df;
        df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(df.format(0));
    }
}
