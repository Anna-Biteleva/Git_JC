package HW_8.project;

import Lesson_7.project.DaysNumber;

import java.io.IOException;

import java.sql.SQLException;

public interface WeatherModel {

    void getWeather(String selectedCity, DaysNumber period) throws IOException, SQLException;

      public void getSavedToDBWeather(String city);


}
