package hu.rgabor.dwb.controller;

import hu.rgabor.dwb.service.DemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/calculate")
public class DemoController {

    private final DemoService demoService;

    @PostMapping(value = "/a", consumes = "application/json")
    public int[] calculateResult(@RequestBody int[] input) {
        log.debug("Calculate demo output. Received input: {}", input);
        return demoService.calculateResult(input);
    }

    @GetMapping("/history")
    public int getHistory() {
        return demoService.getHistory();
    }


}
