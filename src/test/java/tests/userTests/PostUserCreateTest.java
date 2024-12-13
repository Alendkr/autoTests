package tests.userTests;

import api.UserApi;
import model.userModel.GetUserResponseModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class PostUserCreateTest extends BaseTest {


    @Test
    public void postUserCreateTest() {
        GetUserResponseModel user = new GetUserResponseModel(
                0,
                "user1",
                "First",
                "Last",
                "email@test.com",
                "password",
                "1234567890",
                0);
        USER_API.createUser(user);
        GetUserResponseModel createdUser = USER_API.getUserByUserName("user1");

        // Утверждения для проверки правильности данных
        Assert.assertEquals(createdUser.getUsername(), "user1", "Имя пользователя не соответствует");
        Assert.assertEquals(createdUser.getFirstName(), "First", "Имя не соответствует");
        Assert.assertEquals(createdUser.getLastName(), "Last", "Фамилия не соответствует");
        Assert.assertEquals(createdUser.getEmail(), "email@test.com", "Email не соответствует");
        Assert.assertEquals(createdUser.getPassword(), "password", "Пароль не соответствует");
        Assert.assertEquals(createdUser.getPhone(), "1234567890", "Телефон не соответствует");
        Assert.assertEquals(createdUser.getUserStatus(), 0, "Статус пользователя не соответствует");
    }
}
