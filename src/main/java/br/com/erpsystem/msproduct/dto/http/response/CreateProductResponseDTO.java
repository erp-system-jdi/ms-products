package br.com.erpsystem.msproduct.dto.http.response;

import br.com.erpsystem.msproduct.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProductResponseDTO {

    @JsonProperty("product")
    private ProductDTO productDTO;
}
