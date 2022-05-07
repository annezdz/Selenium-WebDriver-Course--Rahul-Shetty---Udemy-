package testNg;


import org.testng.annotations.*;

public class Day3 {


    @BeforeClass
    public void beforeClass() {
        System.out.println("before executing any methods in the class.");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("after executing any methods in the class.");
    }
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("I am number 1.");
    }

    @Parameters({"URL"})
    @Test
    public void webLoginHomeLoan(String url) {
        //selenium
        System.out.println("webloginhome e o mobileLoginCheckoutLoan depende de mim");
        System.out.println(url);
    }

    @BeforeMethod
    public void beforeEvery() {
        System.out.println("I will execute before every test method in day 3 class ");
    }

    @AfterMethod
    public void afterEvery() {
        System.out.println("I will execute after every test method in day 3 class ");
    }

    @Test(enabled = false)
    public void enabledTest() {
        System.out.println("Teste ligado teste");
    }

    @Test(timeOut = 4000)
    public void testeTempo() {
        System.out.println("Esse teste usa o timeOut de 40 segundos");
    }

    @Test
    public void mobileLoginHomeLoan() {
        //Appium
        System.out.println("mobileLoginhome e o mobileLoginCheckoutLoan depende de mim");
    }

    @Test
    public void mobileLoginProductsLoan() {
        //Appium
        System.out.println("mobileProductshome");
    }

    @Test(dependsOnMethods = {"webLoginHomeLoan","mobileLoginHomeLoan"})
    public void mobileLoginCheckoutLoan() {
        //Appium
        System.out.println("mobileLoginCheckout e dependo do @test webLoginHomeLoan e do mobileLoginHomeLoan");
    }


    @Test(groups = {"Smoke"})
    public void loginAPILoginHomeLoan() {
        //Rest Assured
        System.out.println("apiloginhome");
    }
}
