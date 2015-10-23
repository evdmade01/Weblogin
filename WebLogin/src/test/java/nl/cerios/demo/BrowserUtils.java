package nl.cerios.demo;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import settings.PrestashopAdminTestSettings;


public class BrowserUtils {

	private static WebDriver webDriver = null;
	private static boolean shutdownHookEnabled = false;

	public static WebDriver getWebDriver() {
		if(webDriver == null) {
			if(!shutdownHookEnabled) {
				Runtime.getRuntime().addShutdownHook(new Thread() {
			         public void run() {
			        	 close();
			         }				
				});
				shutdownHookEnabled = true;
			}
			/*
			 * Vervang dit eventueel door een browser naar keuze.
			*/
			// FF
//			File pathToBinary = new File(PrestashopAdminTestSettings.FF_Path);
//			FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
//			FirefoxProfile firefoxProfile = new FirefoxProfile();
//			webDriver = new FirefoxDriver(ffBinary,firefoxProfile);
			
//			FirefoxProfile profile = new FirefoxProfile();
//			profile.setPreference("network.proxy.type", 1);
//			profile.setPreference("network.proxy.http", "srv0220.business.finl.fortis");
//			profile.setPreference("network.proxy.http_port", 8080);
			

			// IE with proxy settings
/*			String PROXY = "srv0220.business.finl.fortis:8080";

			org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
			proxy.setHttpProxy(PROXY)
			     .setFtpProxy(PROXY)
			     .setSslProxy(PROXY);
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(CapabilityType.PROXY, proxy);
			
			webDriver = new InternetExplorerDriver(cap);
*/
			// default IE
//			File pathToBinary = new File(PrestashopAdminTestSettings.IE_Path);
//			System.setProperty("webdriver.ie.driver", pathToBinary.getAbsolutePath());
//			webDriver = new InternetExplorerDriver();
			
			// Chrome driver32
			File pathToBinary = new File(PrestashopAdminTestSettings.Chrome_Path);
			System.setProperty("webdriver.chrome.driver", pathToBinary.getAbsolutePath());
			webDriver = new ChromeDriver();

		}
		
		/* Stel een timeout in die aangeeft hoe lang de webDriver moet blijven proberen om een element
		 * dat op de pagina aanwezig zou moeten zijn te selecteren.
		 */
		webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		return webDriver;
	} 
	
	public static void close() {
		if(webDriver != null) {
			webDriver.quit();
			webDriver = null;
		}
	}
	

}
