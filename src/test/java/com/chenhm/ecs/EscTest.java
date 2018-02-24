package com.chenhm.ecs;

import org.apache.ecs.html.Input;

import java.util.UUID;

/**
 * @author chen-hongmin
 * @since 2018/2/5 15:08
 */
public class EscTest {

    public static void main(String[] args) {
        Input input = new Input("hidden","csrf_token", UUID.randomUUID().toString());

        System.out.println(input.toString());
    }

}
