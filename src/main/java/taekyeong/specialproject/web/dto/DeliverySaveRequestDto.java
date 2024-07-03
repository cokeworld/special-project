package taekyeong.specialproject.web.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import taekyeong.specialproject.domain.Delivery;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class DeliverySaveRequestDto {
    // id는 auto increment
    private String title;
    private int deliveryCompanyId;
    private String deliveryNumber;
    private int status;
    private int memberId;

    @Builder
    public DeliverySaveRequestDto(String title, int deliveryCompanyId, String deliveryNumber, int status, int memberId, LocalDateTime createdDate) {
        this.title = title;
        this.deliveryCompanyId = deliveryCompanyId;
        this.deliveryNumber = deliveryNumber;
        this.status = status;
        this.memberId = memberId;
    }

    public Delivery toEntity() {
        return Delivery.builder()
                .title(title)
                .deliveryCompanyId(deliveryCompanyId)
                .deliveryNumber(deliveryNumber)
                .status(status)
                .memberId(memberId)
                .build();
    }
}