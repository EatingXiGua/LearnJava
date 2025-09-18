package com.kkk.springbootcondition.config;

import com.kkk.springbootcondition.condition.ClassCondition;
import com.kkk.springbootcondition.condition.ConditionOnClass;
import com.kkk.springbootcondition.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
   // @Conditional(ClassCondition.class)
    @ConditionOnClass(value = "redis.clients.jedis.Jedis")
    public User user() {
        return new User();
    }
}
