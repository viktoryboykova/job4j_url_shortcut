package ru.job4.url_shortcut.service;

import org.springframework.stereotype.Service;
import ru.job4.url_shortcut.model.Site;
import ru.job4.url_shortcut.repository.SiteRepository;

import java.util.List;

@Service
public class SiteService {

    private SiteRepository siteRepository;

    public SiteService(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    public void save(Site site) {
        siteRepository.save(site);
    }

    public Site findBySite(String site) {
        return siteRepository.findBySite(site);
    }

    public Site findByLogin(String login) {
        return siteRepository.findByLogin(login);
    }

    public List<Site> findAll() {
        return (List<Site>) siteRepository.findAll();
    }
}
