abstract class Item {
    protected String name;
    protected float price;
    public String name(){
        return name;
    }
    public float price(){
        return price;
    }
}

class baseItem extends Item{
    baseItem(){
        name="MotherBoard and 1TB HDD (Base)";
        price=70000;
    }
}

abstract class Extra extends Item{
    Extra(){
        name="Extra";
        price=0;
    }
}

class CPUCooler extends Extra{
    CPUCooler(){
        name="CPU Cooler";
        price=36000;
    }
}

class LiquidCooler extends Extra{
    LiquidCooler(){
        name="Liquid Cooler";
        price=17000;
    }
}

class DVDDrive extends Extra{
    DVDDrive(){
        name="DVD drive";
        price=6000;
    }
}

abstract class RAM extends Item{
    RAM(){
        name="RAM";
        price=0;
    }
}

class v1RAM extends RAM{
    v1RAM(){
        name="8GB DDR4 RAM (2555 MHz)";
        price=2620;
    }
}

class v2RAM extends RAM{
    v2RAM(){
        name="8GB DDR4 RAM (3200 MHz)";
        price=2950;
    }
}

///
abstract class GraphicsCard extends Item{
   GraphicsCard(){
       name="Graphics Card";
       price=0;
   }
}

class v1GCard extends GraphicsCard{
    v1GCard(){
        name= "2 GB Graphics Card";
        price=6500;
    }
}

class v2GCard extends GraphicsCard{
    v2GCard(){
        name= "4 GB Graphics Card";
        price=7600;
    }
}

abstract class Processor extends Item{
    Processor(){
        name="Processor";
        price=0;
    }
}

class Pro1 extends Processor{
    Pro1(){
        name="Intel Core i5";
        price=20000;
    }
}


class Pro2 extends Processor{
    Pro2(){
        name="Intel Core i7";
        price=37000;
    }
}


class Pro3 extends Processor{
    Pro3(){
        name="Intel Core i9";
        price=65000;
    }
}


class Pro4 extends Processor{
    Pro4(){
        name= "AMD Ryzen 7 5700X";
        price=28000;
    }
}