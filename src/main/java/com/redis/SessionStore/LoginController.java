package com.redis.SessionStore;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
public class LoginController {
    // /login?name=Jay

    HashMap<String, String> sessionMap = new HashMap<>();

    @GetMapping("/login")
    public String login(HttpSession session, @RequestParam String name){
        //sessionMap.put(session.getId(), name);
        session.setAttribute("name", name);

        return "Saved.";
    }
    @GetMapping("/myName")
    public String myName(HttpSession session){
        //String myName = sessionMap.get(session.getId());
        String myName = (String)session.getAttribute("name");
        return myName;
    }

}
