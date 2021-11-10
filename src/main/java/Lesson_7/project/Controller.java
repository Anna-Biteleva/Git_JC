package Lesson_7.project;

 import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Controller {
    private WeatherModel weatherModel = new AccuweatherModel();
    private Map<Integer, DaysNumber> variants = new HashMap<>();

    public Controller() {
        this.variants.put(1, DaysNumber.NOW);
        this.variants.put(5, DaysNumber.FIVE_DAYS);
       // variants.put(2, Period.DB);
    }



    public void getWeather(String selectedCity, String userInput ) throws IOException  {
    Integer userIntegerInput = Integer.parseInt(userInput);

        switch (variants.get(userIntegerInput)) {
            case NOW:
                weatherModel.getWeather(selectedCity, DaysNumber.NOW);
                break;
            case FIVE_DAYS:
                weatherModel.getWeather(selectedCity, DaysNumber.FIVE_DAYS);
                break;
             //    case DB:
             //   weatherModel.getSavedToDBWeather();
        }
    }


}
