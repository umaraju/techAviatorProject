package Day7;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class firsttestng extends secondtesng{
  @Test
  public void f1() {
	  System.out.println("test1");
  }
  @Test
  public void f2() {
	  System.out.println("test2");
  }
  @Test
  public void f3() {
	  System.out.println("test3");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Beforemethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Aftermethod");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After Class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("After Suite");
  }

}
