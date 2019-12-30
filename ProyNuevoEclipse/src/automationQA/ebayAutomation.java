package automationQA;

import org.openqa.selenium.By;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;


import org.openqa.selenium.interactions.Actions;


public class ebayAutomation {

	static class detalleProductos implements Comparable<detalleProductos>
	{
		public String nombre;
		public double precio;
		
		public detalleProductos(String nombre, double precio)
		{
			this.nombre = nombre;
			this.precio = precio;
		}
		
		@Override
		public int compareTo(detalleProductos o) {
			// TODO Auto-generated method stub
			
			if(precio<o.precio)
			{
				return -1;
			}
			if (precio>o.precio)
			{
				return 1;
			}
			return 0;
		}
	}
	
	
    public static void main(String[] args) {

	String path = System.getProperty("user.dir");
	detalleProductos[] arrayProductos = new detalleProductos[12];
	
	System.setProperty("webdriver.gecko.driver",path+"//driver//geckodriver.exe");
    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
   capabilities.setCapability("marionette", true);
   // @SuppressWarnings("deprecation")
	@SuppressWarnings("deprecation")
	WebDriver driver = new FirefoxDriver(capabilities);

	
	//WebDriver driver = new FirefoxDriver();
	//driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	String baseUrl = "https://pe.ebay.com/";
	
	//1. Ingresar a Ebay
	driver.get(baseUrl);
	
	//2. buscar Zapatos
	driver.findElement(By.id("gh-ac")).click();
	driver.findElement(By.id("gh-ac")).sendKeys("Zapatos");
	driver.findElement(By.id("gh-btn")).click();
	
	//3. Buscar por Marca PUMA
	driver.findElement(By.id("w4-w12-0[0]")).click();
	driver.findElement(By.id("w4-w12-0[0]")).sendKeys("PUMA");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.findElement(By.xpath("/html/body/div[4]/div[4]/ul/li[1]/ul/li[2]/ul/li[2]/div[2]/div[1]/ul/li[7]/div/a/div/input")).click();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
	//4. Elegir Tamaño 10
	driver.findElement(By.xpath("/html/body/div[4]/div[4]/ul/li[1]/ul/li[2]/ul/li[1]/div[2]/ul/li[5]/div/a/div/div/span[1]")).click(); // Talla 10
	
	//5. Imprimir el numero de resultado
	String valor = driver.findElement(By.xpath("/html/body/div[4]/div[5]/div[1]/div/div[2]/div/div[1]/h1/span[1]")).getText(); //Extraemos el resultado
	System.out.println("Cantidad de Zapatos: " +valor);

	//6. Ordenar precio ascendentemente
	Actions action = new Actions(driver);
	WebElement boton = driver.findElement(By.xpath("/html/body/div[4]/div[5]/div[1]/div/div[1]/div[3]/div[1]/div/button/div"));
	action.moveToElement(boton).perform();
	driver.findElement(By.xpath("/html/body/div[4]/div[5]/div[1]/div/div[1]/div[3]/div[1]/div/div/div/ul/li[4]/a")).click();
	
	
	//
	List<WebElement> zapatosDescripcion = driver.findElements(By.xpath("//div[@class='s-item__info clearfix']/a/h3"));
	List<WebElement> precioZapatos = driver.findElements(By.xpath("//div[@class='s-item__info clearfix']/div[@class='s-item__details clearfix']/div/span[@class='s-item__price']"));
	List<String> detallePrecio = new LinkedList<String>();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	System.out.println("--------------------------------------------------------------------------------------------------------------");
	System.out.println("--------------------------------------PUNTO 7 Y 8-------------------------------------------------------------");
	
	for(int i=0; i<12; i++)
	{
		System.out.println((i+1)+". " + zapatosDescripcion.get(i).getText()+"  -  "+"S/. "+precioZapatos.get(i).getText().substring(4));
		detallePrecio.add(zapatosDescripcion.get(i).getText()+"  -  "+precioZapatos.get(i).getText());
		arrayProductos[i] = new detalleProductos(zapatosDescripcion.get(i).getText(), Double.parseDouble(precioZapatos.get(i).getText().substring(4)));
	}
	
	Collections.sort(detallePrecio);
	System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
	System.out.println("----------------------------------------------9. Ordenar por nombre - Ascendente---------------------------------------------");
	for(String detp : detallePrecio)
	{	int i=0;
		System.out.println((i+1)+". "+detp);
	}
	
	System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
	System.out.println("----------------------------------------------10. Ordenar por precio - Descendente---------------------------------------------");
	
	Arrays.sort(arrayProductos);
	
    for (int i = 0; i < arrayProductos.length; i++) {
        System.out.println((i+1) + ". " + arrayProductos[i].nombre + "  -  " +"S/. " +arrayProductos[i].precio);
    }
	
    //driver.close();
    }
}
