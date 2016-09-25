package JavaSE;

/**
 * Created by yiyuan on 2016/9/24.
 */
public class Test {
    int i =0;
    public String replaceSpace(StringBuffer str) {
        while(str.indexOf(" ")>=0) {
            int i = str.indexOf(" ");
            str.replace(i, i + 1, "%20");
        }
        return str.toString();
    }


}