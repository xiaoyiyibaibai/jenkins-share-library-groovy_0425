def call(args=[:]){
    writeFile(
         file: 'basic.groovy',
         encoding: 'UTF-8',
         text: libraryResource("CommonJenkinsfile/basic.groovy")
    );
    return "basic.groovy"
}
