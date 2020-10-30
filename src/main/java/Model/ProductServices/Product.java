package Model.ProductServices;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String name;
    private String description;
    private String company;
    private String image;
    private double price;
    private int countOfMark;
    private double rating;
}
