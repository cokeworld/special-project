package taekyeong.specialproject.service;

//import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taekyeong.specialproject.domain.Delivery;
import taekyeong.specialproject.mapper.DeliveryMapper;
import taekyeong.specialproject.web.dto.DeliveryListResponseDto;
import taekyeong.specialproject.web.dto.DeliveryResponseDto;
import taekyeong.specialproject.web.dto.DeliverySaveRequestDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DeliveryService {

    private final DeliveryMapper deliveryMapper;
    @Transactional
    public int save(DeliverySaveRequestDto requestDto) {
        return deliveryMapper.save(requestDto.toEntity());
    }

    @Transactional
    public DeliveryResponseDto findById(int id) {
        Delivery entity = deliveryMapper.findById(id);
        return new DeliveryResponseDto(entity);
    }

    @Transactional
    public List<DeliveryListResponseDto> findAllDesc() {
        return deliveryMapper.findAllDesc().stream()
                .map(DeliveryListResponseDto::new)
                .collect(Collectors.toList());
    }
}
