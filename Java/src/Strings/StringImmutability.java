package Strings;

public class StringImmutability {
    public static void main(String[] args) {
        String s1="harish";
        s1=s1.concat(" kumar");

        StringBuilder b1=new StringBuilder("harish");
        b1.append(" kumar");

        System.out.println(b1);

        System.out.println(s1);

        String s2=new String("hk");
        String s3=new String("mk");
        s3=s2;
        System.out.println(s3);

    }
}
