package ru.job4.url_shortcut.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4.url_shortcut.model.Url;

@Repository
public interface UrlRepository extends CrudRepository<Url, Integer> {
    public Url findByCode(String code);

    public Url findByUrl(String url);
}
