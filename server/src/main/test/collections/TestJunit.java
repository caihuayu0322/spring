package collections;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Created by Administrator on 2017-8-3.
 */
@RunWith(Parameterized.class)
public class TestJunit {

    private int a;
    private int b;
    private int c;

    public TestJunit(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /*说明使用parameterized，回根据返回的参数数量循环调用整个test类的测试用例*/
    @Parameterized.Parameters(name = "{index}:add({0} + {1})={2}")
    public static Iterable<Object[]> getdate() {
        return Arrays.asList(new Object[][]{
                {1, 1, 1},
                {1, 2, 3},
                {1, 2, 3}
        });
    }

    /*BeforeClass注释指出这是附着在静态方法必须执行一次并在类的所有测试之前。
    发生这种情况时一般是测试计算共享配置方法(如连接到数据库)*/
    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass");
    }

    /*Before注释表示，该方法必须在类中的每个测试之前执行，以便执行测试某些必要的先决条件*/
    @Before
    public void before() {
        System.out.println(1);
    }

    /*After 注释指示，该方法在执行每项测试后执行(如执行每一个测试后重置某些变量，删除临时变量等)*/
    @After
    public void after() {
        System.out.println(2);
    }

    /*当需要执行所有的测试在JUnit测试用例类后执行，AfterClass注解可以使用以清理建立方法，(从数据库如断开连接)。
    注意：附有此批注(类似于BeforeClass)的方法必须定义为静态。*/
    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass");
    }

    @Test
    public void equire() {
        System.out.println(("方法进入： a" + a));
//        Assert.assertEquals(c, a + b);
    }

    @Test
    public void test1() {
        System.out.println("test");
    }

    @Test
    public void test2() {
        System.out.println("test");
    }

}
