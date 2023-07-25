package Problems;

public class CharacterClassproblem {
    public static void main(String[] args) {
        String str = "Hello World@3%^&";

        for (int i = 0; i < args.length; i++) {
            if(Character.isLetter(str.charAt(i))&& Character.isDigit(str.charAt(i))&&Character.isWhitespace(str.charAt(i))){
                
            }
        }
        
    }
}
