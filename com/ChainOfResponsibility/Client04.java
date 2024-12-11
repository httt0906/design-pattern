package com.ChainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

public class Client04 {
    public static void main(String[] args) {
        Message m = new Message();
        m.setMsg("大家好:),我是练习时长2.5年的唱、跳、rap、basketball选手cxk!");

        FilterChainImprove fc = new FilterChainImprove();
        fc.add(new TimeTransFilter())
                .add(new BasketBallFilter())
                .add(new SmileFaceFilter())
                .doFilter(m);

        System.out.println(m.toString());
    }

}


class SmileFaceFilter implements Filter {

    @Override
    public void doFilter(Message message) {
        String r = message.getMsg();
        r = r.replace(":)", "*v*");
        message.setMsg(r);
    }
}


class FilterChainImprove implements Filter {
    List<Filter> filters = new ArrayList<>();

    public FilterChainImprove add(Filter filter) {
        filters.add(filter);
        return this;
    }

    public void doFilter(Message m) {
        for (Filter filter : filters) {
            filter.doFilter(m);
        }
    }
}