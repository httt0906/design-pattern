package com.ChainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

public class Client02 {
    public static void main(String[] args) {
        Message m = new Message();
        m.setMsg("全民制作人大家好:)，我是练习时长2.5年的个人练习生蔡徐坤。喜欢唱、跳、rap、basketball。");

        List<Filter> filters = new ArrayList<Filter>();
        filters.add(new BasketBallFilter());
        filters.add(new TimeTransFilter());

        for (Filter filter : filters) {
            filter.doFilter(m);
        }

        System.out.println(m.getMsg());
    }



}


class BasketBallFilter implements Filter {

    @Override
    public void doFilter(Message m) {
        String r = m.getMsg();
        r = r.replace("basketball", "篮球");
        m.setMsg(r);
    }
}

class TimeTransFilter implements Filter {
    @Override
    public void doFilter(Message m) {
        String r = m.getMsg();
        r = r.replace("2.5年", "两年半");
        m.setMsg(r);
    }
}


interface Filter {
    void doFilter(Message m);
}
