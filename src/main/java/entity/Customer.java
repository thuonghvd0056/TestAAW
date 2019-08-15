package entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

@Entity
public class Customer {
    @Id
    private long id;
    private String name;
    private String address;
    private String phone_No;
    private int status;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Order> orders;

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Customer() {
        this.status = 1;
        this.id = Calendar.getInstance().getTimeInMillis();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPhone_No() {
        return phone_No;
    }

    public void setPhone_No(String phone_No) {
        this.phone_No = phone_No;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static final class Builder {
        private long id;
        private String name;
        private String address;
        private String phone_No;
        private int status;
        private Set<Order> orders;

        private Builder() {
        }

        public static Builder aCustomer() {
            return new Builder();
        }

        public Builder withId(long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder withPhone_No(String phone_No) {
            this.phone_No = phone_No;
            return this;
        }

        public Builder withStatus(int status) {
            this.status = status;
            return this;
        }

        public Builder withOrders(Set<Order> orders) {
            this.orders = orders;
            return this;
        }

        public Customer build() {
            Customer customer = new Customer();
            customer.setId(id);
            customer.setName(name);
            customer.setAddress(address);
            customer.setPhone_No(phone_No);
            customer.setStatus(status);
            customer.setOrders(orders);
            return customer;
        }
    }
}
