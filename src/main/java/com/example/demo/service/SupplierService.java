package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.SupplierRepository;
import com.example.demo.error.ResourceNotFoundException;
import com.example.demo.model.Supplier;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier createSupplier(Supplier supplier) {
        supplier.setCreatedAt(LocalDateTime.now());
        supplier.setUpdatedAt(LocalDateTime.now());
        return supplierRepository.save(supplier);
    }

    public Supplier getSupplierById(String supplierId) {
        return supplierRepository.findById(supplierId)
            .orElseThrow(() -> new ResourceNotFoundException("Supplier", supplierId));
    }

    public Supplier updateSupplier(Supplier supplier, Supplier command) {

        supplier.setName(command.getName());
        supplier.setDetails(command.getDetails());
        supplier.setRfc(command.getRfc());
        supplier.setPhone(command.getPhone());
        supplier.setUpdatedAt(LocalDateTime.now());

        return supplierRepository.save(supplier);
    }

    public void deleteSupplier(String supplierId) {
        supplierRepository.deleteById(supplierId);
    }
    
}