package mobilelele.mobilelele.web;

import mobilelele.mobilelele.model.binding.UserLoginBindingModel;
import mobilelele.mobilelele.model.binding.UserRegisterBindingModel;
import mobilelele.mobilelele.model.service.UserLoginServiceModel;
import mobilelele.mobilelele.model.service.UserRegisterServiceModel;
import mobilelele.mobilelele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
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
    public String loginSubmit(UserLoginBindingModel userLoginBindingModel,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userBindingModel", userLoginBindingModel);
            //TODO: handle errors in template
            return "redirect:login";
        }

        boolean isUserPresent =
                userService.login(modelMapper.map(userLoginBindingModel, UserLoginServiceModel.class));


        return isUserPresent ? "redirect:/" : "redirect:login";
    }

    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView) {
        modelAndView.setViewName("auth-register");

        return modelAndView;
    }

    @PostMapping("/register")
    public String registerSubmit(UserRegisterBindingModel userRegisterBindingModel,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            //TODO: handle errors in template
            return "redirect:register";
        }

        boolean registerSuccess =
                userService.registerUser(modelMapper.map(userRegisterBindingModel, UserRegisterServiceModel.class));

        return registerSuccess ? "redirect:login" : "redirect:register";
    }

    @GetMapping("/logout")
    public ModelAndView logout(ModelAndView modelAndView) {
        userService.logout();
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
