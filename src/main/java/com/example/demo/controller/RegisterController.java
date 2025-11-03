package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.model.UserForm;

@Controller
public class RegisterController {

    @GetMapping("/form")
    public String readForm(@ModelAttribute UserForm userForm) {
        return "form";
    }

    @PostMapping("/form")
    public String confirm(
            @Validated(UserForm.Groups.class) @ModelAttribute UserForm userForm,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            // エラーがある場合はフォーム画面に戻る
            return "form";
        }

        return "confirm"; // 入力に問題なければ確認画面
    }
}
