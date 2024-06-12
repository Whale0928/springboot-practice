package app.practice.monkey.value;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class BeanProduct {
    @Min(1)
    long id;

    @NotBlank
    String productName;

    @Max(100000)
    long price;

    @Size(min = 3)
    List<@NotBlank String> options;

    @Past
    LocalDateTime createdAt;

    public BeanProduct(long id, String productName, long price, List<@NotBlank String> options, LocalDateTime createdAt) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.options = options;
        this.createdAt = createdAt;
    }

    public static BeanProduct from(long id, String productName, long price, List<String> options, LocalDateTime createdAt) {
        return new BeanProduct(id, productName, price, options, createdAt);
    }

    @Override
    public String toString() {
        return "BeanProduct{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", options=" + options +
                ", createdAt=" + createdAt +
                '}';
    }
}
