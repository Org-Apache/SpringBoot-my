#!/usr/bin/env bash
echo "Where ary you from"
select var in "Beijing" "shanghai" "xinxiang" "guanghzou"
do
break
done
echo "you are from $var"