package spring_06;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(SystemCondition.class)
public class NetConnection {
}
