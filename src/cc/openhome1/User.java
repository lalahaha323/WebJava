package cc.openhome1;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("欢迎使用对象绑定监听器");
    }
    public void valueUnbound(HttpSessionBindingEvent event) {

    }
}