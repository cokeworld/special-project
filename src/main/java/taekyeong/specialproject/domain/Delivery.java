package taekyeong.specialproject.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Delivery {
    private int id;
    private String title;
    private int deliveryCompanyId;
    private String deliveryNumber;
    private int status;
    private int memberId;

    @Builder
    public Delivery(int id, String title, int deliveryCompanyId, String deliveryNumber, int status, int memberId) {
        this.id = id;
        this.title = title;
        this.deliveryCompanyId = deliveryCompanyId;
        this.deliveryNumber = deliveryNumber;
        this.status = status;
        this.memberId = memberId;
    }
}
