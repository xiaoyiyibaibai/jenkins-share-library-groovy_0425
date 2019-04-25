timestamps{
    try {
        node(){
            writeFile(
                    file: 'common.groovy',
                    encoding: 'UTF-8',
                    text: libraryResource("CommonJenkinsfile/common/common.groovy")
            );
          def common = load("common.groovy");
           println(common.xiao);
            common.showEcho()

            stage('prepare'){
                println('--------- prepare-------')
            }
            stage('before'){
                println('--------- before-------')
            }
            def hong = '我是start stage 之前的内容'
            stage('start'){
                println('--------- start-------'+hong)
            }

            stage('end'){
                println('--------- end-------')
            }
            def dong = '我是ater stage 之前的内容'
            stage('after'){
                println('--------- after -------+dong')
            }
        }
    }
    catch (e){
        println(e)
        mail(
                subject:"出现了异常！",
                to: "2367808698@qq.com",
                from:"a250604@sina.com",
                body : env.BUILD_URL
        )
    }
}