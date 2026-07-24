# 📈 Simulador de Fundos Imobiliários (FIIs)

Uma aplicação desenvolvida em **Java** para simular investimentos em Fundos de Investimento Imobiliário (FIIs), permitindo calcular a evolução do patrimônio por meio de aportes, reinvestimento de dividendos e crescimento anual dos ativos.

Este projeto foi desenvolvido com foco na aplicação de conceitos de **Programação Orientada a Objetos (POO)**, organização de código e simulação financeira.

---

## 🚀 Funcionalidades

- Cadastro de um ou mais fundos imobiliários.
- Compra automática de cotas com base no aporte inicial.
- Reinvestimento automático dos dividendos.
- Aportes mensais opcionais.
- Crescimento anual configurável do preço da cota e dos dividendos.
- Controle do saldo restante ("troco") para futuras compras de cotas.
- Simulação por qualquer período em meses.
- Relatório final com patrimônio, cotas, renda mensal e valor investido.

---

## 🛠 Tecnologias Utilizadas

- Java
- Programação Orientada a Objetos (POO)
- IntelliJ IDEA
- Git
- GitHub

---

## 📂 Estrutura do Projeto

```
SimuladorFII
│
├── Main.java
├── FundoImobiliario.java
├── Simulador.java
├── EntradaSaida.java
└── README.md
```

---

## 🏗 Arquitetura

O projeto foi dividido em responsabilidades para facilitar manutenção e reutilização do código.

### 📌 Main

Classe responsável por iniciar a aplicação, configurar o ambiente e conectar todos os componentes.

### 📌 FundoImobiliario

Representa um fundo imobiliário.

Responsável por:

- armazenar os dados do investimento;
- calcular compra de cotas;
- reinvestir dividendos;
- controlar patrimônio;
- aplicar crescimento anual.

### 📌 Simulador

Executa toda a lógica da simulação mês a mês.

### 📌 EntradaSaida

Responsável pela comunicação com o usuário através do terminal.

---

## ▶️ Como Executar

### Pré-requisitos

- Java JDK 17 ou superior
- IntelliJ IDEA

### Passos

1. Clone este repositório.

```
git clone https://github.com/SEU-USUARIO/SEU-REPOSITORIO.git
```

2. Abra o projeto no IntelliJ IDEA.

3. Execute a classe **Main.java**.

4. Informe os dados solicitados no terminal.

---

## 💻 Exemplo de Execução

```
Quantos fundos imobiliários você quer simular?
1

Nome do fundo:
MXRF11

Preço da cota:
10.15

Quanto pretende investir:
1000

Quer investir esse mesmo valor todo mês?
S

Dividendo pago por cota:
0.10

Taxa de crescimento anual:
5

Prazo da simulação:
24
```

### Resultado

```
=============================== RESULTADO DA SIMULAÇÃO ===============================

Fundo      Aporte   Prazo   Cotas    Investido      Renda mensal    Patrimônio

MXRF11     Mensal   24m     254      R$ 25000.00    R$ 26.67        R$ 27182.35

======================================================================================
```

---

## 📚 Conceitos Aplicados

- Programação Orientada a Objetos (POO)
- Encapsulamento
- Construtores
- Métodos
- Coleções (`ArrayList`)
- Estruturas de repetição
- Estruturas condicionais
- Separação de responsabilidades
- Simulação computacional

---

## 🔮 Melhorias Futuras

- Interface gráfica (JavaFX ou Swing).
- Histórico das simulações.
- Exportação dos resultados para PDF ou Excel.
- Persistência dos dados em banco de dados.
- Gráficos de evolução do patrimônio.
- Comparação entre diferentes FIIs.
- Validação avançada das entradas do usuário.

---

## 👨‍💻 Autor

**Guilherme Cavalcanti**

Desenvolvedor em formação aprendendo **Java**, **Python** e **C++**.

Este projeto faz parte do meu portfólio e demonstra conhecimentos em modelagem orientada a objetos, organização de código e desenvolvimento de aplicações Java.

---

## 📄 Licença

Este projeto está disponível para fins de estudo e aprendizado.