package ai.demo.langchain;

import org.springframework.web.bind.annotation.RestController;

/**
 * AiServices会组装Assistant接口以及其他组件，并使用反射机制创建一个实现Assistant接口的代理对象。
 * 这个代理对象会处理输入和输出的所有转换工作。在这个例子中，chat方法的输入是一个字符串，但是大模型需要一个UserMessage对象。
 * 所以，代理对象将这个字符串转换为UserMessage，并调用聊天语言模型。chat方法的输出类型也是字符串，但是大模型返回的是AiMessage对象，代理对象会将其转换为字符串。
 * 简单理解就是：代理对象的作用是输入转换和输出转换
 * @author: luogang
 * @email: <EMAIL>
 * @date: 2023/08/09
 */
@RestController
public class AiServiceController {

}
