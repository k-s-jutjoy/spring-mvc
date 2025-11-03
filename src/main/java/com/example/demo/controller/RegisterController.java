package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.model.UserForm;
import com.example.demo.domain.service.UsersRegisterService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class RegisterController {

    @Autowired
    private UsersRegisterService usersRegisterService;

    @GetMapping("/form")
    public String readForm(@ModelAttribute UserForm userForm) {
        return "form";
    }

    @PostMapping("/form")
    public String confirm(@Validated(UserForm.Groups.class) @ModelAttribute UserForm user,
                          BindingResult result, Model model) {

        // バリデーションでエラーがある場合
        if (result.hasErrors()) {
            return "form";
        }

        // メール重複チェック
        if (usersRegisterService.isValid(user, result)) {
            // エラーあり → 入力フォームに戻す
            return "form";
        }

        // 登録処理
        usersRegisterService.register(user);

        return "confirm";
    }
}
