package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class MenTest extends Utility {
String MyUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(MyUrl);
    }

    @Test
    public void userShouldAddProductSuccessfullyToShoppingCart() throws InterruptedException {
//Mouse Hover on Men Menu
        mouseHoverToElement(By.xpath("//a[@id='ui-id-5']"));


//Mouse Hover on Bottoms
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//a[@id='ui-id-18']"));


//* Click on Pants
        Thread.sleep(1000);
        mouseHoverToElement(By.id("ui-id-23"));

//* Mouse Hover on product name‘Cronus Yoga Pant’ and click on size 32.
        mouseHoverToElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));

//* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        mouseHoverToElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));

//* Mouse Hover on product name‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        mouseHoverToElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[1]/div[1]"));

//* Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String text =getTextFromElement(By.xpath("//div[@class='message-success success message']"));
        Assert.assertEquals("Invalid text", "You added Cronus Yoga Pant to your shopping cart.", text);


//* Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));


//* Verify the text ‘Shopping Cart.’

        String actualText = getTextFromElement(By.xpath("//span[@class='base']"));
        Assert.assertEquals("Invalid text", "Shopping Cart", actualText);

//* Verify the product name ‘Cronus Yoga Pant’
        String actualProductName =getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        Assert.assertEquals("Cronus Yoga Pant", actualProductName);

//* Verify the product size ‘32’
        String actualProductSize =getTextFromElement(By.xpath("//dd[contains(text(),'32')]"));
        Assert.assertEquals("32", actualProductSize);


//* Verify the product colour ‘Black’
        String actualProductColour =getTextFromElement(By.xpath("//dd[contains(text(),'Black')]"));
        Assert.assertEquals("Black", actualProductColour);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}