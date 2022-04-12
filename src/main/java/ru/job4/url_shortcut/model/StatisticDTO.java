package ru.job4.url_shortcut.model;

import java.util.Objects;

public class StatisticDTO {

    private String url;

    private int total;

    public StatisticDTO() {
    }

    public StatisticDTO(Statistic statistic) {
        this.url = statistic.getUrl();
        this.total = statistic.getTotal();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StatisticDTO that = (StatisticDTO) o;
        return Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }
}
