import org.codehaus.plexus.classworlds.launcher.Launcher;
import org.junit.Test;

/**
 * Created by Administrator on 2016-12-4.
 *
 * maven 溯源
 */
public class LaucherTest {

    /**
     * maven 命令行启动
     * @param args
     */
    public static void main(String[] args) {
        Launcher.main(args);
        System.out.println(1);
    }
}
