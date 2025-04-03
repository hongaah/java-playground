# @RestController

@RestController 注解包含了原来的 @Controller 和 @ResponseBody 注解

@ResponseBody 注解是将返回的数据结构转换为 Json 格式。所以在默认情况下，使用了 @RestController 注解即可将返回的数据结构转换成 Json 格式，Spring Boot 中默认使用的 Json 解析技术框架是 jackson。

springboot:
@RestController
@RequestMapping
@PathVariable
@RequestParam
@RequestBody

spring:
@ResponseBody
