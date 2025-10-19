# Simulador de Estacionamento com Semáforos

## Descrição
Este projeto implementa um simulador de estacionamento usando semáforos em Java para demonstrar conceitos de sincronização e controle de concorrência em Sistemas Operacionais.

## 🚀 Executar

```bash
javac Main.java Carro.java Estacionamento.java
java Main
```
## 📝 Estrutura

- **Carro.java**: Thread que representa cada veículo
- **Estacionamento.java**: Gerencia vagas usando `Semaphore`
- **Main.java**: Inicia a simulação

## 🔧 Conceitos

- Programação concorrente com Threads
- Controle de acesso com Semáforos (FIFO)
- Sincronização de recursos compartilhados
- Cada carro permanece estacionado de 2-5 segundos


## 📚 Requisitos

- Java JDK 8 ou superior
