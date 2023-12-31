package com.naveenautomationlabs.AutomationFramework.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.BeforeClass;

import com.naveenautomationlabs.AutomationFramework.Listeners.WebdriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
public static WebDriver wd;
	private FileInputStream fileInputStream;
	private Properties prop;
	public static Logger logger;
	private WebdriverEvents events;
	private WebDriverEventListener eventListener;
	private EventFiringWebDriver eDriver;

	public TestBase() {
		prop = new 	Properties();
		try {
			fileInputStream = new FileInputStream(
					"./src\\main\\java\\com\\naveenautomationlabs\\AutomationFramework\\Config\\Config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@BeforeClass
	public void setUpLogger() {
		logger =Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);
		}

	public void intialisation() {
		//create method return a instance of webDriver:
		String browserName = prop.getProperty("browser");
		switch (browserName) {
		case "chrome":
			wd=WebDriverManager.chromedriver().create();
			break;
		case "Edge":
			wd = new EdgeDriver();
			wd=WebDriverManager.edgedriver().create();
			break;

		case "FireFox":
			wd = new FirefoxDriver();
			wd=WebDriverManager.firefoxdriver().create();
			break;
		default:
			System.out.println("Not a valid browser name:");
			break;
		}
		
		eDriver = new EventFiringWebDriver(wd);
		events= new  WebdriverEvents();
		eDriver.register(events);
		wd = eDriver;
		
		wd.get(prop.getProperty("URL"));
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("Implicit_Wait")), TimeUnit.SECONDS);
	}
	public void tearDown() {
		wd.quit();
	}

}
