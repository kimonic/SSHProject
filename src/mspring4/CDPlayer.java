package mspring4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * spring4自动注入示例
 *
 * @Autowired的使用 可以使用在构造器上或者setter方法上
 * @Autowired(required = false)表示没有匹配bean时不进行装配
 * 而不是抛出异常,但是可能在使用过程中抛出NullPointerException异常
 * @Inject注解与@Autowired注解基本等效
 * @Inject注解来源于Java javax.inject.Inject;
 */
@SuppressWarnings("JavaDoc")
@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Autowired(required = false)
    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }
}
