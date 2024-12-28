package com.A.GA.controller;

import com.A.GA.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class RevenueController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/revenue")
    public String showRevenuePage(Model model) {
        double totalRevenue = orderRepository.getTotalRevenue();
        Map<String, Long> productSalesData = orderRepository.getProductSalesData();

        model.addAttribute("totalRevenue", totalRevenue);
        model.addAttribute("productSalesData", productSalesData);
        return "revenue";
    }
}