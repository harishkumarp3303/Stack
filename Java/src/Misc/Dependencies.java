
package Misc;

class Engine{

    String engineName;
    int enginePower;
    @Override
    public String toString() {
        return "Engine [engineName=" + engineName + ", enginePower=" + enginePower + "]";
    }

    
}
class Car{

    Engine engine;
    String carName;
    int carSpeed;

    public void loadengine(){
        System.out.println(engine.toString());
    }


    public static void main(String[] args) {
        Car car = new Car();
        car.loadengine();

    }
}

public class Dependencies {
    
}
