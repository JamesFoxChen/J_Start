package test;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import RedisDemo.RedisOperate;

/**
 * RedisTest Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 6, 2015</pre>
 */
public class RedisTestTest {

	private RedisOperate redis=new RedisOperate();
	
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
    	
        String result = redis.SimpleTest();
        org.junit.Assert.assertEquals("bar", result);
        
        System.out.println(result);
    }
} 
