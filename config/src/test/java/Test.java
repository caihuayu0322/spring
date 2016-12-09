/**
 * Created by Administrator on 2016-12-8.
 */
public class Test {

    public static <T, Q> void test(ITest<T> a, Class<Q> b) {
        System.out.println(a);
    }

    public static void main(String[] args) {
//        Test.<Object,Object>test(new ITest<Object>() {
//        },ITest<Object>.class);


        long a = 4294967295L;
        System.out.println(a);
    }
}
