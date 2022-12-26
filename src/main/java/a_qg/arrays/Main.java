package a_qg.arrays;

public class Main {

    public static void main(String[] args) {

        int x;
        int y = 3;
        int z = 3;
        int w;
        x = ++y;
        w = z++;


        int[] intArray = new int[14];
        intArray[3] = 5;
        intArray[4] = 3;
        intArray[13] = 14;
        //       intArray[14]=1;

        int[] intArray2 = {4, 4, 4, 3, 3, 1, 0, -5, 7, -8};
        for (int i = 0; i < intArray2.length; i++) {
            boolean equals = false;
            for (int j = i + 1; j < intArray2.length; j++) {
                while (!equals) {
                    if (intArray2[i] == intArray2[j]) {
                        equals = true;
                        break;
                    } else System.out.println(i);
                }
            }
        }
    }


}
