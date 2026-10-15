public class sellTV {
    public static void main(String[] args) {
        tv[] tvs = new tv[3];
        
        
        tvs[0] = new tv();
        tvs[1] = new tv();
        tvs[2] = new tv();

        for(int i = 0; i < tvs.length; i++) {
            tvs[i].setVolume(10);
        }
    }
}
