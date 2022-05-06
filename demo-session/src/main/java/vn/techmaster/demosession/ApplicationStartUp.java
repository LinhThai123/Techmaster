package vn.techmaster.demosession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import vn.techmaster.demosession.service.UserService;

@Component
public class ApplicationStartUp implements ApplicationRunner {
    @Autowired UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userService.addUserAutoActivate("Nguyễn Văn Linh", "Linhthai130100@gmail.com", "123@abc");
        userService.addUser("Nguyễn Văn Linh", "Linhthai130100@gmail.com", "123@abc");
    }
    
}
