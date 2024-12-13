package tests.userTests;

import api.UserApi;
import model.userModel.CreateUserRequestModel;
import model.userModel.GetUserResponseModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;


public class PostUserCreateWithArrayTest extends BaseTest {

    @Test
    public void postUserCreateWithArrayTest() {
        // Подготовка массива пользователей
        CreateUserRequestModel[] userArray = {
                new CreateUserRequestModel(3, "user3", "First3", "Last3", "user3@example.com", "pass3", "1234567893", 1),
                new CreateUserRequestModel(4, "user4", "First4", "Last4", "user4@example.com", "pass4", "1234567894", 1)
        };

        // Отправка POST-запроса
        UserApi userApi = new UserApi();
        userApi.createUserWithArray(userArray);

        // Проверка созданных пользователей
        for (CreateUserRequestModel user : userArray) {
            // Получение данных пользователя по username
            GetUserResponseModel createdUser = userApi.getUserByUserName(user.getUsername());

            // Сравнение полей
            Assert.assertEquals(createdUser.getUsername(), user.getUsername(), "Имя пользователя не совпадает");
            Assert.assertEquals(createdUser.getEmail(), user.getEmail(), "Email не совпадает");
            Assert.assertEquals(createdUser.getPhone(), user.getPhone(), "Телефон не совпадает");
        }
    }
}