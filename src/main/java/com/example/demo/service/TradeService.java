package com.example.demo.service;

import java.time.LocalDateTime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.TradeRepository;
import com.example.demo.error.ResourceNotFoundException;
import com.example.demo.model.Supplier;
import com.example.demo.model.Trade;
import com.example.demo.model.TradeCommand;

@Service
public class TradeService {

    @Autowired
    private TradeRepository tradeRepository;

    public List<Trade> getAllTrades() {
        return tradeRepository.findAll();
    }

    public Trade createTrade(TradeCommand tradeCommand, Supplier existingSupplier) {

        Trade trade = new Trade();

        trade.setName(tradeCommand.getName());
        trade.setDetails(tradeCommand.getDetails());
        trade.setCode(tradeCommand.getCode());
        trade.setPrice(tradeCommand.getPrice());
        trade.setCreatedAt(LocalDateTime.now());
        trade.setUpdatedAt(LocalDateTime.now());
        trade.setSupplier(existingSupplier);

        return tradeRepository.save(trade);
    }

    public Trade getTradeById(String tradeId) {
        return tradeRepository.findById(tradeId)
            .orElseThrow(() -> new ResourceNotFoundException("Trade", tradeId));
    }

    public Trade updateTrade(Trade trade, Supplier existingSupplier, TradeCommand tradeCommand) {

        trade.setName(tradeCommand.getName());
        trade.setDetails(tradeCommand.getDetails());
        trade.setCode(tradeCommand.getCode());
        trade.setPrice(tradeCommand.getPrice());
        trade.setUpdatedAt(LocalDateTime.now());
        trade.setSupplier(existingSupplier);

        return tradeRepository.save(trade);
    }

    public void deleteTrade(String tradeId) {
        tradeRepository.deleteById(tradeId);
    }

}