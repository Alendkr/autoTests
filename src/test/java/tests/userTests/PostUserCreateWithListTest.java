package tests.userTests;

import api.UserApi;
import model.userModel.CreateUserRequestModel;
import model.userModel.GetUserResponseModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.Arrays;
import java.util.List;

public class PostUserCreateWithListTest extends BaseTest {

    @Test
    public void postUserCreateWithListTest() {
        // Подготовка списка пользователей
        List<CreateUserRequestModel> userList = Arrays.asList(
                new CreateUserRequestModel(5, "user5", "First5", "Last5", "user5@example.com", "pass5", "1234567895", 1),
                new CreateUserRequestModel(6, "user6", "First6", "Last6", "user6@example.com", "pass6", "1234567896", 1)
        );

        // Отправка POST-запроса
        UserApi userApi = new UserApi();
        userApi.createUserWithList(userList);

        // Проверка созданных пользователей
        for (CreateUserRequestModel user : userList) {
            // Получение данных пользователя по username
            GetUserResponseModel createdUser = userApi.getUserByUserName(user.getUsername());

            // Сравнение полей
            Assert.assertEquals(createdUser.getUsername(), user.getUsername(), "Имя пользователя не совпадает");
            Assert.assertEquals(createdUser.getEmail(), user.getEmail(), "Email не совпадает");
            Assert.assertEquals(createdUser.getPhone(), user.getPhone(), "Телефон не совпадает");
        }
    }
}