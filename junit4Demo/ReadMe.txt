JUnit的各种断言

JUnit提供了一些辅助函数，用于帮助你确定某个被测试函数是否工作正常。通常而言，我们把所有这些函数统称为断言。断言是单元测试最基本的组成部分。

1. assertEquals([String message], expected,actual) 

比较两个基本类型或对象是否相等（expected和actual是原始类型数值(primitive value)或者必须为实现比较而具有equal方法）；

2.assertFalse([String message],boolean condition)

对布尔值求值，看它是否为“真“；

3.assertTrue([String message],boolean condition) 

对布尔值求值，看它是否为“假“；

4.assertNull([String message],java.lang.Object object)

检查对象是否为“空“；

5.assertNotNull([String message],java.lang.Object object)

检查对象是否不为“空”；

6.assertSame([String message],expected,actual)

检查两个对象是否为同一实例；

7.assertNotSame([String message],expected,actual)

检查两个对象是否不为同一实例；

8. fail( String message ) 

使测试立即失败，其中 message 参数使可选的。这种断言通常被用于标记某个不应该到达的分支（例如，在一个预期发生的异常之后） 。


JUnit Annotation  

从上面的例子可以看到在JUnit 4中还引入了一些其他的元数据，下面一一介绍：

@Before：

使用了该元数据的方法在每个测试方法执行之前都要执行一次。

@After：

使用了该元数据的方法在每个测试方法执行之后要执行一次。

注意：@Before和@After标示的方法只能各有一个。这个相当于取代了JUnit以前版本中的setUp和tearDown方法，当然你还可以继续叫这个

名字，不过JUnit不会霸道的要求你这么做了。

@Test(expected=*.class)

在JUnit4.0之前，对错误的测试，我们只能通过fail来产生一个错误，并在try块里面assertTrue（true）来测试。现在，通过@Test元数据

中的expected属性。expected属性的值是一个异常的类型

@Test(timeout=xxx):

该元数据传入了一个时间（毫秒）给测试方法，

如果测试方法在制定的时间之内没有运行完，则测试也失败。

@ignore：

该元数据标记的测试方法在测试中会被忽略。当测试的方法还没有实现，或者测试的方法已经过时，或者在某种条件下才能测试该

方法（比如需要一个数据库联接，而在本地测试的时候，数据库并没有连接），那么使用该标签来标示这个方法。同时，你可以为

该标签传递一个String的参数，来表明为什么会忽略这个测试方法。比如：@lgnore(“该方法还没有实现”)，在执行的时候，仅会

报告该方法没有实现，而不会运行测试方法。

