(ns projeto.estatisticas
  (:require [projeto.utils :as utils])
  )

;;funcoes:
;;
;validarTamVec[]
;preencherVetor []
;printarVetor [v]
;;
;valorMaximo [v]
;valorMinimo[v]
;media[v]
;mediana [v]
;;
;printarEstatisticaMenu[]
;estatisticasMain []



(def maxSizeVec 100)

(defn validarTamVec[]
  (loop []
    (flush)
    (let [userInput (utils/verificarInputInt)]
      (if (and(<= userInput maxSizeVec)(> userInput 0)) userInput
          (do
            (print utils/vermelho "\nDigite um numero valido.\n" utils/reset)
            (recur)
          )
      )
    )
  )
  )

(defn preencherVetor []

  (utils/limparTerminal)
  (print utils/azul "\n\n===== Novo vetor =====\n" utils/reset)
  (print utils/amarelo "\nInforme o tamanho do vetor: " utils/reset)
  (print "\nObs: tamanho maximo de " maxSizeVec "\n")

  (let [tamVet (validarTamVec)]
  (loop [i tamVet v []]
    (print utils/amarelo "\nDigite o numero #"(- tamVet i)": " utils/reset)
    (flush)
    (if (zero? i)
      v (let [n (utils/verificarInputDouble)]
          (recur (- i 1) (conj v n)))))
  )

)

(defn valorMaximo [v]
  (utils/limparTerminal)
  (print utils/azul "\n\n===== Valor maximo =====\n" utils/reset)
  (print "\n" (last v) "\n")

  (utils/digite0ParaVoltar))

(defn valorMinimo[v]
  (utils/limparTerminal)
  (print utils/azul "\n\n===== Valor minimo =====\n" utils/reset)
  (print"\n" (first v) "\n")

  (utils/digite0ParaVoltar)
  )

(defn media[v]
  (utils/limparTerminal)
  (print utils/azul "\n\n===== Media do vetor =====\n" utils/reset)
  (if (empty? v)
     (print"\n0.0\n")
     (print"\n"(/ (reduce + v) (count v))"\n")
  )
  
  (utils/digite0ParaVoltar)
  )


(defn mediana [v]
  (utils/limparTerminal)
  (print utils/azul "\n\n===== Mediana do vetor =====\n" utils/reset)

  (if (= 0 (rem (count v) 2))   (print "\n" (/ (+ (nth v (quot (count v) 2))
                                                     (nth v (quot (- (count v) 1) 2))) 2)"\n")

                              (print "\n" (nth v (quot (count v) 2)) "\n")
  )


  (utils/digite0ParaVoltar)
)


(defn printarVetor [v]
  (utils/limparTerminal)
  (print utils/azul "\n\n===== Printar vetor =====\n" utils/reset)
  (print"\n" v "\n")

  (utils/digite0ParaVoltar)
  )

;;;;;;;;;;;;

(defn printarEstatisticaMenu[]
  (utils/limparTerminal)
  (print utils/azul "\n\n===== Estatisticas =====\n" utils/reset)
  (print "\n1- Novo vetor")
  (print "\n2- Printar vetor original")
  (print "\n3- Printar vetor ordenado")
  (print "\n4- Media")
  (print "\n5- Mediana")
  (print "\n6- Valor minimo")
  (print "\n7- Valor maximo")
  (print "\n0- Voltar")
  )


(defn estatisticasMain []

  (let [vetor (preencherVetor)
    vetorOrdenado (sort vetor)]

    (printarEstatisticaMenu)
  (loop []
    (print utils/amarelo "\n\nEscolha sua opcao: " utils/reset)
    (flush)
    (let [userinput (read-line)]
      (cond
            ;novo vetor
        (= userinput "1") ()
            ;printar vetor original
        (= userinput "2") (do
                            (printarVetor vetor)
                            (printarEstatisticaMenu)
                            (recur))
        ;printar vetor ordenado
        (= userinput "3") (do
                            (printarVetor vetorOrdenado)
                            (printarEstatisticaMenu)
                            (recur))
        ;media
        (= userinput "4") (do
                            (media vetor)
                            (printarEstatisticaMenu)
                            (recur))
        ;mediana
        (= userinput "5") (do
                            (mediana vetorOrdenado)
                            (printarEstatisticaMenu)
                            (recur))
        ;valor minimo
        (= userinput "6") (do
                            (valorMinimo vetorOrdenado)
                            (printarEstatisticaMenu)
                            (recur))
        ;valor maximo
        (= userinput "7") (do
                            (valorMaximo vetorOrdenado)
                            (printarEstatisticaMenu)
                            (recur))
            ;voltar
        (= userinput "0") ()
        :else (do
                (print utils/vermelho "\nEscolha um numero valido.\n" utils/reset)
                (recur))))))
  
)

