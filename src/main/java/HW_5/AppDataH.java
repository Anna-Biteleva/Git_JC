package HW_5;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AppDataH {
    private  String [][] data;


    public String[][] getData() {
        return data;
    }

    public AppDataH() {
    }


    public static void main(String[] args) {
        AppDataH appData = new AppDataH();
        appData.buffer("hw_5.txt");
        System.out.println( "Данные из исходного файла:" );

        System.out.println(Arrays.deepToString(appData.getData()));

        appData.save("hw5-new.csv");
    }


    public void save(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            for (String [] row : data) {
                writer.write(rowToString(row));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private <T> String rowToString(T[] row) {
        String result = "";
        for (int i = 0; i < row.length; i++) {
            result = result + row[i].toString();
            if (i != row.length - 1) {
                result += ";";
            }
        }
        result += "\n";
        return result;
    }

    public void buffer(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            ArrayList<String[]> dataList = new ArrayList<>();
            String tempString;
            while ((tempString = bufferedReader.readLine()) != null) {
                dataList.add( tempString.split(";"));
            }
            data = dataList.toArray(new String[][]{{}});
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}







