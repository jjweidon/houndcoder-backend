package com.houndcoder.auth.controller;

import com.houndcoder.auth.service.JoinService;
import com.houndcoder.global.controller.dto.JoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class JoinController {
    private final JoinService joinService;

    @GetMapping("/join")
    public String joinP() {

        return "join";
    }


    @PostMapping("/joinProc")
    public String joinProcess(JoinDto joinDTO) {

        System.out.println(joinDTO.getUsername());

        joinService.joinProcess(joinDTO);


        return "redirect:/login";
    }
}