package hu.rgabor.dwb.controller;

import hu.rgabor.dwb.service.DemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @PostMapping
    public int[] calculateResult(@RequestParam int[] input) {
        log.debug("Calculate demo output. Received input: {}", input);
        return demoService.calculateResult(input);
    }


}
