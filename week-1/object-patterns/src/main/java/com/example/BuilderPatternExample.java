package com.example;

class Customer {
    private long id; // required
    private String name; // name
    private String email; // optional
    private String mobile; //optional
    private String address; // optional

    public Customer(long id, String name, String email, String mobile, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }

    static class Builder {

        private long id; // required
        private String name; // name
        private String email; // optional
        private String mobile; //optional
        private String address; // optional

        public Builder(long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setMobile(String email) {
            this.mobile = mobile;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Customer build() {
            return new Customer(id, name, email, mobile, address);
        }

    }

}


public class BuilderPatternExample {
    public static void main(String[] args) {

//    Customer customer1=new Customer(1,"A");
//    Customer customer2=new Customer(1,"A","email");
//    Customer customer3=new Customer(1,"A","email","phone");
//    Customer customer4=new Customer(1,"A","email","phone","address");

        Customer customer1 = new Customer.Builder(1, "A").build();
        Customer.Builder builder = new Customer.Builder(1, "A")
                .setMobile("phone")
                .setEmail("email");
        Customer customer2 = builder.build();

    }

}
