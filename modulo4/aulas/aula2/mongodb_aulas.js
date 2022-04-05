
-- Criar DB

criar vemserdbc
use vemserdbc
db.createCollection("alunos")

-- Inserir

db.alunos.insert(
    {
        "nome" : "Rafael Lazzari", 
        "DATA_NASCIMENTO" : ISODate( new Date (1990,01,27)
    }
)

-- Remover

db.alunos.remove({ "_id" : ObjectId ("56cb0002b6d75ec12f75d3b5") } )


-- Buscar

- FIND com navegação no documento

db.alunos.find()


- FIND com navegação no documento

db.alunos.find().pretty()

db.alunos.find(
{ 
  "nome" : "Rafael"
}
).pretty()


// Ex
SELECT a.(*)
    FROM habilidades as h
    JOIN alunos as a ON a.id = h.aluno_id
    WHERE h.nome="inglês"
    AND a.nome = "Rafael";



db.alunos.find(
	{ 
	  "habilidades.nome": "inglês"
	}
)


-- FIND com OR e IN

db.alunos.find({
    "curso.nome" : "Sistemas de informação",
    "curso.nome" : "Engenharia Química"
})

db.alunos.find({
    "curso.nome" : "Sistemas de informação",
    "curso.nome" : "Engenharia Química",
    "curso.nome" : "Física"
})

db.alunos.find({
    $or : [
        {"curso.nome" : "Sistemas de informação"},
        {"curso.nome" : "Artes"}    
    ]
})


db.alunos.find({
     $or : [
        {"curso.nome" : "Física"},
        {"curso.nome" : "Ciência da computação"},
    ],
    "nome" : "Rafael"
 })

// Ex
SELECT * FROM cursos WHERE nome in ("Sistemas de informação", "Engenharia Química","Moda");

db.alunos.find({
    "curso.nome" : {
        $in : ["Ciência da computação", "Física"]
        }
})

db.alunos.find({ "status" : "X" })



------- HW

db.alunos.find({ "status" : "X" })

// Resultado:

{ _id: ObjectId("619c6798f348a5a68d29db15"),
  nome: 'Rafael',
  data_nascimento: 1994-02-27T03:00:00.000Z,
  idade: 27,
  curso: { nome: 'Ciência da computação' },
  notas: [ 10, 9, 7.5 ],
  habilidades: 
   [ { nome: 'inglês', 'nível': 'avançado' },
     { nome: 'jogatina', 'nível': 'intermediário' } ],
  status: 'X' }
{ _id: ObjectId("624b46cc0c78ca8a81b18d0b"),
  nome: 'Rafael',
  data_nascimento: 1994-02-27T03:00:00.000Z,
  idade: 27,
  status: 'X' }



------------
-- Aula 2 --
------------


---- Insert One
db.alunos.insertOne(
{  
  "nome": "Rafael",
  "data_nascimento": new Date (1994,01,27), 
  "idade": 27,
  "curso": {
    "nome": "Ciência da computação"
  },
  "notas": [10.0, 9.0, 7.5],
  "habilidades": [
    {
      "nome": "inglês",
      "nível": "avançado"
    },
    {
      "nome": "jogatina",
      "nível": "intermediário"
    }
  ],
  "status": "A"
})


db.alunos.insertMany([
  { "nome": "Rafael", "data_nascimento": new Date (1994,01,27), "idade": 27, "curso": { "nome": "Ciência da computação" }, "notas": [10.0, 9.0, 7.5], "habilidades": [ {  "nome": "inglês",  "nível": "avançado" }, {  "nome": "jogatina",  "nível": "intermediário" } ], "status": "A"},
  { "nome": "Miguel", "data_nascimento": new Date (1993,01,27), "idade": 26, "curso": { "nome": "Artes" }, "notas": [8.0, 9.0, 2.5], "habilidades": [ {  "nome": "inglês",  "nível": "básico" }, {  "nome": "jogatina",  "nível": "avançado" } ], "status": "A"},
  { "nome": "Gabriel", "data_nascimento": new Date (1992,01,27), "idade": 25, "curso": { "nome": "Matemática" }, "notas": [8.0, 10.0, 6.5], "habilidades": [ {  "nome": "inglês",  "nível": "avançado" }, {  "nome": "jogatina",  "nível": "básico" } ], "status": "I"},
  { "nome": "Ana", "data_nascimento": new Date (1990,01,27), "idade": 23, "curso": { "nome": "Física" }, "notas": [8.0, 9.0, 9.5], "habilidades": [ {  "nome": "inglês",  "nível": "intermediário" }, {  "nome": "jogatina",  "nível": "avançado" } ], "status": "A"}
])

---- Delete
db.alunos.deleteOne( { nome: "Rafael", idade: 25 } )
db.alunos.deleteMany({}) // deleta todos documentos


---- Find Equal
{ <field1>: <value1>, ... }
{ status: "D" }

// Ex
SELECT * FROM alunos WHERE status = "D"

db.alunos.find({
    "status": "D"
})

db.alunos.find({
    "habilidades": {nome: "jogatina", "nível": "avançado"}
})


---- Find AND
{ status: "A", idade: { $lt: 25 } }

SELECT * FROM alunos WHERE status = "A" AND idade < 25

db.alunos.find({
    status: "A", 
    idade: { $lt: 25 }
})


---- Find OR / IN
{ <field1>: { <operator1>: <value1> }, ... }
{ status: { $in: [ "A", "D" ] } }

SELECT * FROM alunos WHERE status in ("A", "D")


db.alunos.find({
    $or : [
        {"curso.nome" : "Ciência da computação"},
        {"curso.nome" : "Física"},
        {"curso.nome" : "Artes"}
    ],
    "nome" : "Ana"
 })


---- Find Expressão
{ nome: /^Ra/ } 

SELECT * FROM alunos WHERE nome LIKE "Ra%")

db.alunos.find({
    "nome": /^Ra/ 
})


---- Find Campos aninhados
{"curso.nome" : "Física"}

db.alunos.find({
   "curso.nome" : "Física"
})

db.alunos.find({
   "notas.2" : 9.5
})


---- Update
{
  <update operator>: { <field1>: <value1>, ... },
  <update operator>: { <field2>: <value2>, ... },
  ...
}

db.alunos.updateOne(
   { nome: "Rafael" },
   {
     $set: { "nome": "Rafael", status: "Z" }           
   }
)

