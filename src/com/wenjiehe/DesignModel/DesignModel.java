package com.wenjiehe.DesignModel;

/**
 * Created by yiyuan on 2016/9/22.
 */
public class DesignModel {

    public static void main(String args[]) {
        MallDuck mallduck = new MallDuck();
        mallduck.PerformFly();

        final MallDuck m = new MallDuck();
        m.fly = new FlyWithWings();

        //m = new MallDuck();//error
    }

}
