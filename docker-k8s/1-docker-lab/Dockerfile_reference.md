
```Dockerfile
ARG <variable-name>
FROM <base-image>
WORKDIR /app
COPY . /app
ADD <additional-files>
RUN <commands>
EXPOSE <port>
STOPSIGNAL <signal>
SHELL ["/bin/sh", "-c"]
LABEL <key>=<value>
ENV <key>=<value>
USER <username>
VOLUME ["/data"]
HEALTHCHECK --interval=<time> --timeout=<time> --start-period=<time> --retries=<number> CMD <command>
ENTRYPOINT ["cmd1", "param1", "param2"]
CMD ["cmd1", "param1", "param2"]
```


```bash
docker build --build-arg <variable-name>=<value> -t <image-name>:<tag> .
docker run -d --name <container-name> <image-name>:<tag> 
```

