package api;

import io.restassured.http.ContentType;
import model.userModel.CreateUserRequestModel;
import model.userModel.GetLoginResponseModel;
import model.userModel.GetUserResponseModel;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserApi {

    private static final String BASE_URI = "https://petstore.swagger.io/v2";

    public GetUserResponseModel getUserByUserName(String userName) {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .when()
                .log().all()
                .get("/user/" + userName)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(GetUserResponseModel.class);
    }
    public void getUserLogin(GetLoginResponseModel user) {
        given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(user)
                .when()
                .log().all()
                .get("/user/login")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(GetUserResponseModel.class);
    }
    public GetUserResponseModel getUserLogout() {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .when()
                .log().all()
                .get("/user/logout")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(GetUserResponseModel.class);
    }

    public void createUser(GetUserResponseModel user) {
        given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(user)
                .when()
                .log().all()
                .post("/user")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(GetUserResponseModel.class);
    }

    public void createUserWithArray(CreateUserRequestModel[] user) {
        given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(user)
                .when()
                .log().all()
                .post("/user/createWithArray")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(GetUserResponseModel.class);
    }
    public void createUserWithList(List<CreateUserRequestModel> user) {
        given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(user)
                .when()
                .log().all()
                .post("/user/createWithList")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(GetUserResponseModel.class);
    }

    public void updateUser(String userName, GetUserResponseModel user) {
        given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(user)
                .when()
                .log().all()
                .put("/user/" + userName)
                .then()
                .statusCode(200)
                .log().all();
    }

    public void deleteUser(String userName) {
        given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .when()
                .log().all()
                .delete("/user/" + userName)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(GetUserResponseModel.class);
    }
}
