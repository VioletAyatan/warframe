package com.ankol.warframe.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Relics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    /**
     * 核桃名称
     */
    private String relicName;
    /**
     * wm查询所需的UrlName
     */
    private String urlName;

    public String getId() {
        return id;
    }

    public Relics setId(String id) {
        this.id = id;
        return this;
    }

    public String getRelicName() {
        return relicName;
    }

    public Relics setRelicName(String relicName) {
        this.relicName = relicName;
        return this;
    }

    public String getUrlName() {
        return urlName;
    }

    public Relics setUrlName(String urlName) {
        this.urlName = urlName;
        return this;
    }
}

