Java FastMock
==========

[![Maven Status](https://maven-badges.herokuapp.com/maven-central/io.github.fastmock/fastmock/badge.svg?style=flat)](http://mvnrepository.com/artifact/io.github.fastmock/fastmock)
[![License](http://img.shields.io/:license-apache-brightgreen.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

FastMock是一个基于[fastjson](https://github.com/alibaba/fastjson)开发java组件库,生成虚假数据的利器。
当你正在开发一个新项目，并且需要一些漂亮的数据来展示的时候，它是非常有用的,它可以帮助实现一个高仿的系统,来实现需求的演示,便于更早的发现一些问题。
当你是前后端分离开发的项目,java开发人员可以先按照接口约定的结果,做出一份精美的虚假数据,便于前端开发调试。

基本使用
-----
在你项目pom.xml文件中, 增加如下的依赖即可

```xml
<dependency>
    <groupId>io.github.fastmock</groupId>
    <artifactId>fastmock</artifactId>
    <version>2.0.1</version>
</dependency>
```
对于gradle用户，将以下内容添加到您的build.gradle配置文件中。

```groovy
dependencies {
    implementation 'io.github.fastmock:fastmock:2.0.1'
}

```

快速开始

```java
Mock mock = new Mock();
String template1 = "{\"name\": \"@cname\"}";
JSONObject result1 = mock.mock(template1);
log.info("{}", result.toString()); // {"name":"于涛"}
        
String template2 = "{\"age\": \"@int(1,100)\"}";
JSONObject result2 = mock.mock(template2);
log.info("{}", result2.toString());// {"age":"31"}
```

这个[演示地址](https://github.com/fastmock/fastmock)就使用到了该组件库.

Contributions
-------------
See [CONTRIBUTING.md](https://github.com/fastmock)欢迎提交意见和建议,我非常感谢那些能够帮助我改善该项目的工程师。


支持的数据类型
-----
```
// 基本类型
string, bool,
// int integer float 统一叫做number类型
number, decimal,
// 姓名
cname, cfirst, clast,
name, firstname, lastname,
// 日期格式
now, date, datetime, time, timestamp, year, month,
// UUID
guid, uuid,
// 地址(目前支持中国省市区)
province, city, county,
// 文本格式
paragraph, sentence, word, title,
// 中文文本格式
cparagraph, csentence, cword, ctitle,
// 颜色
color, hex, rgb, rgba, hls,
// 图片
image, dataimage,
// 随机选择
pick
// IP Address
ip, ipv4, ipv6,
// user-agent
ua, userAgent,
```

TODO
----
- 1 编写使用说明文档 
- 2 value支持占位符,并保留占位符数据
- 3 增加User-Agent的数据模拟
- 4 增加以java api的方式生成mock数据

LICENSE
-------
Copyright (c) 2021 (王坤)Wangkun. See the LICENSE file for license rights and limitations.

