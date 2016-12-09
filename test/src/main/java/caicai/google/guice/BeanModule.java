package caicai.google.guice;

import com.google.inject.AbstractModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016-12-9.
 */
public class BeanModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IBean.class).to(Bean.class);
        /*即使bind List to beanname 但是List<String>就是找不到实现类BeanName<String>*/
        bind(List.class).to(BeanName.class);
        bind(Map.class).to(BeanMap.class);
    }
}
