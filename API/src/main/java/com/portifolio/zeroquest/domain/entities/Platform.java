package com.portifolio.zeroquest.domain.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_platform")
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Platform() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Platform platform = (Platform) o;
        return Objects.equals(id, platform.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
