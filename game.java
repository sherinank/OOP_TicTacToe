import java.util.Scanner;

public class game {
    public static Scanner scanner = new Scanner(System.in);

    //untuk menentukan kapan berhenti
    public static boolean flag = false;

    public static char maps[][] = {
        //ini varb global
        {'_','_','_'},
        {'_','_','_'},
        {'_','_','_'}
    };

    public static char pemenang;

    public static int baris, kolom;

    public static void printMap(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(maps[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void gantiMap(int angka){
        if (angka %2 != 0){
            maps[baris-1][kolom-1] = 'O'; 
        } else {
            maps[baris-1][kolom-1] = 'X'; 
        }
    }

    public static void cekMenang(){
        for(int i = 0; i < 3; i++){
            if(maps[i][0] != '_' && maps[i][0] == maps[i][1] && maps[i][1] == maps[i][2]){
                pemenang = maps[i][0];
                flag = true;
            }
            if(maps[0][i] != '_' && maps[0][i] == maps[1][i] && maps[1][i] == maps[2][i]){
                pemenang = maps[0][i];
                flag = true;
            }
        }
        if(maps[0][0] == maps[1][1] && maps[1][1] == maps[2][2] && maps[0][0] != '_'){
            pemenang = maps[0][0];
            flag = true;
        } 
        if (maps[0][2] == maps[1][1] && maps[1][1] == maps[2][0] && maps[0][2] != '_'){
            pemenang = maps[0][2];
            flag = true;
        }
    }

    public static void playGame(){
        printMap();

        int i = 1;
        //loop sampai <= 9 & sudah ada yg menang
        while(i <= 9 && flag == false){
            int papi;
            do { 
                papi = 0;
                if(i % 2 != 0){
                    System.err.println("Player 1");
                    System.out.print("Input Baris & Kolom : ");
                    baris = scanner.nextInt();
                    kolom = scanner.nextInt();
                } else {
                    System.err.println("Player 2");
                    System.out.print("Input Baris & Kolom : ");
                    baris = scanner.nextInt();
                    kolom = scanner.nextInt();
                }
    
                if(baris < 1 || baris > 3 || kolom < 1 || kolom > 3){
                    papi = 1;
                }
                else if(maps[baris - 1][kolom - 1] != '_'){
                    papi = 2;
                }
                if(papi == 1){
                    System.err.println("Input the right koor");
                } else if (papi == 2) {
                    System.err.println("The koor has been changed");
                }
            } while (papi != 0);

            gantiMap(i);
            cekMenang();
            printMap();
            i++;
        }
        if(pemenang == 'O'){
            System.out.println("Player 1 the winner");
        } else if (pemenang == 'X'){
            System.out.println("Player 2 is the winner");
        } else {
            System.out.println("No One Win The Game");
        }
    }
    public static void main(String[] args) {
        playGame();
    }
}