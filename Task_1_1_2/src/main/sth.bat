javac -d .\out .\java\org\example\Main.java .\java\org\example\Polynomial.java
javadoc -d .\javadoc .\java\org\example\Main.java .\java\org\example\Polynomial.java
cd .\out
java -classpath . org.example.Main
pause