	package com.example.mypackage;

/**
 * Created by Alex on 12/22/16.
 */

// top level public class
public class PrivateClass {
    public PrivateClass() {
    }

    // top level only classes interfaces and enums exist, everything else must be included in one of these
    // public: the object is visible to all classes everywhere whether they are in the same package or have imported the package containing the public class
    // package private: object is only available within its own package and is visisble to every class within the same package.
    // Package-private is specified by not specifying (default) if you do not specify public. There is no package-private keyword


}
// public interface
//public interface publicInterface{
//
//}

//package-private interface
// interface packagePrivateInterface{
// }

// Member Level
// At the member level public has the same meaning as the top level
// a public class memeber (or field) and public method can be accessed from any other class anywhere, even a different package (you can call class.variable) or set it
// package private has same meaning as at top level
// private only visible within class decared in, not subclasses
// protected: The object is visible anywhere in its own package but also in subclasses, even in another package






// Access is granted at top level or member level 
// make class public or package private (top level)
// only classes, interfaces or enums here at top level 
// public: the object is visible to all classes everywhere whether they are in the same package or have imported the package containing the public class
// package private: object is only available within its own package and is visisble to every class within the same package.
// Package-private is specified by not specifying (default) if you do not specify public. There is no package-private keyword

// Member Level
// At the member level public has the same meaning as the top level
// a public class memeber (or field) and public method can be accessed from any other class anywhere, even a different package (you can call class.variable) or set it
// package private has same meaning as at top level
// private only visible within class decared in, not subclasses
// protected: The object is visible anywhere in its own package but also in subclasses, even in another package-private




	






