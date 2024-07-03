package taekyeong.specialproject.web;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import taekyeong.specialproject.service.DeliveryService;
import taekyeong.specialproject.web.dto.DeliveryResponseDto;
import taekyeong.specialproject.web.dto.DeliverySaveRequestDto;

import java.util.HashMap;

@RequiredArgsConstructor
@RestController
public class DeliveryApiController {

    private final DeliveryService deliveryService;

    @PostMapping("/api/v1/delivery")
    public int save(@RequestBody DeliverySaveRequestDto requestDto) {
        return deliveryService.save(requestDto);
    }

    @GetMapping("/api/v1/delivery/{id}")
    public DeliveryResponseDto findById(@PathVariable int id) {
        return deliveryService.findById(id);
    }

//    @PutMapping("/api/v1/posts/{id}")
//    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
//        return deliveryService.update(id, requestDto);
//    }
//
//    @DeleteMapping("/api/v1/posts/{id}")
//    public Long delete(@PathVariable Long id) {
//        deliveryService.delete(id);
//        return id;
//    }
}