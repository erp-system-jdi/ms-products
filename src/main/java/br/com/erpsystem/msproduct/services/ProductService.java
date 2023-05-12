package br.com.erpsystem.msproduct.services;

import br.com.erpsystem.msproduct.dto.http.request.CreateProductRequestDTO;
import br.com.erpsystem.msproduct.dto.http.request.UpdateStockRequestDTO;
import br.com.erpsystem.msproduct.dto.http.request.WithdrawFromStockRequestDTO;
import br.com.erpsystem.msproduct.dto.http.response.CreateProductResponseDTO;
import br.com.erpsystem.msproduct.dto.http.response.FindProductResponseDTO;
import br.com.erpsystem.msproduct.dto.http.response.UpdateStockResponseDTO;
import br.com.erpsystem.msproduct.dto.http.response.WithdrawFromStockResponseDTO;

import java.util.UUID;

public interface ProductService{

    FindProductResponseDTO findProductById(UUID id);
    CreateProductResponseDTO createProduct(CreateProductRequestDTO createProductRequestDTO);
    WithdrawFromStockResponseDTO withdrawFromStock(WithdrawFromStockRequestDTO withdrawFromStockRequestDTO);
    UpdateStockResponseDTO updateStock(UpdateStockRequestDTO updateStockRequestDTO);

}
