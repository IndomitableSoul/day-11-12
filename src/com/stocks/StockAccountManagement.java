package com.stocks;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StockAccountManagement {
	public static Scanner scanner = new Scanner(System.in);
	//storing the clientPortfolios with id in a hashmap
	public static HashMap<Integer, StockPortfolio> clients = new HashMap<>();
	
	//creates a client stock account profile
	public static void createStockPortfolio(int id) {
		
		clients.put(id, new StockPortfolio(id));
	}
	
	//adds a stock to client selected by his id
	public static void addStockToPortfolio(int id) {
		System.out.println("Enter Stock Name");
		String stockName = scanner.next();
		System.out.println("Enter Amount");
		int amount = scanner.nextInt();

		Stock selectedStock = buy(stockName, amount);
		for(Map.Entry<Integer, StockPortfolio> e : clients.entrySet()) {
			
			if(e.getKey() == id) {
				StockPortfolio client = e.getValue();
				client.stockList.add(selectedStock);
			    client.totalStockPrice+=(selectedStock.numOfShares*selectedStock.sharePrice);
			}
		}
	}
	
	//gives total stock amount of a client
	public static int getTotalStockPrice(int id) {
		int stockPrice = 0;
		for(Map.Entry<Integer, StockPortfolio> e : clients.entrySet()) {
			
			if(e.getKey() == id) {
				StockPortfolio client = e.getValue();
				stockPrice = client.totalStockPrice;
			}

		}
		return stockPrice;
		
	}
	
	//buys stocks for a client 
	public static Stock buy(String stockName, int amount) {
		Stock selectedStock = selectStock(stockName, amount);
		return selectedStock;
	}
	
	
	//selecting stock foor the client
	public static Stock selectStock(String stockName, int amount) {
		System.out.println("Enter the price of the stock");
		int sharePrice = scanner.nextInt();
		int numOFStocks = amount/sharePrice;
		return new Stock(stockName, numOFStocks, sharePrice);
	}
	
	
	//for selling specific stock of a client of specified amount 
	public static void sellStock(int id,int amount, String stockName) {
		for(Map.Entry<Integer, StockPortfolio> e : clients.entrySet()) {
			
			if(e.getKey() == id) {
				StockPortfolio client = e.getValue();
				client.stockList.removeIf(stock->stock.stockName.equalsIgnoreCase(stockName));
				client.totalStockPrice-= amount;
			}

		}
	}
	
	public static void main(String[] args) {
		createStockPortfolio(0);
		createStockPortfolio(1);
		System.out.println(clients);
		addStockToPortfolio(0);
		System.out.println(clients.get(0));
		System.out.println("total stock Price: "+getTotalStockPrice(0));
		addStockToPortfolio(0);
		System.out.println("total stock Price: "+getTotalStockPrice(0));
		System.out.println(clients.get(0));
		sellStock(0, 200, "rel");
		System.out.println(clients.get(0));
	}
}
