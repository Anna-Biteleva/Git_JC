package Lesson_7.project;

import Lesson_7.project.entity.Weather;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.SQLException;


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
    private static final String TEMPERATURE = "Temperature ";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final DataBaseRepository dataBaseRepository = new DataBaseRepository();

    //ArrayList<String[]> dateList = new ArrayList<>();


    @Override
    public void getWeather(String selectedCity, DaysNumber period) throws IOException, SQLException {
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
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                String weatherResponse = oneDayForecastResponse.body().string();
                System.out.println(weatherResponse);


                String weatherDate = objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(0).at("/Date").asText();
                String weatherMinTemp = objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(0).at("/Temperature").at("/Minimum").at("/Value").asText();
                String weatherMaxTemp = objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(0).at("/Temperature").at("/Maximum").at("/Value").asText();
                String precipitation = objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(0).at("/Day").at("/PrecipitationType").asText();


                Double minTemp = Double.parseDouble(weatherMinTemp);
                Double maxTemp = Double.parseDouble(weatherMaxTemp);
                Double temperature = ((maxTemp + minTemp) / 2 - 32) * 5 / 9;
                String tempAbbr = String.format("%.2f", temperature);

               // System.out.println( Double.parseDouble(tempAbbr));

                String[] dateList = weatherDate.split("T");
                System.out.println("Weather at " + selectedCity + " for " + dateList[0] + ": Average temperature is " + tempAbbr + "C " + precipitation);


                dataBaseRepository.saveWeatherToDataBase(new Weather(selectedCity, dateList[0], temperature));


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
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request request_5 = new Request.Builder()
                        .url(httpUrl_5)
                        .build();

                Response fiveDayForecastResponse = okHttpClient.newCall(request_5).execute();
                weatherResponse = fiveDayForecastResponse.body().string();
                System.out.println(weatherResponse);

                for (int i = 0; i < 5; i++) {
                    String weatherDate_5 = objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(i).at("/Date").asText();
                    String weatherMinTemp_5 = objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(i).at("/Temperature").at("/Minimum").at("/Value").asText();
                    String weatherMaxTemp_5 = objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(i).at("/Temperature").at("/Maximum").at("/Value").asText();
                    String precipitation_5 = objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(i).at("/Day").at("/PrecipitationType").asText();


                    Double minTemp_5 = Double.parseDouble(weatherMinTemp_5);
                    Double maxTemp_5 = Double.parseDouble(weatherMaxTemp_5);
                    Double temperature_5 = ((maxTemp_5 + minTemp_5) / 2 - 32) * 5 / 9;
                    String tempAbbr_5 = String.format("%.2f", temperature_5);
                   // double tempDouble_5 =Double.parseDouble(tempAbbr_5);
                    String[] dateList_5 = weatherDate_5.split("T");
                    System.out.println("Weather at " + selectedCity + " for " + dateList_5[0] + ": Average temperature is " + tempAbbr_5 + "C " + precipitation_5);


                    dataBaseRepository.saveWeatherToDataBase(new Weather(selectedCity, dateList_5[0], temperature_5));

                }

                break;

        }
    }


    private static String detectCityKey(String selectCity) throws IOException {
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

    @Override
    public void getSavedToDBWeather(String city) {

        dataBaseRepository.getSavedToDBWeather(city);

    }
}





