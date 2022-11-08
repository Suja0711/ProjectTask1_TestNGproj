package org.testing;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.data.DataSet;
import org.openqa.selenium.WebElement;
import org.pages.SnapDeal;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.utility.BaseClass;

public class SnapDealTest extends BaseClass{

	static SnapDeal sd;
	Map<String, String> productPriceData;
	@BeforeClass
	public static void beforeClass() {
		System.out.println("before  class");
		browserLaunch("chrome");		
		maximize();
		implicitWait(10);
		sd = new SnapDeal();
	}
	
	@AfterClass
	public static void afterClass() {
		quit();
		System.out.println("after class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method");
	}
	
	@AfterMethod
	public void aftrMethod() {
		System.out.println("after method");
	}
	
	@Test(dataProvider="testsite", dataProviderClass=DataSet.class)
	public void test1(String websiteAddr, String srchTxt) {
		System.out.println("test1 method");	
		urlLaunch(websiteAddr);
		sendKeys(sd.getSrchTxt(), srchTxt);
		clickBtn(sd.getSrchBtn());		
	}	
	@Test
	public void test2() {
		
	}	
	@Test
	public void test3() {
		List<WebElement> pdPrice = sd.getproductPrice();
		List<Integer> priceList = new ArrayList<Integer>();
		List<WebElement> pdList = sd.getproductList();
		productPriceData = new LinkedHashMap<String, String>();
		for(int i=0; i<pdList.size(); i++) {
			productPriceData.put(pdList.get(i).getText(), pdPrice.get(i).getText());
		}
		System.out.println("Product Price - "+pdPrice.size());
		System.out.println(" --------PRODUCTS WITH PRICE-----------");
		int temp=0;
		for(WebElement ele:pdPrice) {
			temp = Integer.parseInt(ele.getText().substring(4));
			priceList.add(temp);
		}
		Collections.sort(priceList);
		for(Map.Entry entry:productPriceData.entrySet())
		{
			System.out.println(entry.getKey()+" --->> "+entry.getValue());
		}	
		
		System.out.println("After sorting the price");
		for(Integer intv : priceList)
			System.out.println(intv);
		System.out.println("====> Minimum amount - "+priceList.get(0));
		System.out.println("====> Maximum amount - "+priceList.get(priceList.size()-1));
	}
}

