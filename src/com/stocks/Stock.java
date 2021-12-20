package com.stocks;

public class Stock {
     String stockName;
     int numOfShares;
     int sharePrice;
     
     
	public Stock(String stockName, int numOfShares, int sharePrice) {
		
		this.stockName = stockName;
		this.numOfShares = numOfShares;
		this.sharePrice = sharePrice;
		
	}


	@Override
	public String toString() {
		return "[stockName=" + stockName + ", " + numOfShares + ", " + sharePrice+"]";
	}
	
	public int getStockPrice() {
		return sharePrice;
	}
	
}
