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