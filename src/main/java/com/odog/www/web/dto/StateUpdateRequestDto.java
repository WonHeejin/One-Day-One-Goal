package com.odog.www.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StateUpdateRequestDto {
    //목표 상태 수정 dto

    private String state; //목표 상태

    @Builder
    public StateUpdateRequestDto(String state) {
        this.state = state;
    }
}
