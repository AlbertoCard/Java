package com.example.CashCard.Repository;

import com.example.CashCard.Entities.CashCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

public interface CashCardRepository extends CrudRepository<CashCard, Long> {
}

