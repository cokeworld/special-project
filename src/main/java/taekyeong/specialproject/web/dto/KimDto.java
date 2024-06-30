package taekyeong.specialproject.web.dto;

import lombok.Getter;

@Getter
public class KimDto {
    private int id;
    private String name;

    public KimDto(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
