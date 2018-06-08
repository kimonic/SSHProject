package mspring4.S_4_1;

import org.springframework.stereotype.Component;

@Component
public class PerformanceImpl implements Performance {
    @Override
    public void perform(int count) {

        System.out.println("切点方法执行!"+(count));

    }
}
