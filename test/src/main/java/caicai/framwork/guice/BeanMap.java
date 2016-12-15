package caicai.framwork.guice;

import com.google.inject.Inject;

import java.util.HashMap;

/**
 * Created by Administrator on 2016-12-9.
 */
public class BeanMap<K, V> extends HashMap<K, V> {
    private String ID;

    public BeanMap(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return ID;
    }
}
