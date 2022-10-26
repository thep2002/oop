import java.util.Scanner;

public class DayOfaMonth {

    static String scanString() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    static int checkMonthChars(String month) {
        String[] monthName = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
        String[] monthShortName = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
        for(int i = 0; i < 12; i++) {
            if(month.equals(monthShortName[i]) || month.equals(monthName[i])) return i+1;
        }
        return 0;
    }

    static int monthValidation() {
        String monthInput;
        int check = 0;
        int month = 0;
        do {
            System.out.print("Enter the month ");
            monthInput = scanString();
            if(checkMonthChars(monthInput.toUpperCase()) > 0) {
                month = checkMonthChars(monthInput.toUpperCase());
                check = 1;
            }
            if(monthInput.length() == 4 && monthInput.charAt(3) == '.') {
                month = checkMonthChars(monthInput.substring(0,3).toUpperCase());
                // System.out.print(monthInput.substring(0,3));
                if(month > 0)  {
                    check = 1;
                }
            }
            if(monthInput.length() == 3) {
                month = checkMonthChars(monthInput.toUpperCase());
                if(month > 0) {
                    check = 1;
                }
            }
            if(monthInput.length() == 2) {
                if(Character.isDigit(monthInput.charAt(0)) && Character.isDigit(monthInput.charAt(1))) {
                    month = Integer.parseInt(monthInput);
                    if(month > 0 && month < 13) check = 1;
                }
            }
            if(monthInput.length() == 1) {
                if(Character.isDigit(monthInput.charAt(0))) {
                    month = Integer.parseInt(monthInput);
                    if(month > 0 && month < 10) check = 1;
                }
            }
            if(check == 0) System.out.println("Nhập lại tháng !");
        } while(check == 0);
        return month;
    }
    static boolean checkyears(){
        System.out.print("Enter the years ");
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        if(k%400==0){
            return true;
        }
        if(k%100==0){
            return false;
        }
        if(k%4==0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int n = monthValidation();
        boolean k = checkyears();
        if (n==2 && k==true){
            System.out.println("29");
            System.exit(0);
        }
        if (n==2){
            System.out.println("28");
            System.exit(0);
        }
        if (n==1 || n==3 ||n==5 ||n==7 ||n==8 ||n==10 ||n==12){
            System.out.println("31");
            System.exit(0);
        }
        else{
            System.out.println("30");
            System.exit(0);
        }
    }
}