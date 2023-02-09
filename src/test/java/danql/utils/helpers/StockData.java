package danql.utils.helpers;

public class StockData {
    private String stockCode;
    private String stockName;
    private Double change;
    private Integer volume;

    public StockData(String code, String name, Double change, Integer vol) {
        this.stockCode = code;
        this.stockName = name;
        this.change = change;
        this.volume = vol;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return stockCode + "\t" + stockName + "\t" + change + "\t" + volume;
    }
}

