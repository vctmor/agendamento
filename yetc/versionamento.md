Para realizar o que você deseja, você pode usar o Git para gerenciar as versões do seu projeto. Vou te guiar pelos passos:

1. Criação do Repositório e Versão 1
Inicialize um repositório Git:

Sh

Copiar
git init
Adicione os arquivos ao repositório:

Sh

Copiar
git add .
Faça o commit inicial:

Sh

Copiar
git commit -m "Initial commit - Version 1"
Crie um repositório remoto no GitHub (ou outra plataforma de sua preferência) e copie a URL do repositório. Depois, adicione o repositório remoto:

Sh

Copiar
git remote add origin <URL_do_repositorio>
Faça o push do commit inicial:

Sh

Copiar
git push -u origin master
Marque a versão 1.0:

Sh

Copiar
git tag -a v1.0 -m "Version 1.0"
git push origin v1.0
2. Iniciando a Versão 2
Crie uma nova branch para a versão 2:

Sh

Copiar
git checkout -b version-2
Desenvolva as mudanças para a versão 2: Trabalhe normalmente na branch version-2. As mudanças que você fizer aqui não afetarão a branch principal master.

Faça commit das mudanças:

Sh

Copiar
git add .
git commit -m "Start of Version 2 development"
Faça o push da branch version-2 para o repositório remoto:

Sh

Copiar
git push origin version-2