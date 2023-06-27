package br.com.edgarpinheiro.ecommercebackend;

import br.com.edgarpinheiro.ecommercebackend.model.Produto;
import br.com.edgarpinheiro.ecommercebackend.repository.ProdutoRepository;
import br.com.edgarpinheiro.ecommercebackend.service.ProdutoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class ProdutoServiceTest {

    private ProdutoRepository produtoRepository;
    private ProdutoService produtoService;

    @BeforeEach
    public void setUp() {
        produtoRepository = Mockito.mock(ProdutoRepository.class);
        produtoService = new ProdutoService(produtoRepository);
    }

    @Test
    public void testListarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Produto 1", "Descrição 1", new BigDecimal("10.00")));
        produtos.add(new Produto("Produto 2", "Descrição 2", new BigDecimal("20.00")));

        Mockito.when(produtoRepository.findAll()).thenReturn(produtos);

        List<Produto> resultado = produtoService.listarProdutos();

        Assertions.assertEquals(produtos.size(), resultado.size());
        for (int i = 0; i < produtos.size(); i++) {
            Assertions.assertEquals(produtos.get(i).getNome(), resultado.get(i).getNome());
            Assertions.assertEquals(produtos.get(i).getDescricao(), resultado.get(i).getDescricao());
            Assertions.assertEquals(produtos.get(i).getValor(), resultado.get(i).getValor());
        }
    }

    @Test
    public void testCriarProduto() {
        Produto produto = new Produto("Produto 1", "Descrição 1", new BigDecimal("10.00"));

        Mockito.when(produtoRepository.save(Mockito.any(Produto.class))).thenReturn(produto);

        Produto resultado = produtoService.novoProduto(produto);

        Assertions.assertEquals(produto.getNome(), resultado.getNome());
        Assertions.assertEquals(produto.getDescricao(), resultado.getDescricao());
        Assertions.assertEquals(produto.getValor(), resultado.getValor());
    }
}
