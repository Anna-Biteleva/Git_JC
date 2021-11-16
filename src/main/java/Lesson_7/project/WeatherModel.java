package Lesson_7.project;

import java.io.IOException;

import java.sql.SQLException;

public interface WeatherModel {

    void getWeather(String selectedCity, DaysNumber period) throws IOException, SQLException;

      public void getSavedToDBWeather();


}
