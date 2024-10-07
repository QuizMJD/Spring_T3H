package vn.t3h.java_2407_springboot_client.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDateTime;
@Entity
@Table(name = "product")
@Data// Thư viện loombok
public class Product extends BaseEntity {
    @Id// Đánh dấu n là khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY)// auto increment
    @Column(name = "id")
    Long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "price")
    private Float price;
    @Basic
    @Column(name = "discount")
    private Float discount;
    @Basic
    @Column(name = "quantity")
    private Short quantity;
    @Basic
    @Column(name = "totalBuy")
    private Short totalBuy;
    @Basic
    @Column(name = "author")
    private String author;
    @Basic
    @Column(name = "pages")
    private Short pages;
    @Basic
    @Column(name = "publisher")
    private String publisher;
    @Basic
    @Column(name = "yearPublishing")
    private Integer yearPublishing;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "imageName")
    private String imageName;
    @Basic
    @Column(name = "shop")
    private Boolean shop;
    @Basic
    @Column(name = "createdAt")
    private LocalDateTime createdAt;
    @Basic
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;
    @Basic
    @Column(name = "startsAt")
    private LocalDateTime startsAt;
    @Basic
    @Column(name = "endsAt")
    private LocalDateTime endsAt;
}
