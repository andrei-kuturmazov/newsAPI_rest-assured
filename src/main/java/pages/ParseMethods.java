package pages;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.response.Response;

public class ParseMethods {

    public static JsonObject getJsonFromResponse(Response response) {
        return new JsonParser().parse(response.getBody().asString()).getAsJsonObject();
    }

    public static String getFirstSourceInfo(Response response) {
        return getFirstSource(response)
                .get("name").getAsString();
    }

    public static String getFirstSourceDescription(Response response) {
        return getFirstSource(response)
                .get("description").getAsString();
    }

    public static String getFirstBelarusNewsTitle(Response response) {
        return getFirstNews(response)
                .get("title").getAsString();
    }

    public static String getFirstRUNewsSourceName(Response response) {
        return getFirstNews(response)
                .get("source").getAsJsonObject()
                .get("name").getAsString();
    }

    private static JsonObject getFirstSource(Response response) {
        return getJsonFromResponse(response)
                .get("sources").getAsJsonArray()
                .get(0).getAsJsonObject();
    }

    private static JsonObject getFirstNews(Response response) {
        return getJsonFromResponse(response)
                .get("articles").getAsJsonArray()
                .get(0).getAsJsonObject();
    }
}
