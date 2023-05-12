package br.com.erpsystem.msproduct.dto.http.request;

import br.com.erpsystem.msproduct.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProductRequestDTO {
    @JsonProperty("product")
    private ProductDTO productDTO;
}
