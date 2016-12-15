package caicai.framwork.guice;

import com.google.inject.Inject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016-12-9.
 */
public class Bean implements IBean{

    private List<String> name;
    private Map<String,Object> value;

    @Inject
    public Bean(List name,HashMap<String,Object> value){
        this.name = name;
        this.value = value;
    }
}
