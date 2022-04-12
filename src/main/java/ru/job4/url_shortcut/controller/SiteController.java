package ru.job4.url_shortcut.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.job4.url_shortcut.model.*;
import ru.job4.url_shortcut.service.SiteService;
import ru.job4.url_shortcut.service.StatisticService;
import ru.job4.url_shortcut.service.UrlService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class SiteController {

    private SiteService siteService;

    private StatisticService statisticService;

    private UrlService urlService;

    private BCryptPasswordEncoder encoder;

    public SiteController(SiteService siteService, StatisticService statisticService, UrlService urlService, BCryptPasswordEncoder encoder) {
        this.siteService = siteService;
        this.statisticService = statisticService;
        this.urlService = urlService;
        this.encoder = encoder;
    }

    @PostMapping("/registration")
    public SiteDTO registration(@RequestBody String siteName) {
        SiteDTO siteDTO = new SiteDTO();
        Site site = siteService.findBySite(siteName);
        if (site == null) {
            String login = UUID.randomUUID().toString();
            String password = UUID.randomUUID().toString();
            site = new Site(siteName, login, encoder.encode(password));
            siteService.save(site);
            siteDTO.setRegistration(true);
            siteDTO.setLogin(login);
            siteDTO.setPassword(password);
        }
        siteDTO.setRegistration(false);
        return siteDTO;
    }

    @PostMapping("/convert")
    public UrlDTO convert(@RequestBody String url) {
        Url newUrl = urlService.findByUrl(url);
        if (newUrl == null) {
            String code = UUID.randomUUID().toString();
            newUrl = new Url(url, code);
            urlService.save(newUrl);
        }
        UrlDTO urlDTO = new UrlDTO(newUrl);
        return urlDTO;
    }

    @GetMapping("/redirect/{code}")
    public ResponseEntity<String> redirect(@PathVariable String code) {
        Url url = urlService.findByCode(code);
        if (url == null) {
            throw new NullPointerException("Url is not found");
        }
        Statistic statistic = statisticService.findByUrl(url.getUrl());
        if (statistic == null) {
            statistic = new Statistic(url.getUrl(), 1);
            statisticService.save(statistic);
        } else {
            statisticService.increaseTotal(url.getUrl());
        }
        return ResponseEntity.status(HttpStatus.MOVED_TEMPORARILY)
                .header("Location", url.getUrl())
                .build();
    }

    @GetMapping("/statistic")
    public List<StatisticDTO> statistic() {
        List<StatisticDTO> statisticDTOList = new ArrayList<>();
        statisticService.findAll().forEach(s -> statisticDTOList.add(new StatisticDTO(s)));
        return statisticDTOList;
    }
}
