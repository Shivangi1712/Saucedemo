package Final;
import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;
public class SwagLabs
{
    WebDriver driver = new ChromeDriver();
    @BeforeTest
    //launching browser
    public void launchbrowser() throws InterruptedException
    {
        System.out.println("Launching the webbrowser");
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
        driver.manage().window().maximize();
    }
    
    @Test(priority = 0)
    public void Login() throws InterruptedException
    {
        //sending wrong username and password
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("Shivangi");
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("Shivangi");
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"user-name\"]")).clear();
        //login with correct values
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id=\"password\"]")).clear();
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
    }
    
    @Test(priority = 1)
        //for continue button
    public void dropdown() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]//option[2]")).click();
    }
    
    @Test(priority = 2)
    public void items() throws InterruptedException
        //add items to cart
        {
            String[] itemsNeeded = {
                "Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"
            };
            Thread.sleep(2000);
            int j = 0;
            List < WebElement > products = driver.findElements(By.className("inventory_item_name"));
            for(int i = 0; i < products.size(); i++)
            {
                Thread.sleep(2000);
                WebElement name = products.get(i);
                String formattedName = name.getText();
                //System.out.println(formattedName);
                List itemsNeededList = Arrays.asList(itemsNeeded);
                if(itemsNeededList.contains(formattedName))
                {
                    j++;
                    driver.findElements(By.xpath("//div[@class='pricebar']/button")).get(i).click();
                    if(j == itemsNeeded.length)
                    {
                        break;
                    }
                }
            }
        }
    
    @Test(priority = 3)
        //going in cart
    public void addtocart() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]")).click();
    }
    
        @Test(priority = 4)
        //removing item to cart
    public void removeitems() throws InterruptedException
    {
        String[] itemList = {
            "Sauce Labs Backpack"
        };
        Thread.sleep(2000);
        int j = 0;
        List < WebElement > products = driver.findElements(By.className("inventory_item_name"));
        for(int i = 0; i < products.size(); i++)
        {
            Thread.sleep(2000);
            WebElement name = products.get(i);
            String formattedName = name.getText();
            //System.out.println(formattedName);
            List items = Arrays.asList(itemList);
            if(items.contains(formattedName))
            {
                j++;
                driver.findElements(By.xpath("//div[@class='item_pricebar']//button")).get(i).click();
                if(j == itemList.length)
                {
                    break;
                }
            }
        }
    }
        
    @Test(priority = 5)
        //for continue shopping
    public void continueshopping() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='continue-shopping']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }
    
    @Test(priority = 6)
        //for checkout
    public void checkout() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id=\"checkout\"]")).click();
    }
    
    @Test(priority = 7)
        //for input values
    public void Inbox() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id=\"first-name\"]")).sendKeys("Shivangi");
        driver.findElement(By.xpath("//input[@id=\"last-name\"]")).sendKeys("Sharma");
        driver.findElement(By.xpath("//input[@id=\"postal-code\"]")).sendKeys("H3S111");
    }
    
    @Test(priority = 8)
        //for continue button
    public void button() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id=\"continue\"]")).click();
    }
    
    @Test(priority = 9)
        //for finish shopping
    public void finish() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id=\"finish\"]")).click();
    }
    
    @Test(priority = 10)
        //for back to home page
    public void backtohome() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id=\"back-to-products\"]")).click();
    }
}