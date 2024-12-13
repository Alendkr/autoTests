package tests.userTests;

import api.UserApi;
import model.userModel.GetUserResponseModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;


public class DeleteUserTest extends BaseTest {


    @Test
    public void deleteUserTest() {
        USER_API.deleteUser("user12");
    }
}

