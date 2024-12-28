package com.A.GA.Model;

import com.A.GA.Repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;

public class orderAdmin {
    private static int maOrderCount = OrderRepository.tableOrderAdmin.size(); // tự động tăng id
    private int maOrder;
    private int idUser;
    private String nameCustomer;
    private double sumMoney;
    private LocalDateTime time;
    private AddressCustomer inforDetailed; // thông tin chi tiết của khách hàng
    private List<ProductChicken> products1; // link nhiều sản phẩm
    private  List<ComBo> products2 ;// Link nhiều sản phẩm combo
    private String status; // đây phải là 1 trường lựa trọn gồm các option ( đang chuẩn bị, đã giao cho ship)
    private int maStore;

    public orderAdmin(int idUser, String nameCustomer, double sumMoney, LocalDateTime time, AddressCustomer inforDetailed, List<ProductChicken> products1, List<ComBo> products2, String status, int maStore) {
        this.maOrder = maOrderCount++;
        this.idUser=idUser;
        this.nameCustomer = nameCustomer;
        this.sumMoney = sumMoney;
        this.time = time;
        this.inforDetailed = inforDetailed;
        this.products1 = products1;
        this.products2 = products2;
        this.status = status;
        this.maStore = maStore;
    }


    public int getMaStore() {
        return maStore;
    }

    public void setMaStore(int maStore) {
        this.maStore = maStore;
    }

    public static int getMaOrderCount() {
        return maOrderCount;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setSumMoney(double sumMoney) {
        this.sumMoney = sumMoney;
    }

    public static void setMaOrderCount(int maOrderCount) {
        orderAdmin.maOrderCount = maOrderCount;
    }

    public int getMaOrder() {
        return maOrder;
    }

    public void setMaOrder(int maOrder) {
        this.maOrder = maOrder;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public double getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(Long sumMoney) {
        this.sumMoney = sumMoney;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public AddressCustomer getInforDetailed() {
        return inforDetailed;
    }

    public void setInforDetailed(AddressCustomer inforDetailed) {
        this.inforDetailed = inforDetailed;
    }

    public List<ProductChicken> getProducts1() {
        return products1;
    }

    public void setProducts1(List<ProductChicken> products1) {
        this.products1 = products1;
    }

    public List<ComBo> getProducts2() {
        return products2;
    }

    public void setProducts2(List<ComBo> products2) {
        this.products2 = products2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}