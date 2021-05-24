package com.team03.airbnb.dto;

public class HostDTO {
    private Long id;
    private String name;
    private String avatarUrl;

    public HostDTO(Long id, String name, String avatarUrl) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
