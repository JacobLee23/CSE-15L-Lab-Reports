#! /bin/bash

cd $( dirname $0 )

javac *.java
java ChatServer $1