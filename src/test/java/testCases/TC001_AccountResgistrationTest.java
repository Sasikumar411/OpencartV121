package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountResgistrationTest extends BaseClass
{
	@Test(groups={"Regression","Master"})
	public void verify_account_resgistration()
	{
		logger.info("****** Starting TC001_AccountResgistrationTest *****");
		
		try
		{
		HomePage hp=new HomePage(driver);
		
		hp.clickAccount();
		logger.info("Clicked on MyAccount link");
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		RegistrationPage regpage=new RegistrationPage(driver);
		
		logger.info("Providing customer details...");
		
		regpage.setFirstname(randomString().toUpperCase());
		regpage.setLastname(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumeric());
		
		String pwd=randomAlphaNumeric();
		
		regpage.setPassword(pwd);
		regpage.setConfirmPassword(pwd);
		
		regpage.setPrivacypolicy();
		regpage.clickContinue();
		
		logger.info("Validating expected message");
		
		String msg=regpage.getConfirmationMsg();
		if(msg.equals("Your Account Has Been Created!"))
		{
			AssertJUnit.assertTrue(true);
		}
		else 
		{
			logger.error("Test failed!");
			logger.debug("Debug logs..");
			AssertJUnit.assertTrue(false);
		}
		
		//Assert.assertEquals(msg, "Your Account Has Been Created");
		}
		catch(Exception e)
		{
			AssertJUnit.fail();
		}
		logger.info("**** Finished TC001_AccountResgistrationTest ****");
	}
	
	
	
	
	
	
	

}
