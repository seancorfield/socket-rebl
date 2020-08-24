# Socket REBL

If you are are using [Cognitect's REBL](https://github.com/cognitect-labs/REBL-distro), this simple utility lets you start a Socket REPL where every form entered is submitted to REBL, along with its value.

Instead of using the regular `clojure.core.server/repl` as the `:accept` function, add this library to your classpath and use its `socket.rebl/repl` function for the `:accept` instead, like this:

```clojure
{:aliases
 {:socket-rebl
  {:extra-deps {:git/url "https://github.com/seancorfield/socket-rebl"
                :sha "60b3ccc71bd6b9287565897f52e99dc77a10fd1a"}
   :jvm-opts ["-Dclojure.server.rebl={:port,50123,:accept,socket.rebl/repl}"]}}}

It assumes REBL is on your classpath.
