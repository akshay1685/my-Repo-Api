package basics_of_Automation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Try 
{
	static LocalDate equalsdate;
	static LocalDate currentdate;
	static LocalDate check_date;
	static WebDriver driver;
	static String day;
  public static void main(String[] args) throws InterruptedException, IOException
  {
		System.setProperty("webdriver.chrome.driver","D:\\Selenium java akki\\Automation\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
		ReadWrite_try_pass.read_excel("D:\\Selenium java akki\\Automation\\try_pass.xlsx",0);
		String [][] dat=ReadWrite_try_pass.data();
		int row= dat.length;
		driver.get("http://10.206.39.245/nebula/tester");	
   for(int j=0;j<row;j++)
	{
		System.out.println("new page "+ driver.getTitle());
		System.out.println("Username "+dat[j][0]+" Pass "+dat[j][1]);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(dat[j][0]);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(dat[j][1]);
		   Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		
		Thread.sleep(4000);
		System.out.println(" here new page "+ driver.getTitle());
	if(driver.getTitle().equalsIgnoreCase("Nebula - Effort tracker"))
	{
	    String check= driver.findElement(By.xpath("//table[@id='myTable']/tbody/tr[1]/td[1]")).getText(); 
		
	   System.out.println("string date is "+ check);
        check_date = LocalDate.parse(check);
       // check_date =LocalDate.of(2019,9,11);
	    System.out.println("string date is "+ check_date);
	    String currentday=String.valueOf(check_date.getDayOfWeek());
	    System.out.println(currentday);
		currentdate = LocalDate.now();
		if(check_date.equals(currentdate))
		{
		    System.out.println(check_date+" = "+currentdate +" \n system is uptodate");
		}
		else 
		{
		    for(int i=1;i<=30;i++)
		    {
			    equalsdate = check_date.plusDays(i);
			    day=String.valueOf(equalsdate.getDayOfWeek());
			    System.out.println(day);
			    if(!(day.equalsIgnoreCase("Saturday") || day.equalsIgnoreCase("Sunday")))
			    {
			    	if(equalsdate.equals(currentdate))
					{
					    System.out.println("equal so goto method today");
					   Thread.sleep(2000);
					   today();
					driver.get("http://10.206.39.245/nebula/tester");
					   Thread.sleep(4000);
					    break;
					}
		    	System.out.println("getmonth "+equalsdate.getMonth());
		    	System.out.println("getDayOfMonth "+equalsdate.getDayOfMonth());
			    update();
			    }
		     }
		}
		driver.findElement(By.xpath("//img[@src='images/icon/game.png']")).click();
		   Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();
		ReadWrite_try_pass.write("Passed");
		System.out.println("passesss ");
	}
	else
	{
		ReadWrite_try_pass.write("Failed");
     	System.out.println("\n failed");
	}
	}
	
		driver.quit();
		
   }
	
public static void today() throws InterruptedException
	{
	Thread.sleep(2000);
	driver.findElement(By.xpath("//ul[@class='list-unstyled navbar__list']/li[2]/a[1]")).click();
	Thread.sleep(2000);
	
	if(day.equalsIgnoreCase("tuesday")||day.equalsIgnoreCase("thursday"))
	{
	WebElement select1= driver.findElement(By.name("feature_tasks_name"));
	Select feature1= new Select(select1);
	feature1.selectByValue("Just Dance 2017");	
	driver.findElement(By.name("feature_duration")).sendKeys("120");
	driver.findElement(By.name("save")).click();
	Thread.sleep(1000);

	WebElement select2= driver.findElement(By.name("feature_tasks_name"));
	Select feature2= new Select(select2);
	feature2.selectByValue("Just Dance 2019");	
	driver.findElement(By.name("feature_duration")).sendKeys("120");
	driver.findElement(By.name("save")).click();
	Thread.sleep(1000);

	WebElement select3= driver.findElement(By.name("feature_tasks_name"));
	Select feature3= new Select(select3);
	feature3.selectByValue("Just Dance 2020 [Live/UAT]");
	driver.findElement(By.name("feature_duration")).sendKeys("120");
	driver.findElement(By.name("save")).click();
	}
	else
	{
	WebElement select1= driver.findElement(By.name("feature_tasks_name"));
	Select feature1= new Select(select1);
	feature1.selectByValue("Just Dance 2018");	
	driver.findElement(By.name("feature_duration")).sendKeys("120");
	driver.findElement(By.name("save")).click();
	Thread.sleep(1000);

	WebElement select2= driver.findElement(By.name("feature_tasks_name"));
	Select feature2= new Select(select2);
	feature2.selectByValue("Just Dance 2019");	
	driver.findElement(By.name("feature_duration")).sendKeys("120");
	driver.findElement(By.name("save")).click();
	Thread.sleep(1000);

	WebElement select3= driver.findElement(By.name("feature_tasks_name"));
	Select feature3= new Select(select3);
	feature3.selectByValue("Just Dance 2020 [Live/UAT]");
	driver.findElement(By.name("feature_duration")).sendKeys("120");
	driver.findElement(By.name("save")).click();
	}
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[@class='fa fa-arrow-right']")).click();
	WebElement select= driver.findElement(By.xpath("//select[@name='day_status']"));
	Select s= new Select(select);
	Thread.sleep(1000);
	s.selectByValue("full_day");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='num2']")).sendKeys(random(20,10));//Team effort per Generic Tasks
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='num3']")).sendKeys(random(30,20));//Team Meetings
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='num4']")).sendKeys("");//Trainings
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='num5']")).sendKeys("");//Brainstorming Sessions
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='num6']")).sendKeys("");//HR Sessions
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='num7']")).sendKeys(random(30,10));//Reports
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='num8']")).sendKeys(random(30,10));//Jira
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='num9']")).sendKeys("");//Communication & Collaboration
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='num10']")).sendKeys(random(20,10));//Task Preparation
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='num11']")).sendKeys("");//Transversal Activities
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='num12']")).sendKeys("");//Downtime (Build downloads & Installations)
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='num13']")).sendKeys("");//Troubleshooting
	String totaltext=driver.findElement(By.xpath("//p[@id='result']")).getText();
	String[] totalint=totaltext.split("\\s");
	int total=Integer.parseInt( totalint[0]);
	System.out.println(total);
				if(total>=450)
				{
				Thread.sleep(1000);
				 driver.findElement(By.xpath("//input[@id='submitbutton']")).click();
				System.out.println("exicuted");
				}
				else
				{
					driver.navigate().back();
					today();
				}
			}
		
public static void update() throws InterruptedException
			{
				System.out.println("inside update "+equalsdate);

				String month=String.valueOf(equalsdate.getMonth());
				String date = String.valueOf(equalsdate.getDayOfMonth());
				Thread.sleep(1000);
				driver.findElement(By.xpath("//ul[@class='list-unstyled navbar__list']/li[3]/a[@class='js-arrow' and 1]")).click();
				System.out.println("inside update "+equalsdate);

				System.out.println("inside Update "+month+" date is "+date);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@type='date']")).sendKeys(date+month+Keys.ARROW_RIGHT+"2019");

				if(day.equalsIgnoreCase("tuesday")||day.equalsIgnoreCase("thursday"))
				{
				WebElement select1= driver.findElement(By.name("feature_tasks_name"));
				Select feature1= new Select(select1);
				feature1.selectByValue("Just Dance 2017");	
				driver.findElement(By.name("feature_duration")).sendKeys("120");
				driver.findElement(By.name("save")).click();
				Thread.sleep(1000);
				WebElement select2= driver.findElement(By.name("feature_tasks_name"));
				Select feature2= new Select(select2);
				feature2.selectByValue("Just Dance 2019");	
				driver.findElement(By.name("feature_duration")).sendKeys("120");
				driver.findElement(By.name("save")).click();
				Thread.sleep(1000);
				WebElement select3= driver.findElement(By.name("feature_tasks_name"));
				Select feature3= new Select(select3);
				feature3.selectByValue("Just Dance 2020 [Live/UAT]");
				driver.findElement(By.name("feature_duration")).sendKeys("120");
				driver.findElement(By.name("save")).click();
				}
				else
				{
				WebElement select1= driver.findElement(By.name("feature_tasks_name"));
				Select feature1= new Select(select1);
				feature1.selectByValue("Just Dance 2018");	
				driver.findElement(By.name("feature_duration")).sendKeys("120");
				driver.findElement(By.name("save")).click();
				Thread.sleep(1000);
				WebElement select2= driver.findElement(By.name("feature_tasks_name"));
				Select feature2= new Select(select2);
				feature2.selectByValue("Just Dance 2019");	
				driver.findElement(By.name("feature_duration")).sendKeys("120");
				driver.findElement(By.name("save")).click();
				Thread.sleep(1000);
				WebElement select3= driver.findElement(By.name("feature_tasks_name"));
				Select feature3= new Select(select3);
				feature3.selectByValue("Just Dance 2020 [Live/UAT]");
				driver.findElement(By.name("feature_duration")).sendKeys("120");
				driver.findElement(By.name("save")).click();
				}
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[@class='fa fa-arrow-right']")).click();
				WebElement select= driver.findElement(By.xpath("//select[@name='day_status']"));
				System.out.println("Enter date eg. 12sep");
				Select daystatus= new Select(select);
				Thread.sleep(1000);
				daystatus.selectByValue("full_day");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='num2']")).sendKeys(random(20,10));//Team effort per Generic Tasks
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='num3']")).sendKeys(random(30,20));//Team Meetings
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='num4']")).sendKeys("");//Trainings
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='num5']")).sendKeys("");//Brainstorming Sessions
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='num6']")).sendKeys("");//HR Sessions
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='num7']")).sendKeys(random(30,20));//Reports
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='num8']")).sendKeys(random(30,20));//Jira
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='num9']")).sendKeys("");//Communication & Collaboration
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='num10']")).sendKeys(random(20,10));//Task Preparation
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='num11']")).sendKeys("");//Transversal Activities
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='num12']")).sendKeys("");//Downtime (Build downloads & Installations)
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='num13']")).sendKeys("");//Troubleshooting
				String totaltext=driver.findElement(By.xpath("//p[@id='result']")).getText();
				String[] totalint=totaltext.split("\\s");
				int total=Integer.parseInt( totalint[0]);
				System.out.println(total);
							if(total>=450)
							{
							Thread.sleep(1000);
						 driver.findElement(By.xpath("//input[@id='submitbutton']")).click();
							System.out.println("exicuted");
							}
							else
							{
								driver.navigate().back();
								update();
							}
			}

		public static String random(int max,int min)
		{
			int time= (int) (Math.random()*(max-min))+min;
			String timer=String.valueOf(time);
			return timer;
		}
}
