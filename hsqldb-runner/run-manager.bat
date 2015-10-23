@echo off

set HOME=c:\
set JAVA_HOME=C:\Demo\jdk_1.7.0_21
set M2_HOME=C:\Demo\maven_3.0.5
set M3_HOME=C:\Demo\maven_3.0.5
set PATH="%JAVA_HOME%\bin";"%M3_HOME%\bin";%PATH%
mvn exec:java -Dexec.mainClass="org.hsqldb.util.DatabaseManagerSwing" -Dexec.args="--url jdbc:hsqldb:hsql://localhost/"