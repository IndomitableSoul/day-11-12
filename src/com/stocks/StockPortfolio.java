package com.stocks;

import java.util.ArrayList;

public class StockPortfolio {
	    int portfolioID;
		public ArrayList<Stock> stockList = new ArrayList<>();
		
		
		public StockPortfolio(int portfolioID) {
			
			this.portfolioID = portfolioID;
			
		}


		@Override
		public String toString() {
			return "Portfolio-ID of Client: " + portfolioID + ", stockList=" + stockList;
		}
		
		
		
}
