package testNg;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day4 {

    @Parameters({"KEY","URL"})
    @Test
    public void testeOvo(String key, String url) {
        System.out.println("ovovovo");
        System.out.println(key);
        System.out.println(url);
    }

}
