package pres.jeremy.alnilam.controller;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;
import pres.jeremy.alnilam.support.ResponseEntity;
import pres.jeremy.alnilam.vo.LoginParam;

@RestController
@Slf4j
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginParam loginParam) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginParam.getUserName(), loginParam.getPassword());
        token.setRememberMe(false);
        try {
            //登录认证
            subject.login(token);
            return ResponseEntity.success("index");
        }catch (UnknownAccountException e){
            return ResponseEntity.fail("no account");
        }catch (IncorrectCredentialsException e){
            return ResponseEntity.fail("error password");
        }
    }

    @GetMapping("/noauth")
    public ResponseEntity<String> noauth() {
        return ResponseEntity.fail("noauth");
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResponseEntity.success("success");
    }

    @GetMapping("/needAuth")
    public ResponseEntity<String> needAuth() {
        return ResponseEntity.success("pass auth");
    }
}
