//configuração do banco e da collection

use vem_ser

db.createCollection("pokemon")
db.createCollection("mochila")

//---- Insert One
db.pokemon.insertOne(
	{
	  "mochila_id": 1,
	  "racaPokemon": "Chadzard",
	  "peso": 910.78,
	  "sexo": "MASCULINO",
	  "level": 100,
	  "dificuldade": "DIFICIL",
	  "tipos": [{"tipo1":"FIRE"},{"tipo2":"DRAGON"}],
	  "raridade": "SUPER_RARO"
	}
)

db.mochila.insertMany(
[
	{
	  "_id": 1,
	  "quantidadePokeball": 0,
	  "quantidadeGreatball": 0,
	  "quantidadeMasterball": 0,
	  "quantidadeHeavyball": 0,
	  "quantidadeNetball": 0,
	},
	{
	  "_id": 2,
	  "quantidadePokeball": 10,
	  "quantidadeGreatball": 0,
	  "quantidadeMasterball": 10,
	  "quantidadeHeavyball": 0,
	  "quantidadeNetball": 10,
	},
	{
	  "_id": 3,
	  "quantidadePokeball": 99,
	  "quantidadeGreatball": 99,
	  "quantidadeMasterball": 99,
	  "quantidadeHeavyball": 99,
	  "quantidadeNetball": 99,
	}
])

db.pokemon.insertMany(
[
	{
	  "mochila_id": 1,
	  "racaPokemon": "Bulbasaur",
	  "peso": 7.07,
	  "sexo": "MASCULINO",
	  "level": 5,
	  "dificuldade": "FACIL",
	  "tipos": [{"tipo1":"GRASS"},{"tipo2":"POISON"}],
	  "raridade": "COMUM"
	},
	{
	  "mochila_id": 1,
	  "racaPokemon": "Ivysaur",
	  "peso": 17.56,
	  "sexo": "MASCULINO",
	  "level": 16,
	  "dificuldade": "MEDIO",
	  "tipos": [{"tipo1":"GRASS"},{"tipo2":"POISON"}],
	  "raridade": "RARO"
	},
	{
	  "mochila_id": 1,
	  "racaPokemon": "Wartortle",
	  "peso": 25.56,
	  "sexo": "MASCULINO",
	  "level": 16,
	  "dificuldade": "MEDIO",
	  "tipos": [{"tipo1":"WATER"},{"tipo2":null}],
	  "raridade": "RARO"
	},
	{
	  "mochila_id": 2,
	  "racaPokemon": "Blastoise",
	  "peso": 93.94,
	  "sexo": "MASCULINO",
	  "level": 36,
	  "dificuldade": "DIFICIL",
	  "tipos": [{"tipo1":"WATER"},{"tipo2":null}],
	  "raridade": "SUPER_RARO"
	},
	{
	  "mochila_id": 2,
	  "racaPokemon": "Charmander",
	  "peso": 8.76,
	  "sexo": "FEMININO",
	  "level": 10,
	  "dificuldade": "FACIL",
	  "tipos": [{"tipo1":"FIRE"},{"tipo2":null}],
	  "raridade": "COMUM"
	},
	{
	  "mochila_id": 2,
	  "racaPokemon": "Graveler",
	  "peso": 115.24,
	  "sexo": "FEMININO",
	  "level": 16,
	  "dificuldade": "MEDIO",
	  "tipos": [{"tipo1":"ROCK"},{"tipo2":"GROUND"}],
	  "raridade": "RARO"
	},
	{
	  "mochila_id": 3,
	  "racaPokemon": "Charizard",
	  "peso": 91.26,
	  "sexo": "MASCULINO",
	  "level": 36,
	  "dificuldade": "DIFICIL",
	  "tipos": [{"tipo1":"FIRE"},{"tipo2":"DRAGON"}],
	  "raridade": "SUPER_RARO"
	}
]
)

//---- Delete
db.pokemon.deleteMany({"level": {$lte:10}})

db.mochila.deleteOne({"quantidadePokeball": 99,
	  "quantidadeGreatball": 99,
	  "quantidadeMasterball": 99,
	  "quantidadeHeavyball": 99,
	  "quantidadeNetball": 99,})

//---- Find Equal
db.pokemon.find({"racaPokemon": "Blastoise"})

db.mochila.find({"quantidadeMasterball":99})

//---- Find AND
db.pokemon.find(
	{"sexo":"MASCULINO",
	"level": {$gte: 50}}
)

db.mochila.find(
	{"quantidadePokeball": {$gte:10},
	"quantidadeMasterball": {$gte:10}}
)

//---- Find OR / IN
db.pokemon.find({$or:[
	{"sexo":"FEMININO"},
	{"level": {$gte: 30}}
]}).sort({"level":1})

db.pokemon.find({"raridade":{$in:["SUPER_RARO", "RARO"]}})

db.mochila.find({"quantidadeMasterball": {$in: [0,10]}})

//---- Find Expressão
db.pokemon.find({"racaPokemon": /^Cha.*d$/})

db.pokemon.find({"raridade": /RARO$/})

//---- Find Campos aninhados
db.pokemon.find({"tipos.tipo1":"GRASS"})
db.pokemon.find({"tipos.tipo2":null})
//---- Update
db.pokemon.updateMany({"level":{$lt: 100}},{
	$inc: {"level":1}
})

db.mochila.updateOne({_id:1, "quantidadePokeball":{$gt:0}},{
	$inc: {"quantidadePokeball":-1}
})

