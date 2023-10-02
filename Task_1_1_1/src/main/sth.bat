javac -d .\out .\java\org\example\Main.java .\java\org\example\HeapSort.java
javadoc -d .\javadoc .\java\org\example\Main.java .\java\org\example\HeapSort.java
cd .\out
java -classpath . org.example.Main
pause