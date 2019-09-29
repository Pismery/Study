package com.pismery.study.gof23.pattern.structure.flyweight;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {

    public static void main(String[] args) {
         FlyWeightFactory factory = FlyWeightFactory.getIntance();
         FlyWeight video = factory.getFlyweright(FlyweightType.VIDIEO);
         FlyWeight video2 = factory.getFlyweright(FlyweightType.VIDIEO);
         FlyWeight pictrue = factory.getFlyweright(FlyweightType.PICTURE);
         FlyWeight animation = factory.getFlyweright(FlyweightType.ANIMATION);

         video.display(new OutStutas(10,10,10));
         video2.display(new OutStutas(10,20,100));
         pictrue.display(new OutStutas(30,30,10));
         animation.display(new OutStutas(40,40,10));

         log.debug(String.valueOf(video == video2));

    }
}
