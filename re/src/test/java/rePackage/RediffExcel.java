package rePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RediffExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\\\SeleniumJars\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
		
		WebDriver d=new ChromeDriver();
d.get("https://www.rediff.com");
d.findElement(By.xpath("//*[@id=\"signin_info\"]/a[2]")).click();
WebElement fname=d.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input"));
WebElement Remail=d.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]"));
WebElement pwd=d.findElement(By.xpath("//*[@id=\"newpasswd\"]"));
WebElement rpwd=d.findElement(By.xpath("//*[@id=\"newpasswd1\"]"));
WebElement Aemail=d.findElement(By.xpath("//*[@id=\"div_altemail\"]/table/tbody/tr[1]/td[3]/input"));
WebElement Country=d.findElement(By.xpath("//*[@id=\"country\"]"));
WebElement gend1=d.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]/input[1]"));
WebElement gend2=d.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]/input[2]"));
WebElement mobile=d.findElement(By.xpath("//*[@id=\"mobno\"]"));

File file1=new File("C:\\Users\\SANKET\\git\\repository\\re\\src\\test\\resources\\RediffInput.xlsx");
FileInputStream fis= new FileInputStream(file1);
XSSFWorkbook wb=new XSSFWorkbook(fis);
XSSFSheet sheet=wb.getSheet("Sheet1");
int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
for(int i=1;i<=rowCount;i++)
{
	int cellcount=sheet.getRow(i).getLastCellNum();
	//System.out.println("Row"+i+" data is: ");
	for(int j=0;j<cellcount;j++)
	{
	
	String dt=sheet.getRow(i).getCell(j).getStringCellValue();
	if(j==0)
	{
	fname.sendKeys(dt);
	}
	if(j==1)
	{
	Remail.sendKeys(dt);
	
	}
	if(j==2)
	{
	pwd.sendKeys(dt);
	rpwd.sendKeys(dt);
	}
	if(j==3)
	{
	Aemail.sendKeys(dt);
	}
	if(j==4)
	{
	Select dd1=new Select(Country);
	dd1.selectByVisibleText(dt);
	}
	if(j==5)
	{
	String gender1="Male";
	String gender2="Female";
	if (dt.equals(gender1))
	{
	gend1.click();
	}
	if (dt.equals(gender2))
	{
	gend2.click();
	}
	}
	if(j==6)
	{
	mobile.sendKeys(dt);
	}
	
	}
	
}


		

	}

}
