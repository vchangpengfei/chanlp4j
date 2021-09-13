# chanlp4j
trick for nlp 高性能表达式过滤文本


#高性能表达式过滤文本

nlp处理处理文本的过程中 经常会遇到 一个句子中即包含 哪个词  又包含哪个词 并且不包含 哪个词 类似的需求


这里通过一个表达式来解决，表达式支持

- 括号 （）
- 并且 &&
- 或 ||
- 非 !


实例如下

```java

Map<String,String> exressionMap=new HashMap();
exressionMap.put("16","(洗衣 || 干洗 || 熨衣 || 挂烫机 || 熨斗) && (有 || 提供 || 服务 || 可 || 帮) && !(洗衣液 || 洗衣粉)");
ExpressionParser.getInstance().load(exressionMap);
System.out.println(ExpressionParser.getInstance().getMatchItems("酒店提供干洗服务"));
System.out.println(ExpressionParser.getInstance().getMatchItems("想洗衣服没洗衣粉"));

//输出
[16]
[]

```


cd javacc
java -cp javacc-7.0.9.jar javacc termquery.jj