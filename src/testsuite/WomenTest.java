package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utility {
    String MyUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(MyUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
//* Mouse Hover on Women Menu
        Thread.sleep(1000);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Women')]"));
//* Mouse Hover on Tops
        //li[contains(@class,'nav-2-1 ')]/child::a
        mouseHoverToElement(By.xpath("//li[contains(@class,'nav-2-1 ')]/child::a"));
//* Click on Jackets
        mouseHoverToElement(By.xpath("//li[contains(@class,'nav-2-1 ')]/child::ul/child::li[1]/child::a"));
//* Select Sort By filter “Product Name”
        selectByVisibleTextFromDropDown((By.xpath("//div[@class='column main']/child::div[2]/child::div[3]/child::select[1]")), "Product Name");
//* Verify the products name display in alphabetical order
        List<WebElement> originalList = Mydriver.findElements(By.xpath("//strong[contains(@class,'product name product-item-name')]/child::a"));
        List<String> originalProductList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductList.add(product.getText());
        }
        System.out.println("Before Sorting: " + originalProductList);
        List<WebElement> afterSortingList = Mydriver.findElements(By.xpath("//strong[contains(@class,'product name product-item-name')]/child::a"));
        List<String> afterSortingProductNames = new ArrayList<>();
        for (WebElement product : afterSortingList) {
            afterSortingProductNames.add(product.getText());
        }
        Collections.sort(originalProductList);
        System.out.println("After Sorting: " + afterSortingProductNames);
        Assert.assertEquals(originalProductList, afterSortingProductNames);


    }

    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {
//  Mouse Hover on Women Menu
        Thread.sleep(1000);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Women')]"));
//* Mouse Hover on Tops
        Thread.sleep(1000);
        mouseHoverToElement(By.xpath("//li[contains(@class,'nav-2-1 ')]/child::a"));
//* Click on Jackets
        Thread.sleep(1000);
        mouseHoverToElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
//  Select Sort By filter “Price”
        selectByVisibleTextFromDropDown(By.id("sorter"), "Price");
//* Verify the products price display in Low to High
        List<WebElement> originalList = Mydriver.findElements(By.cssSelector("span[data-price-type='finalPrice']"));
        List<Double> originalProductPriceList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductPriceList.add(Double.valueOf(product.getText().replace("$", "")));
        }
        System.out.println("Before Sorting: " + originalProductPriceList);
        List<WebElement> afterSortingList = Mydriver.findElements(By.cssSelector("span[data-price-type='finalPrice']"));
        List<Double> afterSortingProductPrice = new ArrayList<>();
        for (WebElement product : afterSortingList) {
            afterSortingProductPrice.add(Double.valueOf(product.getText().replace("$", "")));
        }
        Collections.sort(originalProductPriceList);
        System.out.println("After Sorting: " + afterSortingProductPrice);
        Assert.assertEquals(originalProductPriceList, afterSortingProductPrice);

    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
