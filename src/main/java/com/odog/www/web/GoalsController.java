package com.odog.www.web;

import com.odog.www.common.ResultCode;
import com.odog.www.service.goals.GoalsService;
import com.odog.www.web.dto.GoalsSaveRequestDto;
import com.odog.www.web.dto.StateUpdateRequestDto;
import com.odog.www.web.dto.TextUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class GoalsController {

    private final GoalsService goalsService;

    @ResponseBody
    @PostMapping("/goals")
    public Long save(@RequestBody GoalsSaveRequestDto requestDto) {
        return goalsService.save(requestDto);
    }

    @ResponseBody
    @PutMapping("/goals/state/{id}")
    public ResultCode state_update(@PathVariable Long id, @RequestBody StateUpdateRequestDto requestDto) {
        if (id == 0) {
            return ResultCode.PARAMETER_MISSING;
        } else {
            return goalsService.state_update(id, requestDto);
        }
    }

    @ResponseBody
    @PutMapping("/goals/text/{id}")
    public ResultCode text_update(@PathVariable Long id, @RequestBody TextUpdateRequestDto requestDto) {
        if (id == 0) {
            return ResultCode.PARAMETER_MISSING;
        } else {
            return goalsService.text_update(id, requestDto);
        }
    }

    @ResponseBody
    @DeleteMapping("/goals/{id}")
    public ResultCode delete(@PathVariable Long id) {
        if (id == 0) {
            return ResultCode.PARAMETER_MISSING;
        }else {
            return goalsService.delete(id);
        }
    }
}
