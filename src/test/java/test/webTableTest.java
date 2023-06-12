package test;

import driver.WebdriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class webTableTest {

    public static void main(String[] args) {

        testWebTable();
        //testDynamicWebTable();
    }

    public static ChromeDriver createDriverAndGetPage(){
        ChromeDriver driver = WebdriverManager.createChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
        return driver;
    }



    public static void testWebTable() {
        ChromeDriver driver = createDriverAndGetPage();
        getTableDetails(driver);

        //driver.quit();
    }
    public static void getTableDetails( ChromeDriver driver){
        WebElement tableCaption = driver.findElement(By.cssSelector("#tablehere table caption"));
        System.out.println(tableCaption.getText());
        System.out.println("");


        //select table rows and columns

        List<WebElement> tableRows = driver.findElements(By.cssSelector("t#tablehere table tr"));
        for(int i = 0; i < tableRows.size(); i++){
            WebElement currentRow = tableRows.get(i);
        if(i == 0){
            List<WebElement> firstRowColumns = currentRow.findElements(By.cssSelector("th"));
            System.out.println("Header din prima coloana: " + firstRowColumns.get(0).getText());
            System.out.println("Header din a doua coloana: " + firstRowColumns.get(1).getText());
            System.out.println("");
        } else {
            List<WebElement> currentColumns = currentRow.findElements(By.cssSelector("td"));
            System.out.println("Text din randul " + (i + 1) + ", coloana 1: " + currentColumns.get(0).getText());
            System.out.println("Text din randul " + (i + 1) + ", coloana 2: " + currentColumns.get(1).getText());
        }
    }
    }

    public static void updateTable(ChromeDriver driver){
        WebElement summary = driver.findElement(By.cssSelector("details summary"));
        summary.click();
        // update caption
        WebElement caption = driver.findElement(By.id("caption"));
        caption.clear();
        caption.sendKeys("QA ENGINEER TESTER");

        // update table id
        WebElement tableID = driver.findElement(By.id("tableid"));
        tableID.clear();
        tableID.sendKeys("CustomID");


        // press refresh button
        WebElement refreshtableButton = driver.findElement(By.id("refreshtable"));
        refreshtableButton.click();


        WebElement dynamicCaption = driver.findElement(By.cssSelector("#tablehere table caption"));
        System.out.println(dynamicCaption.getText());
        System.out.println("");

        WebElement table = driver.findElement(By.cssSelector("#tablehere table"));
        System.out.println(table.getAttribute("id"));


    }
}
