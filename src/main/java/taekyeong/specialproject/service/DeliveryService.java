package taekyeong.specialproject.service;

//import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taekyeong.specialproject.domain.Delivery;
import taekyeong.specialproject.domain.DeliveryRepository;
import taekyeong.specialproject.web.dto.DeliveryResponseDto;
import taekyeong.specialproject.web.dto.DeliverySaveRequestDto;

@RequiredArgsConstructor
@Service
public class DeliveryService {

//    private final DeliveryRepository deliveryRepository;
//    @Transactional
//    public int save(DeliverySaveRequestDto requestDto) {
//        return deliveryRepository.save(requestDto.toEntity()).getId();
//    }

//    @Transactional
//    public DeliveryResponseDto findById(Long id) {
//        Delivery entity = deliveryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 택배 내역이 없습니다." + id));
//        return new DeliveryResponseDto(entity);
//    }

}
