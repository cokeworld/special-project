package taekyeong.specialproject.service;

//import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taekyeong.specialproject.domain.Delivery;
import taekyeong.specialproject.mapper.DeliveryMapper;
import taekyeong.specialproject.web.dto.DeliveryResponseDto;
import taekyeong.specialproject.web.dto.DeliverySaveRequestDto;

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

}
