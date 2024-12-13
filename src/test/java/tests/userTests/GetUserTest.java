package tests.userTests;

import model.userModel.GetUserResponseModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;


public class GetUserTest extends BaseTest {


    @Test
    public void getUserByUserNameTest() {
        GetUserResponseModel model = USER_API.getUserByUserName("user1");
        Assert.assertEquals(model.getUsername(), "user1");
    }
}
