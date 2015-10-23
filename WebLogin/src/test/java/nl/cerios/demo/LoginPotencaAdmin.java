package nl.cerios.demo;


import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;

public class LoginPotencaAdmin {

	private String baseUrl = "http://www.potenca.nl/webshop/dnvvwdxhgasap4j3";


	@Als("^ik Potencashop open$")
	public void ik_Potencashop_open() throws Throwable {
		BrowserUtils.getWebDriver().get(baseUrl);
	}

	@Als("^email \"([^\"]*)\" intyp$")
	public void email_intyp(String email) throws Throwable {
		BrowserUtils.getWebDriver().findElement(By.id("email")).clear();
		BrowserUtils.getWebDriver().findElement(By.id("email")).sendKeys(email);
	}

	@Als("^password \"([^\"]*)\" intyp$")
	public void password_intyp(String password) throws Throwable {
		BrowserUtils.getWebDriver().findElement(By.id("passwd")).clear();
		BrowserUtils.getWebDriver().findElement(By.id("passwd")).sendKeys(password);
	}

	@Als("^op de inloggenbutton klik$")
	public void op_de_inloggenbutton_klik() throws Throwable {
		BrowserUtils.getWebDriver().findElement(By.name("submitLogin")).click();
	}

	@Dan("^is adminpagina zichtbaar$")
	public void is_adminpagina_zichtbaar() throws Throwable {
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.cssSelector("a.employee_name.dropdown-toggle > span.string-long"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	}
	
	private boolean isElementPresent(By by) 
	{
	    try {
	      BrowserUtils.getWebDriver().findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	 }
}
