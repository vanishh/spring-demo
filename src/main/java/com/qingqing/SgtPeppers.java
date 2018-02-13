package com.qingqing;

import org.springframework.stereotype.Component;

// 创建一个该类的bean
// Spring 容器中所有的bean都有一个ID。默认这个bean的ID为sgtPeppers（类名首字母小写）
// 你也可以自己定义bean 的ID @Compent("lonelyHeartsClub") 或者@Named("lonelyHeartsClub")，大多数场合两者可以互换
@Component
public class SgtPeppers implements CompactDisc {

    private String title = "sgt title";
    private String artist = "The beatles";

    public void play() {
        System.out.println("playing " + title + "by" + artist);
    }
}
