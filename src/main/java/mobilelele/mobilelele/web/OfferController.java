package mobilelele.mobilelele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/offers")
public class OfferController {

    @GetMapping("/add")
    public ModelAndView addOffer(ModelAndView modelAndView) {
        modelAndView.setViewName("offer-add");

        return modelAndView;
    }

    @GetMapping("/all")
    public ModelAndView allOffers(ModelAndView modelAndView) {
        modelAndView.setViewName("offers");

        return modelAndView;
    }
}
