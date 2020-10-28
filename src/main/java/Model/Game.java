package Model;

import lombok.Data;

@Data
public class Game {
    private int id;
    private double rating;
    private double price;
    private String description;
    private String company;
    private String name;
    private String image;
    private int countOfMark;
}
