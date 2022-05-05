package testNg;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Day1 {

    @AfterTest
    public void lastExecution() {
        System.out.println("I will execute last.");
        Assert.assertEquals("teste","tt");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("I am the number 1 from last .");
    }

    @Test
    public void Demo() {
        System.out.println("Hello");
    }

    @Test
    public void secondTest() {
        System.out.println(" Bye");
    }
}
