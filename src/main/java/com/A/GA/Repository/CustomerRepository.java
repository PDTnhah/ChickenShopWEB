package com.A.GA.Repository;

import com.A.GA.Model.AddressCustomer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {
    public static List<AddressCustomer> tableCuntomer = new ArrayList<>();

    public CustomerRepository() {
        // Thêm dữ liệu mặc định vào tableCuntomer
        tableCuntomer.add(new AddressCustomer(1, "Tuyền", "0353616131", "Yên Phong", "Be", "Thêm cơm", "Tiền mặt"));
        tableCuntomer.add(new AddressCustomer(0, "Đạt", "0353616131", "Yên Phong", "Be", "Thêm cơm", "Tiền mặt"));
        tableCuntomer.add(new AddressCustomer(2, "Đức", "0353616131", "Yên Phong", "Be", "Thêm cơm", "Tiền mặt"));
        tableCuntomer.add(new AddressCustomer(3, "Thảo", "0353616131", "Yên Phong", "Be", "Thêm cơm", "Tiền mặt"));
    }

    public static List<AddressCustomer> getAllCustomers() {
        return tableCuntomer;
    }

    public static AddressCustomer getCustomerById(int id) {
        for (AddressCustomer customer : tableCuntomer) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public static void addCustomer(AddressCustomer customer) {
        tableCuntomer.add(customer);
    }

    public void removeCustomer(int id) {
        tableCuntomer.removeIf(customer -> customer.getId() == id);
    }
}
