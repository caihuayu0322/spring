package caicai.framwork.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.name.Names;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016-12-9.
 */
public class BeanModule extends AbstractModule {

    /**
     * DI的主要问题在于找到对应关系，一个引用究竟要被注入什么样的实现类是个问题
     * 1 标记要被注入的字段，方法(方法一定是被注入参数),构造方法，
     * 2 第二找到实现类，怎么找到实现类？
     * a 用户指定 问题是一个对象可以有很多实现类，怎么区分需要使用不同的实现类？guice和spring实现思路类似
     * 用户为一个被注入的对象指定name等唯一标示符;怎么创建？单例还是prototype?guice默认是prototype
     * b 自动判定，其实这点很简单，注入的必定为实现类，合并让用户手动绑定？减少使用者代码、操作才能通用
     *
     * 3 实例化并注入
     * a 怎么注入？构造方法还是？
     *
     */
    @Override
    protected void configure() {
        bind(IBean.class).to(Bean.class);
        /*即使bind List to beanname 但是List<String>就是找不到实现类BeanName<String>*/
        bind(List.class).to(BeanName.class);
        //限定使用注解为bean的实现类
        bind(HashMap.class).annotatedWith(Names.named("bean")).to(BeanMap.class).in(Scopes.SINGLETON);
    }

    @Provides
    private BeanMap getBeanMap(){
        return new BeanMap("testProvides");
    }
}
