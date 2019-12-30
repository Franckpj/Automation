package nuevoPaquete;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.WebDriver
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.JavascriptExecutor;

public class PrimeraClass {

//String user;
//String password;

    public static void main(String[] args) {
		
		String path = System.getProperty("user.dir");
		//System.setProperty("webdriver.ie.driver", path+"//driver//IEDriverServerX64.exe");
		System.setProperty("webdriver.firefox.marionette", path+"//driver//geckodriver.exe");

		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
        String baseUrl = "http://oamul.entel.pe/oam/server/osso_login?Site2pstoreToken=v3.0~35FDC56AB25DA76F77~922796860D09BCC1FC2C51B307657B83~7A85C75187C7B7590E808C12634C1BABD425544ADD0CFCFA402F3D97E0C0BC212F547BC9144FF42DF77975944EFCE1240429E2303D2B5512802BCC37D36AC5254D545F31C3C83D38C757019936256DEC550EBD188B5A60F4164368980749973C11DB3B4AFF5BDEC1D904B8DE0F66B5ED4A3A220DF3CE62A74A7CDB5924ABFCF64C8F40717063D18799DD2034C2CE00DDB93E1313FDBF95EBD6B0C444B9E245D967A7FDA9AEDFD822A9E54E777792CBD7AED0147FB87F1D02CEF437A5962240305BC455DFAF9ECD36B7982AD06BF51F58646A234A5B34EC0A205A6962BA9F263394521429D6B6B938A1244B7216D12A624AB61B85AC013DFBE7C594A4D4252E408CE15CC9BC34DBD23BF4BB0E1B7A7A45CBCA5817B770822E1F6D499431D2310954FCEFCEF282CEDBA277632C078EE7DC0C08FA24379886C5661DD0D4A183BB0FCCAF026833920C66895A2D4A76CA3359C40455AD79805D1CF8C18F18DED5D576BC4190112581C9692F20F5CC3392BB7E";
        String expectedTitle = "Portal Nextel";
        String actualTitle = "";
        

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        
       // WebElement user  = driver.findElement(By.name("username"));
        //  WebElement password  = driver.findElement(By.name("password"));
        // WebElement login = driver.findElement (By.id("submit"));							

        
        driver.findElement(By.name("username")).sendKeys("994001310");
        driver.findElement(By.name("password")).click();//sendKeys("123456");
        driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[1]/table[2]/tbody/tr/td/form/table/tbody/tr[6]/td/input")).click();
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
		
		
		if (actualTitle.contentEquals(expectedTitle))
		{
			System.out.print("Muy Bien!!!");
		}
		else
		{
	        driver.findElement(By.name("username")).sendKeys("994001310");
	        driver.findElement(By.name("password")).click();//sendKeys("123456");
	        driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[1]/table[2]/tbody/tr/td/form/table/tbody/tr[6]/td/input")).click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
        //driver.findElement(By.id("Submit")).click();
       Select aplicacion = new Select (driver.findElement(By.name("rol")));
       aplicacion.selectByVisibleText("Atención al Cliente");
       //driver.findElement(By.cssSelector("font:contains('Compañía')")).click();
      // driver.findElement(By.className("clsTable")).findElement(By.id("tlbMenu")).
       driver.findElement(By.xpath("//td[@text()='Compañía']")).click();
        	
       
       

 
        //close Fire fox
        //driver.close();
       
    }

}