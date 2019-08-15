package controller;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import entity.Customer;
import model.CustomerModel;

public class CustomerController extends ActionSupport implements ModelDriven<Customer> {
    private Customer customer;
    private CustomerModel customerModel = new CustomerModel();

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public  String create(){
        this.customer = Customer.Builder.aCustomer().build();
        return INPUT;
    }
    public String save(){
        customerModel.save(customer);
        return SUCCESS;
    }

    @Override
    public Customer getModel() {
        return customer;
    }
}
