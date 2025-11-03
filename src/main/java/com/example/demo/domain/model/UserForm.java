package com.example.demo.domain.model;


import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserForm {

    // 必須入力、20文字以下であること
    @NotBlank(message = "名前を入力してください。", groups = Group1.class)
    @Size(min = 1, max = 20, message = "名前を20文字以内で入力してください。", groups = Group2.class)
    private String name;

    // Email形式であること
    @Email(message = "E-Mailを正しい形式で入力してください。", groups = Group1.class)
    private String email;

    // 必須入力、入力値が0～100であること
    @NotNull(message = "年齢を入力してください。", groups = Group1.class)
    @Min(value = 0, message = "年齢は0以上を入力してください。", groups = Group2.class)
    @Max(value = 100, message = "年齢は100以下を入力してください。", groups = Group2.class)
    private Integer age;
    


    @GroupSequence({Group1.class, Group2.class})
    public interface Groups {}

    public interface Group1 {}
    public interface Group2 {}

    public String getName(){ return name; }
	public void setName(String name){ this.name = name; }
	public String getEmail(){ return email; }
	public void setEmail(String email){ this.email = email; }
	public Integer getAge(){ return age; }
	public void setAge(Integer age){ this.age = age; }
	
    @Size(max = 20, message = "備考は20文字以内で入力してください。", groups = Group2.class)
	private String note;
	@PostMapping("/form")
	public String submit(@Validated(UserForm.Groups.class) @ModelAttribute UserForm form, BindingResult result) {
	    if(result.hasErrors()) {
	        return "form";
	    }
	    return "result";
	}
	public String getnote() {
		return note;
	}
	public void setnote(String note) {
		this.note = note;
	}
	public Object getNote() {
		// TODO 自動生成されたメソッド・スタブ
		return null;

	}



}