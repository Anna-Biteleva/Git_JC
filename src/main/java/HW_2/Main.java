package HW_2;

public class Main {


    public static void main(String[] args)  {
        String [][]  corrArr = new String[4][4];
        String [][]  wrongSizeArr = new String[4][3];
        String[][] wrongDataArr = new String[4][4];

        for (int i = 0; i < corrArr.length; i++){
            for (int j = 0; j < corrArr[i].length; j++) {
                corrArr[i][j] = "2";
            } }


        for (int i = 0; i < wrongSizeArr.length; i++) {
            for (int j = 0; j < wrongSizeArr[i].length; j++) {
                wrongSizeArr[i][j] = "2";
            } }


        try {
            System.out.println("Величина каждого элемента корректного массива 4*4 :" + corrArr[3][3]);
            sumArr( corrArr);
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
        catch(MyArraySizeException e){
            e.printStackTrace();
        }

        try {
            System.out.println("Размерность второго массива:"+ wrongSizeArr.length + "*"+ wrongSizeArr[0].length);
            sumArr( wrongSizeArr);
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
        catch(MyArraySizeException e){
            e.printStackTrace();
        }

        wrongDataArr = corrArr;
        wrongDataArr[2][3] ="два";


        try {
            System.out.println("В третьем массиве один из элементов не является числом");
            sumArr( wrongDataArr);
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
        catch(MyArraySizeException e){
            e.printStackTrace();
        }




    }


    public static void sumArr  (String[][] sArr) throws MyArraySizeException, MyArrayDataException {
        int[][] iArr = new int[4][4];
        if (sArr.length != 4 || sArr[0].length != 4 || sArr[1].length != 4 || sArr[2].length != 4 || sArr[3].length != 4) {
            throw new MyArraySizeException(" Размер массива  не 4*4, а " + sArr.length +"*" + sArr[1].length);
        }
        int sum = 0;
        for (int i = 0; i < sArr.length; i++) {
            for (int j = 0; j < sArr[i].length; j++) {
                try {
                    iArr[i][j] = Integer.parseInt(sArr[i][j]);
                    sum += iArr[i][j];
                } catch (NumberFormatException e) {

                    throw new MyArrayDataException("элемент массива (" + i +"*"+ j + ") не является числом");
                }

            }

        }
        System.out.println("Сумма элементов массива:" +sum);
    }}



