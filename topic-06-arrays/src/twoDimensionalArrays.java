public class twoDimensionalArrays {
    public static void main(String[] args) {
        int[][] seats = new int[3][4];

        // convert this to the ticketing system
        seats[0][0] = 1;
        seats[0][1] = 2;
        seats[0][2] = 3;
        seats[1][0] = 4;
        seats[1][1] = 5;
        seats[1][2] = 6;
        seats[2][0] = 7;
        seats[2][1] = 8;
        // I feel this is done
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }
}
