# AndroidUtils
android 工具库

* 如果需要用到lib_common,做法如下：
* Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```	
* and then,add the dependecy:
```
dependencies {
	        compile 'com.github.huweijian5:AndroidUtils:latest_version'
}
```
* 其中latest_version请到[releases](https://github.com/huweijian5/AndroidUtils/releases)中查看
