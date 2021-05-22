package com.roofstacks.step_definitions;

import com.roofstacks.pages.RoofStacksPage;
import com.roofstacks.utilities.BrowserUtils;
import com.roofstacks.utilities.ConfigurationReader;
import com.roofstacks.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class UploadResumeStepDefs {

    RoofStacksPage roofStacksPage = new RoofStacksPage();


    @Given("Kullanıcı url sayfasına gider")
    public void kullanıcı_url_sayfasına_gider() {

        Driver.get().get(ConfigurationReader.get("url"));

    }

    @And("{string} yazarak arama yapar")
    public void yazarak_arama_yapar(String str) {

        roofStacksPage.googleSearchInput.sendKeys(str);
        roofStacksPage.googleSearchBtn.click();

    }

    @Then("Arama sonuçlarında roofstacks.com sayfasına tıklar")
    public void arama_sonuçlarında_roofstacks_com_sayfasına_tıklar() {

        roofStacksPage.roofStackBtn.click();

    }
    @Then("Anasayfada career butonuna tıklar")
    public void anasayfada_career_butonuna_tıklar(){

        roofStacksPage.careerBtn.click();

    }

    @Then("Product pozision seçilir")
    public void product_pozision_seçilir() {

        roofStacksPage.productBtn.click();

    }

    @Then("Lead Product Tester seçilir")
    public void lead_Product_Tester_seçilir() {

        roofStacksPage.leadProductTesterBtn.click();

    }

    @Then("Sayfanın Product Tester sayfasında olup olmadığı doğrulanır")
    public void sayfanın_Product_Tester_sayfasında_olup_olmadığı_doğrulanır() throws InterruptedException {

        String expectedResult = "Lead Product Tester";

        BrowserUtils.waitForVisibility(roofStacksPage.leadProductTesterText,10);
        String actualResult =roofStacksPage.leadProductTesterText.getText();
        System.out.println("actual = " + actualResult);


        Assert.assertEquals(expectedResult,actualResult);
        Thread.sleep(5);

    }

    @Then("SendCV buttonu tıklanır")
    public void sendcv_buttonu_tıklanır() throws InterruptedException {

        roofStacksPage.sendCVBtn.click();
        Thread.sleep(5);

    }

    @Then("Kullanıcı email adresini girer")
    public void kullanıcı_email_adresini_girer() throws InterruptedException {

        roofStacksPage.emailInputBox.sendKeys(ConfigurationReader.get("email"));
        Thread.sleep(5);

    }

    @Then("Sample bir CV dosya upload butonuna basılarak paylaşılır")
    public void sample_bir_CV_dosya_upload_butonuna_basılarak_paylaşılır() {

        String filePath = "C:\\Users\\dell\\IdeaProjects\\RoofStackTestStudy\\Sample Resume.pdf";
        roofStacksPage.selectFileInputBox.sendKeys(filePath);
        roofStacksPage.uploadBtn.click();
        BrowserUtils.waitFor(10);
        String percentage = Driver.get().findElement(By.id("percent")).getText();
        System.out.println(" percentage= " +percentage );

        Assert.assertEquals("100%", percentage);

        //upload ederken bir bug ile karşılaştım ve test reportta bu durum mevcut.
    }
}













