package pres.jeremy.alnilam.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pres.jeremy.alnilam.support.ResponseEntity;

@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test1")
    public ResponseEntity<String> test1() {
        return ResponseEntity.success("test1");
    }

    @GetMapping("/test2")
    public ResponseEntity<String> test2() {
        return ResponseEntity.success("test2");
    }
}
