package com.sotugyouseisaku.app.Record;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ProductRecord {
    private int id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private LocalDateTime createdAt;
}

