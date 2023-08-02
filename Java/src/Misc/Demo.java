package Misc;

class Vehicle{
    String company;
    int model;
    int year;
    Integer price;
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((company == null) ? 0 : company.hashCode());
        result = prime * result + model;
        result = prime * result + year;
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vehicle other = (Vehicle) obj;
        if (company == null) {
            if (other.company != null)
                return false;
        } else if (!company.equals(other.company))
            return false;
        if (model != other.model)
            return false;
        if (year != other.year)
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        return true;
    }

    


    

    
}
public class Demo {

    public static void main(String[] args) {
        Vehicle v=new Vehicle();
        v.model=2023;
        Vehicle v1=new Vehicle();

        
        System.out.println(v.hashCode());
      
        
    }
}