(ns projeto.conversoes
  (:require [projeto.utils :as utils])
  )

;;funcoes:
;;
;realDolar []
;dolarReal []
;realEuro []
;euroReal []
;;
;printarMenuConversoes []
;menuConversoes []

;;;;;;;;

(defn realDolar []
  (utils/limparTerminal)
    (print utils/azul "\n\n===== Converter real para dolar =====\n" utils/reset)
    (print utils/amarelo "\nDigite o valor em reais: " utils/reset)

    (let [reais (utils/verificarInputDouble)]
      (print(format "\n R$ %.2f * 0.19 = US$ %.2f \n" reais (* reais 0.19))) 
      )
  
  (utils/digite0ParaVoltar)

  )

(defn dolarReal []
  (utils/limparTerminal)
  (print utils/azul "\n\n===== Converter dolar para real =====\n" utils/reset)
  (print utils/amarelo "\nDigite o valor em dolares: " utils/reset)

  (let [dolares (utils/verificarInputDouble)]
    (print (format "\n US$ %.2f * 5.29 = R$ %.2f \n" dolares (* dolares 5.29))))
  
  (utils/digite0ParaVoltar)
  
  )

(defn realEuro []
  (utils/limparTerminal)
  (print utils/azul "\n\n===== Converter real para euro =====\n" utils/reset)
  (print utils/amarelo "\nDigite o valor em reais: " utils/reset)

  (let [reais (utils/verificarInputDouble)]
    (print (format "\n R$ %.2f * 0.16 = € %.2f \n" reais (* reais 0.16))))
  
  (utils/digite0ParaVoltar)
  
  )

(defn euroReal []
  (utils/limparTerminal)
  (print utils/azul "\n\n===== Converter euro para real =====\n" utils/reset)
  (print utils/amarelo "\nDigite o valor em euros: " utils/reset)

  (let [euros (utils/verificarInputDouble)]
    (print (format "\n € %.2f * 6.13 = R$ %.2f \n" euros (* euros 6.13))))

  (utils/digite0ParaVoltar)
  
  )

;;;;;;;;

(defn printarMenuConversoes []
  (utils/limparTerminal)
  (print utils/azul "\n\n===== Conversoes monetarias =====\n" utils/reset)
  (print "\n1- Real para dolar")
  (print "\n2- Dolar para real")
  (print "\n3- Real para Euro")
  (print "\n4- Euro para Real")
  (print "\n0- Voltar"))

(defn menuConversoes []
    (printarMenuConversoes)

    (loop []
      (print utils/amarelo "\n\nEscolha sua opcao: " utils/reset)
      (flush)
      (let [userinput (read-line)]
        (cond
          ;r$ para us$
          (= userinput "1") (do
                              (realDolar)
                              (printarMenuConversoes)
                              (recur))
          ;us$ para r$
          (= userinput "2") (do
                              (dolarReal)
                              (printarMenuConversoes)
                              (recur))
          ;r$ para €
          (= userinput "3") (do
                              (realEuro)
                              (printarMenuConversoes)
                              (recur))
          ;€ para r$ 
          (= userinput "4") (do
                              (euroReal)
                              (printarMenuConversoes)
                              (recur))
          ;voltar
          (= userinput "0") ()
          :else (do
                  (print utils/vermelho "\nEscolha um numero valido.\n" utils/reset)
                  (recur))))))