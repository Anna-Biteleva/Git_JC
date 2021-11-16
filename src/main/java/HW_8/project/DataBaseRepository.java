package HW_8.project;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Lesson_7.project.entity.Weather;


public class DataBaseRepository {

    private String insertWeather = "insert into weather (city, localDate, temperature) values (?, ?, ?)";
  //  private String getWeather = "select * from weather; ";



    private static final String DB_PATH = "jdbc:sqlite:geekbrains.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean saveWeatherToDataBase(Weather weather) throws SQLException {

        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, weather.getCity());
            saveWeather.setString(2, weather.getLocalDate());
            saveWeather.setDouble(3, weather.getTemperature());
           // connection.close();
            return saveWeather.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Сохранение погоды в базу данных не выполнено!");

    }


    public List<Weather> getSavedToDBWeather(String city) {
        System.out.println("****************");
        List<Weather> weathers = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement getDBWeather = connection.prepareStatement("select * from weather where city =?");
            getDBWeather.setString(1, city);
            ResultSet resultSet= getDBWeather.executeQuery();


            while (resultSet.next()) {
                //   System.out.print(resultSet.getInt("id"));
                System.out.print("Expected temperature at  " + resultSet.getString("city"));
                System.out.print(" on  " + resultSet.getString("localDate") + " is ");
                System.out.println( String.format("%.2f",resultSet.getDouble("temperature")) +"C");
                weathers.add(new Weather(resultSet.getString("city"),
                        resultSet.getString("localDate"),
                        resultSet.getDouble("temperature")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return weathers;
    }

    }


