package better.me.dataprovider;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class UserCredentials {

    @DataProvider(name = "userCredential")
    public static Object[][] createUserData(ITestContext context) {
        return new Object[][]{
                {"user", "password"}
        };
    }

}