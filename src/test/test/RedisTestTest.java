package test;

import utils.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * RedisTest Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 6, 2015</pre>
 */
public class RedisTestTest {

	private RedisUtil redis=new RedisUtil();
	
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
