package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Supplier;
import com.example.demo.model.Trade;
import com.example.demo.model.TradeCommand;
import com.example.demo.service.SupplierService;
import com.example.demo.service.TradeService;

@RestController
@RequestMapping("/api/trade")
public class TradeController {

    @Autowired
    private TradeService tradeService;

    @Autowired
    private SupplierService supplierService;
    
    @GetMapping("/{id}")
    public Trade getTradeById(@PathVariable String id) {
        return tradeService.getTradeById(id);
    }    

    @GetMapping("")
    public List<Trade> getTrades(){
        return tradeService.getAllTrades();
    }

    @PostMapping("")
    public Trade createdTrade(@RequestBody TradeCommand tradeCommand){
        Supplier existingSupplier = supplierService.getSupplierById(tradeCommand.getSupplierId());
        return tradeService.createTrade(tradeCommand, existingSupplier);
    }

    @PutMapping("/{id}")
    public Trade updateTrade(@PathVariable String id, @RequestBody TradeCommand tradeCommand) {
        Trade trade = tradeService.getTradeById(id);
        Supplier existingSupplier = supplierService.getSupplierById(tradeCommand.getSupplierId());
        return tradeService.updateTrade(trade, existingSupplier, tradeCommand);
    }

    @DeleteMapping("/{id}")
    public void deleteTradeById(@PathVariable String id) {
        tradeService.deleteTrade(id);
    }
   
}