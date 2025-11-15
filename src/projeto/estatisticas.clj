(ns projeto.estatisticas
  (:require [projeto.utils :as utils]))

;;funcoes:
;;
;validarTamVec[]
;preencherVetor []
;printarVetor [v]
;;



(def maxSizeVec 100)

(defn validarTamVec []
  (loop []
    (flush)
    (let [userInput (utils/verificarInputInt)]
      (if (and (<= userInput maxSizeVec) (> userInput 0)) userInput
          (do
            (print utils/vermelho "\nDigite um numero valido.\n" utils/reset)
            (recur))))))

(defn preencherVetor []

  (utils/limparTerminal)
  (print utils/azul "\n\n===== Novo vetor =====\n" utils/reset)
  (print utils/amarelo "\nInforme o tamanho do vetor: " utils/reset)
  (print "\nObs: tamanho maximo de " maxSizeVec "\n")

  (let [tamVet (validarTamVec)]
    (loop [i tamVet v []]
      (print utils/amarelo "\nDigite o numero #" (- tamVet i) ": " utils/reset)
      (flush)
      (if (zero? i)
        v (let [n (utils/verificarInputDouble)]
            (recur (- i 1) (conj v n)))))))

(defn printarVetor [v]
  (utils/limparTerminal)
  (print utils/azul "\n\n===== Printar vetor =====\n" utils/reset)
  (print "\n" v "\n")

  (utils/digite0ParaVoltar))