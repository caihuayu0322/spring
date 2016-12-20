package caicai.framework.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Created by Administrator on 2016-12-9.
 */
public class Test {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BeanModule());
        System.out.println(injector.getInstance(IBean.class));
    }
}
