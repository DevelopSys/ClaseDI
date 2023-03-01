
- [Manejo de rutas](#manejo-de-rutas)
  - [Rutas con atributo routerLink](#rutas-con-atributo-routerlink)
  - [Rutas desde el código](#rutas-desde-el-código)
  - [LazyLoad](#lazyload)
        - [Paso de parámetros entre rutas](#paso-de-parámetros-entre-rutas)
- [Comunicación entre componentes (sin rutas)](#comunicación-entre-componentes-sin-rutas)
- [Servicios](#servicios)
  - [Consulta de servicios mediante promesas](#consulta-de-servicios-mediante-promesas)


#### [Volver al índice](#tema4)

# Manejo de rutas

Como toda aplicación, lo normal es que esta no conste solo de un elemento, sino que tenga más y se necesite navegar entre ellos. Para ello Angular tienen un módulo que se encarga de la gestión de todas las rutas de forma que el programador no necesita configurar mucho código a la hora de realizar la navegación. Este módulo es routing que se pregunta cuándo se crea un proyecto. En el caso de tener un proyecto que no tenga el módulo de rutas iniciado se puede crear con el siguiente parámetro
````
ng g m app-routing --routing
````

En su estructura, el módulo de rutas no deja de ser una clase que tiene el decorador @NgModule donde se configuran las rutas a visitar con una serie de parámetros. Inicialmente el contenido del archivo app-routing.module.ts es el siguiente:

````
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

````

Donde:

- Las importaciones son el módulo de rutas (RouterModule), el tipo de las rutas que se definirá en la clase (Routes) y el decorador del módulo (NgModule)
- Una constante donde se declararán cada una de las rutas que se querrán gestionar por medio del módulo de rutas. Este array inicialmente está vacío, hay que ir rellenando manualmente con las opciones que se verán más adelante.
- El decorador del módulo: donde:
	- se importa el módulo de rutas indicando el array con las rutas que se deben gestionar
	- se exporta el módulo de rutas para que puede ser utilizado desde cualquier parte.

Si abrimos el fichero del módulo, podemos observar que el módulo de rutas es importado para que se pueda utilizar por todos los componentes

````
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

````

## Rutas con atributo routerLink


Una vez entendido esto, es importante saber que las rutas solo son utilizadas si nosotros realmente las necesitamos. Para una aplicación pequeña que conste de pocos componentes ni siquiera serán necesarias. En el caso de tener muchos componentes sí que necesitaremos que cada uno se muestre de una forma diferente al pulsar un menú por ejemplo. En este caso el uso de rutas es obligatorio. Para mostrar esta funcionalidad se va a realizar un ejemplo con varios componentes que aparecen según la selección de diferentes menús. 

1. Crear dos componentes y preparación del sistema 
````
ng g c components/fubol
ng g c components/juegos
````

Se puede comprobar que cada uno de ellos tiene sus correspondientes archivos asociados. En los archivos .ts se comprueba el selector asociado a cada uno de ellos y el nombre de la clase. Esto último será lo utilizado para asociarlo en el archivo de rutas
````
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-futbol',
  templateUrl: './futbol.component.html',
  styleUrls: ['./futbol.component.css']
})
export class FutbolComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
````

````
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-juegos',
  templateUrl: './juegos.component.html',
  styleUrls: ['./juegos.component.css']
})
export class JuegosComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
````

Adicionalmente para que estos dos componentes se puedan utilizar en la aplicación deberán ser declarados en el archivo app.module en la parte de declarations

````
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FutbolComponent } from './components/futbol/futbol.component';
import { JuegosComponent } from './components/juegos/juegos.component';

@NgModule({
  declarations: [
    AppComponent,
    FutbolComponent,
    JuegosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

````

En el caso de querer que los dos elementos se visualizan en la misma pantalla, ya sabríamos como hacerlo por lo que simplemente se declaran las dos etiquetas dentro del html del app.component.html

````
<div class="container">

    <app-futbol></app-futbol>
    <app-juegos></app-juegos>

</div>
````

Sin embargo en este caso lo que nos interesa es tener una barra superior que nos permita seleccionar un menú y que depende de este se muestre un componente u otro. Para ello se creará otro componente llamado menú-barra y se colocará en app.component.html ()

````
ng g c components/fubol

````


````
<div class="container-fluid">

    <app-menu-barra></app-menu-barra>

</div>
````

Como lo que se quiere es que al pulsar cada uno de los ítem del menú aparezca un componente u otro, se debe utilizar un elemento particular de angular que se llama router-outlet. Esta etiqueta es el sitio donde se ubicarán todos los componentes llamados mediante rutas. Para ello se modifica el contenido del fichero app.component.html

````
<div class="container-fluid">

    <app-menu-barra></app-menu-barra>
    <router-outlet></router-outlet>
</div>
````


2. Para poder gestionar las rutas, lo siguiente que hay que hacer es en el archivo de rutas, crear un objeto de tipo Routes donde se indica el path (nombre que se utilizará para llamar al componente) y el component (componente asociado al path creado)

````
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FutbolComponent } from './components/futbol/futbol.component';
import { JuegosComponent } from './components/juegos/juegos.component';

const routes: Routes = [
  { path: 'futbol', component: FutbolComponent },
  { path: 'videojuegos', component: JuegosComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

````

3. El path es definido por el programador, y será utilizado para llamar al componente desde "cualquier" navegación. El componente es el nombre de la clase del componente que se quiere asociar
````
const routes: Routes = [{path: 'compouno', component: ComponenteUnoComponent}];

````

4. Por último, hay que asegurarse que el módulo creado está importado en el archivo app.module.ts (al igual que los dos componente creados que se han importado de forma automática) y que está configurada la ruta base en el archivo índex.html

````
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FutbolComponent } from './components/futbol/futbol.component';
import { JuegosComponent } from './components/juegos/juegos.component';
import { MenuBarraComponent } from './components/shared/menu-barra/menu-barra.component';

@NgModule({
  declarations: [
    AppComponent,
    FutbolComponent,
    JuegosComponent,
    MenuBarraComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

````


````
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>ProyectoRutas</title>
  <base href="/">

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" type="image/x-icon" href="favicon.ico">
</head>
<body>
  <app-root></app-root>
</body>
</html>

````


Con estas configuraciones las rutas ya son gestionables y se podrá navegar entre componentes. 

Antes de explicar cómo poder realizar la navegación, merece la pena ver cuales son las posibilidades que ofrece el array de rutas del módulo que gestiona las rutas.  Cosas que hay que tener en cuenta de este array:

- Cada elemento del array (ruta) mapea una URL a un componente.
- La lectura de este array es vertical (de arriba abajo), por lo que la última ruta debería ser una ruta de "escape". Para ello se puede indicar con la siguiente ruta:
````
{ path: '**', component: componme }
````
- Se puede indicar un parámetro redirectTo del path vacío,  estableciendo la página incial. Si se usa redirectTo, es obligado utilizar pathMatch. pathMatch puede ser 'full' o 'prefix'. Si se pone 'prefix' se considerará coincidencia si la url comienza con lo indicado en path.

````
{ path: '', redirectTo: '/compohome', pathMatch: 'full'}
````

- Se explicará más adelante, pero es posible indicar parámetros que se le pasarán al componente en la ruta. Para ello en el parámetro del path se indica path: parámetro:parametro

````
{ path: 'compouno/:id',      component: ComponenteUnoComponent
````

- La propiedad data es un lugar para almacenar información asociada a la ruta.

````
 {path: 'compouno/comosub', component: ComponenteUnoComponent,
        data: { title: 'Componente uno', sub: 'Sub componente' }
      }
````

****

5. Como se ha explicado antes, en el módulo de rutas se indica el array con las rutas que son gestionables. Según el ejemplo de antes se tendrían 3 componentes: compouno, compodos, compohome (creado nuevo) y el módulo de rutas tendría el siguiente aspecto:

````
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FutbolComponent } from './components/futbol/futbol.component';
import { JuegosComponent } from './components/juegos/juegos.component';

const routes: Routes = [
  { path: 'futbol', component: FutbolComponent },
  { path: 'videojuegos', component: JuegosComponent },
  { path: '', redirectTo: '/', pathMatch: 'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
````

Además de la definición de los componentes esto quiere decir que: 

- Si no se mete ninguna ruta redirigirá al componente /
- Si se mete mal una ruta redirigirá al componente /

Para poder funcionar con las rutas, lo que el módulo hace un mareo de URL según el path indicado. Esto quiere decir que si se navega hasta compouno el módulo de rutas interpretará la URL como http://nombre/compouno

Si en el navegador se introducen las siguientes rutas, el componente mostrado será:
- Si no se mete ninguna ruta será http://localhost:4200/futbol y el componente mostrado será FutbolComponent
- Si se mete la ruta http://localhost:4200/videojujuegos el componente mostrado será JuegosComponent

- Si se mete mal la ruta http://localhost:4200/asasdasd se redirigirá a http://localhost:4200/ y el AppComponent

Esto es gracias a las ordenes que se han indicado en el módulo de rutas. **Mucho cuidado con poner** ````  { path: "**", component:AppComponent }```` **la primera línea**

Al tratarse de una SPA para que se puedan visualizar las rutas cuando un componente sea llamado y no tenga necesidad de recargar el navegador, se debe utilizar la etiqueta router-outlet en el sitio donde se mostrará el componente llamado mediante URL. Para ello (en este ejemplo) en el archivo  app-component.ts se incluye dicha etiqueta:

````
<!--The content below is only a placeholder and can be replaced.-->
<div style="text-align:center">
    <h1>Welcome to {{ title }}!</h1>
</div>
<h2>Zona de navegación</h2>

<router-outlet></router-outlet>
````


Según ese código, dentro de la etiqueta router-outlet se mostrándotelas todos aquellos elementos que hayan sido seleccionado en una barra de navegación. Con todo esto configurado tan solo falta poder navegar entre elementos. Para poder navegar entre elementos se utiliza el atributo routerlink, incluyéndolo en la etiqueta que actuará como elemento de navegación con el siguiente formato:
````
[routerlink]=['/nombrePath']
````


````
h2>Zona de navegación</h2>

<ul>
    <li>
        <a [routerLink]="['/compouno']" class="nav-link">link al componente uno</a>
  </li>
  <li>
    <a [routerLink]="['/compodos']"  class="nav-link">link al componente dos</a>
  </li>
</ul>

<router-outlet></router-outlet>
````

Esto indica que al pulsar el primer link, el módulo de las rutas redirigirá a lo indicado en el archivo app-routing.ts. Normalmente la directiva routerlink se suele acompañar con directiva routerLinkActive, la cual se asocia con una clase css que indica que el link está activado y lo representará de forma diferente
````
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">Inicio</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" [routerLink]="['/futbol']" routerLinkActive="router-link-active">Futbol</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" [routerLink]="['/videojuegos']" routerLinkActive="router-link-active" tabindex="-1">Videojuegos</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
````

*¿Qué pasa si se utiliza la propiedad href en vez de la directiva routerlink?*

## Rutas desde el código


Toda la gestión de rutas vista en los puntos anteriores se realiza de forma estática, ya que no hay posibilidad de cambiar el atributo routerLink (si no es con directiva). En algunos casos es necesario que estos links actúen de forma dinámica, para lo cual se debe realizar de forma programática. Para ello hay que utilizar el módulo Router de Angular y su método navigate.

Para poder utilizarlo:

1. Declarar un componente que pueda producir un evento que actúe como elemento de navegación y asociarle un evento mediante binding 


````
ng g c components/libros 
````

Se agrega un elemento en la barra de navegación, por lo que se añade en el archivo menú-barra.component.html y li y se le asocia un evento de click (que habrá que definir en la parte ts)

````
<li class="nav-item">
	<a class="nav-link" tabindex="-1" (click)="navegar()">libros</a>
</li>
````

3. En el constructor de la clase, declarar un parámetro de tipo Router para que pueda ser utilizado en toda la clase

````
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu-barra',
  templateUrl: './menu-barra.component.html',
  styleUrls: ['./menu-barra.component.css'],
})
export class MenuBarraComponent implements OnInit {
  constructor(private navegador: Router) {}

  ngOnInit(): void {}

}

````

4. En el método que gestiona el evento utilizar el parámetro creado en el punto anterior y llamar al método navigate, pasando como parámetro un array con la ruta a la que se quiere navegar (el path indicado en el modulo de rutas)

````
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu-barra',
  templateUrl: './menu-barra.component.html',
  styleUrls: ['./menu-barra.component.css'],
})
export class MenuBarraComponent implements OnInit {
  constructor(private navegador: Router) {}

  ngOnInit(): void {}

  navegar() {

    this.navegador.navigate(['libros']);

  }
}

````

## LazyLoad

Una de las cosas buenas que tiene las SPA realizadas por Angular es la velocidad, tanto de carga inicial como cada vez que se navega a cada uno de los componentes que componen la aplicación. Esto se debe a que la aplicación tan solo carga una página (el componente root) el cual es el encargado de renderizar el resto de componentes cuando estos son llamados. En la carga inicial, la aplicación lee el archivo de rutas y carga todos los elementos en memoria. Para aplicaciones pequeñas / medianas no hay gran problema ya que el tamaño de la carga no es relevante, pero para aplicaciones grandes sí se nota en rendimiento. Por ejemplo, para la aplicación con fichero de rutas:


````
import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { ComponenteUnoComponent } from "./components/componente-uno/componente-uno.component";
import { ComponenteDosComponent } from "./components/componente-dos/componente-dos.component";
import { ComponenteHomeComponent } from "./components/componente-home/componente-home.component";

const routes: Routes = [
  { path: "compouno", component: ComponenteUnoComponent },
  { path: "compodos", component: ComponenteDosComponent },
  { path: "compohome", component: ComponenteHomeComponent },
  { path: "", redirectTo: "compohome", pathMatch: "full" },
  { path: "**", component: ComponenteHomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}

````

Esto quiere decir que cada más cargarse la aplicación se cargar se cargarán lls componentes compouno, compodos, compohome. Muchas veces no es necesario que los componentes se carguen por defecto, ya que no interesa hasta que sean visitados, por lo que la carga diferida se encarga de esto. 

En casi todas las aplicaciones se pueden dividir líneas de negocio, como por ejemplo la linea de clientes (y toda su funcionalidad), la linea de proveedores (y toda su funcionalidad), la linea de trabajo (y toda su funcionalidad). En aplicaciones grandes es buena práctica dividir el trabajo en módulos, de forma que cada una de las lineas de negocio engloben los componentes asociados a la misma. De esta forma cuando un cliente accede a la aplicación tan solo se le cargarán los componentes asociados a su línea. Esto es la difusión en módulos o factorización

Inicialmente las aplicaciones de angular están divididas de la siguiente forma:

- App-module:
	- declara los componentes AppComponent y todos aquellos que serán cargados de forma inicial
	- importa el módulo de rutas
- App.routing.module 
	- identifica todas las rutas que serán cargadas cuando se llame a un path
- src
	- componentes que forman parte de la aplicación 

Si se quiere factorial por módulos una buena organización sería tener un modulo por cada uno de los componentes, o un módulo que englobe los componentes que forman parte de una línea de negocio

- App-module:
	- declara los componentes AppComponent y todos aquellos que serán cargados de forma inicial. 
	- importa el módulo de rutas. Para aquellos que se cargan de forma diferida se realiza un loadChildren en vez de identificar al componente.
- App.routing.module 
	- identifica todas las ruas que serán cargadas cuando se llame a un path
- src
	- components
		- componenteUno
			- modulo.ts: declara todos los componentes que formarán parte del módulo
			- routing.ts: declara todas las rutas de los componentes que forman parte del módulo

Para ello hay que seguir los siguientes pasos:

1. Se una aplicación que tiene tres componentes: compouno, compodos y comohome. Sus módulos de carga y rutas son los siguientes

````
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ComponenteUnoComponent } from './components/componente-uno/componente-uno.component';
import { ComponenteDosComponent } from './components/componente-dos/componente-dos.component';
import { ComponenteHomeComponent } from './components/componente-home/componente-home.component';


@NgModule({
  declarations: [
    AppComponent,
    ComponenteUnoComponent,
    ComponenteDosComponent,
    ComponenteHomeComponent,
    ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
````


````
import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { ComponenteUnoComponent } from "./components/componente-uno/componente-uno.component";
import { ComponenteDosComponent } from "./components/componente-dos/componente-dos.component";
import { ComponenteHomeComponent } from "./components/componente-home/componente-home.component";
import { CompolazyDosComponent } from "./components/compolazy-dos/compolazy-dos.component";

const routes: Routes = [
  { path: "compouno", component: ComponenteUnoComponent },
  { path: "compodos", component: ComponenteDosComponent },
  { path: "compohome", component: ComponenteHomeComponent },
  { path: "", redirectTo: "compohome", pathMatch: "full" },
  { path: "**", component: ComponenteHomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}

````


2. Se crean un componente que no se cargará de forma inicial, sino que lo hará de forma diferida. Para poder hacer esto hay que crear el componente y el módulo asociado al mismo. Para ello:

````
ng g c components/compolazy-uno
ng g m components/compolazy-uno --routing
````

Esto creará un componente con los archivos asociados y un modulo (tanto de carga como de rutas) con el siguiente código

````
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CompolazyUnoRoutingModule } from './compolazy-uno-routing.module';
import { CompolazyUnoComponent } from './compolazy-uno.component';

@NgModule({
  declarations: [CompolazyUnoComponent],
  imports: [
    CommonModule,
    CompolazyUnoRoutingModule
  ]
})
export class CompolazyUnoModule { }

````
En la parte de declaraciones es necesario incluir todos aquellos componentes que este modulo vaya a utilizar. De lo contrario los componentes no podrán ser mostrados
````
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CompolazyUnoComponent } from './compolazy-uno.component';

const routes: Routes = [{path: '', component: CompolazyUnoComponent}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CompolazyUnoRoutingModule { }

````

Este archivo es muy parecido al general de rutas, con la diferencia que en las importaciones se llama al método forChild ya que no se tratan de rutas primarias sino que son secundarias. 

En el array de rutas, al definir los objetos el path debe ponerse como ````''```` ya que será identificada en el general

3. Indicar en el modulo de rutas generales cual es el componente que se cargará en diferido, importando el módulo creado en el punto anterior

````
{
 path: `/compolazyuno`,
 loadChildren: () => import(`./components/componente-uno.module`).then(m => m.ComponenteUnoModule)
}
````

En el path se indica la llamada que se realizará cuando se quiera cargar el componente. En loadChildren se importará el modulo creado en el punto anterior.

Para poder comprobar que la carga diferida se realiza de forma correcta se pueden ver en las herramientas de desarrollador la carga de cada uno de los archivos en cada momento.

****

##### Paso de parámetros entre rutas

Para poder pasar datos mediante la ruta, se realiza mediante construcción de URL donde la estructura sería la siguiente:
````
http://localhost:4200/path/datoPasar/datoPasar
````

De esta forma el routerLink o router (tal y como se vio en el punto anterior) navegará hasta el componente cuyo path es el indicado y le pasará los datos que se introduzcan en la URL. Para que esto funcione, la ruta declarada en el módulo de rutas debe admitir parámetros con la siguiente estructura:
````
{ path: "nombrePath", component: componenteCargar },
{ path: "nombrePath/:parámetro", component: componenteCargar },

````

Como se puede ver en el ejemplo el componente indicado podrá ser accedido tanto con parámetros como sin ellos. Del mismo modo se pueden pasar más de un parámetro mediante esta forma:

````
{ path: "nombrePath/:parametro/:parametro", component: componenteCargar },
````

Esto se puede hacer tanto desde el código html como desde el código ts. Para este ejemplo se va a utilizar los componentes ya definidos en la aplicación, agregándoles la posibilidad de recibir parámetros. Se modificará el menú realizado para que existe un desplegable con las dos opciones:

- sin parámetros (lo explicado hasta ahora)
- con parámetros

````
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  Fútbol
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" >Sin parámetros</a>
                    <a class="dropdown-item" >Con parámetros </a>
                </div>
            </li>
````


Los pasos a seguir son los siguientes

1. Declarar en el módulo de rutas un objeto que incluya la posibilidad de admitir parámetros.

````
{ path: "compodest/:id", component: ComponeneteDestinoComponent }
````

Esto quiere decir que al componente destino creado se le podrá pasar un dato cuyo nombre es 'id'. Este nombre es importante ya que será el utilizado para recuperar el dato en el componente destino. Para el ejemplo se utilizará lo siguiente

````
  { path: 'futbol', component: FutbolComponent },
  { path: 'futbol/:id', component: FutbolComponent },

````

De esta forma se podrá llegar al componente de ambas maneras.


Dependiendo de como se quiera hacer, el código cambiará

**Desde html**

1. Si lo que se quiere es pasar un dato estático, directamente se indica desde el routerLink del li el dato que se quiere pasar guardando la sintaxis declarada en el módulo de rutas. 
````
<div class="dropdown-menu" aria-labelledby="navbarDropdown">
	<a class="dropdown-item" [routerLink]="['/futbol']" routerLinkActive="router-link-active">Sin parámetros</a>
	<a class="dropdown-item" [routerLink]="['/futbol',4]" routerLinkActive="router-link-active">Con parámetros </a>
</div>

````
En el primer caso se abrirá un nuevo componente sin paso de parámetros
En el segundo caso se abrirá un nuevo componente al cual se le pasa un dato cuyo valor es 4

**Desde ts**
1. En el botón declarado se incluye un evento el cual se asocia a un método de la parte lógica
````
<div class="dropdown-menu" aria-labelledby="navbarDropdown">
	<a class="dropdown-item" routerLinkActive="router-link-active" (click)="navegarParametros()">Sin parámetros</a>
	<a class="dropdown-item" routerLinkActive="router-link-active" (click)="navegarParametros(4)">Con parámetros </a>
</div>

````

Como en este ejemplo se puede hacer con / sin parámetros, se declara el evento click para los dos elementos, donde uno pasará como parámetro aquello que se quiera enviar a la ruta y el otro pasará vacío

2. Se declara el método en la parte lógica. Para poder realizar la navegación se utiliza la variable de tipo Router explicada en puntos anteriores. Al tener que pasar datos, en el método navigate se incluyen en forma de array todos los datos que se deben pasar
````
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu-barra',
  templateUrl: './menu-barra.component.html',
  styleUrls: ['./menu-barra.component.css'],
})
export class MenuBarraComponent implements OnInit {
  constructor(private navegador: Router) {}

  ngOnInit(): void {}

  navegar() {
    this.navegador.navigate(['libros']);
  }

  navegarParametros(parametro?) {
    if (parametro) {
      this.navegador.navigate(['videojuegos', parametro]);
    } else {
      this.navegador.navigate(['videojuegos']);
    }
  }
}

````

De esta forma se pasará al componente asociado al path el dato 4 cuando hay parámetro, en el caso de no haber nada pasará al componente directamente

En el caso de querer pasar un elemento que está dentro de un cuadro de texto, se puede hacer de múltiples formas. Utilizando una variable de referencia sería:

1.  Declarar el elemento desde el que se recogen los datos y asociarle un nombre mediante el carácter #
````
<input type="text" #nombreMandar placeholder="Introduce dato a mandar"> <br/>

````

2.  Declarar el elemento que producirá el evento de navegación. Asociarle un método que reciba como parámetros el dato que se recoge desde el elemento del punto 1.

````
<button type="button" class="btn btn-primary" (click)="mandarDatosForm(nombreMandar.value)">Mandar datos por programación</button>

````

3.  En crear el método asociado del punto 2 y utilizar la variable de tipo Router para navegar al componente deseado

````
  mandarDatosForm(dato: string){
    //console.log(dato);
    this.navegador.navigate(['compodest', dato]);
  }
````

*Al igual que se están pasando capturados de inputs o indicados directamente, también se pueden pasar datos que estén guardados en variables de la parte lógica*

````
<button type="button" class="btn btn-primary" [routerLink]="['/compodest',datoPasar]" routerLinkActive="active">Mandar datos</button>
````
````
import { Component } from '@angular/core';
import { Router, RouterState } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  datoPasar:number=3;
}

````

****
**Captura de parámetros**

Una vez se ha realizado el envío de parámetros mediante una ruta, el siguiente paso lógico es recogerlo. Para ello es importante saber cuál es el nombre con el que se ha mandado el parámetro. En el ejemplo anterior, en el módulo de las rutas se configuró la ruta con parámetros de la siguiente forma: 
````
  { path: 'futbol/:id', component: FutbolComponent },
````

Esto quiere decir que al componente cuyo path es futbol se le agrega un parámetro que va asociado a la clave id. Esta clave es la necesaria para poder recuperar el dato. Para ello se utiliza el módulo ActivatedRoute con sus métodos snapshot.paramMap.params. a 
````
console.log(this.rutaActiva.snapshot.paramMap.params['id']);
````

Para poder hacer esto se necesita una variable en el componente destino de tipo ActivatedRoute, desde la cual acceder a los métodos mencionados. Para ello (suponiendo que se ha mandado un dato desde otro componente mediante la ruta):

1. Declarar en el constructor del componente destino una variable de tipo ActivatedRoute
````
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-juegos',
  templateUrl: './juegos.component.html',
  styleUrls: ['./juegos.component.css']
})
export class JuegosComponent implements OnInit {

  constructor(private rutaActiva: ActivatedRoute) { }

  ngOnInit(): void {
    console.log(this.rutaActiva.snapshot.paramMap.params['id']);
  }
````

La variable ActivatedRouter proporciona la siguiente información:

- url: Un Observable del path (o paths) de la ruta, representado como un array de strings para cada parte del path.
- data: Un Observable que contiene el objeto data proporcionado por la ruta.
- param: obsoleto. Hay que utilizar paramMap.
- paramMap: Un Observable que contiene un Map de los parámetros opcionales y obligatorios de la ruta.
- queryParam: obsoleto. Hay que utilizar queryParamMap.
- queryParamMap: Un Observable que contiene un Map de todos los query param disponibles para todas las rutas.
- fragment: Un Observable del URL fragment disponible para todas las rutas.
outlet: El nombre del RouterOutlet utilizado para renderizar la ruta. A un outlet sin nombre, se le asigna el nombre *primary.
- routeConfig: La configuración utilizada para la ruta.
- parent: El objeto ActivatedRoute del "padre" cuando la ruta actual es una ruta "hija".
- firstChild: El objeto ActivatedRoute de la primera de las rutas "hijas" de la ruta actual.
- children: Contiene todas las rutas "hijas" activadas por la ruta actual.

Inicialmente esta forma de capturar parámetros funciona perfectamente. Hay que tener en cuenta que este parámetro debería ser capturado en el método OnInit, de forma que esté disponible cuando el componente este inicializado

````
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-juegos',
  templateUrl: './juegos.component.html',
  styleUrls: ['./juegos.component.css']
})
export class JuegosComponent implements OnInit {

  constructor(private rutaActiva: ActivatedRoute) { }

  ngOnInit(): void {
    console.log(this.rutaActiva.snapshot.paramMap.params['id']);
  }

}

````

Sin embargo esto puede no funcionar siempre. Imaginad el caso en el que el componente cambia internamente y el parámetro pasado es cambia en un momento dado. Con la técnica anterior el cambio no queda registrado ya que tan solo se ha accedido a un snapshot, que más o menos es como una fotografía del momento. Para que pueda funcionar con cambios se utiliza la suscripción a los parámetros. 

````
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-juegos',
  templateUrl: './juegos.component.html',
  styleUrls: ['./juegos.component.css'],
})
export class JuegosComponent implements OnInit {
  constructor(private rutaActiva: ActivatedRoute) {}

  ngOnInit(): void {
    this.rutaActiva.paramMap.subscribe((parametros: Params) => {
      console.log(parametros.id);
    });
  }
}

````

El método subscribe es un observable que permite notificar cambios en el momento en que estos son producidos. Para ello se crea una función de flecha que tiene como paramentos los propios parámetros y se pueden utilizad como se quieran. 

En el caso de utilizar esta suscripción a los parámetros de la URL se debería quitar esta suscripción en el método OnDestroy

Además de poder capturar los elementos de una ruta mediante el módulo ActivatedRouter, también es posible gestionar los eventos que la navegación produce. Para ello se utiliza el módulo Router y la subscripción a los eventos que puede producir, los cuales son:

- NavigationStart: Se lanza cuando comienza la navegación.
- NavigationEnd: Se lanza cuando la navegación termina satisfactoriamente.
- NavigationCancel: Se lanza cuando la navegación se cancel. Esto ocurre cuando el Route Guard devuelve un valor "false" durante la navegación.
- NavigationError: Se lanza cuando la navegación falla.

Para poder subscribirse a los eventos que produce la navegación: 
````
export class ComponeneteDestinoComponent implements OnInit {
  constructor(private manejoRutas: ActivatedRoute, private rutas: Router) {}

  ngOnInit() {
    console.log(this.manejoRutas.snapshot.paramMap.get("id"));
    let claves = this.manejoRutas.snapshot.params.id;
    console.log(claves);

    this.rutas.events.subscribe(evento => {
      if (evento instanceof NavigationStart) {
        console.log('navegación empezada');
      } else if (evento instanceof NavigationEnd) {
        console.log('navegación terminada');
      }
    });
  }
}

````

****
# Comunicación entre componentes (sin rutas)

Del mismo modo que podemos comunicar dos componentes mediante una ruta, en muchos de los casos no es necesaria la utilización de rutas para poder comunicar elementos. Los escenarios que nos podemos encontrar por ejemplo son:
- La comunicación se produce entre la parte lógica y la parte gráfica del mismo elemento
- Los componentes están los dos en la misma pantalla, por lo que la acción de uno repercute en la acción del otro
- Se quiere que la acción de un componente actúe sobre otro componente pero sin necesidad de navegar hasta el segundo, tan solo modificando datos del destino

Si se piensa un poco se pueden sacar multitud de escenarios donde es necesaria la comunicación pero no es necesaria la navegación. Nos vamos a centrar en dos casos, los cuales tienen el mismo escenario: existencia de dos elementos, uno mostrado dentro del otro. 

- Componente Root
	- Componente Padre
		- Componente Hijo

Los casos en los que nos vamos a centrar son la comunicación padre -> hijo y la comunicación hijo -> padre

Para preparar el ejemplo se crean los componentes y se configuran las plantillas

````
ng g c components/componente-padre
ng g c components/componente-hijo
````

````
// componente-padre html
<h1>Componente padre</h1>
````
````
// componente-hijo html
<h2>Componente hijo</h2>
````

````
// app module
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ComponentePadreComponent } from './components/componente-padre/componente-padre.component';
import { ComponenteHijoComponent } from './components/componente-hijo/componente-hijo.component';

@NgModule({
  declarations: [
    AppComponent,
    ComponentePadreComponent,
    ComponenteHijoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

````

````
// app component html
<!--The content below is only a placeholder and can be replaced.-->
<div style="text-align:center">
    <app-componente-padre></app-componente-padre>
</div>
````

No es necesario configurar rutas ya que no se va a utilizar navegación


**Comunicación padre hijo**

En este caso la comunicación se producirá desde el componente padre hasta el componente hijo. Hay que tener en cuenta que para que esto puede ser posible el hijo deberá de estar dentro del padre y utilizar un decorador @Input. Para ello el código de la parte gráfica del padre será la siguiente:

````
// componente padre html
<h1>Componente padre</h1>
<app-componente-hijo></app-componente-hijo>
````
De esta forma el componente hijo será mostrado dentro del componente padre. El siguiente paso es utilizar el decorador @Input en el destino de la comunicación. En el ejemplo será el componente hijo, donde se declara una variable acompañada del decorador @Input, lo que le indica que esa variable podrá ser asociada a un valor desde fuera del componente (siempre y cuando el componente desde donde se asigna el valor tenga alguna relación)
````
// componente hijo ts
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-componente-hijo',
  templateUrl: './componente-hijo.component.html',
  styleUrls: ['./componente-hijo.component.css']
})
export class ComponenteHijoComponent implements OnInit {

  @Input() datoRecibido;

  constructor() { }

  ngOnInit() {
  }

}

````
Una vez está declarada en la parte lógica, podrá ser utilizada en la parte gráfica
````
// componente hijo html
<h2>Componente hijo</h2>
<p>El dato recibido es: {{datoRecibido}}</p>
````

Hasta este momento el componente destino está preparado para recibir información. Lo siguiente que es necesario es el envío desde el componente origen. Para ello en el componente padre, se incluye un atributo dentro de la etiqueta del componente destino cuyo nombre es el de la variable que tiene el decorador @Input del propio componente

````
<h1>Componente padre</h1>
<app-componente-hijo datoRecibido = "dato para pasar"></app-componente-hijo>
````

De esta forma en el componente hijo se asociará el valor pasado y será mostrado en la parte gráfica. En este caso se ha pasado un dato inline, es decir un dato estático. En el caso de querer pasar un dato que está asociado a una variable declarada en la parte lógica del componente padre se puede hacer mediante binding

````
// componente padre ts
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-componente-padre",
  templateUrl: "./componente-padre.component.html",
  styleUrls: ["./componente-padre.component.css"]
})
export class ComponentePadreComponent implements OnInit {
  datoParaHjjo: string;

  constructor() {}

  ngOnInit() {}

}

````
````
// componente padre html
<h1>Componente padre</h1>
<app-componente-hijo [datoRecibido]="datoParaHjjo"></app-componente-hijo>
````

**Comunicación hijo padre**

Para pode comunicar un componente hijo con un componente padre se realiza mediante un decorador @Output. Para ello lo primero que se debe cumplir es que el elemento hijo esté reverenciado mediante su etiqueta selector dentro del componente padre. En el ejemplo anterior teníamos dos componentes (componente-hijo y componente-padre), donde se tenían los soguientes html:
````
// app-root

<!--The content below is only a placeholder and can be replaced.-->
<div style="text-align:center">
    <app-componente-padre></app-componente-padre>
</div>
````

````
// componente padre html
<h1>Componente padre</h1>

<input type="text" placeholder="Por favor introduce tu nombre" #nombre />
<button (click)="comunicarComponente(nombre.value)">Mandar nombre</button>
<div id="comprobacion" *ngIf="algo">
    <div class="alert alert-danger" role="alert">
        no se estra pasando nada
    </div>
</div>
<app-componente-hijo [nombreRecibido]="datoParaHjjo"></app-componente-hijo>
````

````
// html componente hijo
<h2>Componente hijo</h2>
<p>El nombre recibido es: {{nombreRecibido}}</p>
````

Con este código el componente padre le comunicaba un dato al componente hijo. Para el siguiente ejemplo se obviará todo el código de dicha comunicación por lo que el resultante será:
````
// componente padre html
<h1>Componente padre</h1>
<app-componente-hijo ></app-componente-hijo>
````

````
// html componente hijo
<h2>Componente hijo</h2>
````
Como se ha mencionado antes, la comunicación en este caso se dará en sentido ascendente, es decir que un dato que esté presente en el componente hijo se pasará al componente padre. Para ello se siguen los siguientes pasos:

1. En la parte lógica del componente donde esta el elemento que se quiere comunicar (en este caso en el componente hijo) se declara una variable de tipo EventEmitter con el decorador @Output. 
````
// componente hijo ts
export class ComponenteHijoComponent implements OnInit {

  @Input() nombreRecibido;
  @Output() respuesta = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

}
````

Una cosa muy importante a tener en cuenta es la importación del objeto de tipo EventEmitter, que viene de la librería angular/core, no de events

````
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

````


2. Cuando se quiera realizar la comunicación, se utiliza el método emiti del objeto creado en el punto anterior
````
export class ComponenteHijoComponent implements OnInit {

  @Input() nombreRecibido;
  @Output() respuesta = new EventEmitter();

  constructor() { }

  ngOnInit() {
    this.respuesta.emit("constestación");
  }

}
````

En este caso se ha producido la comunicación cuando el componente se ha iniciado. En el caso de querer realizar la comunicación cuando se pulse un botón, sería tan sencillo como escribir el código del método emit en el método asociado al evento

3. Para poder recoger el dato pasado, en la parte gráfica del destino de la comunicación (en este caso el componente padre) se utiliza un binding en la etiqueta del componente hijo, igualándola a un método que admite como parámetro un evento
````
// componente padre html 
<h1>Componente padre</h1>

<
<app-componente-hijo respuesta)="procesarRespuesta($event)"></app-componente-hijo>
````

4. En la parte lógica del destino de la comunicación (en este caso el componente padre) se declara el método creado en en punto anterior. El evento pasado es el propio dato que se comunicó en el punto 2
````
// componente padre ts
export class ComponentePadreComponent implements OnInit {
  datoParaHjjo: string;
  algo: boolean = false;
  datoRespuesta: string;

  constructor() {}

  ngOnInit() {

  }

  procesarRespuesta(event) {
    this.datoRespuesta = event;
    console.log(event);
  }
}
````

En este caso no es necesario meter el método en el ngOnInit ya que se ejecutará desde la linea de código asociada al hijo, por lo que se hará de forma instantánea. 

De esta forma se podrán comunicar los componentes entre sí de una forma sencilla. Sin embargo, para la mayoría de situaciones esto no es suficiente, ya que lo que realmente ayuda es el uso de los servicios. De hecho, se recomienda una buena práctica el aislar a todos los componentes de las funciones lógicas, tan solo dejándoles con la funcionalidad gráfica

****

# Servicios

Los servicios en Angular se pueden definir cómo aquellos elementos capaces de **proveer** a componentes de datos y lógica. Como se verá a continuación, los servicios no dejan de ser clases al uso pero que van acompañadas del decorador @Injectable de la librería core. Esto quiere decir que la clase que representa el servicio podrá ser inyectada como dependencia en todos aquellos sitios que sea necesaria. 

Para poder crear un servicio se utiliza el comando 
````
ng g s services/futbolData
````

Lo cual genera una clase con el siguiente código:
````
import { Injectable } from '@angular/core';
import { Liga } from '../utils/ligas';

@Injectable({
  providedIn: 'root',
})

  constructor() {}

  
}


````

Con el paso anterior el servicio está creado, y puede ser utilizado por cualquier elemento que esté cargado desde el root. Por defecto el servicio es inyectado en el componente root. De esta forma de trabajar puede parecer beneficiosa ya que es muy sencillo, sin embargo cuando estamos hablando de elementos que son muy grandes el tiempo de carga se empieza a ver afectado. En el caso de que el servicio sea utilizado por varios componentes se puede dejar inyectado en el root. En el caso de ser utilizado solo por algunos módulo, el servicio sería inyectado en las dependencias del módulo concreto

````
@NgModule({
  declarations: [
    AppComponent,
    FutbolComponent,
    JuegosComponent,
    MenuBarraComponent,
    LibrosComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, SecundarioModule],
  providers: [FutbolDataService],
  bootstrap: [AppComponent],
})
export class AppModule {}


````

Como se ha dicho anteriormente, un servicio es utilizado para la gestión de los datos de la aplicación. Para ello se va a realizar un ejemplo donde se cargarán datos de un objeto Liga al pulsar en el menú Futbol. Si no se pasan parámetros se cargarán todas las ligas. En el caso de pasar algún parámetro se cargará solo la liga que cumpla con el parámetro pasado.

1. Crear la interface para la creación del objeto
````
export interface Liga {
    id: number;
    nombre: string;
    pais: string;
    logo: string;
}
````

Sería una buena práctica que todas las clases que representen utilizades queden enmarcadas en una carpeta cuyo nombre es utils. En este case se opta por una interfaz pero se puede utilizar una clase al uso si además de crear el objeto se necesitan métodos getter, setter, etc...

2. Crear un servicio y declararlo como provider en el módulo donde va a ser utilizado
````
ng g s services/futbolData
````

````
import { Injectable } from '@angular/core';
import { Liga } from '../utils/ligas';

@Injectable({
  providedIn: 'root',
})

  constructor() {}

  
}
````

````
@NgModule({
  declarations: [
    AppComponent,
    FutbolComponent,
    JuegosComponent,
    MenuBarraComponent,
    LibrosComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, SecundarioModule],
  providers: [FutbolDataService],
  bootstrap: [AppComponent],
})
export class AppModule {}

````


3. En el servicio crear un array de objetos. Del mismo modo crear un método que devuelva dicho array de objetos
````
import { Injectable } from '@angular/core';
import { Liga } from '../utils/ligas';

@Injectable({
  providedIn: 'root',
})
export class FutbolDataService {
  ligas = [
    {
      id: 1,
      nombre: 'La Liga',
      pais: 'España',
      logo:
        'https://3.bp.blogspot.com/-8D_PYiuqhiw/VeSXbIfc_MI/AAAAAAAAAM4/XRzqhoZ6Y2k/s1600/LigaBBVA.png',
    },
    {
      id: 2,
      nombre: 'Premiere League',
      pais: 'Inglaterra',
      logo:
        'https://2.bp.blogspot.com/-4tg1eX1A_pY/WVOHis9gtWI/AAAAAAABKB8/gFWgwyWBjjUiP9IaqHibaD1iRh10B4sXQCLcBGAs/s1600/Premier%2BLeague.png',
    },
    {
      id: 3,
      nombre: 'Serie A',
      pais: 'Italia',
      logo:
        'https://3.bp.blogspot.com/-1wJdeqXqXGU/WPFobp4_h3I/AAAAAAAAA2Y/JDAb0rJGboQGfnztRrnhxyBJh4e_D-NogCLcB/s1600/Serie%2BA%2BTIM%2BLogo.png'
    }
  ];

  constructor() {}

  getLiga(id: number): Liga[] {

    let ligasFiltradas = [];

    this.ligas.forEach(element => {
      if (element.id == id){
        ligasFiltradas.push(element);
      }
    });

    return ligasFiltradas;
  }

  getLigas(): Liga[] {
    
    return this.ligas;
  }
}

````

Adicionalmente se crea un método que reciba por parámetros un número y filtre de la lista de ligas aquella que tiene el id del parámetro pasado. Estos dos métodos serán los llamados por el componente futbol cuando se allamado

4. En el componente donde son necesarios los datos, crear en el constructor una variable del tipo del servicio para que pueda ser utilizada en la clase
````
import { Component, OnInit } from '@angular/core';
import { FutbolDataService } from '../../services/futbol-data.service';
import { Liga } from '../../utils/ligas';
import { ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-futbol',
  templateUrl: './futbol.component.html',
  styleUrls: ['./futbol.component.css'],
})
export class FutbolComponent implements OnInit {
  ligas: Liga[];
  id;

  constructor(
    private servicioFutbol: FutbolDataService,
    private rutaActiva: ActivatedRoute
  ) {}

  ngOnInit(): void {

  }
}

````

5. En el método ngOnInit (cuando el componente se cargado) llamar al método que devuelve el array de objetos desde la variable de tipo servicio 
````
import { Component, OnInit } from '@angular/core';
import { FutbolDataService } from '../../services/futbol-data.service';
import { Liga } from '../../utils/ligas';
import { ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-futbol',
  templateUrl: './futbol.component.html',
  styleUrls: ['./futbol.component.css'],
})
export class FutbolComponent implements OnInit {
  ligas: Liga[];
  id;

  constructor(
    private servicioFutbol: FutbolDataService,
    private rutaActiva: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.rutaActiva.paramMap.subscribe((paramentros: ParamMap) => {
      this.id = paramentros.get('id');
    });

    //console.log(this.id);
    
    if (this.id){
      this.ligas = this.servicioFutbol.getLiga(this.id);
    } else {
      this.ligas = this.servicioFutbol.getLigas();
      console.log(this.ligas);
    }
  }
}

````

Es importante tener en cuenta que se utiliza la suscripción al paramMap para que se tenga la posibilidad de capturar cualquier cambio que se realiza en los parámetros pasados.

6. En el caso de querer mostrarlos todos en una lista de la parte gráfica, utilizar el array de la clase.
````
<div class="card-deck">
    <div class="card" *ngFor="let liga of ligas">
        <img [src]="liga.logo" class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">{{liga.nombre}}</h5>
            <button class="btn btn-primary btn-block">Ver detalle</button>
        </div>
        <div class="card-footer">
            <small class="text-muted">{{liga.pais}}</small>
        </div>
    </div>
</div>
````

Del mismo modo se pueden agregar métodos en el servicio que sirvan de funcionalidad adicional, como por ejemplo búsquedas, mostrado de datos de forma específica, etc ...

En el ejemplo comentado se ha visto como se puede utilizar un servicio para realizar consultas y manejo de datos pero hechas de forma síncrona (es decir en una sola dirección) que no tardan nada en constar. En la mayoría de los casos los servicios se utilizan para consultar servidores cuya respuesta puede que no sea inmediata, no sabiendo de antemano cuando va a tardar. Para eso se utilizan las promesas, las cuales permiten realizar una tarea en 2º plano mientras que el usuario puede continuar utilizando elementos de la aplicación. Si recordamos la estructura de una promesa vista en los primeros temas: 
````
let promesa = new Promise<TipoRetorno>(function(resolve, reject) { // código a ejecutar});
````

Esto quiere decir que cuando la promesa sea creada se ejecutará la función que la forma (función de flecha) pudiendo obtener una respuesta positiva (ejecutada mediante el método then correspondiente a resolve) o una respuesta negativa (ejecutada mediante el método catch correspondiente a reject). El tipo retorno n les obligatorio, pero si muy recomendable ya que será el tipo del valor en la contestación positiva.

````
elemento: boolean = false;
let promesa = new Promise<string>(function(resolve,reject) => {
	if (elemento){
		resolve("El elemento está presente");
	} else {

		reject("El elemento no está presente");
	}
});
````

Esto quiere decir que cuando la variable elemento sea verdadera, la promesa ejecutará el caso resolve mandando un mensaje "El elemento está presente" (de tipo string, indicado en el tipo de la promesa). En caso negativo la promesa ejecutaré el caso resolve.

Cuando esta promesa sea utilizada tendrá la siguiente estructura

````
promesa.then(resolve=>{}).catch(reject=>{});
````

Resolve y reject tomarán el valor del mensaje lanzado en la promesa

Lo normal es que las promesas sean lanzadas desde un método de un servicio, que a su vez es llamado desde el constructor de la clase

Para el ejemplo visto antes, si se quieren retornar todos los coches mediante una promesa llamada desde el servicio creado.


1. Se crea la promesa indicando que el tipo de retorno es array de objetos. Esta se incluye en un método que retorna la promesa. 

````
export class CocheService {
  coches: Coche[] = [
    { marca: "Ford", modelo: "Mustang", cv: 320, matricula: "3345HYG" },
    { marca: "Volkwagen", modelo: "Gof GTI", cv: 220, matricula: '2335POI' },
    { marca: "Seat", modelo: "León", cv: 150, matricula: '1235fas' }

  ];

  constructor() {}

  cargarCoches(): Promise<Coche[]> {
    let promesaCarga = new Promise<Coche[]>((resolve, reject) => {
      if (this.coches) {
        resolve(this.coches);
      } else {
        reject("No se han podido cargar los datos")
      }
    });
    return promesaCarga;
  }
}

````


En la parte de resolve se retorna el array completo. En la parte de reject se retorna un mensaje de error. 

3. En la clase ts del componente donde va a ser llamada la promesa, se llama al método asociado al servicio.

````
import { Component, OnInit } from "@angular/core";
import { Coche } from "../../utils/coche";
import { CocheService } from "../../services/coche.service";

@Component({
  selector: "app-componente-servicio",
  templateUrl: "./componente-servicio.component.html",
  styleUrls: ["./componente-servicio.component.css"]
})
export class ComponenteServicioComponent implements OnInit {
  coches: Coche[];

  constructor(private servicioCoches: CocheService) {}

  ngOnInit() {
    //this.coches = this.servicioCoches.getAllCoches();
    this.servicioCoches
      .cargarCoches()
      .then(resolve => (this.coches = resolve))
      .catch(reject => console.log(reject));
  }
````

En la llamada al método se utilizan los métodos then y catch, donde se obtiene de cada uno los elementos que contestan (en este caso el array de objetos y el mensaje de error)

En muchas ocasiones, el uso de las promesas puede que no sea suficiente por varios motivos: 
- Son ejecutadas en el momento en el que la promesa ha sido creada
- Cuando son ejecutadas no pueden ser canceladas en ningún momento, tan solo terminadas con el valor de retorno correspondiente.

Para paliar este tipo de limitaciones Angular propone el uso del patrón observer de la librería RxJS. Estos elementos además de realizar tareas de forma asíncrona, tienen la capacidad de escuchar todos los cambios que se produzcan en la fuente de datos. De esta forma si mediante un observable nos subscribimos a una fuente de datos y esta añade elementos nuevos, automáticamente nos será notificado evitando que se realicen sucesivas consultas a la fuente de origen. Los principales elementos dentro de la programación mediante observables son:
Los componentes principales de este patrón son:

- Observable: Es aquello que queremos observar, que será implementado mediante una colección de eventos o valores futuros. Un observable puede ser creado a partir de eventos de usuario derivados del uso de un formulario, una llamada HTTP, un almacén de datos, etc. Mediante el observable nos podemos suscribir a eventos que nos permiten hacer cosas cuando cambia lo que se esté observando.
- Observer: Es el actor que se dedica a observar. Básicamente se implementa mediante una colección de funciones callback que nos permiten escuchar los eventos o valores emitidos por un observable. Las callbacks permitirán especificar código a ejecutar frente a un dato en el flujo, un error o el final del flujo.
- Subject: es el emisor de eventos, que es capaz de crear el flujo de eventos cuando el observable sufre cambios. Esos eventos serán los que se consuman en los observers.

Los flujos de datos o stream, representan los datos que están presentes en la fuente original que es "vigilada". Esta fuente de datos puede estar representada desde un simple array, hasta un json completo pasando por una variable de tipo string.

Con los elementos vistos anteriormente, se pude decir que un observable es un stream (flujo de datos) al que podemos suscribir observers que reaccionan cuando se emiten datos (cambios, fallos, etc...).

En código, para poder crear un observable se sigue la siguiente estructura:
````
let myObservable = Rx.Observable.create( observer => {observer.next('cambios');}
);
````
Donde dentro del método créate se crea una función de flecha donde se indica el comportamiento del observable. Los métodos que se pueden identificar son: next, complete y error.

Una vez creado el observable se pueden crear observers que se subscriban al observable. Estos nuevos observables obtendrán el parámetro pasado en le funciona de next, en nuestro caso el parámetro cambios
````
let myObserver = myObservable.subscribe(
(msg)=> {
console.log(`Observable resuelto ${msg}`);
}
);
````

Cuando se crea un observable, del mismo modo que se ha ejecutado el método next(), también se pueden ejecutar dos métodos más para indicar que se ha producido un error o se ha completado la tarea
````
let observable = Rx.Observable.create(
	(observer)=> {
		try {
			observer.next(1);
		} catch(error) {
			observer.error(error);
		}
		observer.complete();
	}
);
````

De esta forma, cuando se crea un observer también se indican las tres posibles respuestas
````
let observer = observableLifecycle.subscribe(
	(msg)=> {
		console.log(`Observable recibido: ${msg}`);	
	},
	(error)=> {
		console.log(`Algo ha salido mal: ${error}`);
	},
	(msg)=> {
		console.log(`Observable terminado`);
	}
);
````

Para poder mostrar su funcionalidad se va a realizar un ejemplo para la carga de un array de datos (**es importante tener en cuenta que la fuente de los datos puede ser cualquiera**)

1. Definir el modelo de datos que será utilizado

````
export interface Coche {
    marca: string;
    modelo: string;
    cv: number;
}
````


2. En el servicio desde el cual se manejarán los datos, crear un array de elementos

````
export class CocheService {
  coches: Coche[] = [
    { marca: "Ford", modelo: "Mustang", cv: 320, matricula: "3345HYG" },
    { marca: "Volkwagen", modelo: "Gof GTI", cv: 220, matricula: '2335POI' },
    { marca: "Seat", modelo: "León", cv: 150, matricula: '1235fas' }
  ];

  constructor() {}

}
````


3. Crear un método que devuelva un observable creado

````
export class CocheService {
  coches: Coche[] = [
    { marca: "Ford", modelo: "Mustang", cv: 320, matricula: "3345HYG" },
    { marca: "Volkwagen", modelo: "Gof GTI", cv: 220, matricula: '2335POI' },
    { marca: "Seat", modelo: "León", cv: 150, matricula: '1235fas' }

  ];

  constructor() {}

  getCoches(): any {
    const cochesObservable = new Observable(observer => {
      setTimeout(() => {
        try {
          observer.next(this.coches);
        } catch {
          observer.error("Error en la carga");
        }
        observer.complete();
      }, 1000);
    });

    return cochesObservable;
  }
}
````

Con el método creado se consigue que una vez suscrito un agente en el punto siguiente pasen las siguientes cosas:
- cada vez que ocurra un cambio (con la escritura del método next()) se vuelva a pasar el array de coches a los agentes que estén escuchando
- si se produce un error se pase un mensaje de aviso
- se avise cuando la tarea haya sido completada

5. En el componente donde se quiera cargar los datos crear en el constructor una variable del tipo del servicio. 

````
@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent implements OnInit {
  title = "proyectoRutas";

  coches: Coche[];

  constructor(
    private servicioCoches: ObservableService
  ) {}

  ngOnInit(): void {
        
  }

}

````


6. En la parte del código donde se quiere consultar la fuente de los datos crear un objeto de tipo observer. Para ello igualarlo al método creado en el servicio y ejecutar el método subscribe 

````
@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent implements OnInit {
  title = "proyectoRutas";

  coches: Coche[];

  constructor(
    private servicioCoches: ObservableService
  ) {}

  ngOnInit(): void {
    
    let myObserver = this.servicioCoches.getCoches();

    myObserver.subscribe(
      (next) => {
        this.coches = msg
      },
      (error) => {
        console.log(`Algo ha salido mal: ${error}`);
      },
      () => {
        console.log(`tarea terminado`);
      }
    );

    
  }

}

````

Para poder estar avisados del cambio de datos, el método subscribe del observable obtenido del servicio ejecuta los tres métodos creados. Para ello mediante las siguientes funciones de flecha se realiza:
- (next): función asociada a los datos publicados en el método next del observable del servicio.
- (error): función asociada a los datos publicados en el método error del observable del servicio.
- (): función asociada a al método next del observable del servicio.

## Consulta de servicios mediante promesas

En muchas ocasiones la provisión de datos viene de un servicio externo que se ejecuta en un servidor y es mostrado en la aplicación. En la mayoría de los casos se utilizan APIS que realizan una tarea y dan los datos resultantes en un formato JSON. 

Lo primero que hay que tener en cuenta a la hora de realizar peticiones externas es que el servicio creado utilice el módulo de HttpClient, ya que es el que posibilita dicha comunicación. Al ser un módulo externo no vale con ponerlo en el servicio o componente que lo vaya a utilizar, sino también en las importaciones del archivo app.module.ts

Para el ejemplo se va a realizar una consulta al api de deportes thesportdb, y en concreto a la url que muestra todas las competiciones.

````
https://www.thesportsdb.com/api/v1/json/1/all_leagues.php
````

1. Crear el servicio asociado que traerá todos los datos. En el ejemplo se utilizará el servicio creado anteriormente FutbolDataService. En este servicio se creará una variable que sea de tipo httpclient para poder realizar peticiones externas

````
import { Injectable } from '@angular/core';
import { Liga } from '../utils/ligas';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from "rxjs/operators";


@Injectable({
  providedIn: 'root',
})
export class FutbolDataService {
  
  constructor(private conexion: HttpClient) {}
 
}

````

Adicionalmente se importará el módulo httpClientmodule en el archivo app.module

````
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FutbolComponent } from './components/futbol/futbol.component';
import { JuegosComponent } from './components/juegos/juegos.component';
import { MenuBarraComponent } from './components/shared/menu-barra/menu-barra.component';
import { SecundarioModule } from './components/secundario/secundario.module';
import { LibrosComponent } from './components/libros/libros.component';
import { FutbolDataService } from './services/futbol-data.service';
import { HttpClientModule } from '@angular/common/http';
import { ImagenPipe } from './pipes/imagen.pipe';

@NgModule({
  declarations: [
    AppComponent,
    FutbolComponent,
    JuegosComponent,
    MenuBarraComponent,
    LibrosComponent,
    ImagenPipe,
  ],
  imports: [BrowserModule, AppRoutingModule, SecundarioModule, HttpClientModule],
  providers: [FutbolDataService],
  bootstrap: [AppComponent],
})
export class AppModule {}

````

Una vez hecho esto, el servicio esta preparado para realizar peticiones externas

2. En el propio servicio se crea un método llamado getLigasAPI en el cual se realiza la petición con el objeto http creado y el método get()

````
import { Injectable } from '@angular/core';
import { Liga } from '../utils/ligas';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from "rxjs/operators";


@Injectable({
  providedIn: 'root',
})
export class FutbolDataService {
  
  constructor(private conexion: HttpClient) {}

  getLigasAPI() {
    return this.conexion.get(
      'https://www.thesportsdb.com/api/v1/json/1/all_leagues.php'
    );
  }
  
}
````

Este método devuelve un **observable**, ya que los datos pueden cambiar en cualquier momento en la url servida y ser refrescados automáticamente. 

3. El siguiente paso es utilizar este elemento como parte de un componente. Es importante notar que la llamada a este método devuelve un observable, por lo que habría que utilizar el método suscribe para detectar los cambios que se pueden producir

````
import { Component, OnInit } from '@angular/core';
import { FutbolDataService } from '../../services/futbol-data.service';
import { Liga } from '../../utils/ligas';
import { ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-futbol',
  templateUrl: './futbol.component.html',
  styleUrls: ['./futbol.component.css'],
})
export class FutbolComponent implements OnInit {
  ligasServicio: [];
  id;

  constructor(
    private servicioFutbol: FutbolDataService,
    private rutaActiva: ActivatedRoute
  ) {}

  ngOnInit(): void {
   
	this.servicioFutbol.getLigasAPI().subscribe((elementos)=>{this.ligasServicio = elementos['leagues']});

    }

  }
}

````

En el método OnInit, habría que igualar el objeto ligasServicio a los elementos que trae la suscripción al observable. Es importante ver como del parámetros que tiene la función de flecha tan solo se selecciona el elemento que tiene como key la palabra leagues ya que el objeto que se devuelve es el siguiente:
 
````
{
    "leagues": [
        {
            "idLeague": "4328",
            "strLeague": "English Premier League",
            "strSport": "Soccer",
            "strLeagueAlternate": "Premier League"
        },
        {
            "idLeague": "4329",
            "strLeague": "English League Championship",
            "strSport": "Soccer",
            "strLeagueAlternate": "],
     "count":234
}
````


En este caso el filtrado de datos se se produce en la parte del componente, pero también es posible realizarlo desde el lado del servicio y que el componente reciban los datos definitivos.  Para ello se utiliza en el lado del servicio un mapeado de datos 

````
  getLigasAPIFiltrado() {
    return this.conexion
      .get('https://www.thesportsdb.com/api/v1/json/1/all_leagues.php')
      .pipe(
        map((resultado) => {
          return resultado['leagues'];
        })
      );
  }
````
 
Donde el método map retorna el elemento concreto ya filtrado y el método getLigasAPIFiltrado() retorna el observable ya completo para que el componente lo pueda utilizar sin necesidad de filtrarlo.

````
import { Component, OnInit } from '@angular/core';
import { FutbolDataService } from '../../services/futbol-data.service';
import { Liga } from '../../utils/ligas';
import { ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-futbol',
  templateUrl: './futbol.component.html',
  styleUrls: ['./futbol.component.css'],
})
export class FutbolComponent implements OnInit {
  ligas: Liga[];
  ligasServicio: [];
  id;

  constructor(
    private servicioFutbol: FutbolDataService,
    private rutaActiva: ActivatedRoute
  ) {}

  ngOnInit(): void {
   
      this.servicioFutbol.getLigasAPIFiltrado().subscribe((elementos)=>{this.ligasServicio = elementos});
  }
}

````





