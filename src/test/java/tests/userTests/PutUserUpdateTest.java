package tests.userTests;

import model.userModel.GetUserResponseModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class PutUserUpdateTest extends BaseTest {


    @Test
    public void putUserUpdateTest() {
        GetUserResponseModel user = new GetUserResponseModel(0,
                "test123",
                "UpdatedFirst",
                "UpdatedLast",
                "updated@test.com",
                "newPassword",
                "0987654321",
                0);
        USER_API.updateUser("user1", user);

        GetUserResponseModel createdUser = USER_API.getUserByUserName("test123");

        // Утверждения для проверки правильности данных
        Assert.assertEquals(createdUser.getUsername(), "test123", "Имя пользователя не соответствует");
        Assert.assertEquals(createdUser.getFirstName(), "UpdatedFirst", "Имя не соответствует");
        Assert.assertEquals(createdUser.getLastName(), "UpdatedLast", "Фамилия не соответствует");
        Assert.assertEquals(createdUser.getEmail(), "updated@test.com", "Email не соответствует");
        Assert.assertEquals(createdUser.getPassword(), "newPassword", "Пароль не соответствует");
        Assert.assertEquals(createdUser.getPhone(), "0987654321", "Телефон не соответствует");
        //Assert.assertEquals(createdUser.getUserStatus(), 0, "Статус пользователя не соответствует");
    }
}
