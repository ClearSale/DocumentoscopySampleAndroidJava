Amostra de aplicativo de Captura de Documentos (Android Java)
===============================

Este é um exemplo de aplicativo Android que usa a tecnologia de Captura de Documentos da Clearsale.

##  Construindo o aplicativo de exemplo

Primeiro, clone o repositório:

`git clone https://github.com/ClearSale/DocumentoscopySampleAndroidJava.git`

Construir a amostra depende de suas ferramentas de construção.

###  Android Studio (recomendado)

(Estas instruções foram testadas com o Android Studio versão Giraffe | 2022.3.1 Patch 3)

* Abra o Android Studio e selecione `File->Open...`
* Selecione o diretório do aplicativo de exemplo
* Clique em 'OK' para abrir o projeto no Android Studio.
* Uma sincronização do Gradle deve começar, aguarde até que ela termine.

##  Executando o aplicativo de exemplo

*Conecte um dispositivo Android à sua máquina de desenvolvimento.
* Preencha as variáveis das linhas 24 a 27 no arquivo `gradle.properties` com os valores enviados pela ClearSale
* Coloque a versão do documentoscopy-sdk de sua preferencia nas dependencias do arquivo `build.gradle` do Módulo
* Preencha as variáveis abaixo no arquivo MainActivity.java:
* linha 32: `clientId` - identifica o client junto a ClearSale, este valor é fornecido pela ClearSale.
* linha 33: `clientSecret` - token de autenticação do cliente, este valor é fornecido pela ClearSale.
* linha 34: `identifierId` - string de até 100 caracteres OBRIGATÓRIA que identifica todo o fluxo do usuário de forma única.
* linha 36: `cpf` - (opcional) CPF do usuário.

Para mais informações, consulte nossa documentação.

* Sincronize e Build o projeto

###  Android Studio

* Selecione `Run -> Run app'` (ou `Debug 'app'` ) na barra de menus
* Selecione o dispositivo no qual deseja executar o aplicativo e clique em 'OK'

##  Usando o aplicativo de amostra

Ao pressionar o botão "INICIAR DOCS" o SDK de Captura de Documentos iniciará, após completar o fluxo o aplicativo retornará o resultado na parte inferior da tela, sendo o SessionId e Tipo de documento em caso de sucesso ou o erro em caso de falha.
