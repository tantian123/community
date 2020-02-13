package com.example.community.controller;

import com.example.community.dto.PaginationDTO;
import com.example.community.mapper.UserMapper;
import com.example.community.model.User;
import com.example.community.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {
    @Resource
    private UserMapper userMapper;
    @Resource
    private QuestionService questionService;


    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name="action")String action,
                          HttpServletRequest request,
                          Model model,
                          @RequestParam(name = "page",defaultValue = "1") Integer page,
                          @RequestParam(name = "size",defaultValue = "2") Integer size){

       User user=(User)request.getSession().getAttribute("user");
        if(user == null){
            return "redirect:/";
        }

        //当路径为questions时，显示我的提问，右边导航栏选中我的提问那一行 ，这里使用model
        if("questions".equals(action)){
            model.addAttribute("setion","questions");
            model.addAttribute("setionName","我的提问");
        }else if("replies".equals(action)){
            model.addAttribute("setion","replies");
            model.addAttribute("setionName","最新回复");
        }

        PaginationDTO paginationDTO=questionService.list(user.getId(),page,size);
        model.addAttribute("pagination",paginationDTO);
        return"profile";
    }
}
