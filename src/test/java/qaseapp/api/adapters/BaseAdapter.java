package qaseapp.api.adapters;

import com.google.gson.Gson;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static qaseapp.api.utils.StringConstant.*;

public class BaseAdapter {
    private static final String TOKEN_VALUE = "2cc861259970a3f8a2a3be79bdfa697aef71469fdbc612193255865077d23215";
    private static final String BASE_URL = "https://api.qase.io/v1";
    protected Gson converter = new Gson();

    protected Response get(String url) {
        return
                given()
                        .header(TOKEN_NAME, TOKEN_VALUE)
                        .when()
                        .get(BASE_URL + url)
                        .then()
                        .log().all()
                        .extract().response();
    }

    protected Response post(String url, String body) {
        return
                given()
                        .header(TOKEN_NAME, TOKEN_VALUE)
                        .header(CONTENT_TYPE, JSON)
                        .body(body)
                        .when()
                        .post(BASE_URL + url)
                        .then()
                        .log().all()
                        .extract().response();
    }

    protected Response delete(String url) {
        return
                given()
                        .header(TOKEN_NAME, TOKEN_VALUE)
                        .when()
                        .delete(BASE_URL + url)
                        .then()
                        .log().all()
                        .extract().response();
    }
}
