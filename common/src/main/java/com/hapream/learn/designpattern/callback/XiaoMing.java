package com.hapream.learn.designpattern.callback;

/**
 * Created by zhangyanggang on 2017/9/4.
 */
public class XiaoMing {

    private XiaoHong xiaoHong;

    public XiaoMing() {
        this.xiaoHong = new XiaoHong();
    }

    public void sum(int a, int b) {
//        System.out.println(a + " + " + b + " = " + (a + b));
//        System.out.println("Help me");
//        return xiaoHong.sum(a, b);
        xiaoHong.sum(a, b, this.new Inner());
    }


    class Inner implements CallBack {

        public void call(int result) {
            System.out.println("This answer is " + result);
        }
    }

}
