# template-engine
模版引擎工程

# 功能用途
* 快速生成指定格式的文件
* 批量快捷，减少人为工作量

# 使用方法
* 方法1：建立自定义模版
<pre>
// 自定义模版
LocalTemplate localTemplate =  new LocalTemplate();
Generator generator = new Generator(localTemplate);
generator.exec();
</pre>
* 方法2：建立自定义流程
<pre>
// 自定义流程
LocalSchedule localSchedule =  new LocalSchedule();
Generator generator = new Generator(localSchedule);
generator.exec();
</pre>

# 备注
之后补全详细文档,实例代码在com.rishqiing中