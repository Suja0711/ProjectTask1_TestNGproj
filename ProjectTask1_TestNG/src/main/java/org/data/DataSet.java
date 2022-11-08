package org.data;

import org.testng.annotations.DataProvider;

public class DataSet {
	
	@DataProvider(name="testsite")
	public Object[][] Testsite() {
		//String str = new String("https://www.snapdeal.com/");
		Object[][] obj = new Object[][] {{"https://www.snapdeal.com/","redmi 9 mobile phone"}};
		return obj;
		
	}

}
