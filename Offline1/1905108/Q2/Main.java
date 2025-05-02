import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class car{
    protected String brandName;
    protected String manCountry;
    protected String color;
    protected String engine;
    protected String dt;

    public void brandName() {
        System.out.println(brandName);
    }
    public void man_country(){
        System.out.println(manCountry);
    }
    public void color(){
        System.out.println(color);
    }
    public void engine(){
        System.out.println(engine);
    }
    public void driveTrains(){
        System.out.println(dt);
    }
    abstract void createCar();
}

class Toyota extends car{
    @Override
    public void createCar(){
        brandName="Toyota";
        manCountry="Japan";
        color="Red";
        engine="Hydrogen fuel cell";
        dt="Rear-wheel";
    }

}

class BMW extends car{
    @Override
    public void createCar(){
        brandName="BMW";
        manCountry="Germany";
        color="Black";
        engine="Electric";
        dt="Rear-wheel";
    }
}

class Tesla extends car{
    @Override
    public void createCar(){
        brandName="Tesla";
        manCountry="US";
        color="White";
        engine="Electric";
        dt="All wheels";
    }
}


class carFactory{
    public car getCar(String location){
        if(location==null){
            return null;
        }
        else if(location.equalsIgnoreCase("Asia")){
            return new Toyota();
        }
        else if(location.equalsIgnoreCase("Europe")){
            return new BMW();
        }
        else if(location.equalsIgnoreCase("US")){
            return new Tesla();
        }
        else
            return null;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        carFactory cf =new carFactory();
        car c;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter your location->\n(a)Asia\n(b)Europe\n(c)US\nEnter: ");
        String location=br.readLine();
        c=cf.getCar(location);

        if(c==null)
            System.out.println("Wrong location!");
        else {
            System.out.println("\nYour car info");
            System.out.println("---------------------------");
            System.out.print("Brand Name: ");
            c.createCar();
            c.brandName();
            System.out.print("Manufacturing Country: ");
            c.man_country();
            System.out.print("Color: ");
            c.color();
            System.out.print("Engine: ");
            c.engine();
            System.out.print("Drive Trains: ");
            c.driveTrains();
        }
    }
}