package cn.edu.ctbu.crm.settings;

import cn.edu.ctbu.crm.utils.DateTimeUtil;
import cn.edu.ctbu.crm.utils.MD5Util;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
    @Test
    public void test1(){
        String expireTime = "2021-03-10 20:19:25";
        /*Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = sdf.format(date);*/
        /*String now = DateTimeUtil.getSysTime();
        System.out.println(expireTime.compareTo(now));*/

        String pwd = "7383923336zbwl";
        pwd = MD5Util.getMD5(pwd);
        System.out.println(pwd);
    }
}
