


```bash
java -cp target/classes com.example.DeadlockSimulator
jps
jstack <pid>
```

# Thread Analysis

```bash
jcmd <PID> Thread.print > deadlock.txt
```
