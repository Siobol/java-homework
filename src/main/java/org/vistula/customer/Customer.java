package org.vistula.customer;

import org.vistula.basket.BasketItem;

import java.util.List;

public class Customer {
    private String firstName;
    private String lastName;
    private int age;
    private List<BasketItem> basket;

    public Customer(String firstName, String lastName, int age, List<BasketItem> basket) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.basket = basket;
    }

    public Customer (){
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<BasketItem> getBasket() {
        return basket;
    }

    public void setBasket(List<BasketItem> basket) {
        this.basket = basket;
    }

    public boolean isOfAge() {
        if (age >= 18){
            return true;}
        else {
            return false;}
    }

    public float sumItemsPrice(){
        float sum = 0;
//     for (int i = 0; i < basket.size(); i++) {
//         sum += basket.get(i).getPrice();
//     }
        // with the use of for each
        for (BasketItem item:
                basket) {
            sum += item.getPrice();
        }
        return sum;
    }

    public void addItem(BasketItem item){
        if(item.isAgeRestrictedItem())
        {
            if (isOfAge())
            {basket.add(item);
            }
            else
            {return;
            }
        }
        basket.add(item);
    }

    public void printItems(){
        for (BasketItem item:
                basket) {
            System.out.print(item.toString());
        }
    }

    public void removeItem(BasketItem item){
        if(basket.contains(item))
        {basket.remove(item);
        }
    }
}