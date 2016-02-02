package test;

import org.junit.Test;

import Utils.JdbcUtil;

public class JdbcTest {

	@Test
	public void Select() {
		JdbcUtil.Select();
	}
	
	@Test
	public void Insert() {
		JdbcUtil.Insert();
	}
	
	@Test
	public void Update() {
		JdbcUtil.Update();
	}
	
	@Test
	public void Delete() {
		JdbcUtil.Delete();
	}
}
