
import junit.framework.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * RedisTest Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÎåÔÂ 6, 2015</pre>
 */
public class RedisTestTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: Simple()
     */
    @Test
    public void testSimple() throws Exception {
        String result = RedisTest.Simple();
        org.junit.Assert.assertEquals("bar", result);

    }


} 
