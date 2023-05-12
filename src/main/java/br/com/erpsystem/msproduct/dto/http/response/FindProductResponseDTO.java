package br.com.erpsystem.msproduct.dto.http.response;

import br.com.erpsystem.msproduct.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindProductResponseDTO {

    @JsonProperty("product")
    private ProductDTO productDTO;
}
