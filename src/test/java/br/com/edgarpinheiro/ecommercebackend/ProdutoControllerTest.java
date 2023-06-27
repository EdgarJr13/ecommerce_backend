package br.com.edgarpinheiro.ecommercebackend;

import br.com.edgarpinheiro.ecommercebackend.controller.ProdutoController;
import br.com.edgarpinheiro.ecommercebackend.model.Produto;
import br.com.edgarpinheiro.ecommercebackend.service.ProdutoService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ProdutoControllerTest {

    @InjectMocks
    private ProdutoController produtoController;

    @Mock
    private ProdutoService produtoService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(produtoController).build();
    }

    @Test
    public void testListarProdutos() throws Exception {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Produto 1", "Descrição 2", new BigDecimal("10.00")));
        produtos.add(new Produto("Produto 2", "Descrição 1", new BigDecimal("20.00")));

        Mockito.when(produtoService.listarProdutos()).thenReturn(produtos);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/produtos"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome", Matchers.is("Produto 1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].nome", Matchers.is("Produto 2")));
    }

    @Test
    public void testCriarProduto() throws Exception {
        Produto produtoSalvo = new Produto("Produto 1", "Descrição 1", new BigDecimal("10.00"));
        produtoSalvo.setId(1L);

        Mockito.when(produtoService.novoProduto(Mockito.any(Produto.class))).thenReturn(produtoSalvo);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/produtos/novo_produto")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\": \"Produto 1\", \"descricao\": \"Descrição 1\", \"valor\": 10.00}"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome", Matchers.is("Produto 1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.descricao", Matchers.is("Descrição 1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.valor", Matchers.is(10.00)));
    }
}
