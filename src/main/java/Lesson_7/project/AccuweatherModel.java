package Lesson_7.project;

import Lesson_7.project.WeatherModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;


public class AccuweatherModel  implements WeatherModel {

    //http://dataservice.accuweather.com/forecasts/v1/daily/1day/349727
    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAY = "5day";
    private static final String API_KEY = "qn1Rh1K2f8uxur79AnTruQz4gj6RWdBy";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";
   // private static final String TEMPERATURE = "\"Temperature \"";
    // private static final String UNITTYPE = "\"UnitType\":17";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public void getWeather(String selectedCity, DaysNumber period) throws IOException {
        switch (period) {
            case NOW:

                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                       .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                    //   .addQueryParameter("details", "true")
                        .build();


                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                String weatherResponse = oneDayForecastResponse.body().string();
                System.out.println(weatherResponse);

                /* objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

                String effectiveDate = objectMapper.readTree(weatherResponse).get(0).at("/EffectiveData").asText();
                System.out.println(effectiveDate);

               Forecast forecast = objectMapper.readValue(weatherResponse, Forecast.class);

                System.out.println(forecast.toString());*/


        break;
           case FIVE_DAYS:
                //TODO*: реализовать вывод погоды на 5 дней
            //   http://dataservice.accuweather.com/forecasts/v1/daily/5day/
               
                         HttpUrl httpUrl_5 = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAY)
                        .addPathSegment(detectCityKey("Moscow"))
                       // .addPathSegment("294021")
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                       Request request_5 = new Request.Builder()
                        .url(httpUrl_5)
                        .build();

                        Response fiveDayForecastResponse = okHttpClient.newCall(request_5).execute();
                         weatherResponse = fiveDayForecastResponse.body().string();
                         System.out.println(weatherResponse);
                break;



        }
    }

       private static String detectCityKey (String selectCity) throws IOException  {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();
           Response response = okHttpClient.newCall(request).execute();
                String responseString = response.body().string();

                String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
                return cityKey;
            }




   /* public static void main(String[] args) throws IOException {


        getWeather( "294021", DaysNumber.NOW);
        getWeather( "294021", DaysNumber.FIVE_DAYS);

    }     */


}
