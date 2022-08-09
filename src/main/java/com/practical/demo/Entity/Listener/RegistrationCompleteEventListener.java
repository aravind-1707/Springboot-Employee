package com.practical.demo.Entity.Listener;

import com.practical.demo.Entity.Event.RegistrationCompleteEvent;
import com.practical.demo.Entity.User;
import com.practical.demo.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import javax.persistence.UniqueConstraint;
import java.util.UUID;

@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        User user = event.getUser();
        String token  = UUID.randomUUID().toString();
        userService.saveVerifiactionTokenForUser(token,user);

        String url = event.getApplicationUrl() +"verifyRegistration?Token="+token;
        log.info("Click the Link to Verify Your Account:{}",url);

    }
}
