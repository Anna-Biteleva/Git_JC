package HW_8.project;

 import Lesson_7.project.AccuweatherModel;
 import Lesson_7.project.DaysNumber;
 import Lesson_7.project.WeatherModel;

 import java.io.IOException;
 import java.sql.SQLException;
 import java.util.HashMap;
import java.util.Map;


public class Controller {
    private WeatherModel weatherModel = new AccuweatherModel();
    private Map<Integer, DaysNumber> variants = new HashMap<>();


    public Controller() {
        this.variants.put(1, DaysNumber.NOW);
        this.variants.put(5, DaysNumber.FIVE_DAYS);
        this.variants.put(2, DaysNumber.DB);
    }



    public void getWeather(String selectedCity, String userInput ) throws IOException  {
    Integer userIntegerInput = Integer.parseInt(userInput);

        switch (variants.get(userIntegerInput)) {
            case NOW:
                try {
                    weatherModel.getWeather(selectedCity, DaysNumber.NOW);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case FIVE_DAYS:
                try {
                    weatherModel.getWeather(selectedCity, DaysNumber.FIVE_DAYS);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

                case DB:
                weatherModel.getSavedToDBWeather(selectedCity);
                break;
        }
    }


}
