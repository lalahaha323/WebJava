package cc.openhome1;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {
    private String name;
    private String data;
    public User(String name) {
        this.name = name;
    }
    public void valueBound(HttpSessionBindingEvent event) {
        //this.data = name + " 来自数据库的东西";
        System.out.println("这是你数据库的东西");
    }
    public void valueUnbound(HttpSessionBindingEvent event) {

    }
}