# cljfunc

A Clojure app using Leiningen that essentially contains functions with various purposes.

## Usage

---

Simply run the Jar 'cljfunc/target/uberjar/cljfunc-0.1.0-SNAPSHOT-standalone.jar'
    
    $ java -jar cljfunc-0.1.0-SNAPSHOT-standalone.jar

Or install Leiningen using instructions found at: 

    https://leiningen.org/

And run...
    
    $ lein run

at the project root directory.

---

If you wish to test the program with your own inputs, you can run
    
    $ lein repl

in the root directory to bring up a command line interface
    
    cljfunc.core=>

Here, you can run the functions, for example:
    
    cljfunc.core=> (addSequential n1 n2)
    
    cljfunc.core=> (palindrome "word")
    
    cljfunc.core=> (quadratic a b c)
    
    cljfunc.core=> (groupNames)


