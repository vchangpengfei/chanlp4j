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
exressionMap.put("120","<int>钱 || <int>元 || 多少钱");
exressionMap.put("110","床-大床房-双床房");
ExpressionParser.getInstance().load(exressionMap);

System.out.println(ExpressionParser.getInstance().getMatchItems("酒店房间115元"));
System.out.println(ExpressionParser.getInstance().getMatchItems("钱"));
System.out.println(ExpressionParser.getInstance().getMatchItems("酒店房间没多少钱"));
System.out.println(ExpressionParser.getInstance().getMatchItems("想洗衣服没洗衣粉"));
System.out.println(ExpressionParser.getInstance().getMatchItems("大床房的床很大"));
System.out.println(ExpressionParser.getInstance().getMatchItems("大床房和双床房的床很大"));
System.out.println(ExpressionParser.getInstance().getMatchItems("大床房和双床房很大"));
System.out.println(ExpressionParser.getInstance().getMatchItems("大床房很大"));

//输出
[120]
[]
[120]
[]
[110]
[110]
[]
[]

```


cd javacc
java -cp javacc-7.0.9.jar javacc termquery.jj
