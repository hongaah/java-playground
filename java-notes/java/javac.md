```sh
# javac 会生成一份 HelloWorld.class 的文件，这份文件其实是一份字节码文件，专门给 JVM 识别使用的
javac helloword.java
java HelloWorld.java

# -d 这里会将 class 文件生成后放在当前目录+包目录的地址下  
javac -d . Cat.java
java org/idea/java/demo/cat/Cat  
```
