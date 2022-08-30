package com.example.week01;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerController {
    private ArrayList<Customer> customers;
    private boolean gender;

    public CustomerController(){
        customers = new ArrayList<Customer>();
        customers.add(new Customer("1010", "John", true, 25));
        customers.add(new Customer("1018", "Peter", true, 24));
        customers.add(new Customer("1019", "Sara", false, 23));
        customers.add(new Customer("1110", "Rose", false, 23));
        customers.add(new Customer("1001", "Emma", false, 30));
    }
//function
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ArrayList<Customer> getCustomers(){
        return this.customers;
    }

    @RequestMapping(value = "/customerbyid/{id}", method = RequestMethod.GET)
    public Customer getCustomerByID(@PathVariable("id") String ID){
        for (Customer data: customers) {
            if (data.getID().equals(ID)){
                return data;
            }
        }
        return null;
    }

    @RequestMapping(value = "/customerbyname/{name}", method = RequestMethod.GET)
    public Customer getCustomerByName(@PathVariable("name") String n){
        for (Customer data: customers) {
            if (data.getName().equals(n)){
                return data;
            }
        }
        return null;
    }

    @RequestMapping(value = "/customerbyDelByid/{id}", method = RequestMethod.DELETE)
    public boolean delCustomerByID(@PathVariable("id") String ID){
        for (Customer data: customers) {
            if (data.getID().equals(ID)){
                customers.remove(data);
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/customerbyDelByname/{name}", method = RequestMethod.DELETE)
    public boolean delCustomerByName(@PathVariable("name") String n){
        for (Customer data: customers) {
            if (data.getName().equals(n)){
                customers.remove(data);
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
    public boolean addCustomer(@RequestParam("id") String ID, @RequestParam("name") String n, @RequestParam("sex") String s, @RequestParam("age") int a){
        if (s.equals("Male") || s.equals("male")){
            gender = true;
        }
        else {
            gender = false;
        }
        customers.add(new Customer(ID, n, gender, a));
        return true;
    }

    @RequestMapping(value = "/addCustomer2", method = RequestMethod.GET)
    public boolean addCustomer2(@RequestParam("id") String ID, @RequestParam("name") String n, @RequestParam("sex") String s, @RequestParam("age") int a){
        if (s.equals("Male") || s.equals("male")){
            gender = true;
        }
        else {
            gender = false;
        }
        customers.add(new Customer(ID, n, gender, a));
        return true;
    }


}
