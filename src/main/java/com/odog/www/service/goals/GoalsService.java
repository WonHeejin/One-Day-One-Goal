package com.odog.www.service.goals;

import com.odog.www.domain.goals.Goals;
import com.odog.www.domain.goals.GoalsRepository;
import com.odog.www.web.dto.GoalResponseDto;
import com.odog.www.web.dto.GoalsSaveRequestDto;
import com.odog.www.web.dto.StateUpdateRequestDto;
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
    public GoalResponseDto update(Long id, StateUpdateRequestDto requestDto) {
        Goals entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 목표가 없습니다. id= "+id));
        entity.state_update(requestDto.getState());
        return new GoalResponseDto(entity);

    }
}
