#!/usr/bin/env bash
echo "$0"
for i in {1..9}
do
 for ((j=1;j<=i;j++))
 do
    printf "%-8s"$i*$j=$((j*i))
 done
 echo
done