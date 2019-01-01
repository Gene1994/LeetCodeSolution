package syntax;

/**
 * @author: create by Gene1994
 * @date:2018/11/27
 */

/**
 * 方法静态分派演示
 */
public class StaticDispatch1 {
    abstract class Human{

    }

    public class Man extends Human{

    }
   public  class Woman extends Human{

    }

    public void sayHello(Human guy){
        System.out.println("hello,guy!");
    }

    public void sayHello(Man guy){
        System.out.println("hello,gentleman!");
    }

    public void sayHello(Woman guy){
        System.out.println("hello,lady!");
    }

    public void go(){
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch1 sr = new StaticDispatch1();
        sr.sayHello(man);
        sr.sayHello(woman);
    }
    public static void main(String[] args) {
        StaticDispatch1 sr = new StaticDispatch1();
        sr.go();
    }
}
