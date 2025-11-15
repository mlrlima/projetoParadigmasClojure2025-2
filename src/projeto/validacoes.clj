(ns projeto.validacoes
  (:require [clojure.string :as str])
  (:require [projeto.utils :as utils]))

;;funcoes:
;;
;validarPenultimoDigito[resto penultimo]
;validarUltimoDigito [resto ultimo]
;validarCpf[]
;;
;validarEmail[]
;;
;printarMenuValidacoes []
;menuValidacoes []

(defn validarPenultimoDigito [resto penultimo]
  (if (or
      ;se o resto for 1 ou 0, penultimo digito deve ser 0
       (and (< resto 2) (= penultimo 0))
      ;se o resto for >=2, penultimo digito deve ser 11-resto
       (and (> resto 1) (= penultimo (- 11 resto)))) true

      false))

(defn validarUltimoDigito [resto ultimo]
  (if (or
      ;se o resto for 1 ou 0, penultimo digito deve ser 0
       (and (< resto 2) (= ultimo 0))
      ;se o resto for >=2, penultimo digito deve ser 11-resto
       (and (> resto 1) (= ultimo (- 11 resto)))) true

      false))

(defn validarCpf []
  (utils/limparTerminal)
  (print utils/azul "\n\n===== Verificacao de CPF =====\n" utils/reset)
  (print utils/amarelo "\n\nDigite um CPF: " utils/reset)
  (flush)
  (let [userinput (read-line)

        ;pegar apenas os numeros da string
        digitos (str/replace userinput #"\D" "")]

    ;verificar se tem exatamente 11 numeros
    (if (= (count digitos) 11)

      ;https://www.mazzarello.com.br/noticias/entendendo-a-matematica-por-tras-do-cpf
      (loop [i 10 x 0 index 0]
          ;condicao de parada do loop
        (if (= i 1) (if (validarPenultimoDigito (rem x 11)
                                                (Integer/parseInt (str (get digitos 9)))) (loop [j 11 y 0 index2 0]
                                  ;condicao de parada do loop
                                                                                            (if (= j 1) (if (validarUltimoDigito (rem y 11)
                                                                                                                                 (Integer/parseInt (str (get digitos 10))))
                                                                                                          (do (print utils/verde "\nCPF valido\n" utils/reset) (utils/digite0ParaVoltar))

                                                                                                          (do (print utils/vermelho "\nCPF invalido: ultimo digito incorreto\n" utils/reset)
                                                                                                              (utils/digite0ParaVoltar)))

                                    ;somar e multiplicar os digitos para verificar o ultimo
                                                                                                (recur (- j 1) (+ y (* j (Integer/parseInt (str (get digitos index2))))) (+ index2 1)))) (do (print utils/vermelho "\nCPF invalido: penultimo digito incorreto\n" utils/reset)
                                                                                                                                                                                             (utils/digite0ParaVoltar)))

            ;somar e multiplicar os digitos para verificar o penultimo
            (recur (- i 1) (+ x (* i (Integer/parseInt (str (get digitos index))))) (+ index 1))))
      (do (print utils/vermelho "\nCPF invalido: nao contem exatamente 11 digitos\n" utils/reset)
          (utils/digite0ParaVoltar)))))

(defn validarEmail []
  (utils/limparTerminal)
  (print utils/azul "\n\n===== Verificacao de e-mail =====\n" utils/reset)
  (print utils/amarelo "\n\nDigite um e-mail: " utils/reset)
  (flush)
  (let [userinput (read-line)]
    ;verificacao simples
    ;letra.-Numero@letra.-Numero.letra
    (if (re-matches #"^[A-Za-z0-9.-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,}$" userinput)
      (print utils/verde "\nEmail valido\n" utils/reset)
      (print utils/vermelho "\nEmail invalido\n" utils/reset))
    (utils/digite0ParaVoltar)))

(defn printarMenuValidacoes []
  (utils/limparTerminal)
  (print utils/azul "\n\n===== Validacoes =====\n" utils/reset)
  (print "\n1- Verificacao de CPF")
  (print "\n2- Verificacao de e-mail")
  (print "\n0- Voltar"))

(defn menuValidacoes []
  (printarMenuValidacoes)

  (loop []
    (print utils/amarelo "\n\nEscolha sua opcao: " utils/reset)
    (flush)
    (let [userinput (read-line)]
      (cond
        ;cpf
        (= userinput "1") (do
                            (validarCpf)
                            (printarMenuValidacoes)
                            (recur))
        ;email
        (= userinput "2") (do
                            (validarEmail)
                            (printarMenuValidacoes)
                            (recur))
        ;exit 0
        (= userinput "0") ()
        :else (do
                (print utils/vermelho "\nEscolha um numero valido.\n" utils/reset)
                (recur))))))