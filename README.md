# 欢迎查阅TestCaseManageSystem（测试用例管理系统）
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

### AgileTC
![](https://testerhome.com/uploads/photo/2022/cff33e14-8c52-4392-8673-acab0a474696.png!large)

&emsp;TestCaseManageSystem是一套敏捷的测试用例管理平台，支持测试用例管理、执行计划管理、进度计算、多人实时协同等能力，方便测试人员对用例进行管理和沉淀。产品以脑图方式编辑可快速上手，用例关联需求形成流程闭环，并支持组件化引用，可在各个平台嵌入使用，是测试人员的贴心助手！

 ---
### 系统背景
&emsp;随着互联网的快速发展，业务的快速迭代，对项目流程各环节的效率要求越来越高，很多QA开始选择使用线下xmind来编写和执行用例进行测试，但面临的问题也越来越多，例如：

        •  用例管理混乱，无法沉淀：散落在wiki、线下xmind、excel
        •  用例无法追溯：如遇到线上问题回溯用例及测试情况时，无法追溯且增加排查问题难度
        •  无法明确感知需求测试进度和结果，研发协作效率低：测试开始了吗？进度如何？失败的case有哪些？等这些问题无法明确感知
        •  测试活动相关数据无法沉淀：研发自测结果？打回率？测试用例失败率？测试周期？

&emsp;因此，我们需要一套完善的测试用例管理系统来满足我们的日常测试需求。然后，业界比较可靠的用例管理平台，如test-link，QC，禅道等，它们均采用传统用例管理方式，类似excel的操作体验，测试用例编写过程较繁琐，与当前业务普遍使用的脑图管理方式不匹配，也不符合当前业务快速迭代的诉求

 ---
### 系统架构
![](https://testerhome.com//uploads/photo/2022/df7e3ccb-58e0-45d3-9db8-552d2bfb8314.png!large)

&emsp;AgileTC的核心是测试用例集和测试任务，其中用例集的编辑和任务编辑当前均基于脑图，因此合并为一个平台。最终由三个平台组成：脑图编辑平台、用例集管理平台和测试任务管理平台。以下主要介绍脑图编辑平台。

&emsp;脑图编辑功能主要由前端实现，采用react框架，包含脑图节点的增加、删除、修改功能，以及脑图样式和布局等。部分脑图基本绘制和布局能力借鉴了百度开源kity的能力。在这些脑图基本能力之上，支持测试常用的标签，如优先级和执行步骤、预期结果，支持测试进展的标记；进行了读写权限隔离，让测试设计和测试执行分开，使测试分工更有序。

&emsp;多人实时协同采用websocket通信协议。客户端打开用例集或者任务详情，在服务端会创建一个客户端session，并判断当前是否有其他客户端打开相同的用例集或任务，如果有，会触发用例集的落库。客户端修改时，会将变更diff发送到服务端，服务端将diff发送到其他客户端保持实时同步。客户端退出时，会触发自动保存。

 ---
### 主要功能
    ▍测试用例集管理
&emsp;AgileTC能够将用例集与需求关联，支持xmind/xmind zen的导入/导出，具备丰富的搜索能力，如根据用例集名称、创建人、管理需求和创建时间进行搜索。

    ▍用例编辑
&emsp;AgileTC支持多人实时协同编辑用例集，其中一个人的修改，会实时同步到打开相同用例的其他客户端，实现更加高效的测试集编写和测试执行协同。支持用例优先级和自定义标签标记。服务端和客户端增加了定时巡检探活机制保障连接稳定性。支持连接异常（如浏览器异常退出或系统故障等）场景下，自动保存用例集。

    ▍测试任务管理
&emsp;用户可以根据用例中的优先级和标签圈选测试用例，组合成自身需要的测试任务。支持任务分配邮件通知机制，用户可以在测试任务中标记用例测试状态，并查看测试任务的整体进展。

 ---
### 环境配置
   1. [JDK1.7以上](http://www.Oracle.com/technetwork/Java/javase/downloads/index.html)
   2. [Eclipse](http://www.eclipse.org/downloads)/[IDEA](https://www.jetbrains.com/idea/)
   3. [MySql](https://www.mysql.com/downloads/) 
   4. [Chrome](https://www.google.cn/intl/zh-CN/chrome/) 
   5. [Maven](http://maven.apache.org/download.cgi) 
   6. [Git](https://git-scm.com/) 

 - 部分网站需要翻墙，具体安装参考：https://blog.csdn.net/love4399/article/details/77164500
 
 ---
### 系统准备：
 - 创建依赖数据库，application-dev.properties中配置数据库名称为case_manager create database case_manager
 - 利用sql中的脚本配置对应表。创建脚本路径：case-server/sql/case-server.sql
 - 修改application-dev.properties中spring.datasource的配置。默认数据库端口号为3306
 - 安装xmind jar包
 - mvn install:install-file -Dfile=org.xmind.core_3.5.2.201505201101.jar -DgroupId=com.xmind -DartifactId=sdk-Java -Dversion=201505201101 -Dpackaging=jar

 ---
### 系统运行：
mvn spring-boot:run
浏览器打开 http://localhost:8094/case/caseList/1

 ---
### 系统使用：
#### 登陆注册
第一步：进入首部页面，如果没有注册过，则点击【注册】按钮，输入账号和密码进行登录

<img src="https://dpubstatic.udache.com/static/dpubimg/113ed6a2-143c-49ed-9bcd-d818f773e221.png" style="zoom:50%;" />

第二步：如果已经注册过，则点击【登陆】按钮，输入账号和密码进行登录

<img src="https://dpubstatic.udache.com/static/dpubimg/abaac832-3cb3-40e7-b9b9-ed98ec95a71c.png" style="zoom:50%;" />

#### 新建用例

第一步：点击【新建用例集】按钮，弹出"新增测试用例集"弹窗

<img src="https://dpubstatic.udache.com/static/dpubimg/5eca11a9-83ca-43e6-9cf7-fc89f5b1bc58.png" style="zoom:50%;" />

第二步：输入用例集名称（必填），关联需求，用例集分类（必填），描述，导入本地xmind文件

<img src="https://dpubstatic.udache.com/static/dpubimg/004b82f0-2932-4a73-9388-316973a78fff.png" style="zoom:50%;" />

第三步：点击"确定"按钮，新的测试用例就新增成功啦

第四步：点击"用例名称"，跳转到用例详情页，展示刚刚新增的具体用例内容，如图

<img src="https://dpubstatic.udache.com/static/dpubimg/a5007a80-2603-4638-9e1f-7bca0c316a93.png" style="zoom:50%;" />

<img src="https://dpubstatic.udache.com/static/dpubimg/8673b7c1-34fc-4803-8cc1-730915871937.png" style="zoom:50%;" />

#### 编辑用例

第一步：点击【编辑用例】按钮，弹出"修改测试用例"弹窗，可更改用例集名称，关联需求，用例集分类及描述，更改完成之后点击“确定”按钮

<img src="https://dpubstatic.udache.com/static/dpubimg/0f601abb-8564-4bc9-8b39-94901ff7bd0e.png" alt=" " style="zoom:50%;" />

第二步：更改完成之后，可在列表页看到最新更新人，如图

<img src="https://dpubstatic.udache.com/static/dpubimg/8a7ee595-acd7-4aeb-91f9-ee9436573d40.png" style="zoom:50%;" />

第三步：编辑用例内容，可点击"用例集名称"，跳转到用例详情页，增加或删选用例内容

第四步：添加一个同级主题时可以点击插入同级主题，也可以使用快捷键Enter，添加一个下级主题时可以点击插入下级主题，也可以使用快捷键Tab，添加一个上级主题时可以点击插入上级主题，如图

<img src="https://dpubstatic.udache.com/static/dpubimg/dbf10a68-9af1-4fab-b199-31c04c829594.png" style="zoom:50%;" />

第五步：可通过打tag的方式标记测试用例，选中标记的用例，添加所需要的tag，比如输入"预置条件"，点击"添加"按钮，"预置条件"tag被添加在选项框中，用例被标记"预置条件"tag，如已有tag，选中用例，勾选tag即可，取消掉勾选的tag，会取消用例勾选的tag，如图

<img src="https://dpubstatic.udache.com/static/dpubimg/d80ced72-7b6f-4805-8de8-9362093826dc.png" style="zoom:50%;" />

<img src="https://dpubstatic.udache.com/static/dpubimg/67487697-fc7e-4b50-9268-bdfd90b74c1f.png" style="zoom:50%;" />

第六步：可通过打优先级的方式标记测试用例，选中标记的用例，添加所需要的优先级，比如对AgileTC这个测试用例进行打优先级，点击测试用例，然后选择相对应的【优先级】P0，P1，P2，“优先级”被标记到测试用例，如果想取消标记的优先级，勾选“—”即可，会取消用例勾选的优先级，如图

<img src="https://dpubstatic.udache.com/static/dpubimg/5765ac0c-0d1e-473a-a854-1c6e0c8f73bb.png" style="zoom:50%;" />

<img src="https://dpubstatic.udache.com/static/dpubimg/ebe8a809-f7aa-427b-9819-483378a68589.png" style="zoom:50%;" />

第七步：可以给测试用例添加【链接】，添加【图片】以及添加【备注】

<img src="https://dpubstatic.udache.com/static/dpubimg/04edf805-c47e-4c85-9c0b-1e41c0c2d6dc.png" style="zoom:50%;" />

<img src="https://dpubstatic.udache.com/static/dpubimg/60285bb1-674f-4c04-a372-8fa79f79b26e.png" style="zoom:50%;" />

<img src="https://dpubstatic.udache.com/static/dpubimg/b646bf0d-b19d-4a5b-b582-9d0ea0413115.png" style="zoom:50%;" />

第八步：右键点击测试用例可以出现上面讲到的一些操作，包括插入上级主题，插入同级主题，插入下级主题，将测试用例前移，将测试用例后移，删除测试用例，编辑测试用例等操作，此外还可以定义优先级，如图

<img src="https://dpubstatic.udache.com/static/dpubimg/f9deea90-3407-4835-bcc4-85abdc70c64d.png" style="zoom:50%;" />

<img src="https://dpubstatic.udache.com/static/dpubimg/61556ce1-2e1c-43b3-97c1-0cef1577b408.png" style="zoom:50%;" />

第九步：点击【外观】可以更改背景主题，脑图类型，以及自动整理布局，如图

<img src="https://dpubstatic.udache.com/static/dpubimg/448e744d-857b-4ee0-b009-553388e8dcaa.png" style="zoom:50%;" />

<img src="https://dpubstatic.udache.com/static/dpubimg/40300122-418e-45ef-a494-4f47d932db8f.png" style="zoom:50%;" />

<img src="https://dpubstatic.udache.com/static/dpubimg/0145a9ac-2c3c-45c1-9cbf-0ab5f13ee1ff.png" style="zoom:50%;" />

第十步：点击【视图】可以选择想要看到的脑图结构

<img src="https://dpubstatic.udache.com/static/dpubimg/305123e7-5fab-4c87-999d-86b03e9278e8.png" style="zoom:50%;" />

第十一步：点击【用例锁】，此时用例被锁住，当前只能进行读，不能进行修改

<img src="https://dpubstatic.udache.com/static/dpubimg/96091081-88d0-4fbd-8b84-3b5d97732f2c.png" style="zoom:50%;" />

第十二步：点击【全屏】可以将脑图全屏展示

<img src="https://dpubstatic.udache.com/static/dpubimg/41ba4d61-198a-482b-b7f8-03d0f231b05c.png" style="zoom:50%;" />

#### 执行用例

第一步：新建测试任务

（1）选择待执行的用例，点击"创建测试任务"按钮，弹出"新增测试任务"弹窗

<img src="https://dpubstatic.udache.com/static/dpubimg/05c88de0-2514-4b77-ac72-d2cb5d7c42c9.png" style="zoom:50%;" />

<img src="https://dpubstatic.udache.com/static/dpubimg/79de8939-a232-4be2-9b0d-078554185715.png" style="zoom:50%;" />

（2）输入名称（必填），负责人（非必填），描述（非必填），计划周期（非必填）

（3）选择用例

- 选择全部用例，测试任务便包含该测试用例全部用例

- 也可手动圈选部分用例，比如P0，P1，P2，测试任务便包含所选优先级的用例

  <img src="https://dpubstatic.udache.com/static/dpubimg/8a51b763-0a8f-4490-8aab-c5e012b9270b.png" style="zoom:50%;" />

（4）点击"确定"按钮，测试任务就新建成功啦

<img src="https://dpubstatic.udache.com/static/dpubimg/366eacd4-1ace-4f8a-9bc2-8ab76dadf29e.png" style="zoom:50%;" />

第二步：执行测试任务

（1） 点击用例id旁边的打开按钮，展示新建的测试任务list

<img src="https://dpubstatic.udache.com/static/dpubimg/eb143692-9374-462a-8695-808264839124.png" style="zoom:50%;" />

（2）点击"执行测试"按钮，跳转到新建任务详情页，就可以看到新建任务具体的测试用例

<img src="https://dpubstatic.udache.com/static/dpubimg/1b92babe-6070-4886-8714-3722ed7a6be2.png" style="zoom:50%;" />

（3）执行完一条用例，用例测试通过，点击对应的用例，比如"Authority"，再点击绿色的对号按钮，可以标记通过，如图

<img src="https://dpubstatic.udache.com/static/dpubimg/24f1170b-9638-4144-9ef3-d59929c34cb1.png" style="zoom:50%;" />

（4）执行完一条用例，用例测试不通过，点击对应的用例，比如"删除"，再点击黄色的"X"按钮，可以标记不通过，如图

<img src="https://dpubstatic.udache.com/static/dpubimg/2c00b301-0c52-4414-9d4e-8b702c7aa6c8.png" style="zoom:50%;" />

（5）当然也可以清除标记记录，清除对应的一条记录，点击"移除结果"按钮，标记的成功或失败记录即可消除，比如消除"删除"用例的不通过标记，如图

<img src="https://dpubstatic.udache.com/static/dpubimg/bc9f6e72-0c0e-42f7-a52a-c1b502847a8a.png" style="zoom:50%;" />

（6）需要清除测试任务所有用例的标记记录，可点击"清除执行记录"按钮，便可清除该任务所有用例的标记，再点击"保存"按钮即可

<img src="https://dpubstatic.udache.com/static/dpubimg/0eb52b2c-a2a1-47fd-a7e9-a0babd4aaea0.png" style="zoom:50%;" />

（7）执行用例之后，在任务详情页面可以看到执行用例的个数以及通过率，如图

<img src="https://dpubstatic.udache.com/static/dpubimg/7e545c85-ec8b-446c-a0a6-98e59267967c.png" style="zoom:50%;" />

（8）在任务列表页，可以看到这个测试任务的执行人以及通过率等信息，通过率表示已测用例集中通过的用例占总用例的百分比，如图

<img src="https://dpubstatic.udache.com/static/dpubimg/a1d6dc51-8b36-45a3-98e0-d8f22f3a6e6f.png" style="zoom:50%;" />

#### 复制用例

第一步：选择待复制的用例，点击【复制测试集】按钮，弹出"复制测试用例"弹窗

<img src="https://dpubstatic.udache.com/static/dpubimg/2e9a4da4-f548-4cbe-814b-e384312b5d72.png" style="zoom:50%;" />

<img src="https://dpubstatic.udache.com/static/dpubimg/a571685b-1c1c-4042-bfc8-79e5daae8e7c.png" style="zoom:50%;" />

第二步：默认读取被复制用例的描述、用例集分类及用例内容，可更改用例名称、用例集分类和描述，可选择关联需求，点击"确认"按钮，提示"复制测试用例成功"，在列表页即可看到复制的用例

<img src="https://dpubstatic.udache.com/static/dpubimg/a571685b-1c1c-4042-bfc8-79e5daae8e7c.png" style="zoom:50%;" />

<img src="https://dpubstatic.udache.com/static/dpubimg/7ed09680-de15-41b8-af30-950f8155732b.png" style="zoom:50%;" />

#### 删除用例

第一步：选择待删除的用例，点击【删除用例】按钮，弹出"确认删除用例"弹窗

<img src="https://dpubstatic.udache.com/static/dpubimg/7ed09680-de15-41b8-af30-950f8155732b.png" style="zoom:50%;" />

第二步：勾选"我明白以上操作"，点击【删除】按钮，可删除用例，用例及用例下的测试任务会全部删除，**不可恢复**

<img src="https://dpubstatic.udache.com/static/dpubimg/e01e0228-42ae-47e0-92fd-eedb430801a7.png" style="zoom:50%;" />

#### 导出xmind文件

支持导出测试用例的xmind文件，在本地编辑，点击【导出xmind文件】按钮，可下载该xmind文件，如图

<img src="https://dpubstatic.udache.com/static/dpubimg/b10660fc-64b2-4552-879f-f38d74f0be58.png" style="zoom:50%;" />

 ---
### 非常感谢
#### 如果您觉得这个框架对您有用，您可以捐赠下我，让我有理由继续下去，非常感谢。
![](https://testerhome.com/uploads/photo/2018/26d494a6-7b4f-4b69-8db1-0a3b45f886b7.png!large)

**非常感谢您花费时间阅读，祝您在这里记录、阅读、分享愉快！**
**欢迎留言评论，有问题也可以联系我或者加群交流...**

作者：[@刘智King](http://wpa.qq.com/msgrd?v=3&uin=1306086303&site=自动化&menu=yes)
QQ：1306086303     
Email：hagyao520@163.com

> QQ官方交流群 126325132
<a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=346d11a1a76d05086cd48bc8249126f514248479b50f96288189ab5ae0ca7ba5"><img border="0" src="//pub.idqqimg.com/wpa/images/group.png" alt="软件测试开发交流群" title="软件测试开发交流群"></a>