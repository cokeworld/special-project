package taekyeong.specialproject.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import taekyeong.specialproject.service.DeliveryService;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final DeliveryService deliveryService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("deliveries", deliveryService.findAllDesc());

        // todo: 택배회사 테이블 조회 후 모델에서 사용(등록 수정 모달에서 택배회사 셀렉트 박스, 택배 리스트의 택배회사)
//        model.ddAttribute('deliveryCompanies', )
        return "index";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "signup";
    }
}
