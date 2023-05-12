package br.com.erpsystem.msproduct.dto;

import br.com.erpsystem.msproduct.enums.SaleUnitEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    @JsonProperty("product_id")
    private UUID id;
    @JsonProperty("product_name")
    private String name;
    @JsonProperty("sale_unit")
    private SaleUnitEnum saleUnit;
    @JsonProperty("unit_price")
    private Double unitPrice;
    @JsonProperty("active")
    private Boolean isActive;
    @JsonProperty("description")
    private String description;
    @JsonProperty("quantity_in_stock")
    private Integer quantityInStock;
}
