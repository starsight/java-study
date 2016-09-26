package com.wenjiehe.DesignModel;

/**
 * Created by yiyuan on 2016/9/24.
 */
public abstract class Duck {
    FlyBehavior fly;

    public void PerformFly(){
    fly.fly();
    }
}
