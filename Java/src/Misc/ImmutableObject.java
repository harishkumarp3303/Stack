package Misc;


final class  Addresss{
    private final String city;

    private final String state;

    

    public Addresss(String city, String state) {
        this.city = city;
        this.state = state;
    }

    
    public String getCity() {
        return city;
    }


    public String getState() {
        return state;
    }


    @Override
    public String toString() {
        return "Addresss [city=" + city + ", state=" + state + "]";
    }


    
}
public class ImmutableObject {
    
    public static void main(String[] args) {
        Addresss address=new Addresss("Bangalore","Karnataka");
        System.out.println(address);


        // address.city="Chennai"; // error


        // Addresss address2 = new Addresss("Chennai","Tamil Nadu");
        // address=address2;

        System.out.println(address);

    }
}
