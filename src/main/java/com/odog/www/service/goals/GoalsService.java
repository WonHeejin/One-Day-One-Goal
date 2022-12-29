package com.odog.www.service.goals;

import com.odog.www.common.ResultCode;
import com.odog.www.domain.goals.Goals;
import com.odog.www.domain.goals.GoalsRepository;
import com.odog.www.web.dto.GoalsSaveRequestDto;
import com.odog.www.web.dto.StateUpdateRequestDto;
import com.odog.www.web.dto.TextUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class GoalsService {
    private final GoalsRepository repository;

    @Transactional
    public Long save(GoalsSaveRequestDto requestDto) {
        return repository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public ResultCode state_update(Long id, StateUpdateRequestDto requestDto) {
        ResultCode resultCode;
        Goals entity = repository.findById(id).orElse(null);

        if (entity == null) {
            resultCode = ResultCode.DB_EMPTY;
        } else {
            entity.state_update(requestDto.getState());
            resultCode = ResultCode.SUCCESS;
        }

        return resultCode;
    }

    @Transactional
    public ResultCode text_update(Long id, TextUpdateRequestDto requestDto) {
        ResultCode resultCode;
        Goals entity = repository.findById(id).orElse(null);

        if (entity == null) {
            resultCode = ResultCode.DB_EMPTY;
        } else {
            entity.text_update(requestDto.getText());
            resultCode = ResultCode.SUCCESS;
        }

        return resultCode;
    }
    @Transactional
    public ResultCode delete(Long id) {
        ResultCode resultCode;
        Goals goals = repository.findById(id).orElse(null);

        if (goals == null) {
            resultCode = ResultCode.DB_EMPTY;
        } else {
            repository.deleteById(id);
            resultCode = ResultCode.SUCCESS;
        }

        return resultCode;
    }
}
