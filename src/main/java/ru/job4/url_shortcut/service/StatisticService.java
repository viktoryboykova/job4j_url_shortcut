package ru.job4.url_shortcut.service;

import org.springframework.stereotype.Service;
import ru.job4.url_shortcut.model.Statistic;
import ru.job4.url_shortcut.repository.StatisticRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StatisticService {

    private StatisticRepository statisticRepository;

    public StatisticService(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    public void save(Statistic statistic) {
        statisticRepository.save(statistic);
    }

    public Statistic findByUrl(String url) {
        return statisticRepository.findByUrl(url);
    }

    public List<Statistic> findAll() {
        return (List<Statistic>) statisticRepository.findAll();
    }

    @Transactional
    public int increaseTotal(String url) {
        return statisticRepository.increaseTotal(url);
    }
}
