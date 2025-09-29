// Aktiver strict-mode
"use strict"; // Tryggere JS, plukker opp feildeklarerte variabler.

//****************************
// Pokémon creation
//****************************
class Pokemon{
    constructor(name, stats, moves){
        this.name = name;
        
        this.hp = stats.hp;
        this.attack = stats.attack;
        this.defense = stats.defense;
        this.speed = stats.speed;
        // Legg til power stat

        this.moves = moves;
    }

    isAlive(){
        return this.hp > 0;
    }
}

const pikachu = new Pokemon("Pikachu", 
    { hp: 40, attack: 12, defense: 12, speed: 14 }, 
    [{name: "Tackle", power: 1 }, { name: "Thunder", power: 2}, { name: "Thunderbolt", power: 2}]);
const bulbasaur = new Pokemon("Bulbasaur", 
    { hp: 60, attack: 9, defense: 16, speed: 10 },
    [{name: "Vine Whipe", power: 1 }, { name: "Solar Beam", power: 2}]);

//****************************
// Functions
//****************************
function calculateDamage(attacker, defender, move){
    // Legg til inflytelse fra power-stat og en grad av tilfeldighet.
    let pokemonAttack = Math.floor((attacker.attack) + (move.power * Math.random() * 4));
    let pokemonDefense = Math.floor(defender.defense / 3);

    return Math.max(1, pokemonAttack - pokemonDefense);
}

function log(msg){
    document.getElementById("battle-log").textContent += msg + "\n";
}

function renderHP(pokemon){
    let hp = "|".repeat(Math.ceil(pokemon.hp / 10));
    return pokemon.name + " HP: "  + hp + " (" + pokemon.hp + ")";
}

// Skriv en funksjon som utfører en runde av kampen.
function performTurn(pokemon1, pokemon2, move){
    let damage = calculateDamage(pokemon1, pokemon2, move);
    pokemon2.hp -= damage;
    
    log(pokemon1.name + " used " + move.name + "!\n" +
    pokemon2.name + " took " + damage + " damage.\n")

    if (pokemon2.hp <= 0){
        log(pokemon2.name + " fainted!");
        return true;
    }
    else{
        return false;
    }
}

// Skriv en funksjon som avslutter kampen.
function endBattle(){
    log("Battle over!");

}

// Skriv en funksjon som lager en knapp for hvert angrep spillerens pokémon har.
function createMoveButtons(pokemon, onMoveChosen){
    const container = document.getElementById("move-buttons");

    pokemon.moves.forEach(move => {
        let button = document.createElement("button");
        button.textContent = move.name;
        button.addEventListener("click", () => onMoveChosen(move));
        container.appendChild(button);
    });
}

// Skriv en funksjon som setter i gang kampen.
function startBattle(playerPokemon, opponentPokemon){
    document.getElementById("start-btn").disabled = true;
    log(`Battle start: ${playerPokemon.name} vs ${opponentPokemon.name}`);
    log(renderHP(playerPokemon));
    log(renderHP(opponentPokemon));

    createMoveButtons(playerPokemon, (chosenMove) => {
        if(!playerPokemon.isAlive() || !opponentPokemon.isAlive()) return;

        // Player turn
        if(performTurn(playerPokemon, opponentPokemon, chosenMove)){
            endBattle();
            return;
        }

        // Opponent turn
        let opponentMove = opponentPokemon.moves[Math.floor(Math.random() * opponentPokemon.moves.length)];
        if(performTurn(opponentPokemon, playerPokemon, opponentMove)){
            endBattle();
            return;
        }

        log("--- Next round ---\n")
    });
}


//****************************
// Button handling
//****************************
document.getElementById("start-btn").addEventListener("click", () => {
    //document.getElementById("move-")

    startBattle(pikachu, bulbasaur);
})

// Legg bindinger til knappene.
