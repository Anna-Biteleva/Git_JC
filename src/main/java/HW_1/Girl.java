package HW_1;

public class Girl extends Student implements DoSwim {

    private int swimmingSpeed;

    public Girl(String name, int runDistance, int jumpHeight) {
        super(name, runDistance, jumpHeight);
        swimmingSpeed =  Course.randomValue( 600, 1200 );
    }
@Override
    public String getData() {
        return ( name + ", которая может пробежать " + runDistance + " км и взять барьер высотой " + jumpHeight + " см. Кроме того, она умеет плавать, проплывая за час " + swimmingSpeed + " метров." );
    }


    @Override
    public int swim(Pool pool) {
        return (int) (pool.getSwimLength()/swimmingSpeed);
    }
}
