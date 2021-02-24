package com.cagdassalur.payday.repository;

import com.cagdassalur.payday.domain.Orderstock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface OrderstockRepository extends JpaRepository<Orderstock,Long> {
    @Query(
            "select  e From Orderstock e " +
                    " where e.stockSymbol = :symbol " +
                    " and e.orderType = :orderType" +
                    " and e.cash <= :cash " +
                    " and e.active = true"
    )
    List<Orderstock> findByStockSymbolEqualsAndOrderTypeEqualsAndCashIsLessThanAbove(@Param("symbol") String symbol,
                                                                                     @Param("orderType") String orderType,
                                                                                     @Param("cash") BigDecimal cash);

    @Query(
            "select  e From Orderstock e " +
                    " where e.stockSymbol = :symbol " +
                    " and e.orderType = :orderType" +
                    " and e.cash >= :cash " +
                    " and e.active = true"
    )
    List<Orderstock> findByStockSymbolEqualsAndOrderTypeEqualsAndCashIsGreatThanAbove(@Param("symbol") String symbol,
                                                                                      @Param("orderType") String orderType,
                                                                                      @Param("cash") BigDecimal cash);
}
