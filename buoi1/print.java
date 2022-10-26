import java.util.Scanner;
public class print{
    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("n = ");
        int iAge = keyboard.nextInt();
        for(int value=0;value < iAge;value++){
            for(int valuefor=0;valuefor < iAge-value-1; valuefor++ ){
                System.out.print(" ");
            }
            for(int valuefor=0;valuefor < value*2+1; valuefor++ ){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}