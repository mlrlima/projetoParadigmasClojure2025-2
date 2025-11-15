(ns projeto.validacoes
  (:require [projeto.utils :as utils]))

;;funcoes:
;;
;validarEmail[]
;;
;printarMenuValidacoes []
;menuValidacoes []


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
                            ;(validarCpf)
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