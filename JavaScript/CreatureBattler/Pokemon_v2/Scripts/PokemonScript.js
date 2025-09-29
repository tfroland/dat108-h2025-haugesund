// Aktiver strict-mode
// ???

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
        // ???

        this.move1 = moves.move1;
        this.move2 = moves.move2;
    }

    isAlive(){
        return this.hp > 0;
    }
}

const pikachu = new Pokemon("Pikachu", { hp: 40, attack: 12, defense: 12, speed: 14 }, {move1: "Tackle", move2: "Thunder"});
const bulbasaur = new Pokemon("Bulbasaur", { hp: 60, attack: 9, defense: 16, speed: 10 }, {move1: "Vine Whipe", move2: "Solar Beam"});

//****************************
// Functions
//****************************
function calculateDamage(attacker, defender){
    // Legg til inflytelse fra power-stat
    // ???
    let base = Math.floor(attacker.attack) - Math.floor(defender.defense / 3);
    return Math.max(1, base);
}

function log(msg){
    document.getElementById("battle-log").textContent += msg + "\n";
}

function renderHP(pokemon){
    let hp = "|".repeat(Math.ceil(pokemon.hp / 10));
    return pokemon.name + " HP: "  + hp + " (" + pokemon.hp + ")";
}

// Skriv en funksjon som utfører en runde av kampen.
// ???

// Skriv en funksjon som avslutter kampen.
// ???

// Skriv en funksjon som lager en knapp for hvert angrep spillerens pokémon har.
// ???

// Skriv en funksjon som setter i gang kampen.
// ???

//****************************
// Battle loop
//****************************
let roundCounter = 1;

while (pikachu.hp > 0 && bulbasaur.hp > 0){
    log("Round " + roundCounter);
    roundCounter += 1;

    let pokemon1;
    let pokemon2;
    if (pikachu.speed > bulbasaur.speed){
        pokemon1 = pikachu;
        pokemon2 = bulbasaur;
    }
    else{
        pokemon1 = bulbasaur;
        pokemon2 = pikachu; 
    }

    // Refaktorer koden inn i en egen funksjon for å unngå repetering av kode.
    let damage = calculateDamage(pokemon1, pokemon2);
    pokemon2.hp -= damage;
    log(pokemon1.name + " used " + pokemon1.move1 + "!\n" +
    pokemon2.name + " took " + damage + " damage.\n")
    if (pokemon2.hp <= 0){
        log(pokemon2.name + " fainted!");
        break;
    }
    
    damage = calculateDamage(pokemon2, pokemon1);
    pokemon1.hp -= damage;
    log(pokemon2.name + " used " + pokemon2.move1 + "!\n" +
    pokemon1.name + " took " + damage + " damage.\n")
    if (pokemon1.hp <= 0){
        log(pokemon1.name + " fainted!");
        break;
    }


    log(renderHP(pokemon1));
    log(renderHP(pokemon2));
    log("********\n\n")


//****************************
// Button handling
//****************************

// Legg bindinger til knappene.
}