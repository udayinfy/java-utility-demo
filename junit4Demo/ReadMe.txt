JUnit�ĸ��ֶ���

JUnit�ṩ��һЩ�������������ڰ�����ȷ��ĳ�������Ժ����Ƿ���������ͨ�����ԣ����ǰ�������Щ����ͳ��Ϊ���ԡ������ǵ�Ԫ�������������ɲ��֡�

1. assertEquals([String message], expected,actual) 

�Ƚ������������ͻ�����Ƿ���ȣ�expected��actual��ԭʼ������ֵ(primitive value)���߱���Ϊʵ�ֱȽ϶�����equal��������

2.assertFalse([String message],boolean condition)

�Բ���ֵ��ֵ�������Ƿ�Ϊ���桰��

3.assertTrue([String message],boolean condition) 

�Բ���ֵ��ֵ�������Ƿ�Ϊ���١���

4.assertNull([String message],java.lang.Object object)

�������Ƿ�Ϊ���ա���

5.assertNotNull([String message],java.lang.Object object)

�������Ƿ�Ϊ���ա���

6.assertSame([String message],expected,actual)

������������Ƿ�Ϊͬһʵ����

7.assertNotSame([String message],expected,actual)

������������Ƿ�Ϊͬһʵ����

8. fail( String message ) 

ʹ��������ʧ�ܣ����� message ����ʹ��ѡ�ġ����ֶ���ͨ�������ڱ��ĳ����Ӧ�õ���ķ�֧�����磬��һ��Ԥ�ڷ������쳣֮�� ��


JUnit Annotation  

����������ӿ��Կ�����JUnit 4�л�������һЩ������Ԫ���ݣ�����һһ���ܣ�

@Before��

ʹ���˸�Ԫ���ݵķ�����ÿ�����Է���ִ��֮ǰ��Ҫִ��һ�Ρ�

@After��

ʹ���˸�Ԫ���ݵķ�����ÿ�����Է���ִ��֮��Ҫִ��һ�Ρ�

ע�⣺@Before��@After��ʾ�ķ���ֻ�ܸ���һ��������൱��ȡ����JUnit��ǰ�汾�е�setUp��tearDown��������Ȼ�㻹���Լ��������

���֣�����JUnit����Ե���Ҫ������ô���ˡ�

@Test(expected=*.class)

��JUnit4.0֮ǰ���Դ���Ĳ��ԣ�����ֻ��ͨ��fail������һ�����󣬲���try������assertTrue��true�������ԡ����ڣ�ͨ��@TestԪ����

�е�expected���ԡ�expected���Ե�ֵ��һ���쳣������

@Test(timeout=xxx):

��Ԫ���ݴ�����һ��ʱ�䣨���룩�����Է�����

������Է������ƶ���ʱ��֮��û�������꣬�����Ҳʧ�ܡ�

@ignore��

��Ԫ���ݱ�ǵĲ��Է����ڲ����лᱻ���ԡ������Եķ�����û��ʵ�֣����߲��Եķ����Ѿ���ʱ��������ĳ�������²��ܲ��Ը�

������������Ҫһ�����ݿ����ӣ����ڱ��ز��Ե�ʱ�����ݿⲢû�����ӣ�����ôʹ�øñ�ǩ����ʾ���������ͬʱ�������Ϊ

�ñ�ǩ����һ��String�Ĳ�����������Ϊʲô�����������Է��������磺@lgnore(���÷�����û��ʵ�֡�)����ִ�е�ʱ�򣬽���

����÷���û��ʵ�֣����������в��Է�����

