package mx.florinda.cardapio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import mx.florinda.cardapio.ItemCardapio.CategoriaCardapio;

public class Database {

    private Map<Long, ItemCardapio> itensPorId = new HashMap<>();

    public Database() {
        var refrescoChaves = new ItemCardapio(1L, "Refresco do Chaves", "Suco de limão que parece de groselha", CategoriaCardapio.BEBIDA, new BigDecimal("2.50"), null);
        itensPorId.put(1L,refrescoChaves);

        var sanduicheDoChaves = new ItemCardapio(2L, "Sanduiche de presundo", "Sanduiche de presunto simples", CategoriaCardapio.PRATO_PRINCIPAL, new BigDecimal("3.50"), new BigDecimal("2.99"));
        itensPorId.put(2L, sanduicheDoChaves);

        var tortaDeFrango = new ItemCardapio(3L, "Torta de frango", "Torta de frango com catupiry", CategoriaCardapio.PRATO_PRINCIPAL, new BigDecimal("5.50"), null);
        itensPorId.put(3L, tortaDeFrango);

        var tornaDonaFlorinda = new ItemCardapio(4L, "Torta da Dona Florinda", "Torta de baba de moça", CategoriaCardapio.SOBREMESA, new BigDecimal("5.50"), null);
        itensPorId.put(4L, tornaDonaFlorinda);

        var paoComManteiga = new ItemCardapio(5L, "Pão com manteiga", "Pão francês com manteiga", CategoriaCardapio.ENTRADA, new BigDecimal("1.50"), null);
        itensPorId.put(5L, paoComManteiga);
    }

    public List<ItemCardapio> listaDeItensCardapio() {
        return new ArrayList<>(itensPorId.values());
    }

    public Optional<ItemCardapio> itemCardapioPorId(Long itemId) {
        ItemCardapio item = itensPorId.get(itemId);
        return Optional.ofNullable(item);
    }

}