import java.util.Date;

public class Product {
    private String id;
    private String name;
    private long price;
    private int quantity;
    private Date createDate;


    public Product(String id, String name, long price, int quantity, Date createDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.createDate = createDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
