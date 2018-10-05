P1 – ADS MANHÃ 4º CICLO
Felipe de Souza Shitinoe Santos

Resumo da experiência
Problemas econtrados no decorrer do desenvolvimento:
 - Não consegui ler corretamente os arquivos no começo pois os valores se misturavam (solução: split, getLines);
 - Não consegui gerenciar bem a comunicação entre os atores, ocasionando na perda de performance (ainda estou pesquisando sobre);

Proposta
O objetivo era ler as matrizes do primeiro (A) e do segundo arquivo(B), efetuar um cálculo (B * (A + Bt)), gerar um arquivo com os resultados e o número de resultados iguais, maiores e menores que zero. Eu pretendia fazer o programa o mais simples possível, eu ainda tenho dificuldades com o scala, então o plano era dividir cada uma das tarefas para um ator, sem subdividi-las.  As tarefas eram: 
 1 - Ler o arquivo A;
 2 - Ler o arquivo B;
 3 - Fazer a transposição do arquivo B;
 4 - Calcular o resultado de B * (A + Bt);
 5 - Separar resultados positivos, negativos e iguais a zero.
 
	Conforme o programa foi evoluindo, pensei na possibilidade de distribuir todas as etapas para apenas dois atores, procurando utilizar os dois 100% do tempo. Ficaria da seguinte forma:
 1 - EscravoA = Ler arquivo 1     /     EscravoB = Ler arquivo 2 e transposta do arquivo 2;
 2 - EscravoA = calcular arquivo 1 + Arquivo 2 transposto     /     EscravoB = Criar arquivo;
 3 - EscravoA = Ler arquivo 1     /     EscravoB = arquivo 1 * resultado de a1 + a2t;
 4 - EscravoA = Inserir resultados no arquivo     /     EscravoB = Contar quantos resultados positivos, negativos e 0.

Resultados
Os dois arquivos foram lidos porém o cálculo não foi executado.
