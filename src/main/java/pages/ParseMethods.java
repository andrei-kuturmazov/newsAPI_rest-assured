package pages;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.response.Response;

public class ParseMethods {

    public static JsonObject getJsonFromResponse(Response response) {
        return new JsonParser().parse(response.getBody().asString()).getAsJsonObject();
    }

    public static String getFirstSourceInfo(Response response) {
        return getJsonFromResponse(response)
                .get("sources").getAsJsonArray()
                .get(0).getAsJsonObject()
                .get("name").getAsString();
    }

    public static String getFirstSourceDescription(Response response) {
        return getJsonFromResponse(response)
                .get("sources").getAsJsonArray()
                .get(0).getAsJsonObject()
                .get("description").getAsString();
    }

    public static String getFirstBelarusNewsTitle(Response response) {
        return getJsonFromResponse(response)
                .get("articles").getAsJsonArray()
                .get(0).getAsJsonObject()
                .get("title").getAsString();
    }
}
