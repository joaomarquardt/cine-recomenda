# 🎬 CineRecomenda - Sistema de Recomendação de Filmes

Sistema full-stack de recomendação personalizada de filmes usando Spring Boot, React e APIs do TMDB.

## 🚀 Tecnologias

**Backend:** Java, Spring Boot, Maven, Docker  
**Frontend:** React, TypeScript, Vite 
**APIs:** TMDB, Movie 
**Deploy:** Render (Backend) + Vercel (Frontend)

## ✨ Funcionalidades

- 🎲 Recomendação surpresa (filme único)
- 🍿 Coleção completa com paginação
- 🔍 Filtros avançados: gêneros, ano, rating, duração, idioma
- 📱 Design responsivo e tratamento de erros
- 🎬 Modal com detalhes completos do filme

## 📦 Pré-requisitos

- Java 21+
- Node.js 18+
- Maven 3.9+
- Conta TMDB ([criar aqui](https://www.themoviedb.org/signup))

## ⚙️ Instalação e Configuração

### 1. Clone o repositório

```
git clone https://github.com/joaomarquardt/cine-recomenda.git
cd movie-recommendation
```


### 2. Configurar Backend

Crie e edite `src/main/resources/application.properties`:
```
CORS_ALLOWED_ORIGINS=<SUA URL DO FRONTEND>
TMDB_API_URL=https://api.themoviedb.org/3/
TMDB_API_TOKEN=<SEU TOKEN DA API TMDB>
TMDB_FILTER_VOTE_COUNT_MIN=<NÚMERO MÍNIMO DE REVIEWS DO FILME PARA SER RECOMENDADO>
TMDB_FILTER_VOTE_AVERAGE_MIN=<NOTA MÉDIA MÍNIMA DO FILME PARA SER RECOMENDADO>
```

**Obter chave TMDB:**
1. Acesse https://www.themoviedb.org/settings/api
2. Crie uma conta gratuita
3. Vá em Settings → API
4. Gere uma API Key (v3 auth)
5. Cole no application.properties

Execute o backend:

```
./mvnw spring-boot:run
```

API disponível em: `http://localhost:8080`

### 3. Configurar Frontend
```
cd frontend
npm install
```

Execute o frontend:
```
npm run dev
```

Aplicação disponível em: `http://localhost:5173`

#### Se este projeto te agradou, considere dar uma estrela!
