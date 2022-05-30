package mobilelele.mobilelele.web;

import mobilelele.mobilelele.model.view.BrandViewModel;
import mobilelele.mobilelele.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/brands")
public class BrandController {

    private final BrandService brandService;
    private final ModelMapper modelMapper;

    public BrandController(BrandService brandService, ModelMapper modelMapper) {
        this.brandService = brandService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public ModelAndView brands(ModelAndView modelAndView) {

        List<BrandViewModel> allBrands = brandService.getAllBrands();

        modelAndView.addObject("brands", allBrands);
        modelAndView.setViewName("brands");

        return modelAndView;
    }
}
