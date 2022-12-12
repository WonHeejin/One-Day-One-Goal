package com.odog.www.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ResultCode {

    SUCCESS("0000", "성공"),
    FAIL("0002", "실패"),
    PARAMETER_MISSING("0003", "파라미터가 존재하지 않습니다."),
    DB_EMPTY("0004", "데이터베이스에 존재하지 않는 정보입니다.");


    private final String code;
    private final String message;



}
