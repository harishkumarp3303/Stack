package Misc;

interface Animals{
    public void run();
    public void attack();
}

class Dogs implements Animals{

    @Override
    public void run() {
        System.out.println("Dog is running");
    }

    @Override
    public void attack() {
        System.out.println("Dog is attacking");
    }
 
    public void soung(){
        System.out.println("Bow Bow");
    }
}

class Cats implements Animals{

    @Override
    public void run() {
        System.out.println("cats is running");
    }

    @Override
    public void attack() {
        System.out.println("cats is attacking");
    }
 
    public void soung(){
        System.out.println("Meow Meow");
    }
}



public class Castings {
    

    public static void main(String[] args) {

        Animals a1=new Dogs();
        a1.attack();
        a1.run();
        
        Animals anonymousanimal=new Animals() {

            @Override
            public void run() {
                System.out.println("Anonumous is running");
            }

            @Override
            public void attack() {
                System.out.println("Anonymous class attcking");
            }
            
        };

        anonymousanimal.attack();
        anonymousanimal.run();
    }
}
