/**
 * Created by gh on 2017/4/14.
 */
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.test1(null)
        );

    }

    public Integer test1(String str) {
        Integer i = null;
        try {
            i = 2;
            i = Integer.parseInt(str);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return i;
    }
}
