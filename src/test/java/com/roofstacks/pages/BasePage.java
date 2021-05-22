package com.roofstacks.pages;

import com.roofstacks.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class  BasePage {

    public BasePage() {

        PageFactory.initElements(Driver.get(), this);
    }

}


