package org.fasttrackit.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.RandomStringUtils;
import org.fasttrackit.steps.RegisterSteps;
import org.fasttrackit.utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class RegisterTest extends Constants {
    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    private RegisterSteps registerSteps;

    @Test
    public void validRegister(){
        String email = RandomStringUtils.randomAlphabetic(8);
        registerSteps.navigateToRegisterPage();
        registerSteps.setCredentials(email+"@mailinator.com","testfast12345");
        registerSteps.clickonRegisterButton();
        registerSteps.getWelcomeMessage("Hello" +" "+email+ " "+"(not"+""+" " +email+"? Log out)");



    }
    @Test
    public void registerWithAnEmailAlreadyRegistered(){
        registerSteps.navigateToRegisterPage();
        registerSteps.setCredentials(USER_EMAIL,USER_PASSWORD);
        registerSteps.clickonRegisterButton();
        registerSteps.getErrorMessage("Error: An account is already registered with your email address. Please log in.");


    }

    @Test
    public void registerWithAnWeakPassword(){
        registerSteps.navigateToRegisterPage();
        registerSteps.setCredentials("bunea@mailinator.com","12345");
        //registerSteps.clickonRegisterButton();
        registerSteps.tryToClick();


    }
}
