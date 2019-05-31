package com.ssm.dao;

import java.util.HashMap;
import java.util.Map;

public class Msg {


    private int status;
    private String msg;
    private Map<String,Object> map=new HashMap<>();



    public static Msg  success(){
    Msg msg = new Msg();
    msg.setStatus(200);
    msg.setMsg("处理成功！");
    return msg;

}


    public static Msg  fail(){
        Msg msg = new Msg();
        msg.setStatus(500);
        msg.setMsg("处理失败！");
        return msg;
    }


   public  Msg add(String s,Object o){
    this.getMap().put(s,o);
    return this;
   }


    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }


}
