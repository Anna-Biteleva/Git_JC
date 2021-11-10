package Lesson_7.project;
import java.io.IOException;

import java.util.List;
public interface WeatherModel {
    void getWeather(String selectedCity, DaysNumber period) throws IOException;

 //   public List<Weather> getSavedToDBWeather();

}
