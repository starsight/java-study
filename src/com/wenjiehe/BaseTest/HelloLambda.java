package com.wenjiehe.BaseTest;

/**
 * Created by yiyuan on 16/11/20.
 */
public class HelloLambda {
    Runnable r1 = () -> System.out.println(this);
    Runnable r2 = () -> System.out.println(toString());

    @Override
    public String toString() {
        return "Hello, lambda!";
    }

    public static void main(String[] args) {
        //new HelloLambda().r1.run();
        //new HelloLambda().r2.run();

        Employee e1 = new Employee("hewenjie",10);
        Employee e2 = e1;
        e2.setName("e233");
        System.out.println(e1.getName());
        //Comparator.comparing()
        //ArrayList list = new ArrayList();
        //list.forEach(o -> System.out.println(o.toString()));
       // int sum  = 0;
       // list.forEach(i -> {sum += i;});
    }


}
