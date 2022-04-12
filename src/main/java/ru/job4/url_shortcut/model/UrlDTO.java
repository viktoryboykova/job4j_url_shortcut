package ru.job4.url_shortcut.model;

import java.util.Objects;

public class UrlDTO {

    private String code;

    public UrlDTO() {
    }

    public UrlDTO(Url url) {
        this.code = url.getCode();
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
        UrlDTO urlDTO = (UrlDTO) o;
        return Objects.equals(code, urlDTO.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
