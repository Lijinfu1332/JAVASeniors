package test;

public class Stock {

    private String symbol;
    private int totalShares;
    private double totalCost;

    public Stock(String symbol, int totalShares, double totalCost) {
        this.symbol = symbol;
        this.totalShares = totalShares;
        this.totalCost = totalCost;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setTotalShares(int totalShares) {
        this.totalShares = totalShares;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
// Initializes a new Stock with no shares purchased.
//初始化未购买股份的新股。
public Stock(String theSymbol) {
            symbol = theSymbol;
            totalShares = 0;
            totalCost = 0.0;
        }
// Returns the total profit or loss earned on this stock.
// 返回此股票的利润或亏损总额
        public double getProfit(double currentPrice) {
            double marketValue = totalShares * currentPrice;
            return  marketValue - totalCost;
        }
// Records purchase of the given shares at the given price.
   // 记录以给定价格购买给定股份的情况
        public void purchase(int shares, double pricePerShare) {
            totalShares += shares;
            totalCost += shares * pricePerShare;
        }
        @Override
        public String toString() {
            return "Stock [symbol=" + symbol + ", totalShares=" + totalShares + ", totalCost=" + totalCost + "]";
        }
//getter和setter方法自己补充

    }
    class DividendStock extends Stock{
        private double dividents;
        public DividendStock(  String symbol,int totalShares, double totalCost,double dividents){
            super(symbol,totalShares,totalCost);
            this.dividents=dividents;
        }
        public double getDividents() {
            return dividents;
        }

        public void setDividents(double dividents) {
            this.dividents = dividents;
        }


        // Returns the total profit or loss earned on this stock.
// 返回此股票的利润或亏损总额
        public double getProfit(double currentPrice) {
            return 0;
        }
        public void payDividend(double amountPerShare){
                dividents=0.00;
        }
    }

