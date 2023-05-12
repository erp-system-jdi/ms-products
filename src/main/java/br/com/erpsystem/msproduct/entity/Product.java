package br.com.erpsystem.msproduct.entity;

import br.com.erpsystem.msproduct.enums.SaleUnitEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TB_01_PRODUCT")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "sale_unit")
    private SaleUnitEnum saleUnit;
    @Column(name = "unit_price")
    private Double unitPrice;
    @Column(name = "active")
    private Boolean isActive;
    @Column(name = "description")
    private String description;
    @Column(name = "quantity_in_stock")
    private Integer quantityInStock;

}
