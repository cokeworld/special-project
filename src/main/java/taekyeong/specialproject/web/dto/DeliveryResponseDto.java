package taekyeong.specialproject.web.dto;

import lombok.Builder;
import taekyeong.specialproject.domain.Delivery;

public class DeliveryResponseDto {
    private int id;
    private String title;
    private int deliveryCompanyId;
    private String deliveryNumber;
    private int status;
    private int memberId;

//    public DeliveryResponseDto(Delivery entity) {
//        this.id = entity.getId();
//        this.title = entity.getTitle();
//        this.deliveryCompanyId = entity.getDeliveryCompanyId();
//        this.deliveryNumber = entity.getDeliveryNumber();
//        this.status = entity.getStatus();
//        this.memberId = entity.getMemberId();
//    }
}
