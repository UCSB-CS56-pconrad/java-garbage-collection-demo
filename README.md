# java-garbage-collection-demo

Demonstration of Java Garbage Collection instrumentation

This code is intended to go with these articles:
* https://ucsb-cs56-pconrad.github.io/topics/java_gc/
* https://ucsb-cs56-pconrad.github.io/topics/java_gc_under_the_hood/

Note that the techniques shown in this code are "best effort".  They do not necessarily show EXACTLY when an object
becomes eligible for garbage collection.     But, they often get pretty close to what a hand analysis of the code
would suggest is the time that the object becomes eligible, so they are a good way to check our understanding.

# Resources

* "How can you force gc in Java" 
    * Short answer: you can't 100%, but you can get pretty close
    * Here's how: http://stackoverflow.com/questions/1481178/how-to-force-garbage-collection-in-java

* "How you can see when an object gets garbage collected?"
    * Short answer: you can't, but you can get pretty close
    * Here's how: 
    
* When do objects referred to by static class members get garbage collected?
    * Short answer: they usually don't
    * Longer answer, if and only if the classloader that loaded them is unloaded.  Which is pretty uncommon. See: http://stackoverflow.com/questions/405364/whats-up-with-static-memory-in-java
    
* More Java GC Stuff: https://github.com/deephacks/awesome-jvm#garbage-collectors
