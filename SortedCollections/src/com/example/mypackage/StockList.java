package com.example.mypackage;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Alex on 5/13/17.
 */
public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new TreeMap<>();
    }

    public Map<String, Double> PriceList(){
        Map<String, Double> prices = new LinkedHashMap<>();
        for(Map.Entry<String, StockItem> item : list.entrySet()){
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    public int addStock(StockItem item){
        if(item != null){
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // check if quantities of this item
            if(inStock != item){
                item.adjustStock(inStock.availableQuantity());
            }

            list.put(item.getName(), item); // if already exists, put method overwrites what is there
            return item.availableQuantity();
        }
        return 0;
    }

    public int sellStock(String item, int quantity){
        StockItem inStock = list.getOrDefault(item, null);

        if((inStock != null) && (inStock.availableQuantity() >= quantity) && (quantity > 0)){
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem get(String key){
        return list.get(key);
    }

    public Map<String, StockItem> Items() {
        // map list and set have a wrapper for immutability called unmodifiable
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List \n";
        double totalCost = 0.0;
        for(Map.Entry<String, StockItem> item : list.entrySet()){
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.availableQuantity();

            s = s + stockItem + "\n There are " + stockItem.availableQuantity()  + " in stock. Value of Items: ";
            totalCost += itemValue;

        }
        return s + " Total stock value " + totalCost;
    }
}
