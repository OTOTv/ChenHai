package com.hrdemo.msg;

/**
 * Created by OTOT on 2019/5/18.
 */
public class Msg {
    private int num;
    private String msg;

    public static Msg success(){
        Msg msg=new Msg();
       msg.setNum(100);
       msg.setMsg("成功！");
        return msg;
    }
    public static Msg fail(){
        Msg msg=new Msg();
        msg.setNum(200);
        msg.setMsg("失败");
        return msg;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
