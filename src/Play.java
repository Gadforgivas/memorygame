import java.util.ArrayList;
import java.util.Scanner;

public class Play {


    private static Cards[][] kartlar = new Cards[4][4];


    public static void main(String[] args){

        ArrayList<String> bands = new ArrayList<String>();

        bands.add("Disturbed");
        bands.add("Metallica");
        bands.add("Chino Moreno");
        bands.add("Farmer Boys");
        bands.add("As i lay Dying");


        kartlar[0][0] = new Cards('A');
        kartlar[0][1] = new Cards('B');
        kartlar[0][2] = new Cards('C');
        kartlar[0][3] = new Cards('D');
        kartlar[1][0] = new Cards('E');
        kartlar[1][1] = new Cards('F');
        kartlar[1][2] = new Cards('G');
        kartlar[1][3] = new Cards('H');
        kartlar[2][0] = new Cards('A');
        kartlar[2][1] = new Cards('B');
        kartlar[2][2] = new Cards('C');
        kartlar[2][3] = new Cards('D');
        kartlar[3][0] = new Cards('E');
        kartlar[3][1] = new Cards('F');
        kartlar[3][2] = new Cards('G');
        kartlar[3][3] = new Cards('H');

        tabloyuGoster();
        for(String a : bands){

            System.out.println(a);
        }

        while(true){

            tahminAl();
        }

    }

   public static void tabloyuGoster(){

        for(int i = 0 ; i < 4 ; i++){
            for(int j = 0 ; j < 4 ; j++){
                if(kartlar[i][j].isTahmin()){

                    System.out.print(" | "+ kartlar[i][j].getDeger()+ " | ");
                } else{
                    System.out.print(" | | ");
                }
            }
            System.out.println("");
        }
    }

    public static void tahminAl(){

        Scanner scanner = new Scanner(System.in);

        System.out.println(" Açılacak kartın konumunu arada bir boşluk olacak şekilde sırasıyla i j olarak giriniz");
        int i1 = scanner.nextInt();
        int j1 = scanner.nextInt();

        kartlar[i1][j1].setTahmin(true);
        tabloyuGoster();

        int i2 = scanner.nextInt();
        int j2 = scanner.nextInt();

        if(kartlar[i1][j1].getDeger()== kartlar[i2][j2].getDeger()){

            kartlar[i2][j2].setTahmin(true);
            tabloyuGoster();

        } else {

            kartlar[i1][j1].setTahmin(false);
            kartlar[i2][j2].setTahmin(false);
            tabloyuGoster();

        }
    }

}
