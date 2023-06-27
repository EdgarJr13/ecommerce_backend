package br.com.edgarpinheiro.ecommercebackend.repository;

import br.com.edgarpinheiro.ecommercebackend.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p WHERE LOWER(p.nome) LIKE LOWER(concat('%', :searchTerm, '%'))")
    List<Produto> findByTerm(@Param("searchTerm") String searchTerm);
}
