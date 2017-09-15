CSS
===


1. css的引入

2. css的选择器

How css works
浏览器在展现一个文档的时候，必须要把文档内容和相应的样式信息结合起来展示。 这个处理过程一般分两个阶段：

浏览器先将标记语言和CSS转换成DOM (文档对象模型)结构。 这时DOM 就代表了电脑内存中的相应文档，因为它已经融合了文档内容和相应的样式表。
最后浏览器把 DOM的内容展示出来。

样式来源
+ 浏览器对HTML定义的默认样式。
+ 用户定义的样式。
+ 开发者定义的样式，可以有三种形式：
    - 定义在外部文件（外链样式）：本教程中案例主要是通过这种形式定义样式。
    - 在页面的头部定义（内联样式）：通过这种形式定义的样式只在本页面内生效。
    - 定义在特定的元素身上（行内样式）：这种形式多用于测试，可维护性较差。

## CSS选择器
rule

declaration

+ 类型选择器
+ 类选择器(class)
+ ID选择器(id, #号开头)
+ 选择器 [type='button'] 选中所有 type 属性为 button 的元素
id 属性值 principal必须在文档中是唯一的；但文档中的其他标签可以有和p相同的 class 属性值 key.
如果多于一个规则指定了相同的属性值都应用到一个元素上，CSS规定拥有更高确定度的选择器优先级更高。ID选择器比类选择器更具确定度, 而类选择器比标签选择器（tag selector）更具确定度。
如果样式中包含冲突的规则，且它们具有相同的确定度。那么，后出现的规则优先级高。

如果你遇到规则冲突，你可以增加其中一条的确定度或将之移到后面以使它具有更高优先级。
### 伪类选择器
CSS伪类（pseudo-class）是加在选择器后面的用来指定元素状态的关键字。比如，:hover 会在鼠标悬停在选中元素上时应用相应的样式。



常见的基于关系的选择器
选择器	选择的元素
A E	元素A的任一后代元素E (后代节点指A的子节点，子节点的子节点，以此类推)
A > E	元素A的任一子元素E(也就是直系后代)
E:first-child	任一是其父母结点的第一个子节点的元素E
B + E	元素B的任一下一个兄弟元素E
B ~ E	B元素后面的拥有共同父元素的兄弟元素E


