let numero: number = 7;
let palabra: string = "ejemplo"
let array: number[] = [1,2,34,5,6]
console.log(`${palabra}`);


function funcionParamentros(numero: number) {
    console.log(numero);
}

function funcionConRetorno(numeroUno: number, numeroDos: number): number {
    let resultado = numeroUno +numeroDos
    return resultado
}

function funcionParamentrosOptativos(numero: number, palabra:string, acierto?: boolean) {
    
    console.log(numero);
    console.log(palabra);
    console.log(acierto);   
}

function funcionParametrosAdicionales(params:number, ...parametroArray:any[]) {
    parametroArray.forEach(element => {
        
    });
}

function funcionParamentrosDefecto(params:number, param2: string='por defecto') {
    
}

funcionParamentros(123456)
console.log(funcionConRetorno(123,123));
funcionParamentrosOptativos(1,"asd")
funcionParametrosAdicionales(9,123,123,423,423,543,6,457,587,678,4,35,"weqwe",false);
funcionParamentrosDefecto(456789,"asdasd");


