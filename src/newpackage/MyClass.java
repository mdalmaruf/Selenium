package newpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MyClass {
	public static void main(String[] args) {
        // declaration and instantiation of objects/variables
    
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    	
		
		//1st case----------------------
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        
        
        //2nd case----------------------
        String baseUrl2 = "http://www.facebook.com";
        String tagName = "";
        
        driver.get(baseUrl2);
        tagName = driver.findElement(By.id("email")).getTagName();
        System.out.println(tagName);
        
                
        
        //3rd case----------------------
        driver.get("http://demo.guru99.com/selenium/deprecated.html");
        driver.switchTo().frame("classFrame");
        driver.findElement(By.linkText("Deprecated")).click();
        
       
        //4th case----------------------        
        String alertMessage = "";

        driver.get("http://jsbin.com/usidix/1");
        driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();
        alertMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
       
        System.out.println(alertMessage);
        
        
        //5th case---------------------- 
     
        // (1) Go to a page
        driver.get("http://www.google.com");
        // (2) Locate an element
        WebElement element = driver.findElement(By.name("q"));
        // (3-1) Enter something to search for
        element.sendKeys("Ontario Tech Univeristy");
        // (3-2) Now submit the form. WebDriver will find the form for us from the element
        element.submit();
        // (3-3) Wait up to 10 seconds for a condition
        WebDriverWait waiting = new WebDriverWait(driver, 10);
        waiting.until( ExpectedConditions.presenceOfElementLocated( By.id("pnnext") ) );
        // (4) Check the title of the page
        if( driver.getTitle().equals("Ontario Tech Univeristy - Google Search") )
            System.out.println("PASS");
        else
            System.err.println("FAIL");

        
       
        //close chrome 
       driver.close();
       
    }
	
	
}
