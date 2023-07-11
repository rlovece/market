package com.ruth.market.domain.repository;

import com.ruth.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    List<Purchase> getAll(); ///todas las compras del market
    Optional<List<Purchase>> getByClient(String clientId); ///todas las compras de un cliente, si es que tiene.
    Purchase save (Purchase purchase);

}
