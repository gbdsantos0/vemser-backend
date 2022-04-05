//configuração do banco e da collection

use vem_ser

db.createCollection("pokemon")
db.createCollection("mochila")


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

//---- Insert Many
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

//---- Find Ordenado
db.pokemon.find(
	{"sexo":"FEMININO"}
).sort({"level":1})

db.mochila.find({}).sort({"quantidadeMasterball":-1})

//---- Find Limite
db.pokemon.find({$or:[
	{"sexo":"FEMININO"},
	{"level": {$gte: 30}}
]}).sort({"level":1}).limit(2)

//---- Find Array
db.createCollection("arraysCollection")

db.arraysCollection.insertMany([
	{"vetorzinho":[110,112]},
	{"vetorzinho":[1,1,146,1,1]},
	{"vetorzinho":[1,2,3]}
])

db.arraysCollection.find({"vetorzinho": {$gt:100}})

db.arraysCollection.find({"vetorzinho": {$lte:3}})

//-- produtos
// Na ordem exata
db.arraysCollection.find({"vetorzinho":[1,2,3]})
// Contém
db.arraysCollection.find({"vetorzinho":1})
// Condição múltipla, no array todo
db.arraysCollection.find({"vetorzinho":{$gte:3, $lte:110}})
// Condição múltipla, no mesmo elemento do array 
db.arraysCollection.find({"vetorzinho":{$elemMatch: {$gte:3, $lte:110}}})
// Usando índice do array, segundo elem > 25
db.arraysCollection.find({"vetorzinho.0":{$lte:1}})
// Tamanho
db.arraysCollection.find({"vetorzinho":{$size: 2}})

//---- Projections
db.pokemon.find({},{_id:1, "racaPokemon":1, "tipos.tipo1":1, "tipos.tipo2":1})

db.pokemon.find({},{_id:0, "level":0, "dificuldade":0, "raridade":0})


//---- Aggregate
db.pokemon.aggregate([
	{$match: {"racaPokemon": /^C.*d.*/}},
	{$group: {_id:"$mochila_id", "peso": {$sum:"$peso"}}}
]).sort({"peso":-1})

db.mochila.aggregate([
	{
		$group:{
			_id:null,
			"total": {
				$sum:{
					$add:
					["$quantidadePokeball",
					"$quantidadeGreatball",
					"$quantidadeMasterball",
					"$quantidadeHeavyball",
					"$quantidadeNetball"]
				}
			}
		}
	}
])

