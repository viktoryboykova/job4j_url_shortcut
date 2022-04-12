package ru.job4.url_shortcut.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sites")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String site;

    private String login;

    private String password;

    public Site() {
    }

    public Site(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Site(String site, String login, String password) {
        this.site = site;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Site site = (Site) o;
        return id == site.id && Objects.equals(login, site.login) && Objects.equals(password, site.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password);
    }
}
