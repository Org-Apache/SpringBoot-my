#!/usr/bin/env bash
read -p "Please input your Password:" password
if [ "$password" == "root" ]
then
 echo -e "\033[32mok\033[0m"
else
 echo -e "\033[31merror!\033[0m"
fi