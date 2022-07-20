package org.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.baseclass.BaseClass;

public class LoginPage extends org.baseclass.BaseClass {

	public  LoginPage() {
		PageFactory.initElements(driver, this);
	}
	                              //@anotation -hiding location with encap setter
	@CacheLookup //repeated actions of locator
	@FindBys({ @FindBy(id="email") , @FindBy(xpath="//input[@id='email']") })                                     
  private List<WebElement> txtuser;//encapsulation setter//hiding method, variable
	
	//OR OPE-MOSTLY USED
	@FindAll({@FindBy(id="pass") , @FindBy(xpath="//input[@id='pass']") })
  private WebElement txtpass;
	
	@FindBy(name="login")
  private WebElement btnlogin;
	
	
	public List<WebElement> getTxtuser() { //encap getter to get element location
		return txtuser;
	}
	public WebElement getTxtpass() {
		return txtpass;
	}
	public WebElement getBtnlogin() {
		return btnlogin;
	}
	
	
	

	// public WebElement txtusername() {
	   
     //  WebElement txtuser =driver.findElement(By.id("email"));
	//return txtuser;
//}
	
}
