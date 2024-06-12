package app.practice.monkey.value;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public class Product {
    private long id;

    private String productName;

    private long price;

    private List<String> options;

    private Instant createdAt;

    private ProductType productType;

    private Map<Integer, String> merchantInfo;

    public Product() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public void setMerchantInfo(Map<Integer, String> merchantInfo) {
        this.merchantInfo = merchantInfo;
    }
}
