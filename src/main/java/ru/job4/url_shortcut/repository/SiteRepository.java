package ru.job4.url_shortcut.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4.url_shortcut.model.Site;

@Repository
public interface SiteRepository extends CrudRepository<Site, Integer> {

    public Site findBySite(String site);

    public Site findByLogin(String login);
}
