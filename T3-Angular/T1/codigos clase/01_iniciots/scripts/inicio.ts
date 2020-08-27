/*console.log('hola mundo');
console.log('Esto es un ejemplo de linea de codigo')
console.log('Esto es un nuevo cambio');
let numero:number = 1;
let palabra:string='1';
console.log(numero);*/

let nombre: string = "Borja";
let apellido: string = "Martin Herrera";
// console.log(nombre+' '+apellido)
console.log(`${nombre} ${apellido}`);
let nota: number = 1;
/*if (nota >= 5) {
    console.log('Has aprobado');
} else if (nota < 5 && nota > 2) {
    console.log('Has suspendido');
} else {
    console.log('fatal')
}*/
switch (nota) {
  case 1:
    console.log("caso 1");
    break;

  case 2:
    console.log("caso 2");
    break;

  default:
    console.log("Resto de casos");
    break;
}
/*for (let index = 0; index < 10; index++) {
    console.log(`Elemento ${indeconjuntoPaab*/

let conjuntoPalabras: string[] = ["primera", "segundo", "tercero", "cuarto"];

console.log("con forin");
for (const key in conjuntoPalabras) {
  console.log(conjuntoPalabras[key]);
}

console.log("con forof");

for (const iterator of conjuntoPalabras) {
  console.log(iterator);
}

console.log("con foreach arrow");

conjuntoPalabras.forEach(element => {
  console.log(element);
});

console.log("funciones");

function funcionInicial(nombre: string) {
  console.log(nombre);
}

function funcionInicialParametros(
  nombre: string,
  apellido: string,
  edad: number
) {
  console.log(`${nombre} ${apellido} ${edad}`);
}

function funcionRetorno(numeroUno: number, numeroDos: number): number {
  return numeroUno + numeroDos;
}

function funcionCualquierParamentro(params: any) {
  console.log(params);
}

function funcionParamentesMultiples(nombre:string,...nombresMultiples:string[]) {
    console.log(nombre)
    if (nombresMultiples.length>0){
        nombresMultiples.forEach(element => {
            console.log(element);
        });
    }else{
        console.log('no han pasado paramentros multiples')
    }
}

function funcionParamentrosMultiples(nombre:string, nombresMultiple:string[]){

}

function funcionParametrosOptativos(nombre: string,apellido: string,
     edad?:number){
    if (edad==null){
        console.log(`${nombre} ${apellido}`)
    } else{
        console.log(`${nombre} ${apellido} ${edad}`)
    }
}

function funcionValoresDefecto(nombre:string,apellido:string='defecto'){
    console.log(`${nombre} ${apellido}`)
}

funcionInicial("MiNombre");
funcionInicialParametros("Borja", "Martin", 123);
console.log(funcionRetorno(44, 53));
funcionCualquierParamentro("asd");
funcionCualquierParamentro(123);
funcionCualquierParamentro(true);
funcionParamentesMultiples('Borja','asd','iytre','uytre')
let ejemploNombresArray:string[] = [""]
funcionParamentrosMultiples('Borja',ejemploNombresArray)
funcionParametrosOptativos('Borja','Martin')
funcionParametrosOptativos('Borja','Martin',345)
funcionValoresDefecto('Borja','Martin')