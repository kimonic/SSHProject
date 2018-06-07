package mspring4;

import org.springframework.stereotype.Component;

/**
 * CompactDisc接口的实现类,spring自动转配示例--02
 * spring会扫描带有@Component注解的类,并作为bean类自动装载
 * @Component 默认以类名首字母小写的形式做为类的id
 * 也可以显式的指定id  @Component("sgtPeppers")
 */

@SuppressWarnings("JavaDoc")
@Component
public class SgtPeppers implements CompactDisc{
    private String title="亦筝笙";
    private String artist="小土豆";
    @Override
    public void play() {
        System.out.println("playing "+title+" by "+artist);

    }
}
