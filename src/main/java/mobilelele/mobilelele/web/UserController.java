package mobilelele.mobilelele.web;

import mobilelele.mobilelele.model.binding.UserBindingModel;
import mobilelele.mobilelele.model.service.UserServiceModel;
import mobilelele.mobilelele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("auth-login");
        return modelAndView;
    }

    @PostMapping("/login")
    public String loginSubmit(UserBindingModel userBindingModel,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userBindingModel", userBindingModel);

            return "redirect:login";
        }

        boolean isUserPresent =
                userService.login(modelMapper.map(userBindingModel, UserServiceModel.class));

        System.out.println(userBindingModel.getUsername());

        return isUserPresent ? "redirect:/" : "redirect:login";
    }

    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView) {
        modelAndView.setViewName("auth-register");

        return modelAndView;
    }
}
