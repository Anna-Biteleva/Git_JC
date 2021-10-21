package Lesson_HW;

public class Girl extends Student{

    public Girl(String name, int runDistance, int jumpHeight) {
        super(name, runDistance, jumpHeight);
    }
@Override
    public String getData() {
        return ( "девочка "+ name + ", которая может пробежать " + runDistance + " км и взять барьер высотой " + jumpHeight + " см." );
    }
}
