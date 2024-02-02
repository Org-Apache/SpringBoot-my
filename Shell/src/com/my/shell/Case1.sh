#!/usr/bin/env bash
show1(){
 echo "function 1 Running"
}
show2(){
echo "function 2 Running"
}
show3(){
echo "function 3 Running"
}
read -p "Input chose：" choose
case $choose in
{1..10})
show1
;;
[a-z]|[A-Z])
show2
;;
*)
show3
esac