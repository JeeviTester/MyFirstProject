package org.baseclass;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

//-user defined class-
public class BaseClass { //also k.as helper class, parent class, utility class,functional library
      
	public static WebDriver driver;//Declared as Global variable// MENTION STATIC AS METHOS IS STATIC

//CHROME LAUNCH
	public static WebDriver chromeLaunch() {
// static-can call in diff package & class using "EXTENDS"
//if used "EXTENDS" can call method directly without creating objt
//CHROME LAUNCH		
		WebDriverManager.chromedriver().setup();
//Create object then only browser will open 
	    driver =new ChromeDriver();
		return driver;//want return type. So, set method instead of void
	}
	
	//instant A.K.aS Global variable
	
//EDGE LAUNCH
	public static WebDriver edgeLaunch() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		 return driver;
	}
	
//SWITCH CASE TO LAUNCH BROWSER	
	public static void browserlaunch(String browsername) {
		
		switch(browsername) {//switch case switch to exact particular browser when we calling. not like loop
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			
		case"edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		}
}
//URL LAUNCH	
	public static void urlLaunch(String url) {
		driver.get(url);
	}
//IMPLICIT WAIT	
	public static void impWait(int sec) {//byte & short cannot passed as parameter
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
    }
//id, name, xpath, tagname
//	public static void elementPathId(String elementpath) {
//		driver.findElement(By.id(elementpath));
//		
//	}
//		public static void elementPathName(String elementpath) {
//		driver.findElement(By.name(elementpath));
//	}
//		
//		public static void elementPathXpath(String elementpath) {	
//		driver.findElement(By.xpath(elementpath));
//	}
//		public static void elementPathTagName(String elementpath) {
//		driver.findElement(By.tagName(elementpath));
//    }
//FIND ELEMENTS
		public static void findElements(String id, int index, String Data) {
        List<WebElement> lists = driver.findElements(By.id(id));
        WebElement we = lists.get(index);
        we.sendKeys(Data);
		}
		public static void findElements(String id, int index) {
	        List<WebElement> lists = driver.findElements(By.id(id));
	        WebElement we = lists.get(index);
	        we.click();
		}
//SENDKEYS
	    public static void sendkeys(WebElement txtuser, String data) {
	    txtuser.sendKeys(data);
    }
//CLICK
		public static void click(WebElement e) {
			e.click();
    }
//GET TITLE
		public static String gettitle() {
			 String title = driver.getTitle();
			return title;
    }
//GETCURRENT URL
		public static String getcurrenturl() {
			String url=driver.getCurrentUrl();
			return url;
    }
//QUIT
	public static void quit() {
		driver.quit();
    }
//GETATTRIBUTE
	public static String getAttribute(WebElement e) {
		String a=e.getAttribute("value");
		return a;
	}
//GET TEXT: doubt
	public static String gettext(WebElement we,String WebElementxpath) {
		//WebElement e=driver.findElement(By.xpath(WebElementxpath));
		String s= we.getText();
		return s;
	}
//ACTIONS
	//1.DRAG AND DROP
	public static void dragAndDrop(WebElement from, WebElement to) {
		Actions a=new Actions(driver);
		a.dragAndDrop(from, to).perform();
    }
	//2.MOVE TO ELEMENT
	public static void movetoElement(WebElement move) {
		Actions a=new Actions(driver);
		a.moveToElement(move).perform();
   }
	//3.CLICK AND HOLD
	public static void clickAndHold(WebElement from, WebElement to) {
		Actions a=new Actions(driver);
		a.clickAndHold(from).release(to).perform();
	}
//ALERT	
  //1.SIMPLE ALERT
	public static void simpleAlert() {
		Alert a = driver.switchTo().alert();
	    a.accept();
    }
   //2.CONFIRM ALERT
	public static void confirmAlert() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
		a.accept();
	}
  //3.PROMPT ALERT
	public static void promptAlert(String data) {
		Alert prompt = driver.switchTo().alert();
		prompt.sendKeys(data);
		prompt.accept();
	}
  //4.GET TEXT ALERT
	public static void getTextAlert() {
		Alert a = driver.switchTo().alert();
        a.getText();
	}
//DROP DOWN 
	//1.SELECT BY INDEX
	public static void seletByIndex(WebElement e, int index) {
		Select s =new Select(e);
		s.selectByIndex(index);
   }
  //2.SELECT BY VALUE
	public static void selectByValue(WebElement refname, String value) {
		Select s=new Select(refname);
		s.selectByValue(value);
   }
  //3.SELECT BY VISIBLE TEXT
	public static void selectByVisibleText(WebElement refname, String visibletext) {
    Select s =new Select(refname);
    s.selectByVisibleText(visibletext);
	}
  //4.DESELECT ALL
	public static void deselectAll(WebElement e) {
    Select s=new Select(e);
    s.deselectAll();
	}
  //5.DESELECT BY INDEX
	public static void deselectByIndex(WebElement e, int index) {
		Select s=new Select(e);
		s.deselectByIndex(index);
	}
  //6.DESELCT BY VALUE
	public static void deselectByValue(WebElement e, String value) {
		Select s=new Select(e);
		s.deselectByValue(value);
	}
  //7.DESELCT BY VISIBEL TEXT
	public static void deselectByVisibleText(WebElement e, String visibletext) {
		Select s=new Select(e);
		s.deselectByVisibleText(visibletext);
	}
  //8.GET OPTIONS
	public static void getOptions(WebElement e, int index) {
		Select s=new Select(e);
		List<WebElement> options = s.getOptions();
		WebElement we = options.get(index);
		String text = we.getText();
	}
  //9.GETALL SELECTED OPTIONS
	public static void getAllSelectedOptions(WebElement e) {
		Select s=new Select(e);
		s.getAllSelectedOptions();
	}
  //10.GETFIRST SELECTED OPTION
	public static void getFirstSelectedOption(WebElement e) {
		Select s=new Select(e);
		s.getFirstSelectedOption();
	}
  //11.IS MULTIPLE
	public static void isMultiple(WebElement e) {
		Select s=new Select(e);
		boolean ismultiple = s.isMultiple();
	}
//FRAMES
	//1.intINDEX
	public static void switchIntoFrames(int index) {
		driver.switchTo().frame(index);
	}
	//2.string ID
	public static void switchIntoFramesbyid(String id) {
		driver.switchTo().frame(id);
    }
	//3.string NAME
	public static void switchIntoFrames(String name) {
		driver.switchTo().frame(name);
    }
	//4.by webElement
	public static void switchIntoFrames(WebElement element) {
		driver.switchTo().frame(element);
    }
	//5.SWITCH TO PARENT FRAME
	public static void switchToParentFrame() {
		driver.switchTo().parentFrame();
    }
	//6.SWITCH TO DEFAULT CONTENT
	public static void defaultContent() {
      driver.switchTo().defaultContent();
	}
//SCREENSHOT 
	public static void getScreenShotsAs(String name) throws IOException {
		String  FileLocation = System.getProperty("user.dir");
		
     TakesScreenshot tk=(TakesScreenshot)driver;
     File srcFile=tk.getScreenshotAs(OutputType.FILE);
   
     File destFile =new File(FileLocation+"\\src\\tst\\resources"+name+".png");
     FileUtils.copyFile(srcFile, destFile);
	}
//JS EXECUTOR	
	//SET ATTRIBUTE
	public static void jsSetAttributeuser(String data, WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
	   js.executeScript("arguments[0].setAttribute('value', '"+data+"')",e);
	}
	
	public static void jsSetAttributepass(String pass, WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//driver.findElement(By.xpath(path));
        js.executeScript("arguments[0].setAttribute('value', '"+pass+"')",e);
	} 
	//CLICK 
       public static void BtnClick(Object clikbtn) {
    JavascriptExecutor js=(JavascriptExecutor)driver;
   // driver.findElement(By.name(e));
    js.executeScript("arguments[0].click()", clikbtn);
    }
	//GET ATTRIBUTE
	public static String jsGetAttribute( WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Object executeScript = js.executeScript("return arguments[0].getAttribute('value')",e);
		String s = executeScript.toString();
		return s;
	}
	
	
// WINDOWHANDLE
	//ENHANCED FOR LOOP
	public static void WindowHandleID( int index) {
		String onewindow =  driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
         
         for(String eachwindow :allwindows) {
        	 int count =0;
		 if(count==index ) {
				driver.switchTo().window(eachwindow);
			}
			count=count+1;
         }
	}
	// WAYTO SWITCHTO WINDOW SET ,LIST
	public static void WindowHandleIdByList(int index) {
		String onewindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
         List<String> list =    new ArrayList<>();
	    list.addAll(allwindows);
	    driver.switchTo().window(list.get(index));
	}
//NAVIGATION 
	//ISDISPLAYED ID
	public static boolean isDisplayedById(WebElement e,String path) {
           driver.findElement(By.id(path));
           boolean displayed = e.isDisplayed();
		return displayed;
	}
	//ISDISPLAYED name
	public static boolean isDisplayed(WebElement e,String path) {
        driver.findElement(By.name(path));
        boolean displayed = e.isDisplayed();
		return displayed;
	}
	//IS ENABLED
	public static boolean isEnable(WebElement e,String path) {
        driver.findElement(By.xpath(path));
        boolean enabled = e.isEnabled();
        e.click();
        return enabled;
	}
	//IS SELECTED
	public static boolean isSelected(WebElement e,String path){
        driver.findElement(By.xpath(path));
        boolean displayed = e.isSelected();
		return displayed;
	}
	
//GO BACK
	public static void goBack() {
		driver.navigate().back();
    }
//GO FORWARD
	public static void goforward() {
		driver.navigate().forward();
    }
//REFRESH THE PAGE
	public static void refreshPage() {
		driver.navigate().refresh();
    } 
	    
	//53 METHODS 




	
}
