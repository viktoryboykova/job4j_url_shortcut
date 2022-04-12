package ru.job4.url_shortcut.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4.url_shortcut.model.Statistic;

@Repository
public interface StatisticRepository extends CrudRepository<Statistic, Integer> {

    Statistic findByUrl(String url);

    @Modifying
    @Query(value = "update statistic set total = total + 1 where url = ?1", nativeQuery = true)
    int increaseTotal(String url);
}
