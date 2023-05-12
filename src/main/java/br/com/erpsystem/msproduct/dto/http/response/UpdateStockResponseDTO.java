package br.com.erpsystem.msproduct.dto.http.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateStockResponseDTO {

    @JsonProperty("product_id")
    private String productId;
    @JsonProperty("products_in_stock")
    private Integer productInStock;
}
