#! /bin/bash

CLASSPATH=".;lib/hamcrest-core-1.3.jar;lib/junit-4.13.2.jar"

cd $( dirname $0 )

javac -cp $CLASSPATH *.java
java -cp $CLASSPATH org.junit.runner.JUnitCore ListTests