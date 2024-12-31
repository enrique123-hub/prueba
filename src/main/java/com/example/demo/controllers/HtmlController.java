package com.example.demo.controllers;

import com.example.demo.model.Supplier;
import com.example.demo.model.Trade;
import com.example.demo.model.TradeCommand;
import com.example.demo.service.SupplierService;
import com.example.demo.service.TradeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HtmlController {

    @Autowired
    private TradeService tradeService;

    @Autowired
    private SupplierService supplierService;

    @GetMapping("")
    public String getTradesPage(Model model) {
        model.addAttribute("trades", tradeService.getAllTrades());
        return "trade-page";
    }

    @GetMapping("/add-trade")
    public String addTradeForm(Model model) {
        model.addAttribute("trade", new Trade());
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "add-trade";
    }

    @GetMapping("/edit-trade/{id}")
    public String editTrade(@PathVariable("id") String tradeId, Model model) {
        Trade trade = tradeService.getTradeById(tradeId);
        model.addAttribute("trade", trade);
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "edit-trade";
    }

    @GetMapping("/add-supplier")
    public String addSupplierForm(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "add-supplier";
    }

    @PostMapping("/add-trade")
    public String addTrade(@ModelAttribute TradeCommand tradeCommand) {
        Supplier existingSupplier = supplierService.getSupplierById(tradeCommand.getSupplierId());
        tradeService.createTrade(tradeCommand, existingSupplier);
        return "redirect:/trades-page";
    }

    @PostMapping("/update-trade/{id}")
    public String updateTrade(@PathVariable("id") String tradeId, @ModelAttribute TradeCommand tradeCommand) {
        Trade trade = tradeService.getTradeById(tradeId);
        Supplier existingSupplier = supplierService.getSupplierById(tradeCommand.getSupplierId());
        tradeService.updateTrade(trade, existingSupplier, tradeCommand);
        return "redirect:/trades-page";
    }

    @PostMapping("/delete-trade/{id}")
    public String deleteTrade(@PathVariable("id") String tradeId) {
        tradeService.deleteTrade(tradeId);
        return "redirect:/trades-page";
    }

    @PostMapping("/add-supplier")
    public String addSupplier(@ModelAttribute Supplier supplier) {
        supplierService.createSupplier(supplier);
        return "redirect:/trades-page";
    }
}