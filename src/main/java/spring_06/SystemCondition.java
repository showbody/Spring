package spring_06;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class SystemCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();

        String osname = env.getProperty("os.name");
        System.out.println(env.getProperty("user.dir"));
        System.out.println(env.getProperty("user.home"));
        if (osname.contains("Linux")){
            return false;
        }
        return true;
    }
}
