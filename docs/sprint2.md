# Sprint Planning 2
**Periodo:** 12/02/2026 – 22/02/2026  

**Backlog:**  

| ID | Priorità | Task | ISE |
|----|----------|------|----------------------|
| 1  | Alta    | Modellazione utente | 3 |
| 2  | Alta    | Autenticazione utente | 2 |
| 3  | Alta    | Registrazione utente | 1 |
| 4  | Alta    | Eliminazione utente | 1 |
| 5  | Alta    | Modifica utente | 1 |
| 6  | Alta    | Interfaccia grafica utente (Registrazione) | 4 |
| 7  | Alta    | Interfaccia grafica utente (Login) | 4 |
| 8  | Alta    | Interfaccia grafica utente (Modifica ed eliminazione) | 4 |
| 9  | Alta    | Sistema persistenza utenti | 4 |
| 10 | Alta    | Modellazione Quiz a risposta multipla | 3 |
| 11 | Alta    | Modellazione Quiz "Fill-in-the-blank" | 3 |
| 12 | Alta    | Interfaccia grafica interazione Utente-Quiz | 6 |
| 13 | Media   | Valutazione risposte | 8 |
| 14 | Media   | Sistema persistenza Quiz | 4 |
| 15 | Media   | Modellazione Level | 3 |
| 16 | Media   | Sistema persistenza Level | 4 |
| 17 | Media   | Interfaccia grafica percorso didattico | 4 |
| 18 | Media   | Sistema persistenza progressi Utente | 6 |
| 19 | Media   | Testing logica applicativa | 8 |
| 20 | Media   | Dashboard progressi utente | 5 |
| 21 | Media   | Contenuti teorici livelli | 5 |
| 22 | Media   | Contenuti Quiz Domande e Risposte | 5 |
| 23 | Bassa   | Rifinitura UX | 5 |
| 24 | Bassa   | Modalità Survival | 15 |
| 25 | Bassa   | Playground Prolog | 20 |

---

## Sprint Goal
Completare l’interfaccia di registrazione, introdurre la persistenza locale per gli utenti e abilitare il cambio scene dinamico. Preparare il terreno per l’inserimento dei primi quiz.

---

## Deadline
La scadenza dello sprint è il **22/02/2026**.

---

## Task completati nello Sprint

### Interfaccia
**Pagina Registrazione** — sviluppo e integrazione della schermata di registrazione con le stesse regole stilistiche della login.

**Scene switching** — meccanismo funzionale per passare da una scena all'altra (login ➜ registrazione ➜ dashboard).

### Persistenza
**Storage utenti** — introduzione di un file/DB locale per salvare gli oggetti `User` creati e letti dal CRUD.

### Logica utente
**Validazione** — controllo dei campi durante la registrazione e modifica con messaggi di errore visibili.

### Quality Assurance
**Test persistenti** — estensione della suite di unit test per verificare le operazioni CRUD atte alla persistenza.

---

## Sprint Review

### Progresso
Le funzionalità di base dell’utente ora conservano i dati tra le sessioni e l’esperienza GUI è navigabile.

### Architettura
Nessuna modifica sostanziale, ma il package `persistence` è stato aggiunto con le classi di salvataggio.

### Utente
Registrazione e login sono operativi con validazione e salvataggio; resta da sviluppare la pagina di modifica/eliminazione.

### Qualità
I test sono passati e l’infrastruttura per testare la persistenza è stabile.

---

## Sprint Retrospective

### Cosa è andato bene
- Persistenza semplice e veloce da introdurre grazie alla struttura MVC chiara.
- Scene switching è risultato molto utile per prototipare percorsi utente.

### Difficoltà incontrate
- Gestione degli errori di I/O (file corrotto, permessi) ha richiesto più tempo del previsto.
- La validazione lato client ha rivelato casi limite non previsti inizialmente.

---

## Miglioramenti previsti per Sprint 3
- Completare CRUD utente (modifica/eliminazione interface e storage).
- Iniziare la modellazione dei quiz (risposta multipla e fill-in-the-blank).
- Progettare interfaccia grafica per l’interazione Utente‑Quiz.
