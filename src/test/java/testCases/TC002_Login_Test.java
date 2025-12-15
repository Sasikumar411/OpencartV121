package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_Login_Test extends BaseClass
{
	@Test(groups={"Sanity", "Master"})
	public void verify_login()
	{
		logger.info("**** Starting TC002_Login_Test *****");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickAccount();
		hp.clicklogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmailAddress(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage ap=new MyAccountPage(driver);
		boolean targetPage=ap.isMyAccountPageExist();
		//Assert.assertEquals(targetPage, true, "Login Failed");
		Assert.assertTrue(targetPage);   
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**** Finished TC002_Login_Test *****");
		
				
		
		
	}

}
