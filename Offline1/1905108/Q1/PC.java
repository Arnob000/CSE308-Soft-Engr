import java.util.ArrayList;
import java.util.List;

public class PC {
    private List<Item> items;

    public  PC(){
        items=new ArrayList<Item>();
    }

    public void addItem(Item i){
        items.add(i);
    }

    public float totalPrice(){
        float totPrice=0;

        for(Item i: items){
            totPrice=totPrice+i.price();
        }
        return totPrice;
    }

    public void show(){
        System.out.println("-------------------------");
        for(Item i: items){
            System.out.print(i.name()+" "+i.price()+" BDT\n");
        }
        System.out.println("-------------------------");
        System.out.print("Total price: "+totalPrice()+" BDT\n");
        System.out.println("-------------------------");
        System.out.println();
    }
}
