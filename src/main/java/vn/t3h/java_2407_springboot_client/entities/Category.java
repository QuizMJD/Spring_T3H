package vn.t3h.java_2407_springboot_client.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "category")
@Data// Thư viện loombok
public class Category extends BaseEntity {

    @Id// Đánh dấu n là khóa chính
            @GeneratedValue(strategy = GenerationType.IDENTITY)// auto increment
            @Column(name = "id")
    Long id;

    @Basic
    @Column(name = "name")
    String name;

    @Basic
    @Column(name = "description")
    String description;

    @Basic
    @Column(name = "imageName")
    String imageName;
}
