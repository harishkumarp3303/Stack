package Problems;

public class Anagram {
    public static void main(String[] args) {
        String s="abc";
        String t="cae";
        boolean result=false;
        for (int i = 0; i <s.length() ; i++) {
            for (int j = 0; j <s.length()-1 ; j++) {
                if(i!=j){
                    if(s.charAt(i)==t.charAt(j)){
                        result=true;
                        t=t.substring(0,j)+t.substring(j+1);
                        System.out.println(t);
                        break;
                    }
                }
            
            
        
        }
        if(result==false){
            break;
        }
    }

    if(result){
        System.out.println("Anagram");
    
    }else{
        System.out.println("Not an Anagram");
    }
}
}