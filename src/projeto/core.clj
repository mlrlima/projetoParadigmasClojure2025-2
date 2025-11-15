;namespace
(ns projeto.core
  (:require [projeto.utils :as utils])
  (:require [projeto.conversoes :as conversoes])
  (:require [projeto.estatisticas :as estatisticas])
  (:require [projeto.validacoes :as validacoes])
  )


;;funcoes:
;;
;informacoes []
;;
;printarMenuInicial []
;menuInicial []
;;
;-main []

(defn informacoes []
  (utils/limparTerminal)
  (print utils/azul "\n\n===== Informacoes do projeto =====\n" utils/reset)
  (print"\nProjeto desenvolvido para a disciplina de")
  (print"\nParadigmas de Linguagens de Programacao")
  (print"\nem 2025.2")
  (print"\nna Universidade Catolica de Pernambuco (UNICAP)\n")

  (print "\nGrupo:")
  (print "\nJulia Souto\nGabriel Martins\nGabriela Lemos\nMaria Luiza Ribeiro\nMatheus Verissmo\nRoberto Regis\n")

  (utils/digite0ParaVoltar)

  )

(defn printarMenuInicial []
  (utils/limparTerminal)
  (print utils/azul "\n\n===== Funcionalidades =====\n" utils/reset)
  (print "\n1- Conversoes monetarias")
  (print "\n2- Estatisticas")
  (print "\n3- Validacoes")
  (print "\n4- Informacoes do projeto")
  (print "\n0- Terminar programa")
  )

(defn menuInicial [] 
  (printarMenuInicial)

  (loop []
    (print utils/amarelo "\n\nEscolha sua opcao: " utils/reset)
    (flush)
    (let [userinput (read-line)]
      (cond
        ;conversoes
        (= userinput "1") (do
                            (conversoes/menuConversoes)
                            (printarMenuInicial)
                            (recur))
        ;estatisticas
        (= userinput "2")(do
                           (estatisticas/estatisticasMain)
                           (printarMenuInicial)
                           (recur))
        ;validacao
        (= userinput "3")(do
                           (validacoes/menuValidacoes)
                           (printarMenuInicial)
                           (recur))
        ;infos
        (= userinput "4") (do
                            (informacoes)
                            (printarMenuInicial)
                            (recur))
        ;exit 0
        (= userinput "0") (do
                            (print "\nTerminando programa\n")
                            (flush)
                            (System/exit 0)
                            (recur))
        :else (do 
                (print utils/vermelho "\nEscolha um numero valido.\n" utils/reset) 
                (recur))
        )
      )
    )
  )

(defn -main []
  (print utils/azul "\n\n===== Projeto: Paradigmas do Sucesso =====\n" utils/reset)

  (menuInicial))
