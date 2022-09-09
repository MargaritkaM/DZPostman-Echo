package ru.netology;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class TestTest {

    @Test
    void shouldReturnDemoAccounts() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("some data") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("some data"))
        ;
    }
        @Test
         void sendingTheRequestBody() {
            // Given - When - Then
// Предусловия
            given()
                    .baseUri("https://postman-echo.com")
                    .body("Test") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                    .when()
                    .post("/post")
// Проверки
                    .then()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .body("data", equalTo("Test"))
            ;
        }
    @Test
    void shouldReturnData() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("Hello, testers!") // отправляемые данные (заголовки и query можно выставлять аналогично)
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                .body("data", notNullValue())
                .body("data", equalTo("Hello, testers!"))
        ;
    }
    @Test
    void shouldReturnHeaderRightType() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("Hello, testers!") // отправляемые данные (заголовки и query можно выставлять аналогично)
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                .header("Content-Type", equalTo("application/json; charset=utf-8"))
        ;
    }
}