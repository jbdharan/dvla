package cucumber.test.steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import common.getBrowser;
import common.dvlaPageObj;

import java.io.File;
import java.util.List;

import static common.findFiles.findFilesInfo;
import static common.findFiles.returnCellData;
import static common.findFiles.writeToExcel;
import static common.GeneralUtils.timestamp;


public class stepdef extends dvlaPageObj {
    getBrowser browser = new getBrowser();
    WebDriver driver = browser.getChromeDriver();
    static File folder = new File(System.getProperty("user.dir") + "/src/main/resources/filesinfolder/");
    String screenshots = System.getProperty("user.dir") + "/target/cucumber/screenshots/";


    @Given("^As end user i want to open browser and enter home url$")
    public void as_end_user_i_want_to_open_browser_and_enter_home_url() throws Throwable {
        driver.get(home_url);
        //throw new PendingException();
    }

    @And("^click on start  button$")
    public void click_on_start_button() throws Throwable {
        driver.findElement(startnow_button).click();
        //throw new PendingException();
    }


    @Then("^read registration number from inputfolder and enter registration number validate color and make then generate report$")
    public void read_registration_number_from_inputfolder_and_enter() throws Throwable {
        List usefulFilesData = returnCellData(findFilesInfo(folder));
        int j = 0;
        int k = 0;
        int rowClont = 1;
        String resultToExcel;
        for (int i = 0; i <= usefulFilesData.size(); rowClont++) {
            resultToExcel = "PASS";
            writeToExcel(usefulFilesData.get(i).toString(), k, rowClont, resultToExcel);
            driver.findElement(enter_venicle_number).sendKeys(usefulFilesData.get(i).toString());
            driver.findElement(continue_button).submit();
            i = i + 1;
            try {
                Assert.assertFalse(driver.findElement(You_must_enter_your_registration_number_in_a_valid_format).isDisplayed());
            } catch (Exception e) {
            }
            Assert.assertEquals(driver.findElement(Make).getText(), usefulFilesData.get(i).toString());
            i = i + 1;
            k = k + 1;
            if (driver.findElement(Colour).getText().equals(usefulFilesData.get(i).toString())) resultToExcel = "PASS";
            else resultToExcel = "FAIL";
            writeToExcel(usefulFilesData.get(i).toString(), k, rowClont, resultToExcel);
            Assert.assertEquals(driver.findElement(Colour).getText(), usefulFilesData.get(i).toString());
            i = i + 1;
            k = k + 1;
            if (driver.findElement(Colour).getText().equals(usefulFilesData.get(i).toString())) resultToExcel = "PASS";
            resultToExcel = "PASS";
            writeToExcel(usefulFilesData.get(i).toString(), k, rowClont, resultToExcel);
            k = 0;
            j = j + 1;
            driver.navigate().back();
        }
        driver.close();
    }


    @Then("^Enter registration number (.*) then validate made (.*) and color (.*)$")
    public void enterRegistrationNumberRegNumberThenValidateMadeMadeAndColorColours(String RegNumber, String Made, String Colours) throws Throwable {
        driver.findElement(enter_venicle_number).sendKeys(RegNumber);
        driver.findElement(continue_button).submit();
        screenShotPlease(driver, screenshots +RegNumber+ timestamp());
        try {
            Assert.assertFalse(driver.findElement(You_must_enter_your_registration_number_in_a_valid_format).isDisplayed());
        } catch (Exception e) {
        }
        Assert.assertEquals(driver.findElement(Make).getText(), Made);
        Assert.assertEquals(driver.findElement(Colour).getText(), Colours);
        driver.navigate().back();
        driver.close();

    }




    public static void screenShotPlease(WebDriver driver, String fileWithPath) throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);

    }

    public DvlaCucumberStepDefs() throws Exception {
    }

    @AfterClass

    void killBrowser(){
        driver.close();
        driver.quit();


    }


}
