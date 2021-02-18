package parameterization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterization {

    @Test(dataProvider = "getData")
    public void loginTest(String login, String password) {
        System.out.println(login + "----" + password);
    }

    @DataProvider
    public Object[][] getData() {

        Object[][] data = new Object[3][2];

        data[0][0] = "user1@mail.ru";
        data[0][1] = "1234";

        data[1][0] = "user2@mail.ru";
        data[1][1] = "5486";

        data[2][0] = "user3@mail.ru";
        data[2][1] = "585785";

        return data;
    }
}
