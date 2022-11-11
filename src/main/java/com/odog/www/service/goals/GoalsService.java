package com.odog.www.service.goals;

import com.odog.www.domain.goals.GoalsRepository;
import com.odog.www.web.dto.GoalsSaveRequestDto;
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
}
