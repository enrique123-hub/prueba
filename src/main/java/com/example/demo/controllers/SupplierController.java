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
import com.example.demo.service.SupplierService;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/{id}")
    public Supplier getSupplierById(@PathVariable String id) {
        return supplierService.getSupplierById(id);
    }

    @GetMapping("")
    public List<Supplier> getTrades(){
        return supplierService.getAllSuppliers();
    }
    
    @PostMapping("")
    public Supplier createdSupplier(@RequestBody Supplier supplier) {
        return supplierService.createSupplier(supplier);
    }

    @PutMapping("/{id}")
    public Supplier updateSupplier(@PathVariable String id, @RequestBody Supplier command) {
        Supplier supplier = supplierService.getSupplierById(id);
        return supplierService.updateSupplier(supplier, command);
    }

    @DeleteMapping("/{id}")
    public void deleteSupplierById(@PathVariable String id) {
        supplierService.deleteSupplier(id);
    }

}