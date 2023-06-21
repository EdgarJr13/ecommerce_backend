package br.com.edgarpinheiro.ecommercebackend.repository;

import br.com.edgarpinheiro.ecommercebackend.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
