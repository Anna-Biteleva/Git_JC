package Lesson_6;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;

public class accuWeather {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
              .addPathSegment("auth")
                .build();

        String authBody = "{\n" +
                "    \"username\" : \"anbi713\",\n" +
                "    \"password\" : \"Viktor25\"\n" +
                "}";

        RequestBody requestAuthBody = RequestBody.create(authBody, MediaType.parse("JSON"));

        Request requestAuth = new Request.Builder()
                .url(httpUrl)
                .addHeader("Content-Type", "application/json")
               // .addHeader("Accept-Encoding", "gzip")
                .post(requestAuthBody)
                .build();

        Response response = okHttpClient.newCall(requestAuth).execute();

        System.out.println(response.isSuccessful());

    }
}
