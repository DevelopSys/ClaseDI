- [Conceptos básicos](#tema3)
	- Bootstrap
	- Plantillas y Data-binding
	- Directivas: estructurales, de atributo y personalizadas
	- Pipes
#### [Volver al índice](#tema3)

# Bootstrap

Bootstrap es un framework CSS que agrega multitud de estilos a una aplicacion web. Gracias a esta cantidad de estilos, desarrollar interfaces gráficas atractivas es bastante sencillo. Existen dos posibilidades de implementación: 
- Implementación online: se trata de una implementación donde todos los estilos estarán disponibles en la aplicación gracias a un link del framework. De forma generalizada esta es la forma de trabajar
- Implementación offline: en algunos casos no es conveniente tener una dependencia de internet (escenarios de pruebas por ejemplo), por lo que es necesario que todos los elementos están disponibles en modo sin conexión.

## Implementación online

Para poder hacer una implementación online, tan solo hay que abrir la parte de la <a href="https://getbootstrap.com/docs/4.3/getting-started/download/" target="_blank">documentación oficial</a> donde se referencia el link que debe agregarse al proyecto.

Los links que se deben agregar al proyecto son los siguientes:
````
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
````

Como muchos de los elementos de bootstrap utilizan js y librerías parecidas, también es necesario poner los links referentes a estas librerías

````
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
````

Este link debe ir situado en en archivo índex.html, dentro de la etiqueta ````<head>````

````
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>ProyectoBootstrap</title>
  <base href="/">

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" type="image/x-icon" href="favicon.ico">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
  <app-root></app-root>
</body>
</html>

````

De esta forma dentro del proyecto se podrá utiliza cualquier estilo creado en bootstrap. Para comprobar que todo ha funcionado tan solo tendríamos que aplicar alguno de los estilos o clases a un componente
````
<!--The content below is only a placeholder and can be replaced.-->
<div style="text-align:center">
    <h1>
        Welcome to {{ title }}!
    </h1>
</div>
<h2>Here are some links to help you start: </h2>
<p class="container-fluid"></p>
````


## Implementación offline

Para poder hacer una implementación offline hay que seguir los siguientes pasos:
1. Descargar el zip con la version de <a href="https://getbootstrap.com/docs/4.3/getting-started/download/" target="_blank">bootstrap</a>
2. Crear una carpeta llamada styles dentro del proyecto src
3. Copiar el contenido de los ficheros descargados. Los que realmente interesan son los que aparecen en la imagen

![bootstrap](./images/boots.png)

4. En el archivo de angular.json hay que indicar que los estilos son manejados desde los ficheros que se han creado
````
"styles": [
  "styles/bootstrap-3.3.7-dist/css/bootstrap.min.css",
  "styles.scss"
],
"scripts": [
  "styles/bootstrap-3.3.7-dist/js/jquery.min.js",
  "styles/bootstrap-3.3.7-dist/js/bootstrap.min.js"
]
````

Con estos pasos es suficiente para agregar bootstrap en local

Existe otra posibilidad que es hacer la instalación mediante el gestor de paquetes npm mediante el comando:
````
npm install bootstrap
````

En este caso, y para referenciar que los estilos serán manejados por el módulo de bootstrap descargado, el archivo angular.json tendrá este aspecto:
````
"styles": [
  "src/styles.css",
  "node_modules/bootstrap/dist/css/bootstrap.min.css"
],
"scripts": [
  "node_modules/jquery/dist/jquery.min.js",
  "node_modules/bootstrap/dist/js/bootstrap.min.js"
]
````


En la documentación oficial se pueden buscar todas las posibilidades. Uno de los estilos de maquetación= más utilizados es el de columnas o grid, donde  se divide cada fila en 12 columnas. El usuario indica cual es la forma en la que quiere que se dividan las columnas pudiendo indicar el número de columnas que quiere que ocupe el elemento

En el caso de querer que las columnas ocupen lo mismo se utiliza la clase col, y en el caso de querer que ocupe una medida concreta se utiliza col-1 (o el número que se quiere utilizar)

````
<div class="container">
    <div class="row">
        <div class="col">
            <h1>Columna 1</h1>
            <div>
                <p>Esta es la primera columna aplicando tan solo la clase col </p>
            </div>
        </div>
        <div class="col">
            <h1>Columna 2</h1>
            <p>Esta es la segunda columna aplicando tan solo la clase col </p>
        </div>
    </div>

    <div class="row">
        <div class="col">
            <h1>Columna 1</h1>
            <p>Esta es la segunda columna aplicando tan solo la clase col </p>

        </div>
        <div class="col-6 ">
            <h1>Columna 2</h1>
            <p>Esta es la segunda columna aplicando tan solo la clase col-6 </p>

        </div>
        <div class="col">
            <h1>Columna 3</h1>
            <p>Esta es la tercera columna aplicando tan solo la clase col </p>

        </div>
    </div>
</div>
````

En este caso las columnas de la primera fila se reparten por igual, mientras que las columnas de la segunda fila ocupan 3, 6 y 3 respectivamente

Existe la posibilidad de querer personalizar un poco la UI dependiendo de cuánto ocupe la pantalla ya que no es lo mismo una pantalla grande que una pequeña. Para esta distinción de tamaños se utilizan las siguientes medidas:

- Pantallas grandes (LG) > 1200 pixels
- Pantlallas medias (MD) > 992 pixels
- Pantallas tipo tablet (SM) > 768 pixels

Con estas medidas se puede indicar cuantas unidades ocupa cada columna dependiendo del tamaño de la pantalla de la siguiente forma

````
<div class="row">
        <div class="lg-col-3 md-col-4 sm-col-6">
            <h1>Columna 1</h1>
        </div>
        <div class="lg-col-3 md-col-4 sm-col-6">
            <h1>Columna 2</h1>
        </div>
        <div class="lg-col-3 md-col-4 sm-col-6">
            <h1>Columna 3</h1>
        </div>
        <div class="lg-col-3 md-col-4 sm-col-6">
            <h1>Columna 4</h1>
        </div>
    </div>
````

En este ejemplo para pantallas lg se situarán 4 columnas (4*3 = 12), para pantallas md  3 columnas (3*4 = 12) y para pantallas sm 2 columnas (2*6=12)


# Plantillas y Data-binding

Como ya se ha comentado, los componentes de Angular son los elementos principales de la aplicación. Estos constan de dos partes que son las que realizan casi todo el trabajo: parte gráfica y parte lógica. Lo normal es que los datos de una parte sean utilizados en la otra y viceversa. Esto es lo que se conoce como DataBinding y existen dos grandes tipos:

- One Way binding: Cuando se produce una comunicación entre el componente y el DOM de la página. Esta comunicación puede ser desde la parte gráfica a la parte lógica o viceversa:
	- Comunicación ts --> html

		- Obtener el contenido de un dato que se encuentra en la parte lógica y se quiere representar en la parte gráfica: Interpolation binding  ````{{data}}````
		- Asociar el contenido de un valor que se encuentra en la parte lógica a una propiedad HTML de la parte gráfica: Property binding ````[property]=”data”````
		- Asociar el contenido de un valor que se encuentra en la parte lógica a un atributo HTML: Attribute Binding: ````[attribute]=”data”````
		- Asociar el contenido de un valor que se encuentra en la parte lógica a una clase HTML: Class Binding ````[class]=”data”````
		- Asociar el contenido de un valor que se encuentra en la parte lógica a un atributo HTML: Style Binding ````[style]=”data”````

	- Comunicación html --> ts
		- Actuar ante un evento producido por un usuario en un elemento de la parte gráfica, asociando a una función declarada en la parte lógica: Event binding ````(click)="elementoPulsado()"````
- Two Way binding: Cuando se produce una comunicación entre el componente y el DOM de la página al mismo tiempo. Muy utilizado en el caso de los formularios.````[(ngModel)]="data"````


## One Way binding
Dentro de este tipo de binding lo más importante es ser capaz de diferenciar un atributo de una propiedad. Para ello es recomendable leer el siguiente <a href = "https://angular.io/guide/template-syntax#html-attribute-vs-dom-property" target="_blank">link</a>

**Interpolation binding**
****
Se produce cuando se quiere usar el contenido de un dato desde la parte ts hasta la parte html para por ejemplo representarlo en pantalla.

1. Crear dos variables en la parte lógica que son las que se quieren representar en la parte gráfica
````
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-componente-binding',
  templateUrl: './componente-binding.component.html',
  styleUrls: ['./componente-binding.component.css']
})
export class ComponenteBindingComponent implements OnInit {

  nombre: string = 'Mi nombre';
  apellido: string = 'Mi apellido';

  constructor() {}

  ngOnInit() {}
}
````

En este caso se han declarado dos variables a las que se les ha asignado un valor cualquiera

2. En la parte gráfica utilizar la variable declarada entre {{}} para poder utiliza su contenido
````
<p>{{nombre}}<br/> {{apellido}}</p>
````

De esta forma en el párrafo se renderizará el contenido de las variables nombre y apellido.

Del mismo modo que se pueden interpolar String, también se pueden interpolar la ejecución de funciones declaradas en el archivo ts o incluso la ejecución de sentencias js

````
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-componente-binding',
  templateUrl: './componente-binding.component.html',
  styleUrls: ['./componente-binding.component.css']
})
export class ComponenteBindingComponent implements OnInit {

  numero1: number = 1;
  numero2: number = 2;

  constructor() {}

  suma(num1: number, num2: number ): number {
    return num1 + num2;
  }

  ngOnInit() {}
}
````
````
<p>El resultado de la suma de {{numero1}} y {{numero2}} es {{numero1+numero2}}</p>
<p>El resultado de la suma de {{numero1}} y {{numero2}} es {{suma(numero1,numero2)}}</p>

````

**Property binding, Attribute Binding, Class Binding, Style Binding**
****
Es utilizada para asociar un valor declarado en el archivo ts con un elemento de un componente HTML. 

````
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-componente-binding',
  templateUrl: './componente-binding.component.html',
  styleUrls: ['./componente-binding.component.css']
})
export class ComponenteBindingComponent implements OnInit {

  activado: boolean = true;

  constructor() {}

  ngOnInit() {}
}

````
````
<p>
    <input type="text" [disabled]="activado">
</p>
````

En este caso la propiedad disabled del elemento input está asociada al valor de la variable activado declarada en la parte lógica

El resto de bindings se realiza exactamente de la misma forma

````
// Class Binding
<p [class]="clase">
    Ejemplo 
</p>
// Style Binding
<p [style.font-size.px]="50" [style.background]="color"></p>

````


**Event Binding**
****
Se utiliza cuando se asocia el evento producido por un elemento de la interfaz con la ejecución de una función declarada en la parte lógica
1. Declarar una función que realice una tarea deseada
````
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-componente-binding',
  templateUrl: './componente-binding.component.html',
  styleUrls: ['./componente-binding.component.css']
})
export class ComponenteBindingComponent implements OnInit {

  activado: boolean = true;
 
  modificarInput(){
    this.activado = !this.activado;
  }
}
````

2. Asociar un evento determinado a un elemento html, encapsulado mediante ()
````
<button type="button" class="btn btn-primary" (click)=''>Activar / Desactivar</button>


````

3. Igualar a dicho evento la función declarada en el punto 1
````
<button type="button" class="btn btn-primary" (click)='modificarInput()'>Activar / Desactivar</button>

````

Del mismo modo que pasa en los bindings anteriores, a un evento también se le puede asignar un código js

3. Igualar a dicho evento la función declarada en el punto 1
````
<button type="button" class="btn btn-primary" (click)='activado = !activado'>Activar / Desactivar</button>

````

## Two Way binding

Sobre todo es utilizada en formularios y se produce cuando hay una comunicación bidireccional entre el elemento ts y el elemento html, es decir que sus componentes realizan comunicación en ambos sentidos. Para ello se utilizan los caracteres [()] y solo es efectiva si está activo el módulo de formularios, por lo que el primer paso es incluirlo dentro del fichero app.module

````
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DirectivasComponent } from './components/directivas/directivas.component';


@NgModule({
  declarations: [
	DirectivasComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule, FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

````


````
<input type="text" [(ngModel)]="nombre">
````

[()] es una "abreviatura" del siguiente código:

````
<input [ngModel]="nombre" (ngModel)="nombre=$event.target.value"/>
````

ó

````
<input [value]="nombre" (click)="nombre=$event.target.value"/>

````

De esta forma el valor de la variable nombre declarada en la parta .ts se actualizará automáticamente, sin necesidad de que se produzca un evento de enviado, reservado para el envío de los datos (no la captura) y la acción propia de enviado.

# Directivas

Las directivas en Angular son aquellos elementos que permiten modificar el DOM de la página de forma dinámica. Un ejemplo sería mostrar un conjunto de datos dentro de una página web donde no se sabe exactamente cuántos elementos se deben mostrar, por lo que no se puede saber cuantos divs hay que hacer. Existen 3 tipos de directivas:

- Directivas de componente: son aquellas que permiten agregar un componente al DOM de la página. Como se explicó cuando se hablo de componentes, si se quiere agregar un componente a la parte gráfica de otro componente se debe utilizar el selector. El uso de este selector sería la propia directiva de componente.
````
<div>
    <app-componente-directivas></app--componente-directiva>
</div>
````

- Directivas estructurales: son aquellas que modifican la estructura del DOM, agregando o quitando elementos según diferentes elementos. Estas directivas estructurales son:
	- ngIf
	- ngFor
	- ngSwitch
	- ng-Container
- Directivas de atributo: son aquellas que modifican los atributos de elementos del DOM, cambiando el aspecto o comportamiento del elemento. Estas directivas de atributo son:
	- NgClass
	- NgStyle
	- NgModel
	- NgForm

## Directivas de componente
Antes de ver cada una de ellas, es importante saber que tan solo se puede aplicar una directiva estructural por componente

**ngIf**
****
Su uso es muy parecido al estamento if de programación orientada a objetos, pero aplicado a componentes HTML. Para su uso de declara la directiva dentro de la etiqueta de la que se quiere mostrar u ocultar su contenido, igualando a una función o variable que tenga un valor boolean. En el caso de ser verdadero la etiqueta será mostrada, en caso contrario la etiqueta no se mostrará. Para poder utilizarla tan solo hay que incluir la directiva ````*ngIf```` al elemento que le afectará. Su estructura es la siguiente
````
*ngIf= 'valor'
````
Donde valor es una variable boolean

1. En la parte gráfica, incluir en el elemento que se quiere mostrar u ocultar la directiva NgIf
````
<p *ngIf="">Elemento del DOM que aparece y desaparece</p>
````

2. Declarar en la parte lógica una variable boolean
````
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-direcivas-estructurales',
  templateUrl: './direcivas-estructurales.component.html',
  styleUrls: ['./direcivas-estructurales.component.css']
})
export class DirecivasEstructuralesComponent implements OnInit {

  elementoNgIf: boolean = true;

  constructor() { }

  ngOnInit() {
  }

}
````
3. Asociar la variable declarada en el punto anterior con la directiva NgIf del punto 1
````
<p *ngIf="elementoNgIf">Elemento del DOM que aparece y desaparece</p>

````
4. Decidir la lógica por la que la variable del punto dos cambia de valor. En este ejemplo se realiza mediante la pulsación de un botón
````
<p>
El siguiente texto aparecerá y desaparacerá dependiendo de la pulsación del siguiente botón<br />
<button type="button" class="btn btn-primary" (click)="elementoNgIf = !elementoNgIf">Pulsar</button>
</p>
<p *ngIf="elementoNgIf">Elemento del DOM que aparece y desaparece</p>
````

En el ejemplo se realiza el mostrado / ocultación del p donde está presente la directiva mediante la ejecución del evento igualado a código js

````
(click)="elementoNgIf = !elementoNgIf"
````

Pero se podría hacer igualándolo a una función que altere el valor de la variable
````
<button type="button" class="btn btn-primary" (click)="mostrarOcultar()">Pulsar</button>
````

````
export class DirecivasEstructuralesComponent implements OnInit {

  elementoNgIf: boolean = true;

  constructor() { }

  ngOnInit() {
  }

  mostraOcultar(){
  	this.elementoNgif != this.elementoIf; 
  }

}
````

Del mismo modo se podría hacer directamente sobre un div completo para que afecte a todos los elementos que están dentro 

**ngFor**
****
Esta directiva que permite realizar repeticiones sobre un código HTML tomando como valores de la iteración los pertenecientes a una colección de datos. Su funcionamiento es muy parecido a un bucle foreach y su estructura es la siguiente
````
*ngFor= 'let indice of colección'
````

Donde:
- let: es el elemento que se está recorriendo en cada iteración
- colección: es la variable array declarada en la parte lógica que se quiere recorrer 

Aquella etiqueta donde está aplicada la directiva repetirá tantas veces como elemento tenga el contenido de la etiqueta. Lo normal es querer utilizar cada uno de los elementos de la iteración, por lo que se utilizará la interpolación de contenido con el elemento item
````
{{item}}
````

1. En la parte gráfica, incluir en el elemento que se quiere repetir su contenido la directiva NgFor. En la mayoría de los casos suele ser listas
````
<ul *ngFor="let item of ">
</ul>
````
2. Declarar en la parte lógica una variable array con los elementos que se quieren representar
````
export class DirecivasEstructuralesComponent implements OnInit {

  elementosLista: string[] = ['Elemento1', 'Elemento2', 'Elemento3'];

  constructor() { }

  ngOnInit() {
  }

}
````
3. Asociar la variable declarada en el punto anterior con la directiva NgFor del punto 1
````
<ul *ngFor="let item of elementosLista">
</ul>
````
4. Incluir la etiqueta que se repetirá tantas veces como elementos tenga la lista. Si se quiere utilizar los elementos que se iteran, utilizarlos mediante interpolación
````
<ul *ngFor="let item of elementosLista">
	<li>{{item}}</li>
</ul>
````

En este caso aparecerá una lista con 3 strings (aquellos que representa la lista). En el caso de ser elementos más complejos, se utilizará el acceso a sus propiedades mediante el caracter .

1. Declarar en la parte lógica un array de elementos complejos
````
elementosLista2: any[] = [
    { nombre: "Elemento1", posicion: 1 },
    { nombre: "Elemento2", posicion: 2 },
    { nombre: "Elemento3", posicion: 3 }

];
````

2. Utilizar el acceso a sus propiedades

````
<ul *ngFor="let item of elementosLista2">
	<li>{{item.posicion}} {{item.nombre}} </li>
</ul>
````

Si se sigue un patrón de MVC donde se declara un objeto en una clase externa (bien sea mediante interfaz o clase), se realizaría de la misma forma

````
export class Coche {
    private marca: string;
    private modelo: string;
    private cv: number;

    constructor(marca: string, modelo: string, cv: number) {
        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
    }

    get marcaProp() {
        return this.marca;
    }

    get modelProp() {
        return this.modelo;
    }

    get cvProp() {
        return this.cv;
    }
}

````

Importante la palabra reservada export para que la clase pueda ser utilizada en otro archivo ts
````
import { Component, OnInit } from "@angular/core";
import { Coche } from "../../utils/coche";

@Component({
  selector: "app-direcivas-estructurales",
  templateUrl: "./direcivas-estructurales.component.html",
  styleUrls: ["./direcivas-estructurales.component.css"]
})
export class DirecivasEstructuralesComponent implements OnInit {

  elementosObjeto: Coche[] = [
    new Coche("Ford", "Mustang", 500),
    new Coche("Volwagen", "Arteon", 270),
    new Coche("Mercedes", "GLC", 350)
  ];

  constructor() {}

  ngOnInit() {}
}

````

````
<ul *ngFor="let item of elementosObjeto">
	<li>{{item.marcaProp}} {{item.modelProp}} {{item.cvProp}} </li>
</ul>
````

Además de poder utilizar los elementos que forman el array indicado en la directiva nfFor, también se pueden utilizar una serie de variables incluidas en la directiva como son:

- index: number: El índice del elemento actual.
- first: boolean: True cuando el item actual es el primero.
- last: boolean: True cuando el item actual es el último.
- even: boolean: True cuando el índice del item actual es par.
- odd: boolean: True cuando el índice del item actual es impar.

Algunos ejemplos de uso

````
<ul *ngFor="let item of elementosObjeto ; let i = index">
	<li>{{i+1}} {{item.marcaProp}} {{item.modelProp}} {{item.cvProp}} </li>
</ul>
````

````
<ul *ngFor="let item of elementosObjeto; let i = index; let p = odd">
                <li>
                    <p *ngIf="p">Elemento par</p>
                    <p *ngIf="!p">Elemento impar</p>
                    {{ i + 1 }} {{ item.marcaProp }} {{ item.modelProp }} {{ item.cvProp }}
                </li>
</ul>
````

**ngSwitch**
****
Esta directiva es exactamente igual que un estamento switch de programación, donde el resultante de una expresión definirá cual es el elemento del DOM (el tag) que se mostrará. Para ello se utilizan los atributos ````[ngSwitch]```` igualado a una variable definida en código (la cual será la que cambie su valor) y los atributos *ngSwitchCase igualados a los posibles valores que puede tomar la variable. Cuando la variable tome el valor de uno de los *ngSwitchCase se mostrará el tag asignado. También se puede incluir un tag con el atributo *ngDefaultSwitch para que se muestre siempre y cuando el valor de la variable no está contemplado en ninguno de los casos. Su sintaxis es la siguiente:
````
<div [ngSwitch]="variable">
    <div *ngSwitchCase="'elemento1'" ></div>
    <div *ngSwitchCase="'elemento2'"></div>
    <div *ngSwitchCase="'elemeneto3'"></div>
	<div *ngSwitchDefault></div>

</div>  
````

Para utilizarlo:

1. Declarar la directiva ngSwitch en la etiqueta donde se mostrarán los elementos dependiendo de un elemento
````
<div [ngSwitch]="">
</div>
````

2. Declarar una variable en la parte lógica. Esta variable será la que cambie según algún evento y hará modificar el DOM
````
export class DirecivasEstructuralesComponent implements OnInit {
  seleccionado: string;
}
````

3. Igualar la variable a la directiva ngSwitch, configurando los casos posibles
````
<div [ngSwitch]="seleccionado">
	<div *ngSwitchCase="'Op1'">Seleccionado caso 1</div>
	<div *ngSwitchCase="'Op2'">Seleccionado caso 2</div>
	<div *ngSwitchDefault>Seleccionado caso desconocido</div>
</div>
````
Es importante que los casos van entra los caracteres " y ' de modo que lo tome como un literal y no como una variable

````
// variable de la parte lógica cuyo nombre es Op1
<div *ngSwitchCase="Op1">Seleccionado caso 1</div>
// literal Op2
<div *ngSwitchCase="'Op2'">Seleccionado caso 2</div>
````

4. (**para este ejemplo**) Crear tantos radios como opciones haya y meterlos dentro de un grupo
````
<div class="input-group-text">
        <label style="padding-right: 10px">
          <input
            type="radio"
            name="grupo"
            value="Op1"
          />
          Opción 1
        </label>
        <label>
          <input
            type="radio"
            name="grupo"
            value="Op2"
          />
          Opción 2
        </label>
</div>
````
Esto se puede realizar muy fácilmente con la directiva NgFor explicada

5. Crear una función que evalúenlos el elemento pulsado. Esto se realiza mediante un evento, por lo que el parámetro de entrada es un objeto de tipo any
````
grupoSeleccionado(event: any) {
    this.seleccionado = event.target.value;
    console.log(this.seleccionado);
}
````

6. En cada uno de los radios hacer un EventBinding igualándolo al método creado para manejar el camino de selección 
````
      <div class="input-group-text">
        <label style="padding-right: 10px">
          <input
            type="radio"
            name="grupo"
            (change)="grupoSeleccionado($event)"
            value="Op1"
          />
          Opción 1
        </label>
        <label>
          <input
            type="radio"
            name="grupo"
            (change)="grupoSeleccionado($event)"
            value="Op2"
          />
          Opción 2
        </label>
      </div>

      <div [ngSwitch]="seleccionado">
        <div *ngSwitchCase="'Op1'">Seleccionado caso 1</div>
        <div *ngSwitchCase="'Op2'">Seleccionado caso 2</div>
        <div *ngSwitchDefault>Seleccionado caso desconocido</div>
      </div>
````

Para poder pasar como parámetro el evento realizado hay que poner el caracter $event 

## Directivas de atributo

Son aquellas que permiten modificar el DOM de la página pero no mostrando u ocultando elementos, sino que modificando propiedades de los elementos donde son configuradas. A diferencia de las anteriores, se pueden aplicar varias directivas de atributo al mismo componente

**ncClass**
****

Modifica de forma dinámica la clase css que se le asignará al elemento en donde es aplicada. Para ello se cuenta con una serie de clases css que son las que se puede aplicar, donde más de una puede aplicarse. La sintaxis es la siguiente:

````
<div [ngClass]="estilos">
````

Donde estilos es un array de objetos par clave - valor donde la clave es el nombre de la clase y el valor una expresión boolean que dice si se aplica o no el estilo. Se puede declarar tanto literal en el HTML o asociarlo a una variable de la parte lógica

Para utilizarlo. 

1. Declarar las clases css que podrán ser aplicadas al elemento (dentro del ámbito del componente)
````
.letraUno {
    font-size: 10px;
    font-style: italic;
    font-weight: bold;
}

.letraDos {
    font-size: 20px;
    font-style: normal;
    font-weight: bolder;
}

.letraTres {
    font-size: 30px;
    font-style: oblique;
    font-weight: initial;
}
````

2. Asignar la directiva ngClass al elemento que se quiere aplicar la o las clases
````
<div [ngClass]="">
</div>

````

3. Declarar en la parte lógica un array par clave valor con las clases. Asignar un valor a cada clase
````
export class DirecivasEstructuralesComponent implements OnInit {

  estilos = {letraUno: false, letraDos: false, letraTres: true};
}
````

3. Asociar el array declarado a la directiva ngClass

````
<div [ngClass]="estilos">
</div>
````

Del mismo modo se podría haber declarado de forma literal en el HTML

````
<div [ngClass]="{letraUno: true, letraDos: false, letraTres: false}">
</div>
````

**Realizar el cambio de estilo de forma dinámica con tres checkbox.**

**ngStyle***
****

Tiene un funcionamiento muy similar a la directiva anterior, con la única diferencia que no modifica el valor de una clase css asignándole una nueva completa, sino que modifica algunas atributo del estilo. Su sintaxis es muy parecida a la directiva anterior

````
<div [ngClass]="estilos">
````

Donde estilos es un array de objetos par clave - valor donde la clave es el nombre de la propiedad del estilo y el valor una expresión que devuelve el valor a aplicar al estilo. Se puede declarar tanto literal en el HTML o asociarlo a una variable de la parte lógica

En este caso el valor no puede ser boolean ya que no tendría ningún sentido aplicar por ejemplo Font-Sise = true, sino que sería Font-Sise = 20. Para ello se utilizan las expresiones directas o condicionales 

En las directas se utiliza la siguiente sintaxis:
````
'Font-size' : '12px'
````


En las condicionales se utiliza siguiente sintaxis:

````
(expresion1)? expresion2 : expresion3
````

Donde si “expresion1” es verdadera, se devuelve el valor de “expresion2”; y si es falsa, se
devuelve el valor de “expresion3”. Un ejemplo sería 

````
this.grande ? '50px' : '12px'
````
En este caso, dependiendo del valor de la variable grande la salida será:
- si es verdadera, la salida será 50px
- si es falsa, la salida será 12px

Lo normal es que la salida se asigne a una propiedad de estilo, para ello la variable de la que depende la salida se le asigna el valor de esta forma:

````
'font-size': this.grande ? '50px' : '12px';

````

Un ejemplo sería:
````
'font-size': '12px', 'background-color' : 'green'};

````

En el caso de querer hacerlo dinámico, lo mejor es declarar un método que devuelva el array de estilos con todas sus posibilidades. La directiva ngStyle se asociará al método

Para poder utilizarlo:

2. Asignar la directiva ngStyle al elemento que se quiere aplicar los diferentes estilos
````
<div [ngStyle]="">
</div>

````

3. Declarar en la parte lógica un array par clave valor con los estilos que se pueden aplicar. Asignar un valor de estilo a cada posible salida
````
export class DirecivasEstructuralesComponent implements OnInit {

grande:boolean = false;
color:boolean = false;

estilosDinamicos = {'font-size': this.grande ? '50px' : '12px', 'background-color' : this.color ? 'green' : 'none'};

  estilos = {letraUno: false, letraDos: false, letraTres: true};
  constructor() {}

  ngOnInit() {}

}

````

3. Asociar el array declarado a la directiva ngClass

````
<div [ngStyle]="estilosDinamicos">
</div>
````

En el caso de querer aplicar los estilos directos, se podría hacer definido la variable con los valores directos 
````
estilosDinamicos = {'font-size': '50px' , 'background-color' : 'green'};

````
Ó en el HTML diretamente

````
<div [ngStyle]="{'font-size': '50px' , 'background-color' : 'green'}">
</div>
````

**Existen otros tipos de directivas que se irán explicando a lo largo de los siguientes temas ya que se mezclan con otros elementos como por ejemplo los formularios**

# Pipes

Los pipes actúan como funciones de transformación de datos, es decir que toman una entrada cualquiera y la transforman para que esta sea mostrada de forma diferente. Para poder utilizarlos el caracter | debe seguir a la información que se quiere transformar. Los tipos de pipes que existen son:

- UpperCasePipe
- TitleCasePipe
- SlicePipe
- DecimalPipe
- PercentPipe
- CurrecyPipe
- AsyncPipe
- DatePipe
- JsonPipe

Cada uno de ellos realiza las siguientes funciones pero su sintaxis es igual:
````
{{variable | pipe:param1:param2}}
````

Dependiendo del tiempo de pipe los parámetros que se pueden poner son diferentes pero su uso es el mismo:

1. Se crea una variable en la parte lógica de tipo string y se iguala a un valor
2. En la parte gráfica, se llama al contenido de la variable a la cual se le aplica el pipe

Para los ejemplos mostrados en cada uno de los siguientes pipes se definen en la parte lógica las siguientes variables:
````
  palabraMinuscula: string = 'PASAR A MINUSCULAR';
  palabraMayuscula: string = 'pasar a mayuscula';
  palabraCapitalizar: string = 'las primeras letras a mayuscula';
  palabraCortar: string = 'Ejemplo de corte';
  fecha: Date = new Date(2019, 9);
  numeroDecimal: number = 12.12312;
  numeroPorcentaje: number = 44.390;
  numeroMoneda: number = 2.500;
````


- UpperCasePipe | LowerCasePipe

Utilizado para transformar un texto en mayúsculas / minúsculas respectivamene. Para ello:
````
        <tr>
            <td>Valor normal: {{ palabraMinuscula }}</td>
            <td>Valor con pipe: {{ palabraMinuscula | lowercase }}</td>
        </tr>
        <tr>
            <td>Valor normal: {{ palabraMayuscula }}</td>
            <td>Valor con pipe: {{ palabraMayuscula | uppercase }}</td>
        </tr>
````

- TitleCasePipe

Muy similar a los anteriores, con la diferencia que capitaliza la primera letra de cada palabra

````
        <tr>
            <td>Valor normal: {{ palabraCapitalizar }}</td>
            <td>Valor con pipe: {{ palabraCapitalizar | titlecase }}</td>
        </tr>
````

- SlicePipe

Utilizado para poder cortar partes de un elemento según se indiquen en los parámetros del pipe. Su sintaxis es la siguiente

````
// suponer una variable var = 'Ejemplo de variable';
// {{var | slice: posicionInicio:posicionFin}}
{{var | SlicePipe:0:6}} // Ejemplo
````

````
            <td>Valor normal: {{ palabraCortar }}</td>
            <td>Valor con pipe: {{ palabraCortar | slice: 0:7 }}</td>
````

- DecimalPipe

Utilizado para mostrar números en un formato específico. Se utiliza con variables formato number. Los argumentos que admite son:
````
{{ var | number: ’ minimoDeEnteros . minimDeDecimales -maximoDeDecimales ’ }}
````

````
        <tr>
            <td>Valor normal: {{ numeroDecimal }}</td>
            <td>Valor con pipe: {{ numeroDecimal | number: "2.4" }}</td>
        </tr>
````

- PercentPipe

Muy similar al anterior, con la diferencia que convierte un numero dado en su correspondiente decimal. Los argumentos que admite son:

````
{{ var | number: ’ minimoDeEnteros . minimDeDecimales -maximoDeDecimales ’ }}
````

````
        <tr>
            <td>Valor normal: {{ numeroPorcentaje }}</td>
            <td>Valor con pipe: {{ numeroPorcentaje | percent: "1.4" }}</td>
        </tr>
````


- CurrencyPipe

Utilizado para mostrar un valor en formato moneda. Los argumentos que admite son:
````
{{ var | currency: ‘codigoISO’ : valorBooleanoParaMostrarSimboloOCodigoIso: ’ minimoDeEnteros . minimDeDecimales -maximoDeDecimales ’ }}
````

````
        <tr>
            <td>Valor normal: {{ numeroMoneda }}</td>
            <td>Valor con pipe: {{ numeroMoneda | currency: "EUR":true:"1.3" }}</td>
        </tr>
````


Los códigos ISO de las monedas locales se pueden consultar en el siguiente <a href="https://es.iban.com/currency-codes" target="_blank">link</a>

- DatePipe

Transforma un dato en el formato fecha que se le indique. Para ello, los argumentos que admite son:

````
{{ value_expression | date [ : format [ : timezone [ : locale ] ] ] }}
````
````
        <tr>
            <td>Valor normal: {{ fecha }}</td>
            <td>Valor con pipe: {{ fecha | date: "short" }}</td>
            <td>Valor con pipe: {{ fecha | date: "yyyy/dd/MM" }}</td>
        </tr>
````


Los formatos de fecha que podemos pasarle a estas pipes son:

````
DatePipe:‘short’ // 6/15/19, 9:03 AM
DatePipe:‘medium’ // Jun 15, 2019, 9:03:01 AM
DatePipe:‘long’ // June 15, 2019 at 9:03:01 AM GMT+1
DatePipe:‘full’ // Monday, June 15, 2019 at 9:03:01 AM GMT+01:00
DatePipe:‘shortDate’ // 6/15/19
DatePipe:‘mediumDate’ // Jun 15, 2019
DatePipe:‘longDate’ // June 15, 2019
DatePipe:‘fullDate’ // Monday, June 15, 2019
DatePipe:‘shortTime’// 9:03 AM
DatePipe:‘mediumTime’// 9:03:01 AM
DatePipe:‘longTime’ // 9:03:01 AM GMT+1
DatePipe:‘fullTime’ // 9:03:01 AM GMT+01:00
````

Del mismo modo también se puede indicar el formato propio


````
{{myVar | date: 'M/d/yy'}}
````

Se pueden consultar todos los valores de formato específico en el siguiente <a href="https://angular.io/api/common/DatePipe" target="blank">link</a>

- JsonPipe

Permite mostrar de forma "legible" on objeto de tipo son

- AsyncPipe

Permite mostrar datos que provienen de Observables o promesas 

# Personalización: Directivas y Pipes


Al igual que existen tanto directivas como pipes ya creados en Angular, un usuario puede crear sus propios elementos ya que en muchas ocasiones es necesario personalizar al máximos las tareas que se realizan. 

## Pipes personalizados

Para poder generar un pie se debe poner el comando 

````
````

Esto genera el pipe personalizado

````
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'pipePerso'
})
export class PipePersoPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}
````

Esto genera una clase que implementa PipTrasform donde se crea un método transform que es el ejecutado cuando el pie es llamado. Entre los valores que tiene el método (args), se encuentran todos los elementos que podrá obtener el pie en entrada. Para el ejemplo se utilizará una lista de cartas con una imagen y un texto. En el caso de no encontrar la imagen se cargará una por defecto mediante un pipe. Para ello los pasos son los siguientes

1. Se crea el componente PipesPersonalizados y se crea un array de objetos donde cada uno de ellos tiene nombre e imagen. 

````

````


2. En la parte html se cargan una serie de cartas donde aparece la imagen y el nombre.








