package com.backend.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.project.Service.StaffService;
import com.backend.project.model.Staff;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping("/login")
    public String login(@RequestBody Staff staff){
        Staff authenticate = staffService.authenticate(staff.getUsername(), staff.getPassword());
        if(authenticate != null){
            return "登入成功";
        } else {
            return "*帳號或密碼錯誤";
        }
    }

    @PostMapping("/login/ForgotPassword")
    public String forgotPassword(@RequestBody Staff staff){
        Staff authenticate = staffService.forgotPasswordAuthenticate(staff.getUsername(), staff.getEmail());
        if(authenticate != null){
            return "1";
        } else {
            return "*帳號或電子郵件錯誤";
        }
    }

    @PutMapping("/login/changePassword/{username}")
    public ResponseEntity<String> changePassword(@PathVariable String username, @RequestBody Staff staff) {
        String changePasswordCheck = staffService.changePassword(username, staff.getPassword());  // 使用傳過來的密碼
        if("Change Password successfully".equals(changePasswordCheck)){
            return ResponseEntity.ok(changePasswordCheck);
        } else {
            return ResponseEntity.status(404).body(changePasswordCheck);
        }
    }

    @GetMapping("/system/user/{username}")
    public Staff getUser(@PathVariable String username) {
        return staffService.getUser(username);
    }
    
}
