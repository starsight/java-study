import sun.rmi.runtime.Log;

/**
 * Created by yiyuan on 2016/9/24.
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("FlyWithWings");
    }
}
