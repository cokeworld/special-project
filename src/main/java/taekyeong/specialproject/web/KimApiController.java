package taekyeong.specialproject.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import taekyeong.specialproject.domain.Kim;
import taekyeong.specialproject.service.KimService;

@RequiredArgsConstructor
@RestController
public class KimApiController {
    private final KimService kimService;

    @GetMapping("/api/v1/kim/{id}")
    public Kim findTestById(@PathVariable Integer id) {
        return kimService.findById(id);
    }
}
