package ru.job4.url_shortcut.service;

import org.springframework.stereotype.Service;
import ru.job4.url_shortcut.model.Url;
import ru.job4.url_shortcut.repository.UrlRepository;

@Service
public class UrlService {

    private UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public void save(Url url) {
        urlRepository.save(url);
    }

    public Url findByCode(String code) {
        return urlRepository.findByCode(code);
    }

    public Url findByUrl(String url) {
        return urlRepository.findByUrl(url);
    }
}
