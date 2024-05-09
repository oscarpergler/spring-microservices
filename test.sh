#!/bin/bash

# https://signoz.io/blog/docker-stats/

logfile="cpu_load.log"

touch $logfile

while true; do
    timestamp=$(date +"%Y-%m-%d %H:%M:%S")

    cpu_load=$(top -bn1 | grep "Cpu(s)" | awk '{print $2}')

    echo "$timestamp CPU Load: $cpu_load%" >> "$logfile"

    sleep 1
done
