package com.odog.www.service.goals;

import com.odog.www.domain.goals.Goals;
import com.odog.www.domain.goals.GoalsRepository;
import com.odog.www.web.dto.GoalsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GoalsService {
    private final GoalsRepository repository;

    @Transactional
    public int save(List<GoalsSaveRequestDto> requestDto) {
        List<Goals> jpaGoalList = requestDto.stream()
                .map(GoalsSaveRequestDto::toEntity)
                .collect(Collectors.toList());
        return repository.saveAll(jpaGoalList).size();

    }
}
