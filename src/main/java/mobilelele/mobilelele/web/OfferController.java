package mobilelele.mobilelele.web;

import mobilelele.mobilelele.model.binding.OfferAddBindingModel;
import mobilelele.mobilelele.model.service.OfferAddServiceModel;
import mobilelele.mobilelele.model.view.BrandViewModel;
import mobilelele.mobilelele.model.view.ModelViewModel;
import mobilelele.mobilelele.service.BrandService;
import mobilelele.mobilelele.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;
    private final BrandService brandService;
    private final ModelMapper modelMapper;

    public OfferController(OfferService offerService, BrandService brandService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.brandService = brandService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public ModelAndView addOffer(ModelAndView modelAndView) {
        List<BrandViewModel> allBrands = brandService.getAllBrands();
        modelAndView.addObject("brands", allBrands);
        List<ModelViewModel> models = allBrands.stream()
                .map(BrandViewModel::getModels)
                .map(model -> modelMapper.map(model, ModelViewModel.class))
                .toList();
        //TODO get models of each brand and add it to the view
        modelAndView.setViewName("offer-add");

        return modelAndView;
    }

    @PostMapping("/add")
    public String addOfferSubmit(OfferAddBindingModel offerAddBindingModel,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerAddBindingModel", offerAddBindingModel);
            //TODO: handle error in template
            return "redirect:addOffer";
        }

        offerService.addOffer(modelMapper.map(offerAddBindingModel, OfferAddServiceModel.class));

        return "redirect:allOffers";
    }

    @GetMapping("/all")
    public ModelAndView allOffers(ModelAndView modelAndView) {
        modelAndView.setViewName("offers");

        return modelAndView;
    }
}
