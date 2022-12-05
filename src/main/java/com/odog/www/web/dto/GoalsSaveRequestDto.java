package com.odog.www.web.dto;

import com.odog.www.domain.goals.Goals;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GoalsSaveRequestDto {
    //목표 저장 dto

    private String text; // 목표 내용
    private String state; // 목표 상태 - 목표, 성공, 실패
    private String userId; // 사용자

    @Builder
    public GoalsSaveRequestDto(String text, String state, String userId) {
        this.text = text;
        this.state = state;
        this.userId = userId;
    }

    public Goals toEntity() {
        return Goals.builder()
                .state(state)
                .text(text)
                .userId(userId)
                .build();
    }

}
