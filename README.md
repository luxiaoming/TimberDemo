# TimberDemo
大神的log封装的demo，为了方便查找
Timber 经典的android Log封装库

更多精彩内容，关注代码GG公众号，code_gg_home


目标：
精简Log，使得Log使用的更轻便。


官网地址：

https://github.com/JakeWharton/timber

demo地址：

https://github.com/luxiaoming/TimberDemo

第一步：android项目的build.gradle里面加入


    
    
    dependencies {
    
    .......
    compile 'com.jakewharton.timber:timber:4.1.2'
    
    }
    

第二步：在app（Application）里面的onCreate里面注册一下：

        //在这里先使用Timber.plant注册一个Tree，然后调用静态的.d .v 去使用
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new CrashReportingTree());
        }


第三步：开始使用

   		Timber.tag("code_gg");
        Timber.d("test Timber %d",10);


轻松完成。
