机票安卓自动化项目

jenkins配置
appurl   apk URL，如果无需安装新app，则输入 0 就行
projectName 项目名称：用于保存图片的路径，使用默认值就好
isonline 是否是线上环境
recip 报告收件人

maven构建
goals  test

Properites 配置
appurl=$appurl
build=$BUILD_NUMBER
jenkinsHome=$JENKINS_HOME
projectName=$projectName
isonline=$isonline

添加构建步骤shell 或者 batch command（下面是batch command 示例）
echo %BUILD_NUMBER%
cd target/classes
mvn exec:java -Dexec.mainClass="com.appium.base.ReportEmail" -Dexec.args="%JENKINS_HOME% %projectName% %BUILD_NUMBER% %recip%" -f ../../pom.xml