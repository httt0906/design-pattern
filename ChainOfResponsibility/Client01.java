package ChainOfResponsibility;

public class Client01 {
    public static void main(String[] args) {
        Message m = new Message();
        m.setMsg("全民制作人大家好:)，我是练习时长2.5年的个人练习生蔡徐坤。喜欢唱、跳、rap、basketball。");

        String r = m.getMsg();
        r = r.replace("2.5年", "两年半");
        r = r.replace("basketball", "篮球");
        System.out.println(r);

        // 1. 这个过滤是写死的 我们可能会有更多的过滤规则 如何扩展

    }
}
