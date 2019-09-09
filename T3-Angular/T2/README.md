- [Primer proyecto:](#tema2)
    - Comandos básicos: creación y compilación proyectos
	- Angular y Git
	- Estructura y bloques fundamentales del proyecto.
	- Gestión de módulos y componentes

#### [Volver al índice](#tema2)

Como se ha comentado antes, las instalaciones necesarias para manejar ts eran:

- NodeJs (con el gestor de paquetes npm)
- TypeScrip
- IDE

Dentro de todos los IDEs que están disponibles, uno de los más amigables para el trabajo con TypeScript es VisualStudioCode. Su instalación es muy sencilla ya que no requiere de configuraciones adicionales. Una vez el IDE está instalado si es recomendable instalar una serie de plugins que facilitan el trabajo. Para ello hay que pulsar en el icono de las extensiones (último de la fila que se muestra en la parte izquierda) y seleccionar los siguientes:

- Angular 2 TypeScript Emmet
- Angular Language Service
- Angular Snippets (Version 8)
- Angular v5 Snippets
- angular2-inline
- Bootstrap 4, Font awesome 4, Font Awesome 5 Free & Pro snippets
- HTML CSS Support
- JavaScript (ES6) code snippets
- JS-CSS-HTML Formatter
- jshint
- Material Icon Theme
- Prettier - Code formatter
- Terminal
- TSLint
- TypeScript Hero
- TypeScript Importer

La gran mayoría de las extensiones se encargan mostrar los snippets (atajos de nomenglatura), formateo de código, organización de importaciones - exportaciones , etc...

Además de las herramientas mencionadas, también se debe instalar Angular-cli mediante el comando
````
npm install -g @angular/cli
````

Este comando instalará una herramienta que posibilita entre otras cosas:

- Generar la estructura completa de un proyecto angular (scaffolding).
- Generar nuevos módulos, componentes y servicios a un proyecto angular.
- Arrancar un servidor de desarrollo que automáticamente recompila la aplicación y refresca el browser cuando guardamos los cambios que realizamos en el código.
- Revisa la corrección del código que escribimos (lint)
- Lanza los test
- Construye la aplicación lista para su distribución en producción.

Los comandos que se utilizan para gestionar un proyecto Angular son

````
// crea un nuevo proyecto llamado miApp
ng new miApp
// compila el proyecto situado en la ruta desde donde se ejecuta el comando
ng serve --open
// idéntico al anterior con la personalización del host que lanza el proyecto
ng serve --host 0.0.0.0 --port 4201
````


El proceso de creación de un proyecto Angular es algo lento, dependiendo de la velocidad de conexión y potencia de la máquina dónde se ejecute. 

- Mediante terminal situarse en el directorio donde se quiere crear el proyecto
- Ejecutar el siguiente comando

````
ng new NombreProyecto. 
````

Esto empezará a crear el proyecto, descargando todas las dependencias necesarias. Es posible que se pregunte durante la creación si se quiere añadir el routing de Angular durante la instalación y si se quiere utilizar algún estándar para la gestión de estilos. Esto ayudará bastante a la hora de gestionar el tema de la navegación. 

#### Angular y GitHub

Hoy en día en el mundo del desarrollo el trabajo en equipo es un pilar básico para cualquier proyecto. Por eso trabajar con un control de versiones es básico. Para ello manejar un proyecto GitHub y Angular es básico. 

En el paso anterior se ha explicado cómo crear un proyecto local de Angular. Lo primero más importante a tener en cuenta en cuanto a control de versiones, es que en la creación del mismo ya va incluido un repositorio git (local). Otra cosa que hay que tener en cuenta es que de querer clonar un repositorio Angular ubicado en un gestor de control de versiones, ademas de clonar el repositorio se deben instalar todos los módulos necesarios. Para ello se ejecutan los siguientes comando:

````
// clonar el repositorio
git clone url_código
// instalar las dependencias necesarios
npm install
````

En el caso de tener el proyecto local creado, para poder versionarlo en GitHub hay que seguir los siguientes pasos:

1. Asociar el proyecto de Angular con un proyecto de GitHub creado

````
git remote add origin URL_proyecto_git
````

2. Abrir la vista de comandos. View -- Command Pallete. Seleccionar la opción Push to.. Esto pedirá que se seleccione un repositorio donde se subirán todos los archivos
3. Desde View -- Command Pallete seleccionar la opción Commit All
4. Desde View -- Command Pallete seleccionar la opción Push All

De esta forma el proyecto queda vinculado al repositorio de GitHub. Si se produce algún cambio lo primero que se debería hacer es un Full

1. Desde View -- Command Pallete seleccionar la opción Pull

#### Estructura de un proyecto

Los ficheros más importantes dentro de la estructura base del proyecto son:

- e2e/: end-to-end tests
- node_modules/: módulos de terceros listados en package.json.
- src/: Directorio donde reside la aplicación
- .editorconfig: Configuración para el editor (para intentar que todo el equipo de desarrollo utilice la misma configuración). (http://editorconfig.org)
- .gitignore: archivos a ignorar por Git
- angular.json: Fichero de configuración de angular.
- package.json: Lista de paquetes de terceros que usa el proyecto.
- README.md: Pre-relleno con información sobre comandos de angular.
- tsconfig.json: Configuración para TypeScript para el IDE
- tslint.json: Configuración para TSLint

Dentro de la carpeta src los ficheros más importantes son:

- app/app.component.{ts,html,css,spec.ts}: El componente raíz de la aplicación (archivo typescript, archivo html, archivo css y archivo spec.ts para test).
- app/app.module.ts: Define el módulo AppModule, (el módulo raíz) que le dice a angular cómo ensamblar la aplicación.
- assets/: Directorio para los assets (se copiará tal cual al construir la aplicación).
- environments/: Este directorio contiene un archivo por cada entorno. En él se encuentra la configuración de algunas variables que se utilizan en la aplicación. Por ejemplo, quizás utilices una API REST diferente durante el desarrollo que la que utilizarás en producción, diferentes tokens de analytics, servicios mock... Angular cli elige el fichero adecuado en cada caso.
- browserslist: Fichero de configuración para indicar a las distintas herramientas los target browsers.
- favicon.ico: El icono favicon.
- index.html: El html principal.
- karma.conf.js: Configuración de Karma (para tests unitarios)
- main.ts: El punto de entrada principal de la aplicación.
- polyfills.ts: Cada navegador tiene diferente grado de soporte de los estándares web. Polyfills es una librería javascipt que normaliza esas diferencias. Browser Support Guide.
- styles.css: Estilos css globales de la aplicación.
- test.ts: Punto de entrada principal a los tests unitarios.
- tsconfig.app.json: Configuración del compilador TypeScript para la aplicación angular.
- tsconfig.spec.json: Configuración del compilador TypeScript para los tests unitarios(tsconfig.spec.json).
- tslint.json: Configuración para el TSLint y Codelyzer, utilizados al ejecutar el comando ng lint.

En el caso de haber iniciado el proyecto con el gestor de rutas de Angular también estará presente el archivo app-routing.module.ts que tiene un decorador y un array de rutas (será explicado más adelante). Si se ha dicho que no a la generación de este módulo, se puede hacer manualmente o mediante el comando
````
ng g m app-routing --routing
````

#### Principales elementos

Los principales elementos de los que consta una aplicación de Angular son los: componentes y módulos. 


##### Módulos

Un módulo se puede definir como un aglutinado de componentes. Si estamos trabajando con aplicaciones pequeñas, solamente existirá el módulo raíz. En aplicaciones grandes, es recomendable separar la misma en diferentes módulos según funcionalidades, flujo de trabajo, o alguna otra característica.

En código un módulo es una clase NgModule con un decorador @NgModule. Por defecto está creado un módulo llamado app.module.ts que tiene el siguiente contenido:
````
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';


@NgModule({
  declarations: [
    AppComponent,
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

Cada uno de los elementos declarados dentro del decorador NgModule son:

- declarations: Las view classes que pertenecen a este módulo. Angular tiene 3 tipos de view classes: componentes, directivas, y pipes.
- exports: El subconjunto de declarations que deben ser visibles y utilizables en las plantillas de componente (component templates) de otros módulos que lo importen.
- imports: Lista de módulos importados. Tendremos acceso a los elementos incluidos en el exports del módulo importado.
- providers: Creadores de servicios (services) con los que este módulo contribuye en la colección global de servicios. Son accesibles en cualquier parte de la aplicación
- bootstrap: La vista de aplicación principal (el componente raíz) que alberga al resto de vistas. Solamente el módulo raíz utilizará la propiedad bootstrap. Por defecto se puede ver que la vista que actúa como principal es el AppComponent

Si se quiere crear un módulo se utiliza el comando 
````
ng g m modulo-ejemplo
````

#### Componentes

Se trata del componente más importante y representa la mayor parte del trabajo en angular. Gráficamente se pueden asociar a páginas o partes de una página. Uno de sus principales beneficios es la reutilización ya que en un momento determinado en una SPA desarrollada por Angular se podría estar mostrando al mismo tiempo un componente que se encarga de mostrar un menú con las rutas, otras componente con un listado de elementos que están disponibles dentro de la aplicación, etc....  Esto garantiza tanto la reutilización de código cómo el mantenimiento de la aplicación de una forma mucho más sencilla.

Para poder crear un componente se ejecuta el siguiente comando

````
ng g c nombre-componente
````

Esto generará un componente, el cual está formado por:
- Una clase typescript que tiene el decorador @Component, donde se definen:
	- selector: elemento que será nombrado en el html donde sea utilizado
	- templateUrl: elemento html que representa la parte gráfica del elemento. 
	- styleUrls: elemento css que representa la parte de estios del elemento. Del mismo modo que en la templateUrl, se puede utilizar los caracteres para definirlo en el propio archivo
	- providers: array de proveedores de inyección de dependecias (dependency injection providers) para servicios que este componente necesite. Es una de las maneras de informar a Angular que él constructor de este componente necesita una instancia de un servicio concreto. También se pueden indicar en los constructores cómo se verá más adelante.

**Lo suyo es crear todos los componentes bajo una misma estructura. Para ello se puede crear una carpeta dentro de app que se llame components**

Una vez creado aparecerá dentro de la ruta indicada donde cada uno de los archivos tendrá la siguiente funcionalidad

- componente-ejemplo.component.ts

Se trata del más importante, ya que se encarga de la lógica del componente y de linkar el resto de elementos. Su contenido inicial es:

````
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-componente-ejemplo',
  templateUrl: './componente-ejemplo.component.html',
  styleUrls: ['./componente-ejemplo.component.css']
})
export class ComponenteEjemploComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
````

Dentro del decorador @Component (que indica que se trata de un componente) se encuentra:
- selector: nombre que será utilizado cuando el componente quiera ser mostrado en otro componente, como por ejemplo el inicial
- templateUrl: link del archivo que representa la parte gráfica del componente. En este caso el archivo.css 
- styleUrls: link del archivo que representa los estilos que se aplicarán al componente. En este caso es el archivo .css

En la mayoría de los casos la definición tanto del templateUrl como del styleUrl van a ser punteros a archivos, pero también existe la posibilidad de indicar directamente el código bien html o css en el propio decorador. Tan solo deberían ser utilizados para casos donde los elementos son muy pequeños. En ese caso tendría el siguiente aspecto:
````
@Component({
  selector: 'app-componente-ejemplo',
  template: `
    <h1>Ejemplo</h1>
  `,
  styles: ['h1 { font-weight: normal; }','h2 { color: red; }']
})
````


- componente-ejemplo.component.html

Se trata de código html al uso, donde se indican cada uno de los elementos que serán mostrados en el componente. Como se verá más adelante se puede comunicar la parte gráfica con la parte lógica.

````
<p>componente-ejemplo works!</p>
````

Para facilitar el desarrollo y realizar un despliegue más rápido, se utilizarán las librerías de bootstrap para facilitar todo el aspecto gráfico

- componente-ejemplo.component.css

Se trata de código css al uso, donde se indican cada uno de los estilos que tendrán los elementos. Inicialmente el archivo está vacío 
- componente-ejemplo.component.spec.ts

Archivo donde se indican todas las pruebas de componente que se realizarán. 

````
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponenteEjemploComponent } from './componente-ejemplo.component';

describe('ComponenteEjemploComponent', () => {
  let component: ComponenteEjemploComponent;
  let fixture: ComponentFixture<ComponenteEjemploComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComponenteEjemploComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponenteEjemploComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

````

Al mismo tiempo se deben actualizar dos elementos:
1. **El fichero app-routing.module.ts** encargado de gestionar las rutas de la aplicación (se explicará más adelante), donde se ha incluido en el array de Route la siguiente línea.
````
const routes: Routes = [
  {path: 'componente_ejemplo', component: ComponenteEjemploComponent}
];
````

En esta constante se indica todas las rutas que son gestionadas desde el módulo de rutas. En el objeto se indican el path (que será el nombre utilizado cuando se quiera llamar al elemento en una redirección) y el component (que apuntará al componente que está asociado a ese nombre). Del mismo modo en el modulo de rutas se importará el componente con la siguiente línea

````
import { ComponenteEjemploComponent } from './componentes/componente-ejemplo/componente-ejemplo.component';
````


2. **El fichero module.ts** encargado de indicar cuales son los elementos que se pueden utilizar (entre otras cosas ya que se explicará más adelante). En él se habrá incorporado de forma automática el componente en la parte de declaraciones

````
declarations: [
    AppComponent,
    ComponenteEjemploComponent,
  ]
````

Del mismo modo que en el caso anterior se habrá importado el componente con la siguiente linea
````
import { ComponenteEjemploComponent } from './componentes/componente-ejemplo/componente-ejemplo.component';
````

Una vez hecho todo esto el componente está creado y listo para utilizarse. Es importante tener en cuenta que si no está declarado en el fichero module.ts no podrá ser utilizado aunque el resto de elementos están bien configurados. Para poder utilizarlo (que sea visible en la pantalla) se realizarán los siguientes pasos:

1. Abrir el archivo index.html
````
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>ProyectoBaseRouting</title>
  <base href="/">

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" type="image/x-icon" href="favicon.ico">
</head>
<body>
  <app-root></app-root>
</body>
</html>

````

Se indica que el ````<app-root>```` es el elemento que se está mostrado. Si se abre el archivo app.component.ts se puede ver que este componente tiene como selector app-root
````
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'proyectoBaseRouting';
}
````


2. Abrir el fichero que indica el index que actúa como root, que es el indicado en el punto anterior (app.component.ts)

````
<!--The content below is only a placeholder and can be replaced.-->
<div style="text-align:center">
  <h1>
    Welcome to {{ title }}!
  </h1>
  <img width="300" alt="Angular Logo" src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAyNTAgMjUwIj4KICAgIDxwYXRoIGZpbGw9IiNERDAwMzEiIGQ9Ik0xMjUgMzBMMzEuOSA2My4ybDE0LjIgMTIzLjFMMTI1IDIzMGw3OC45LTQzLjcgMTQuMi0xMjMuMXoiIC8+CiAgICA8cGF0aCBmaWxsPSIjQzMwMDJGIiBkPSJNMTI1IDMwdjIyLjItLjFWMjMwbDc4LjktNDMuNyAxNC4yLTEyMy4xTDEyNSAzMHoiIC8+CiAgICA8cGF0aCAgZmlsbD0iI0ZGRkZGRiIgZD0iTTEyNSA1Mi4xTDY2LjggMTgyLjZoMjEuN2wxMS43LTI5LjJoNDkuNGwxMS43IDI5LjJIMTgzTDEyNSA1Mi4xem0xNyA4My4zaC0zNGwxNy00MC45IDE3IDQwLjl6IiAvPgogIDwvc3ZnPg==">
</div>
<h2>Here are some links to help you start: </h2>
<ul>
  <li>
    <h2><a target="_blank" rel="noopener" href="https://angular.io/tutorial">Tour of Heroes</a></h2>
  </li>
  <li>
    <h2><a target="_blank" rel="noopener" href="https://angular.io/cli">CLI Documentation</a></h2>
  </li>
  <li>
    <h2><a target="_blank" rel="noopener" href="https://blog.angular.io/">Angular blog</a></h2>
  </li>
</ul>

<router-outlet></router-outlet>

````

Ya se tratarán cada uno de los elementos de este archivo, pero de forma general es el contenido que se mostrará en el index.

3. Introducir el el una etiqueta con el selector configurado en el archivo componente-ejemplo.component.ts. Para ello se modifica el archivo abierto en el punto anterior y se indica el selector 
````
<!--The content below is only a placeholder and can be replaced.-->
<div style="text-align:center">
    <h1>
        Welcome to {{ title }}!. Esto es parte del componente app.component
    </h1>
</div>
<app-componente-ejemplo style="text-align:center"></app-componente-ejemplo>
````

El selector ````app-componente-ejemplo```` se puede ver en el archivo componente-ejemplo.component.ts

````
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-componente-ejemplo',
  templateUrl: './componente-ejemplo.component.html',
  styleUrls: ['./componente-ejemplo.component.css']
})
export class ComponenteEjemploComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
````

