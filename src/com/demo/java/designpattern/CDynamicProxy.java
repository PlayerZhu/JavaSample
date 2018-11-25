package com.demo.java.designpattern;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: 动态代理
 * @author: maker
 * @create: 2018/11/25
 */
public class CDynamicProxy {
    @Test
    public void testDynamicProxy() {
        ProxySubject proxySubject = ProxyFactory.getInstance(ProxySubject.class);
        ISubject iSubject = proxySubject.bind(new RealSubject());
        iSubject.eat(2, "蛋炒饭");
    }
}

interface ISubject {
    public void eat(int num, String msg);
}

class RealSubject implements ISubject {
    @Override
    public void eat(int num, String msg) {
        System.out.println("吃了" + num + "份" + msg);
    }
}

class ProxyFactory {
    private ProxyFactory() {
    }

    public static <T> T getInstance(Class<?> clazz) {
        try {
            return (T) clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

class ProxySubject implements InvocationHandler {

    private ISubject target;

    public ISubject bind(ISubject target) {
        this.target = target;
        return (ISubject)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public void prepare() {
        System.out.println("准备吃饭!!!");
    }

    public void clear() {
        System.out.println("吃完了，收拾碗筷!!!");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        prepare();
        Object ret = method.invoke(this.target, args);
        clear();
        return ret;
    }
}