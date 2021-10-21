package Lesson_HW;

public class Boy extends Student{

    public Boy(String name, int runDistance, int jumpHeight) {
        super(name, runDistance, jumpHeight);
    }

    @Override
    public String getData() {
        return ( "мальчик "+ name + ", который может пробежать " + runDistance + " км и взять барьер высотой " + jumpHeight + " см." );
    }
}
