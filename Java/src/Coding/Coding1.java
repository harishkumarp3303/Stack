package Coding;

public class Coding1 {

    public static boolean isthereadigit(String s){
        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))){
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        String s="kumar";

        if(isthereadigit(s)){
            System.out.println("String contains digit");
        }else{
            System.out.println("String does not contains digit");
        }
    }
}
