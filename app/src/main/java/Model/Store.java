/**
 * @author Jacob Gualtieri
 * @date 2/8/2020
 * Representation of a Wegmans Grocery Store
 */
package Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class Store{
    // Store Attributes
    private int number;
    private String name;
    private String type;
    private boolean hasPharmacy;
    private float salesTaxPercentage;
    private Address address;
    private Object _links;

    /**
     * Creates an instance of the Store class
     * @param store_number The unique number assigned to a wegmans grocery store
     * @param store_name The name of a wegmans branch
     * @param store_type The type of wegmans branch
     * @param store_address The address of the wegmans branch
     */
    public Store(int store_number,
                 String store_name,
                 String store_type,
                 boolean hasPharmacy,
                 float salesTaxPercentage,
                 Address store_address,
                 Object _links
    ){
        this.number = store_number;
        this.name = store_name;
        this.type = store_type;
        this.hasPharmacy = hasPharmacy;
        this.salesTaxPercentage = salesTaxPercentage;
        this.address = store_address;
        this._links = _links;
    }

    public int getStoreNumber(){ return this.number; }

    public String getName(){ return this.name; }

    public String getType(){ return this.type; }

    public boolean isHasPharmacy() {
        return hasPharmacy;
    }

    public float getSalesTaxPercentage() {
        return salesTaxPercentage;
    }

    public Address getAddress(){ return this.address; }

    public Object get_links(){
        return this._links;
    }

    @Override
    public String toString(){
        return "Store: " + String.valueOf(number) + ", " + String.valueOf(name) + ", " + String.valueOf(type) + String.valueOf(address);
    }
}
