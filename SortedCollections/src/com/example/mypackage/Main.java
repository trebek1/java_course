package com.example.mypackage;

import java.util.Map;

public class Main {

    private static StockList stockList = new StockList();

    public static void main(String[] args) {

        StockItem temp = new StockItem("Bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.11, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.11, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 0.51, 200);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.5, 134);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.45, 7 );
        stockList.addStock(temp);

        temp = new StockItem("door", 71.91, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 35);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.69, 11);
        stockList.addStock(temp);



        System.out.println(stockList);

        Basket alexBasket = new Basket("Alex");
        sellItem(alexBasket, "car", 1);
        System.out.println(alexBasket);

        sellItem(alexBasket, "vase", 10);
        System.out.println(alexBasket);

        sellItem(alexBasket, "cup", 10);
        System.out.println(alexBasket);

        sellItem(alexBasket, "blase", 10);

        System.out.println(stockList);


//        temp = new StockItem("pen", 1.12);
//        stockList.Items().put(temp.getName(), temp);

        stockList.Items().get("car").adjustStock(2000);
        stockList.get("car").adjustStock(-1000);
        System.out.println(stockList);

        for(Map.Entry<String,Double> price : stockList.PriceList().entrySet()){
            System.out.println(price.getKey() + " costs " + price.getValue());
        }
    }

    public static int sellItem(Basket basket, String item, int quantity){
        // retrieve item from stock list first
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We dont sell " + item);
            return 0;
        }

        if(stockList.sellStock(item, quantity) != 0){
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }
}
