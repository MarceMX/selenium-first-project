package org.marnunezt;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * TODO: Complete class documentation
 *
 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
 * @since 2022-Aug-29
 */
@Slf4j
public class DataProviderDemo {
	
    @Test (dataProvider = "data")
	public void demo(Integer i, String s) {
		try {
			System.out.println(i + " " + s);
		} catch (Exception e) {
			throw new RuntimeException("Impossible instantiate class DataProviderDemo due to an internal error.", e);
		}
	}
	
	@DataProvider(name = "data")
	public Object[][] output(){
		return new Object[][]{
				{1,"aaa"},
				{2,"bbb"},
				{3,"ccc"}
		};
	}
}