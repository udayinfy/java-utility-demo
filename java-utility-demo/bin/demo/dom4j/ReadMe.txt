1.��ȡDocument 
?SAXReader saxReader = new SAXReader(); 
?Document document = saxReader.read(FileUtil.getFileInputStream(fileName));

2.��ѯElement 
?String xpath ="/composites/composite[@type='onDelete']";//��ѯ����type='ondDelete'��composite 
?List<Element> composites = document.selectNodes(xpath);

3.xpath�﷨
ѡȡ�ڵ�
XPath ʹ��·�����ʽ�� XML �ĵ���ѡȡ�ڵ㡣�ڵ���ͨ������·������ step ��ѡȡ�ġ�

�����г��������õ�·�����ʽ��
���ʽ ���� 
nodename ѡȡ�˽ڵ�������ӽڵ� 
/ �Ӹ��ڵ�ѡȡ 
// ��ƥ��ѡ��ĵ�ǰ�ڵ�ѡ���ĵ��еĽڵ㣬�����������ǵ�λ�� 
. ѡȡ��ǰ�ڵ� 
.. ѡȡ��ǰ�ڵ�ĸ��ڵ� 
@ ѡȡ����

ʵ��
������ı���У��������г���һЩ·�����ʽ�Լ����ʽ�Ľ����

·�����ʽ ��� 
bookstore ѡȡ bookstore Ԫ�ص������ӽڵ� 
/bookstore ѡȡ��Ԫ�� bookstore

ע�ͣ�����·����ʼ����б��( / )�����·��ʼ�մ���ĳԪ�صľ���·����
 
bookstore/book ѡȡ�������� bookstore ����Ԫ�ص� book Ԫ�ء� 
//book ѡȡ���� book ��Ԫ�أ��������������ĵ��е�λ�á� 
bookstore//book ѡ���������� bookstore Ԫ�صĺ���� book Ԫ�أ�����������λ�� bookstore ֮�µ�ʲôλ�á� 
//@lang ѡȡ������Ϊ lang �����ԡ� 

ν�Predicates��
ν����������ĳ���ض��Ľڵ���߰���ĳ��ָ����ֵ�Ľڵ㡣

ν�ﱻǶ�ڷ������С�

ʵ��
������ı���У������г��˴���ν���һЩ·�����ʽ���Լ����ʽ�Ľ����

·�����ʽ ��� 
/bookstore/book[1] ѡȡ���� bookstore ��Ԫ�صĵ�һ�� book Ԫ�ء� 
/bookstore/book[last()] ѡȡ���� bookstore ��Ԫ�ص����һ�� book Ԫ�ء� 
/bookstore/book[last()-1] ѡȡ���� bookstore ��Ԫ�صĵ����ڶ��� book Ԫ�ء� 
/bookstore/book[position()<3] ѡȡ��ǰ����������� bookstore Ԫ�ص���Ԫ�ص� book Ԫ�ء� 
//title[@lang] ѡȡ����ӵ����Ϊ lang �����Ե� title Ԫ�ء� 
//title[@lang='eng'] ѡȡ���� title Ԫ�أ�����ЩԪ��ӵ��ֵΪ eng �� lang ���ԡ� 
/bookstore/book[price>35.00] ѡȡ���� bookstore Ԫ�ص� book Ԫ�أ������е� price Ԫ�ص�ֵ����� 35.00�� 
/bookstore/book[price>35.00]/title ѡȡ���� bookstore Ԫ���е� book Ԫ�ص� title Ԫ�أ������е� price Ԫ�ص�ֵ����� 35.00�� 

ѡȡδ֪�ڵ�
XPath ͨ���������ѡȡδ֪�� XML Ԫ�ء�

ͨ��� ���� 
* ƥ���κ�Ԫ�ؽڵ� 
@* ƥ���κ����Խڵ� 
node() ƥ���κ����͵Ľڵ� 

ʵ��
������ı���У������г���һЩ·�����ʽ���Լ���Щ���ʽ�Ľ����

·�����ʽ ��� 
/bookstore/* ѡȡ bookstore Ԫ�ص������ӽڵ� 
//* ѡȡ�ĵ��е�����Ԫ�� 
//title[@*] ѡȡ���д������Ե� title Ԫ�ء� 

ѡȡ����·��
ͨ����·�����ʽ��ʹ�á�|���������������ѡȡ���ɸ�·����

ʵ��
������ı���У������г���һЩ·�����ʽ���Լ���Щ���ʽ�Ľ����

·�����ʽ ��� 
//book/title | //book/price ѡȡ���� book Ԫ�ص� title �� price Ԫ�ء� 
//title | //price ѡȡ�����ĵ��е� title �� price Ԫ�ء� 
/bookstore/book/title | //price ѡȡ�������� bookstore Ԫ�ص� book Ԫ�ص� title Ԫ�أ��Լ��ĵ������е� price Ԫ�ء� 




XPath ��
��ɶ���ĳ������ڵ�ǰ�ڵ�Ľڵ㼯��

������ ��� 
ancestor ѡȡ��ǰ�ڵ�������ȱ��������游�ȣ� 
ancestor-or-self ѡȡ��ǰ�ڵ�������ȱ��������游�ȣ��Լ���ǰ�ڵ㱾�� 
attribute ѡȡ��ǰ�ڵ���������� 
child ѡȡ��ǰ�ڵ��������Ԫ�ء� 
descendant ѡȡ��ǰ�ڵ�����к��Ԫ�أ��ӡ���ȣ��� 
descendant-or-self ѡȡ��ǰ�ڵ�����к��Ԫ�أ��ӡ���ȣ��Լ���ǰ�ڵ㱾�� 
following ѡȡ�ĵ��е�ǰ�ڵ�Ľ�����ǩ֮������нڵ㡣 
namespace ѡȡ��ǰ�ڵ�����������ռ�ڵ� 
parent ѡȡ��ǰ�ڵ�ĸ��ڵ㡣 
preceding ѡȡ�ĵ��е�ǰ�ڵ�Ŀ�ʼ��ǩ֮ǰ�����нڵ㡣 
preceding-sibling ѡȡ��ǰ�ڵ�֮ǰ������ͬ���ڵ㡣 
self ѡȡ��ǰ�ڵ㡣 

λ��·�����ʽ
λ��·�������Ǿ��Եģ�Ҳ��������Եġ�

����·����ʼ����б��( / )�������·����������������������У�λ��·��������һ����������ÿ��������б�ָܷ

����λ��·����
/step/step/...���λ��·����
step/step/...ÿ���������ݵ�ǰ�ڵ㼯֮�еĽڵ������м��㡣

����step��������
�ᣨaxis�� 
������ѡ�ڵ��뵱ǰ�ڵ�֮�������ϵ 
�ڵ���ԣ�node-test�� 
ʶ��ĳ�����ڲ��Ľڵ� 
������߸���ν�predicate�� 
�������������ѡ�Ľڵ㼯
�����﷨��
������::�ڵ����[ν��]ʵ��
���� ��� 
child::book ѡȡ�������ڵ�ǰ�ڵ����Ԫ�ص� book �ڵ� 
attribute::lang ѡȡ��ǰ�ڵ�� lang ���� 
child::* ѡȡ��ǰ�ڵ��������Ԫ�� 
attribute::* ѡȡ��ǰ�ڵ���������� 
child::text() ѡȡ��ǰ�ڵ�������ı��ӽڵ� 
child::node() ѡȡ��ǰ�ڵ�������ӽڵ� 
descendant::book ѡȡ��ǰ�ڵ������ book ��� 
ancestor::book ѡ��ǰ�ڵ������ book �ȱ� 
ancestor-or-self::book ѡȡ��ǰ�ڵ������book�ȱ��Լ���ǰ�ڵ㣨����˽ڵ���book�ڵ�Ļ��� 
child::*/child::price ѡȡ��ǰ�ڵ������ price � 



XPath �����
�����г��˿����� XPath ���ʽ�е��������

����� ���� ʵ�� ����ֵ 
| ���������ڵ㼯 //book | //cd �������д��� book �� ck Ԫ�صĽڵ㼯 
+ �ӷ� 6 + 4 10 
- ���� 6 - 4 2 
* �˷� 6 * 4 24 
div ���� 8 div 4 2 
= ���� price=9.80 ��� price �� 9.80���򷵻� true��

��� price �� 9.90���򷵻� fasle��
 
!= ������ price!=9.80 ��� price �� 9.90���򷵻� true��

��� price �� 9.80���򷵻� fasle��
 
< С�� price<9.80 ��� price �� 9.00���򷵻� true��

��� price �� 9.90���򷵻� fasle��
 
<= С�ڻ���� price<=9.80 ��� price �� 9.00���򷵻� true��

��� price �� 9.90���򷵻� fasle��
 
> ���� price>9.80 ��� price �� 9.90���򷵻� true��

��� price �� 9.80���򷵻� fasle��
 
>= ���ڻ���� price>=9.80 ��� price �� 9.90���򷵻� true��

��� price �� 9.70���򷵻� fasle��
 
or �� price=9.80 or price=9.70 ��� price �� 9.80���򷵻� true��

��� price �� 9.50���򷵻� fasle��
 
and �� price>9.00 and price<9.90 ��� price �� 9.80���򷵻� true��

��� price �� 8.50���򷵻� fasle��
 
mod ������������� 5 mod 2 1 
