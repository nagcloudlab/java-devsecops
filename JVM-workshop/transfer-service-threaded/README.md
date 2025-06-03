

# build the project
```bash
mvn clean package
```



# JVM Memory Settings


## Metaspace
```bash
java \
--add-opens java.base/java.lang=ALL-UNNAMED \
-XX:MetaspaceSize=64m \
-XX:MaxMetaspaceSize=128m \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=./heapdump-metaspace.hprof \
-XX:NativeMemoryTracking=summary \
"-Xlog:gc*" \
-jar target/transfer-service-1.0-SNAPSHOT.jar
```

```bash
jconsole
# Connect to the running JVM
```

```bash
jvisualvm
# Connect to the running JVM
```

```bash
jps
jcmd 20510 VM.native_memory summary

```



## Stack
```bash
java \
--add-opens java.base/java.lang=ALL-UNNAMED \
-XX:ThreadStackSize=256 \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=./heapdump-stack.hprof \
-XX:NativeMemoryTracking=summary \
"-Xlog:gc*" \
-jar target/transfer-service-1.0-SNAPSHOT.jar
```

```bash
jps
jcmd 66364 VM.native_memory summary
```


## Heap
```bash
java \
--add-opens java.base/java.lang=ALL-UNNAMED \
-Xms512m \
-Xmx2g \
-XX:MaxMetaspaceSize=128m \
-XX:ThreadStackSize=256 \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=./heapdump-full.hprof \
-XX:NativeMemoryTracking=summary \
"-Xlog:gc*,gc+heap=info,gc+ref=debug" \
-jar target/transfer-service-1.0-SNAPSHOT.jar
```


```bash
jps
jcmd 24865 VM.native_memory summary
```


## GC
```bash
java \
--add-opens java.base/java.lang=ALL-UNNAMED \
-Xms512m \
-Xmx2g \
-XX:MaxMetaspaceSize=128m \
-XX:ThreadStackSize=256 \
-XX:+UseG1GC \
-XX:MaxGCPauseMillis=200 \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=./heapdump-gc.hprof \
-XX:NativeMemoryTracking=summary \
"-Xlog:gc*,gc+heap=info,gc+ref=debug" \
-jar target/transfer-service-1.0-SNAPSHOT.jar
```


```bash
jps
jcmd 24865 VM.native_memory summary
jcmd 24865 GC.heap_info
jcmd 24865 GC.class_histogram

jcmd <pid> GC.run
jcmd <pid> GC.heap_dump ./heapdump-gc.hprof

```

## GC log file
```bash
java \
--add-opens java.base/java.lang=ALL-UNNAMED \
-Xms512m \
-Xmx2g \
-XX:MaxMetaspaceSize=128m \
-XX:ThreadStackSize=256 \
-XX:+UseG1GC \
-XX:MaxGCPauseMillis=200 \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=./heapdump-gc.hprof \
-XX:NativeMemoryTracking=summary \
"-Xlog:gc*,gc+heap=info,gc+ref=debug:file=./gc.log:time,uptime:filecount=5,filesize=10M" \
-jar target/transfer-service-1.0-SNAPSHOT.jar
```


## Thread Dump
```bash
jcmd <pid> Thread.print
jstack <pid>
```

### GC pause log
```bash
java \
-XX:+UseG1GC \
-XX:+PrintGCApplicationStoppedTime \
-XX:+PrintGCApplicationConcurrentTime \
-XX:+PrintGCDetails \
-XX:+PrintGCDateStamps \
-Xloggc:gc-pause-demo.log \
-Xmx512m \
com.example.GcPauseDemo
```


### jfr (Java Flight Recorder) and JMC (Java Mission Control)

```bash
java \
--add-opens java.base/java.lang=ALL-UNNAMED \
-Xms512m \
-Xmx2g \
-XX:MaxMetaspaceSize=128m \
-XX:ThreadStackSize=256 \
-XX:+UseG1GC \
-XX:MaxGCPauseMillis=200 \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=./heapdump-gc.hprof \
-XX:NativeMemoryTracking=summary \
"-Xlog:gc*,gc+heap=info,gc+ref=debug:file=./gc.log:time,uptime:filecount=5,filesize=10M" \
-XX:StartFlightRecording=filename=./recording.jfr,dumponexit=true,settings=profile \
-jar target/transfer-service-1.0-SNAPSHOT.jar
```

```bash
jcmd <pid> JFR.start name=recording settings=profile
```



## Profiling
```bash
java \
--add-opens java.base/java.lang=ALL-UNNAMED \
-Xms512m \
-Xmx2g \
-XX:MaxMetaspaceSize=128m \
-XX:ThreadStackSize=256 \
-XX:+UseG1GC \
-XX:MaxGCPauseMillis=200 \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=./heapdump-gc.hprof \
-XX:NativeMemoryTracking=summary \
"-Xlog:gc*,gc+heap=info,gc+ref=debug:file=./gc.log:time,uptime:filecount=5,filesize=10M" \
-XX:StartFlightRecording=filename=./recording.jfr,dumponexit=true,settings=profile \
-agentlib:async-profiler=start,event=cpu,interval=10ms,dir=./profiler \
-jar target/transfer-service-1.0-SNAPSHOT.jar
```

```bash
jcmd <pid> JFR.start name=recording settings=profile
```


