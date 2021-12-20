package com.stocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class StockAccountManagement {
	public static Scanner scanner = new Scanner(System.in);
	public static HashMap<Integer, StockPortfolio> clients = new HashMap<>();
	
	public static void createStockPortfolio(int id) {
		
		clients.put(id, new StockPortfolio(id));
	}
	public static void addStockToPortfolio(int id) {
		Stock selectedStock = selectStock();
		for(Map.Entry<Integer, StockPortfolio> e : clients.entrySet()) {
			
			if(e.getKey() == id) {
				e.getValue().stockList.add(selectedStock);
			}
		}
	}
	
	public static Stock selectStock() {
		System.out.println("Welcome to Stock Account Management");
		System.out.println("Enter the name of the stock");
		String stockName = scanner.next();
		System.out.println("Enter the number of the stock");
		int numOFStocks = scanner.nextInt();
		System.out.println("Enter the price of the stock");
		int sharePrice = scanner.nextInt();
		return new Stock(stockName, numOFStocks, sharePrice);
	}
	
	
	public static void main(String[] args) {
		createStockPortfolio(0);
		createStockPortfolio(1);
		System.out.println(clients);
		addStockToPortfolio(0);
		System.out.println(clients.get(0));
		
		
		
	}
}
