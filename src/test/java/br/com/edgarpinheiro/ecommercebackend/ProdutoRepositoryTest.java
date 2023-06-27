package br.com.edgarpinheiro.ecommercebackend;

import br.com.edgarpinheiro.ecommercebackend.model.Produto;
import br.com.edgarpinheiro.ecommercebackend.repository.ProdutoRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProdutoRepositoryTest {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Test
    public void testSalvarProduto() {
        Produto produto = new Produto("Produto 1", "Descrição 1", new BigDecimal("10.00"));
        produtoRepository.save(produto);

        Optional<Produto> produtoSalvo = produtoRepository.findById(produto.getId());

        Assertions.assertTrue(produtoSalvo.isPresent());
        Assertions.assertEquals(produto.getNome(), produtoSalvo.get().getNome());
        Assertions.assertEquals(produto.getDescricao(), produtoSalvo.get().getDescricao());
        Assertions.assertEquals(produto.getValor(), produtoSalvo.get().getValor());
    }

    @Test
    public void testListarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Produto 1", "Descrição 1", new BigDecimal("10.00")));
        produtos.add(new Produto("Produto 2", "Descrição 2", new BigDecimal("20.00")));

        produtoRepository.deleteAll();

        produtoRepository.saveAll(produtos);

        List<Produto> produtosListados = produtoRepository.findAll();

        Assertions.assertEquals(produtos.size(), produtosListados.size());
        for (int i = 0; i < produtos.size(); i++) {
            Assertions.assertEquals(produtos.get(i).getNome(), produtosListados.get(i).getNome());
            Assertions.assertEquals(produtos.get(i).getDescricao(), produtosListados.get(i).getDescricao());
            Assertions.assertEquals(produtos.get(i).getValor(), produtosListados.get(i).getValor());
        }
    }
}
