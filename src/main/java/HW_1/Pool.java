package HW_1;

public class Pool {

        private int swimLength;

        public Pool(int length) {
            this.swimLength = swimLength;
        }

    public int getSwimLength() {
        return swimLength ;
        }

        public int getTimeToOvercomePool(DoSwim swimmer) {
            return swimmer.swim(this);
        }
    }

