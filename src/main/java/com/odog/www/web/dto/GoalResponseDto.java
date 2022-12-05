package com.odog.www.web.dto;

import com.odog.www.domain.goals.Goals;
import lombok.Getter;

@Getter
public class GoalResponseDto {

    private Long id;
    private String text;
    private String state;

    public GoalResponseDto(Goals entity) {
        this.id = entity.getId();
        this.text = entity.getText();
        this.state = entity.getState();
    }
}
