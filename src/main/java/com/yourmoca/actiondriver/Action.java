package com.yourmoca.actiondriver;

import com.yourmoca.Base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Action extends BaseClass {
    public Action(){
        super();
    }
    // to scroll until the element should be visible
    public static void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ele);

    }

    //To perform mouse click action
    public static void Mouseclick(WebDriver driver, WebElement ele) {

        Actions act = new Actions(driver);
        act.moveToElement(ele).click().build().perform();

    }

    public static boolean performClick(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            ele.click();
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                System.out.println("Able to click "+ele);
            } else {
                System.out.println("Unable to click "+ele);

            }
        }

    }


    public static boolean findElement(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            ele.isDisplayed();
            flag = true;
        } catch (Exception e) {
            //System.out.println("Location not found: "+ ele);
            flag = false;
        } finally {
            if (flag) {
                System.out.println("Successfully Found element ");
            } else {
                System.out.println("Unable to locate element ");
            }
        }
        return flag;
    }

    public static boolean isDisplayed(WebDriver driver, WebElement ele) {
        boolean flag = false;
        flag = findElement(driver, ele);
        System.out.println(flag);
        if (flag) {
            flag = ele.isDisplayed();
            if (flag) {
                System.out.println("The element is Displayed");
            } else {
                System.out.println("The element is not Displayed");
            }
        } else {
            System.out.println("Not displayed ");
        }
        return flag;
    }

    public static boolean isSelected(WebDriver driver, WebElement ele) {
        boolean flag = false;
        flag = findElement(driver, ele);
        if (flag) {
            flag = ele.isSelected();
            if (flag) {
                System.out.println("The element is Selected");
            } else {
                System.out.println("The element is not Selected");
            }
        } else {
            System.out.println("Not selected ");
        }
        return flag;
    }

    public static boolean isEnabled(WebDriver driver, WebElement ele) {
        boolean flag = false;
        flag = findElement(driver, ele);
        if (flag) {
            flag = ele.isEnabled();
            if (flag) {
                System.out.println("The element is Enabled");
            } else {
                System.out.println("The element is not Enabled");
            }
        } else {
            System.out.println("Not Enabled ");
        }
        return flag;
    }

    /*
     * Enter text at location
     * @param ele -> locator
     * @param text
     * @return - true/false
     */

    public static boolean EnterText(WebElement ele, String text) {
        boolean flag = false;
        try {
            flag = ele.isDisplayed();
            ele.clear();
            ele.sendKeys(text);
            // logger.info("Entered text :"+text);
            flag = true;
        } catch (Exception e) {
            System.out.println("Location Not found "+ ele);
            flag = false;
        } finally {
            if (flag) {
                System.out.println("Successfully entered value "+text);
            } else {
                System.out.println("Unable to enter value "+text);
            }

        }
        return flag;
    }

    //select value from dropdown by entering the text
    public static boolean selectBySendkeys(String value,WebElement ele) {
        boolean flag = false;
        try {
            ele.sendKeys(value);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                System.out.println("Selected value from the DropDown");
            } else {
                System.out.println("Not Selected value from the DropDown");
                // throw new ElementNotFoundException("", "", "")
            }
        }
    }

    /*
     * select value from DropDown by using selectByIndex
     *
     * @param element     : Action to be performed on element (Get it from Object
     *                    repository)
     *
     * @param index     : Index of value wish to select from dropdown list.
     *
     */
    public static boolean selectByIndex(WebElement element, int index) {
        boolean flag = false;
        try {
            Select s = new Select(element);
            s.selectByIndex(index);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                System.out.println("Option selected by Index");
            } else {
                System.out.println("Option not selected by Index");
            }
        }
    }

    /*
     * select value from Droppdown by using value
     *
     * @param element(locator)     : Action to be performed on element (Get it from Object
     *                    repository)
     *
     * @param value     : Value wish to select from dropdown list.
     *
     * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
     *                    Listbox etc..)
     */


    public static boolean selectByValue(WebElement element,String value) {
        boolean flag = false;
        try {
            Select s = new Select(element);
            s.selectByValue(value);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                System.out.println("Option selected by Value");
            } else {
                System.out.println("Option not selected by Value");
            }
        }
    }

    /*
     * select value from DropDown by using selectByVisibleText
     *
     * @param ele(locator)     : Action to be performed on element (Get it from Object
     *                    repository)
     *
     * @param visibletext : VisibleText wish to select from dropdown list.
     *
     * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
     *                    Listbox etc..)
     */


    public static boolean selectByVisibleText(String visibletext, WebElement ele) {
        boolean flag = false;
        try {
            Select s = new Select(ele);
            s.selectByVisibleText(visibletext);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                System.out.println("Option selected by VisibleText");
            } else {
                System.out.println("Option not selected by VisibleText");
            }
        }
    }

    public static boolean clickItemFromList(WebDriver driver, List<WebElement> itemList, String itemName) {
        boolean found = false; // Flag to check if item was found
        for (WebElement item : itemList) {
            String itemText = item.getText();
            if (itemText.equalsIgnoreCase(itemName)) {
                Action.performClick(driver, item);
                found = true; // Set the flag to true when found
                System.out.println("Selected item: " + itemText);
                break; // Exit the loop after clicking
            }
        }
        if (!found) {
            System.out.println("Item not found: " + itemName);
            // Optionally return false or throw an exception if needed
        }
        return found; // Return whether the item was found and selected
    }

    public static boolean JSClick(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            // WebElement element = driver.findElement(locator);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", ele);
            // driver.executeAsyncScript("arguments[0].click();", element);

            flag = true;
        }
        catch (Exception e) {
            throw e;
        } finally {
            if (flag) {
                System.out.println("Click Action is performed");
            } else if (!flag) {
                System.out.println("Click Action is not performed");
            }
        }
        return flag;
    }


    public static boolean switchToFrameByIndex(WebDriver driver,int index) {
        boolean flag = false;
        try {
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
            driver.switchTo().frame(index);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                System.out.println("Frame with index \"" + index + "\" is selected");
            } else {
                System.out.println("Frame with index \"" + index + "\" is not selected");
            }
        }
    }

    /**
     * This method switch the to frame using frame ID.
     *
     * @param idValue : Frame ID wish to switch
     *
     */

    public static boolean switchToFrameById(WebDriver driver,String idValue) {
        boolean flag = false;
        try {
            driver.switchTo().frame(idValue);
            flag = true;
            return true;
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        } finally {
            if (flag) {
                System.out.println("Frame with Id \"" + idValue + "\" is selected");
            } else {
                System.out.println("Frame with Id \"" + idValue + "\" is not selected");
            }
        }
    }

    /**
     * This method switch the to frame using frame Name.
     *
     * @param nameValue : Frame Name wish to switch
     *
     */

    public static boolean switchToFrameByName(WebDriver driver,String nameValue) {
        boolean flag = false;
        try {
            driver.switchTo().frame(nameValue);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                System.out.println("Frame with Name \"" + nameValue + "\" is selected");
            } else if (!flag) {
                System.out.println("Frame with Name \"" + nameValue + "\" is not selected");
            }
        }
    }
    public static boolean switchToFrameByWebElement(WebDriver driver,WebElement ele) {
        boolean flag = false;
        try {
            driver.switchTo().frame(ele);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                System.out.println("Frame with webelement is selected");
            } else if (!flag) {
                System.out.println("Frame with webelement is not selected");
            }
        }
    }


    public static boolean switchToDefaultFrame(WebDriver driver) {
        boolean flag = false;
        try {
            driver.switchTo().defaultContent();
            flag = true;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (flag) {
                // SuccessReport("SelectFrame ","Frame with Name is selected");
                System.out.println("successfully switched to default frame");
            } else if (!flag) {
                // failureReport("SelectFrame ","The Frame is not selected");
                System.out.println("Failed to switch to default frame");
            }
        }
    }


    public static void mouseHoverElement(WebDriver driver,WebElement element) {
        boolean flag = false;
        try {
            new Actions(driver).moveToElement(element).build().perform();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag) {
                System.out.println(" MouserOver Action is performed on ");
            } else {
                System.out.println("MouseOver action is not performed on");
            }
        }
    }


    public static boolean moveToElement(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            // WebElement element = driver.findElement(locator);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView(true);", ele);
            Actions actions = new Actions(driver);
            // actions.moveToElement(driver.findElement(locator)).build().perform();
            actions.moveToElement(ele).build().perform();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    public static boolean mouseHover(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            new Actions(driver).moveToElement(ele).build().perform();
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            /*
             * if (flag) {
             * SuccessReport("MouseOver ","MouserOver Action is performed on \""+locatorName
             * +"\""); } else {
             * failureReport("MouseOver","MouseOver action is not performed on \""
             * +locatorName+"\""); }
             */
        }
    }
    public static boolean rightclick(WebDriver driver,WebElement ele) {
        boolean flag = false;
        try {
            Actions clicker = new Actions(driver);
            clicker.contextClick(ele).perform();
            flag = true;
            return true;
            // driver.findElement(by1).sendKeys(Keys.DOWN);
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                System.out.println("RightClick Action is performed");
            } else {
                System.out.println("RightClick Action is not performed");
            }
        }
    }
    public static boolean switchWindowByTitle(WebDriver driver,String windowTitle, int count) {
        boolean flag = false;
        try {
            Set<String> windowList = driver.getWindowHandles();

            String[] array = windowList.toArray(new String[0]);

            driver.switchTo().window(array[count-1]);

            if (driver.getTitle().contains(windowTitle)){
                flag = true;
            }else{
                flag = false;
            }
            return flag;
        } catch (Exception e) {
            //flag = true;
            return false;
        } finally {
            if (flag) {
                System.out.println("Navigated to the window with title");
            } else {
                System.out.println("The Window with title is not Selected");
            }
        }
    }
    public static boolean switchToNewWindow(WebDriver driver) {
        boolean flag = false;
        try {

            Set<String> s=driver.getWindowHandles();
            Object popup[]=s.toArray();
            driver.switchTo().window(popup[1].toString());
            flag = true;
            return flag;
        } catch (Exception e) {
            flag = false;
            return flag;
        } finally {
            if (flag) {
                System.out.println("Window is Navigated with title");
            } else {
                System.out.println("The Window with title: is not Selected");
            }
        }
    }
    public static boolean switchToOldWindow(WebDriver driver) {
        boolean flag = false;
        try {

            Set<String> s=driver.getWindowHandles();
            Object popup[]=s.toArray();
            driver.switchTo().window(popup[0].toString());
            flag = true;
            return flag;
        } catch (Exception e) {
            flag = false;
            return flag;
        } finally {
            if (flag) {
                System.out.println("Focus navigated to the window with title");
            } else {
                System.out.println("The Window with title: is not Selected");
            }
        }
    }
    public static int getColumncount(WebElement row) {
        List<WebElement> columns = row.findElements(By.tagName("td"));
        int a = columns.size();
        System.out.println(columns.size());
        for (WebElement column : columns) {
            System.out.print(column.getText());
            System.out.print("|");
        }
        return a;
    }
    public static int getRowCount(WebElement table) {
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        int a = rows.size() - 1;
        return a;
    }


    /**
     * Verify alert present or not
     *
     * @return: Boolean (True: If alert preset, False: If no alert)
     *
     */
    public static boolean alertAccept(WebDriver driver) {
        boolean presentFlag = false;
        Alert alert = null;

        try {
            // Check the presence of alert
            alert = driver.switchTo().alert();
            // if present consume the alert
            alert.accept();
            presentFlag = true;
        } catch (NoAlertPresentException ex) {
            // Alert present; set the flag

            // Alert not present
            ex.printStackTrace();
        } finally {
            driver.switchTo().defaultContent();
            if (!presentFlag) {
                System.out.println("The Alert is handled successfully");
            } else{
                System.out.println("There was no ed to handle");
            }
        }
        return presentFlag;
    }

    public static boolean alertSendKeys(WebDriver driver, String text) {
        boolean presentFlag = false;
        Alert alert = null;

        try {
            // Switch to the alert
            alert = driver.switchTo().alert();
            // Send text to the alert and accept it
            alert.sendKeys(text);
            alert.accept();
            presentFlag = true;
            System.out.println("Text sent to alert and alert accepted.");
        } catch (NoAlertPresentException ex) {
            System.out.println("No alert present to send keys.");
        } catch (Exception e) {
            System.out.println("An error occurred while sending text to alert.");
            e.printStackTrace();
        } finally {
            // Switch back to the default content after handling the alert
            driver.switchTo().defaultContent();
        }

        return presentFlag;
    }
    public static boolean launchUrl(WebDriver driver,String url) {
        boolean flag = false;
        try {
            driver.navigate().to(url);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                System.out.println("Successfully launched \""+url+"\"");
            } else {
                System.out.println("Failed to launch \""+url+"\"");
            }
        }
    }
    public static boolean isAlertPresent(WebDriver driver)
    {
        try
        {
            driver.switchTo().alert();
            return true;
        }   // try
        catch (NoAlertPresentException Ex)
        {
            return false;
        }   // catch
    }
    public static String getTitle(WebDriver driver) {
        boolean flag = false;

        String text = driver.getTitle();
        /*if (flag) {
            System.out.println("Title of the page is: \""+text+"\"");
        }*/
        return text;
    }
    public static String getCurrentURL(WebDriver driver)  {
        boolean flag = false;

        String text = driver.getCurrentUrl();
        /*if (flag) {
            System.out.println("Current URL is: \""+text+"\"");
        }*/
        System.out.println("Current URL is: \""+text+"\"");
        return text;
    }
    public static boolean PerformClick(WebElement locator, String locatorName) {
        boolean flag = false;
        try {
            locator.click();
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                System.out.println("Able to click on \""+locatorName+"\"");
            } else {
                System.out.println("Click Unable to click on \""+locatorName+"\"");
            }
        }

    }
    public static void fluentWait(WebDriver driver,WebElement element, int timeOut) {
        Wait<WebDriver> wait = null;
        try {
            wait = new FluentWait<WebDriver>((WebDriver) driver)
                    .withTimeout(Duration.ofSeconds(timeOut))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(Exception.class);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
        }catch(Exception e) {
        }
    }
    public static void implicitWait(WebDriver driver, int timeOut) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
    }

    public static void explicitWait(WebDriver driver, WebElement element, int timeOut ) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
        // driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
    }
    public static void UrlToBe(WebDriver driver, String url){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public static void UrlContains(WebDriver driver, String Urltext){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains(Urltext));
    }

    public static String screenShot(WebDriver driver, String filename) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        //String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";
        String destination = "./Screenshots" + filename + "_" + dateName + ".png";
        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (Exception e) {
            e.getMessage();
        }

        // This new path for jenkins
        String newImageString = "http://localhost:8080/job/ShopLocal_Project/ws/Screenshots" + filename + "_"
                + dateName + ".png";
        return newImageString;
    }

    public static String getCurrentTime() {
        String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
        return currentDate;
    }
    public static boolean slider(WebDriver driver,WebElement ele, int x, int y) {
        boolean flag = false;
        try {
            // new Actions(driver).dragAndDropBy(dragitem, 400, 1).build()
            // .perform();
            new Actions(driver).dragAndDropBy(ele, x, y).build().perform();// 150,0
            Thread.sleep(5000);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                System.out.println("Slider Action is performed");
            } else {
                System.out.println("Slider Action is not performed");
            }
        }
    }


}
