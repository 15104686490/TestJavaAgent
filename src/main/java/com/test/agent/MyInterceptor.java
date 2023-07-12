package com.test.agent;

import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;

import java.lang.reflect.Method;

public class MyInterceptor {
    public static Object intercept(@AllArguments Object[] args, @Origin Method method) {
        System.out.println("方法调用前拦截：" + method.getName());
        // 在这里可以执行自定义的逻辑，例如修改参数、记录日志等
        Object result = "";
        System.out.println(args[0].toString());
        try {
            result = method.invoke(MyInterceptor.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("方法调用后拦截：" + method.getName());

        return result;
    }
}
