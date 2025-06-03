

### Without JIT Compilation

```bash
java -Xint com.example.JITDemo2
```

### With JIT Compilation

```bash
java -XX:+TieredCompilation -XX:CompileThreshold=1000 com.example.JITDemo2
```

### JIT Compilation with Profiling

```bash
java \
-XX:+UnlockDiagnosticVMOptions \
-XX:+PrintCompilation \
-XX:+LogCompilation \
-XX:CICompilerCount=2 \
-XX:+TieredCompilation \
-XX:+PrintInlining \
-XX:CompileThreshold=1000 \
-XX:TieredStopAtLevel=4 \
-XX:+UnlockExperimentalVMOptions \
com.example.JITDemo
```



### JIT with GraalVM 

```bash
sudo xattr -r -d com.apple.quarantine /Users/nag/Downloads/graalvm-community-openjdk-17.0.8+7.1/

export GRAALVM_HOME=/Users/nag/Downloads/graalvm-community-openjdk-17.0.8+7.1/Contents/Home/
export PATH=$GRAALVM_HOME/bin:$PATH 
java --version

$GRAALVM_HOME/bin/java \
  -XX:+UnlockExperimentalVMOptions \
  -XX:+EnableJVMCI \
  -XX:+UseJVMCICompiler \
  -XX:+PrintCompilation \
  com.example.JITCompare

```


### AOT Compilation with GraalVM Native Image

```bash
$GRAALVM_HOME/bin/gu install native-image
native-image com.example.HelloApp
```


🚫 But why JVM still matters?

Even though native image works well for many use cases, the JVM is still relevant because:

JVM Advantages	                  Native Image Trade-offs
🔁 Dynamic Classloading	         ❌ No support for dynamic class loading
⚡ JIT optimizations at runtime	 ❌ All optimization is fixed at compile time
🔧 Reflection & proxies supported	✅ Partially supported, but needs configuration
🔁 Faster iterative dev cycles	 ❌ Native image builds are slow (mins vs secs)
🧠 Memory-efficient GC options	 ❌ Native image GC is simpler & less dynamic
🔍 Monitoring, Profiling tools	 ❌ Limited support in native binaries


✅ Use Native Image When:
-> You want fast startup and low memory (e.g., CLI apps, microservices).
-> You don’t need dynamic features like reflection, class loading, proxies.

✅ Use JVM When:
-> You rely on hot code paths that benefit from JIT.

-> Your app uses dynamic frameworks (Spring, Hibernate, etc.).
-> You want full observability, debugging, and tool support.