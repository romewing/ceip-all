package com.ghca.data;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;

/**
 * Created by gh on 2017/5/15.
 */
@Component
public class TestJmsListener {

    @JmsListener(destination = "t1")
    public void listen(Message message) {
        System.out.println(message);
    }
}
