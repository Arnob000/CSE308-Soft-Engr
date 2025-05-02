//implementation
interface OS {
   void storeFile();
   void interact();
   void communicate();
}

class Windoors implements OS{
    String name;

    Windoors(){
        name="Windoors";
    }
    public void storeFile(){
        System.out.println("Functionality: Store file\nModule: Storage\nOS: "+name);
    }
    
    public void interact(){
        System.out.println("Functionality: Interact with device\nModule: Interface\nOS: "+name);        
    }

    public void communicate(){
        System.out.println("Functionality: Communicate with one another \nModule: Communication\nOS: "+name);
    }
}

class Linus implements OS{
    String name;

    Linus(){
        name="Linus";
    }
    public void storeFile(){
        System.out.println("Functionality: Store file\nModule: Storage\nOS: "+name);
    }

    public void interact(){
        System.out.println("Functionality: Interact with device\nModule: Interface\nOS: "+name);
    }

    public void communicate(){
        System.out.println("Functionality: Communicate with one another \nModule: Communication\nOS: "+name);
    }
}