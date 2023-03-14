package br.com.erpsystem.msproduto.repository;

import br.com.erpsystem.mscomercial.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {

}
