package com.ChainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

public class Client03 {
    public static void main(String[] args) {
        Message m = new Message();
        m.setMsg("大家好:),我是练习时长2.5年的唱、跳、rap、basketball选手蔡徐坤!");

        FilterChain fc = new FilterChain();
        fc.add(new BasketBallFilter());
        fc.add(new TimeTransFilter());
        // 改造: 链式add


        fc.doFilter(m);
        System.out.println(m.toString());


    }
}

class FilterChain {
    List<Filter> filters = new ArrayList<>();

    public void add(Filter filter) {
        filters.add(filter);
    }

    public void doFilter(Message m) {
        for (Filter filter : filters) {
            filter.doFilter(m);
        }
    }
}