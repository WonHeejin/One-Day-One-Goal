package com.odog.www.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TextUpdateRequestDto {
// 목표 내용 수정 dto
    private String text; //목표 내용

    @Builder
    public TextUpdateRequestDto(String text) {
        this.text = text;
    }

}
