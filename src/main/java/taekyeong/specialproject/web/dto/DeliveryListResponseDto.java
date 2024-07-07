package taekyeong.specialproject.web.dto;

import lombok.Getter;
import taekyeong.specialproject.domain.Delivery;

@Getter
public class DeliveryListResponseDto {
    private int id;
    private String title;
    private int deliveryCompanyId;
    private String deliveryNumber;
    private int status;
    private int memberId;

    public DeliveryListResponseDto(Delivery entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.deliveryCompanyId = entity.getDeliveryCompanyId();
        this.deliveryNumber = entity.getDeliveryNumber();
        this.status = entity.getStatus();
        this.memberId = entity.getMemberId();
    }
}
