package tests.userTests;

import model.userModel.GetLoginResponseModel;
import model.userModel.GetUserResponseModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;


public class GetUserLoginTest extends BaseTest {


    @Test
    public void getUserLogin() {;
        GetLoginResponseModel user = new GetLoginResponseModel(
                0,
                "user1",
                "password",
                0);
        USER_API.getUserLogin(user);
        GetUserResponseModel loginUser = USER_API.getUserByUserName("user1");

        // Утверждения для проверки правильности данных
        Assert.assertEquals(loginUser.getUsername(), "user1", "Имя пользователя не соответствует");
        Assert.assertEquals(loginUser.getPassword(), "password", "Пароль не соответствует");
        //Assert.assertEquals(loginUser.getUserStatus(), 0, "Статус пользователя не соответствует");
    }
}