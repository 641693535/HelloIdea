package javatest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @Description
 * @create 2020-04-28 21:13
 */
interface Human{

    String getBelief();

    void eat(String food);

}

class Superman implements Human{

    @Override
    public String getBelief() {
        return "I can Fly~";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

class ProxyFactory{
    public static Object getProxyInstance(Object obj){

        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();

        myInvocationHandler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), myInvocationHandler);
    }
}
class MyInvocationHandler implements InvocationHandler{

    private Object obj;

    public void bind(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object invoke = method.invoke(obj, args);

        return invoke;


    }
}

public class ProxyTest1 {
    public static void main(String[] args) {
        Superman superman = new Superman();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superman);

        proxyInstance.eat("河南烩面");

        String belief = proxyInstance.getBelief();
        System.out.println(belief);

    }
}
