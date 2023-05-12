package br.com.erpsystem.msproduct.dto.http.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WithdrawFromStockRequestDTO {

    private String productId;
    private Integer quantity;
}
