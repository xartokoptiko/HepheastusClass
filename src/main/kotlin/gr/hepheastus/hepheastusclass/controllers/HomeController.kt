package gr.hepheastus.hepheastusclass.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import java.security.Principal

@Controller
class HomeController {

    @GetMapping("/")
    fun homePage(principal: Principal, model: Model) : String = "index.html"

    @GetMapping("/log-in")
    fun loginPage() : String = "log-in.html"

}