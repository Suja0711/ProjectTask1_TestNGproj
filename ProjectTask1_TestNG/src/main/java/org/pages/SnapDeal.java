package org.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.BaseClass;

public class SnapDeal extends BaseClass{
	public SnapDeal() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="inputValEnter")
	private WebElement srchTxt;
	
	@FindBy(xpath="//span[text()='Search']")
	private WebElement srchBtn;

	@FindBy(xpath="//p[@class='product-title']")
	private List<WebElement> productList;
	
	@FindBy(xpath="//span[contains(@class,'product-price')]")
	private List<WebElement> productPrice;
	
	public WebElement getSrchTxt() {
		return srchTxt;
	}

	public WebElement getSrchBtn() {
		return srchBtn;
	}
	
	public List<WebElement> getproductList() {
		return productList;
	}
	
	public List<WebElement> getproductPrice(){
		return productPrice;
	}
	
}
