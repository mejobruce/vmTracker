package com.mtm.stepdefs;

import java.io.ByteArrayOutputStream;
import org.openqa.selenium.JavascriptExecutor;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.apache.logging.log4j.LogManager;
//import org.kodiak.utils.ReadConfig;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mtm.utils.RandomStringUtil;
import com.mtm.utils.ReadConfig;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
public class StepDef extends BaseClass {
	
	ReadConfig readconfig;
	RandomStringUtil rsu;
	Robot robot;
	String browser;
	static int driverInitializedFlag=0;
	@Given("I am at some place")
	public void i_am_at_some_place() {

     System.out.println("This is Given");
	}

	@When("I do some action")
	public void i_do_some_action() {
		System.out.println("This is When");
	}

	@Then("Something happens")
	public void something_happens() {
		System.out.println("This is Then");
	}

	
	
	
	@Before  
	//@BeforeClass
	public void setup1() throws AWTException {
		readconfig = new ReadConfig();
		rsu = new RandomStringUtil();
		robot = new Robot();

		// Initialize logger
		//log = LogManager.getLogger("StepDef");

		
		//System.out.println("Setup-Sanity method executed..");

		browser = readconfig.getBrowser();
		
		//String browser = "chrome";

		ChromeOptions option = new ChromeOptions();
		//option.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
		//headless argument
		//option.addArguments("--headless");

		//option.addArguments("--lang=en_US");
		
		//option.addArguments("--start-maximized");
		/*option.addArguments("--disable-gpu");
		option.addArguments("--window-size=1920,1080");
		option.addArguments("--start-maximized");
		option.addArguments("--disable-extensions");
		option.addArguments("--disable-gpu");
		option.addArguments("--no-sandbox");
		option.addArguments("--disable-dev-shm-usage");
		option.addArguments("--no-sandbox");
		option.addArguments("--disable-cache");
		option.addArguments("browser.cache.disk.enable");
		option.addArguments("browser.cache.memory.enable");
		option.addArguments("browser.cache.offline.enable");
		option.addArguments("network.http.use-cache");*/
		//option.setHeadless(true);
		
	

//	option.chrome_options.add_argument("--proxy-server='direct://'")
//	self.chrome_options.add_argument("--proxy-bypass-list=*")

//	self.chrome_options.add_argument('--ignore-certificate-errors')
//	self.browser = webdriver.Chrome(options=self.chrome_options)
if(driverInitializedFlag==0)	{	
		switch (browser.toLowerCase()) {
		case "chrome":
			//WebDriverManager.chromedriver().setup();
			WebDriverManager.chromedriver().clearDriverCache().setup();

			driver = new ChromeDriver(option);
			driver.manage().window().maximize();
			js=(JavascriptExecutor)driver;
			driverInitializedFlag=1;
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driverInitializedFlag=1;
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driverInitializedFlag=1;
			break;
		default:
			driver = null;
			break;
		}
	}
		// log.info("");
		//log.fatal("Setup1 executed...");
	}
	
	//@BeforeStep
    public void beforeStep() throws AWTException {
        System.out.println("======>  This is before step  <======");
        
		
       js.executeScript("window.scrollBy(0, 10);");
        //Do something before executing the step
    }
	
@After
public void teardown(Scenario sc) throws IOException
{
	System.out.println("Tear Down method executed..");
	 String userDirectory = System.getProperty("user.dir");
     System.out.println(userDirectory);
	String path = userDirectory+"//Shot.png";
	try {
        Thread.sleep(120);
        Robot r = new Robot();

        // It saves screenshot to desired path

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("ScreenSize : " + screenSize);

        // Used to get ScreenSize and capture image
        //Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        Rectangle capture = new Rectangle(50,50,700,700);
        BufferedImage Image = r.createScreenCapture(capture);
        ImageIO.write(Image, "png", new File(path));
        System.out.println("Screenshot saved");
    }
    catch (AWTException | IOException | InterruptedException ex) {
        System.out.println(ex);
    }
	if(sc.isFailed()==true)
	{
		//Convert web driver object to TakeScreenshot
//		String fileWithPath = "/kodiak.automation/test-output/../Screenshots/failedScreenshot.png";
	//	TakesScreenshot scrShot =((TakesScreenshot)driver);

		//Call getScreenshotAs method to create image file
	//	File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		//Move image file to new destination
	      BufferedImage bImage = ImageIO.read(new File(path));
	      ByteArrayOutputStream bos = new ByteArrayOutputStream();
	      ImageIO.write(bImage, "png", bos );
	      byte [] data = bos.toByteArray();
		
		//Copy file at destination
		final byte[] sst =path.getBytes();
		try {
			//FileUtils.copyFile(SrcFile, DestFile);
			sc.attach(data ,"image/png", sc.getName());
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}
//driver.quit();
}



}
