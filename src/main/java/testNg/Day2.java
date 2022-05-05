package testNg;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day2 {

    @BeforeTest
    public void preRequisite() {
        System.out.println("I will execute first.");
    }

    @Test(groups = {"Smoke"})
    public void webLoginCarLoan() {
        //selenium
        System.out.println("weblogincar");
    }

    @Test
    public void mobileLoginCarLoan() {
        //Appium
        System.out.println("mobilelogincar ");
    }

    @Test
    public void loginAPILoginCarLoan() {
        //Rest Assured
        System.out.println("apilogincar");
    }

    @Test(dataProvider = "getData")
    public void dataProviderTest(String username, String password) {
        System.out.println(username);
        System.out.println(password);
    }

    @DataProvider
    public Object[][] getData() {
        //1st combination - username, password
        //2 nd - username password - no credit history
        //3rd - fraudulent credit history
        Object[][] data = new Object[3][2];
        //1 set
        data[0][0] = "firstUsername";
        data[0][1] = "password";
        //columns in the row are nothing but values for that particular combination(row)
        //2 set
        data[1][0] = "secondUsername";
        data[1][1] = "secondPassword";

        //3 setU
        data[2][0] = "thirdUsername";
        data[2][1] = "thirdPassword";
        return data;
    }
}
