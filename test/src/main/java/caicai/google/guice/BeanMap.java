package caicai.google.guice;

import com.google.inject.Inject;

import java.util.HashMap;

/**
 * Created by Administrator on 2016-12-9.
 */
public class BeanMap<K,V> extends HashMap<K,V>{

    @Inject
    public BeanMap(){
    }
}
