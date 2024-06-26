package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.web.dto.UserRegisterDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.http.HttpClient;

@Controller
public class UserController {
    @GetMapping("users/register")
    public String viewRegister(){
        return "register";
    }

    @PostMapping("user/register")
    public String doRegister(@Valid UserRegisterDTO data,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes
    ){
        if (bindingResult.hasErrors ()){
            redirectAttributes.addAttribute ("registerData", data);
            //handle errors
            return "register";
        }
        //register user
        return "redirect:/users/login";
    }
    @GetMapping("users/login")
    public String viewLogin(){
        return "login";
    }
}
