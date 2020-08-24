(ns socket.rebl
  "Provide a Socket REPL accept function that automatically submits
  every form and result to REBL itself.
  
  :aliases
  {:socket 
   {:jvm-opts 
    [\"-Dclojure.server.rebl={:port,50123,:accept,socket.rebl/repl}\"]}}"
  (:require [clojure.core.server :as s]
            [clojure.main :as m]
            [cognitect.rebl :as rebl]))

(defn- submit-eval [form]
  (let [value (eval form)]
    (rebl/submit form value)
    value))

(defn repl
  "Like clojure.core.server/repl but also submits forms to REBL"
  []
  (m/repl :init s/repl-init :read s/repl-read :eval submit-eval))
