package ru.yandex.praktikum.client;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.yandex.praktikum.model.User;
import static io.restassured.RestAssured.given;

public class UserClient {

    private static final String BASE_URL = "https://stellarburgers.education-services.ru/api";

    @Step("Создать пользователя через API")
    public ValidatableResponse createUser(User user) {
        return given()
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .post(BASE_URL + "/auth/register")
                .then();
    }

    @Step("Удалить пользователя через API")
    public ValidatableResponse deleteUser(String accessToken) {
        return given()
                .header("Authorization", accessToken)
                .when()
                .delete(BASE_URL + "/auth/user")
                .then();
    }
}