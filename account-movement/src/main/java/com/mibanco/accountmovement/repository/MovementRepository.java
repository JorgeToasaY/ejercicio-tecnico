package com.mibanco.accountmovement.repository;

import com.mibanco.accountmovement.entity.Account;
import com.mibanco.accountmovement.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MovementRepository extends JpaRepository<Movement, Long> {
    //Optional<Movement> findByCustomerId(String customerId);
    List<Movement> findByAccountAndDateBetween(Account account, LocalDateTime startDate, LocalDateTime endDate);
    //List<Movement> findByAccount_AccountNumber(String accountNumber);

   /* @Query("SELECT m FROM Movement m WHERE m.account.customer.name = :customerName AND m.date BETWEEN :start AND :end")
    List<Movement> findByCustomerAndDateRange(
            @Param("customerName") String customerName,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );*/
}
