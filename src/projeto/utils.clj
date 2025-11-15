(ns projeto.utils)

(ns projeto.utils)

;;funcoes & variaveis:
;;
;vermelho
;verde
;amarelo
;azul
;reset
;;
;limparTerminal []
;;
;digite0ParaVoltar []

(def vermelho "\u001b[31m")
(def verde "\u001b[32m")
(def amarelo "\u001b[33m")
(def azul "\u001b[34m")
(def reset "\u001b[0m")

(defn limparTerminal []
  (print (str (char 27) "[2J")) ; clear screen
  (print (str (char 27) "[;H")) ; move cursor to the top left corner of the screen
  )

(defn digite0ParaVoltar []

  (loop []
    (print amarelo "\nDigite '0' para voltar\n" reset)
    (flush)
    (let [userinput (read-line)]
      (cond
        (= userinput "0") ()
        :else (recur)))))
