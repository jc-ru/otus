> $current = $PWD -replace "\\", "/" -replace "C", "c"  
> docker run -d
--name selenoid
-p 4444:4444
-v //var/run/docker.sock:/var/run/docker.sock
-v ${current}/config/:/etc/selenoid/:ro
aerokube/selenoid:latest-release