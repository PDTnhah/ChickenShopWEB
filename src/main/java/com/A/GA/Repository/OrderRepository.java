package com.A.GA.Repository;

import com.A.GA.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {
    public static int idOfCustomer = 1;
    public static int idOrder = 0;

    public static List<orderAdmin> tableOrderAdmin = new ArrayList<>();

    private final CustomerRepository customerRepository;

    @Autowired
    public OrderRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        List<ComBo> product2 = new ArrayList<>(ProductRepository.tableOrderComBo);
        List<ProductChicken> product1 =new ArrayList<>(ProductRepository.tableOrder);
        // Thêm các đơn hàng mặc định
        tableOrderAdmin.add(new orderAdmin(1, "trần thanh hằng", 1000, LocalDateTime.now(),
                customerRepository.getCustomerById(1), ProductRepository.tableOrder, ProductRepository.tableOrderComBo,"prepare", 1));
//        tableOrderAdmin.add(new orderAdmin(0, "trần thanh hằng", 1000, LocalDateTime.now(),
//                customerRepository.getCustomerById(2), ProductRepository.tableOrder, ProductRepository.tableOrderComBo, "prepare", 1));
    }


    public void addCustomerAdmon(int id, String hoten, String phoneNumber, String address, String transport, String paymentMethod, String note) {
        AddressCustomer newCustomer = new AddressCustomer(id, hoten, phoneNumber, address, transport, note, paymentMethod);
        CustomerRepository.addCustomer(newCustomer);
        idOfCustomer = id;
    }

    public AddressCustomer getByIdCustomer(int id) {
        return CustomerRepository.getCustomerById(id);
    }

    public void addOrderAdmin(int idUser, String hoten, double sumPrice, LocalDateTime timeNow,
                              AddressCustomer addressCustomer, List<ProductChicken> tableOrder, List<ComBo> tableOrderComBo,
                              String preparing, int maStore) {
        orderAdmin orderAdminNew = new orderAdmin(idUser, hoten, sumPrice, timeNow, addressCustomer, tableOrder, tableOrderComBo, preparing, maStore);
        tableOrderAdmin.add(orderAdminNew);
        idOrder = orderAdminNew.getMaOrder();
    }

    public orderAdmin getByIdOrder() {
        for (orderAdmin orderAdmin : tableOrderAdmin) {
            if (orderAdmin.getMaOrder() == idOrder) {
                return orderAdmin;
            }
        }
        return null;
    }

    public List<orderAdmin> getHistory(int idUser) {
        List<orderAdmin> orderAdminHistory = new ArrayList<>();
        for (orderAdmin orderAdmin : tableOrderAdmin) {
            if (orderAdmin.getIdUser() == idUser) {
                orderAdminHistory.add(orderAdmin);
            }
        }
        return orderAdminHistory;
    }

    public List<orderAdmin> getproductOfOneStore(int maStore) {
        List<orderAdmin> listProductOfOneStore = new ArrayList<>();
        for (orderAdmin orderAdmin : tableOrderAdmin) {
            if (orderAdmin.getMaStore() == maStore) {
                listProductOfOneStore.add(orderAdmin);
            }
        }
        return listProductOfOneStore;
    }
    public Map<String, Long> getProductSalesData() {
        return tableOrderAdmin.stream()
                .flatMap(order -> order.getProducts1().stream()) // Lấy danh sách products1
                .collect(Collectors.groupingBy(
                        ProductChicken::getNameProduct, // Gom nhóm theo tên sản phẩm
                        Collectors.counting()           // Đếm số lượng từng sản phẩm
                ));
    }
    public double getTotalRevenue() {
        return tableOrderAdmin.stream()
                .mapToDouble(orderAdmin::getSumMoney) // Lấy tổng tiền từ mỗi đơn hàng
                .sum(); // Tính tổng
    }
}
