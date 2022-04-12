package ru.job4.url_shortcut.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "url")
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String url;

    private String code;

    public Url(String url, String code) {
        this.url = url;
        this.code = code;
    }

    public Url() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Url url1 = (Url) o;
        return id == url1.id && Objects.equals(url, url1.url) && Objects.equals(code, url1.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url, code);
    }
}
