##  shared library仓库的文件结构
  主要有三个  src, vars   和   resource  
  
  src和var的区别目前好像看不出来，都可以写函数，只是调用的方式不一样（题外话：groovy的文件名不严格和它的class名一致），
resource里面放的是一些资源文件，就像java加载资源那样一样。

![目录结构](https://note.youdao.com/yws/public/resource/5d25efa596c5a33faea87a386d3f31a1/xmlnote/165D24F05D9249BD971AABA6749C2E2F/23455)

- src目录就是标准的Java源目录结构。执行Pipeline时，该目录将添加到类路径中。

- vars目录托管定义可从Pipeline访问的全局脚本(一般我们可以在这里编写标准化脚本)。通常，每个.groovy文件的基本名称应使用驼峰（camelCased）模式，.txt（如果存在）可以包含格式化处理的文档。

- resources目录允许libraryResource从外部库中使用步骤来加载相关联的非Groovy文件。目前内部库不支持此功能。

## 一、src下文件的编写

> src目录就是标准的Java源目录结构。执行Pipeline时，该目录将添加到类路径中。在文件的末尾 return this 一定要加上，否则找不到类

示例

```aidl
package com.xiaoren.shenghuo

def printClassName(name){
    echo name
}
return this

```

## 二、vars 全局脚本

> vars目录托管定义可从Pipeline访问的全局脚本(一般我们可以在这里编写标准化脚本)。
通常，每个.groovy文件的基本名称应使用驼峰（camelCased）模式，.txt（如果存在）可以包含格式化处理的文档.
在vars中的文件不需要加 return this ，但在src中的文件，在末尾不需要加上。

示例 vars/foo.groovy

```aidl

def printCommandName(commandName){
    return { echo 'The command name :'+commandName}
}

def sendEmail(to,subject,body){
    mail(
        subject: subject,
        to: to,
        from: 'a250604@sina.com',
        body: body
    )
}

def test(){
    echo 'hi, this is pipeline shared library.'
}

// 在vars中的文件不需要加 return this ，但在src中的文件，在末尾不需要加上。
```

然后在jenkins -- manage jenkins -- config system 里修改以下地方。
