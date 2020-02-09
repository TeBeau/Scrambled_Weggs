package Model;

class Food {
    //Constructors
    public Food(int a, float p, String n, String c){
        this.aisle= a ;
        this.price= p;
        this.name= n;
        this.catagory= c;
    }

    //Accessors
    public int get_aisle(){return this.aisle;}
    public float get_price(){return this.price;}
    public String get_name(){return this.name;}
    public String get_catagory(){return this.catagory;
    }

    //Variables
    private final int aisle;
    private final float price;
    private final String name;
    private final String catagory;

}