# java-garbage-collection-demo

Demonstration of Java Garbage Collection instrumentation

This code is intended to go with these articles:
* https://ucsb-cs56-pconrad.github.io/topics/java_gc/
* https://ucsb-cs56-pconrad.github.io/topics/java_gc_under_the_hood/

Note that the techniques shown in this code are "best effort".  They do not necessarily show EXACTLY when an object
becomes eligible for garbage collection.     But, they often get pretty close to what a hand analysis of the code
would suggest is the time that the object becomes eligible, so they are a good way to check our understanding.

# Demo

Compiling and running this code, you get the following output.  What we've done
here is two things:

* We used a `public static void finalize()` method of Dog to print out the
    name of each Dog when it is finalized.  This happens
    sometime between when it becomes eligible for garbage collection, and
    when it actually gets garbage collected (that's the best we can do.)

* We then used System.gc() to try to "strongly encourage" the garbage
   collector to run in between every two lines of code that manipulate
   our references.   We did this by calling it not just once, but twice.
   (It seems as though there is no 100% reliable way to *force* gc to run
   but this "strong encouragement" was sufficient.)

If you hand trace the `Dog` references `d1` through `d6`, `temp`, and
the private static reference `dogOfTheWeek` with respect to the `Dog`
objects, this output looks pretty much like what we'd expect.

```
pconrad $ javac Dog.java; java Dog
Line 0
Line 1
Line 2
Finalizing Princess
Line 3
Line 4
Line 5
Line 6
Line 7
Line 8
Line 9
Line 10
Line 11
Finalizing Fido
Line 12
Finalizing Spot
Line 13
Line 14
Finalizing Rover
Line 15
Line 16
pconrad $
```



# More about the `finalize()` method

The `finalize()` method is called once sometime between when an object becomes
eligible for garbage collection, and when it is finally garbage collected.

Note: In ordinary practice, you do not need a finalize() method; it
is typically only needed when writing systems that use a combination
of two languages, e.g. some Java code and some C++ code interacting
with one another, where, for example, you might have an object written
half in Java and half in C++, and you need to call the C++
"destructor" when the Java object is garbage collected.  But we can use this
"hook" to get some visibility into the Java Garbage Collection process.


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
