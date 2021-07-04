package org.example.alphamodel.risorse;

import org.example.alphamodel.risorse.Resource;

public class ResourceQuantity {
    private final Resource resource;
    private int quantity;

    public ResourceQuantity(Resource resource, int quantity){
        this.resource=resource;
        this.quantity=quantity;
    }

    /** @return the enum (name) of the resource
     */
    public Resource getResource() {
        return resource;
    }


    /** @return the quantity of the resource
     */
    public int getQuantity() {
        return quantity;
    }


    /** setQuantity is a setter method for the object's quantity parameter
     * @param quantity is the new quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRequirementAsString() {
        return quantity + " " +resource.toString();
    }
}
