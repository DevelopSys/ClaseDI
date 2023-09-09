# Comandos más utilizados en Angular


| Comando                       | Explicación                                                                                                                                                                                                                                         |
|-------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ng new                        | creación de un nuevo proyecto                                                                                                                                                                                                                       |
| ng serve                      | creación del servidor donde se ejecuta la aplicación Este comando abre el puerto 4200 del localhost para poder ver la aplicación.  En el caso de querer abrir otro puerto diferente hay que utilizar el comando ng serve --open 0.0.0.0 --port 3000 |
| ng build                      | crea el desplieuge de la aplicación, generando los archivos que serán subidos al servidor para ver la app web                                                                                                                                       |
| npm start                     | Script que ejecuta el comando ng serve y abre el puerto 4200 para la visualización de la aplicación                                                                                                                                                 |
| npm build                     | Script que ejecuta el comando ng build y genera los ficheros definitivos                                                                                                                                                                            |
| npm install                   | Gestor de paquetes de node que permite instalar paquetes / módulos en el proyecto donde estamos ubicados.  Instalará todas las dependencias del proyecto donde estoy situado                                                                        |
| npm install modulo -g         | Instalará de forma genérica el módulo indicado. Esto quiere decir que todos los usuarios de la máquina podrán usarlo. Es importante ejecutar este comando iniciando la consola como administrador                                                   |
| npm install modulo --save-dev | Instalará el módulo indicado pero con dependencias de desarrollo para el proyecto donde estamos ubicados                                                                                                                                            |
| ng g c ruta/nombre            | Crea un @Component en la ruta del proyecto donde estamos ubicados. Hay que tener en cuenta que el componente tendrá que ser importado en el módulo de la aplicación. (lo hace solo pero comprobarlo por si no lo hiciese)                           |
| ng g p ruta/nombre            | Crea un @Pipe en la ruta del proyecto donde estamos ubicados.                                                                                                                                                                                       |
| ng g s ruta/nombre            | Crea un @Injectable (servicio) en la ruta del proyecto donde estamos ubicados                                                                                                                                                                       |
| ng g m ruta/nombre            | Crea un @Module en la ruta del proyecto donde estamos ubicados                                                                                                                                                                                      |
| ng g m ruta/nombre --routing  | Crea un @Module en la ruta del proyecto donde estamos ubicados, conteniendo la configuración necesaria para que este sea modulo de rutas. Es importante tener en cuenta que debe ser declarado dentro del app.module en la parta de imports         |

# Estructura de un proyecto

- app (carpeta genérica del los elementos del proyecto)
	- components (contenedor de todos los componentes del proyecto, excepto el principal)
		- componente_uno (componente uno)
			- componente_uno.componente.ts (parte lógica)
			- componente_uno.componente.html (parte gráfica)
			- componente_uno.componente.css (parte estilos)
		-  componente_dos
			- componente_dos.componente.ts 
			- componente_dos.componente.html
			- componente_dos.componente.css
	- pipes (contenedor de los pipes personalizados)
		-  directiva_uno.pipe.ts (definición lógica del pipe)
	- services
		- servicio_uno.service.ts (parte lógica del servicio)
	- utils
		- clase.ts (clase utilizada para la creación y manejo de objetos)
	- app.componente.ts (parte lógica del componente principal. Es el root desde donde se pinta todo)
	- app.componente.css (parte estilos del componente principal)
	- app.componente.html (parte gráfica del componente principal, desde donde son llamados el resto)
	- app.routing.module (modulo dedicado a la gestión de las rutas en la aplicación)
	- app.module (módulo principal de la aplicación, que carga cada uno de los elementos que están dentro de el)
- index.html
- style.css

# Estructura de un componentes

````
// importación de los elementos que con necesarios en esta clase
import { Component, OnInit } from '@angular/core';

// declaración del componente como tal
@Component({
// el selector que deberá utilizarse en la parte html cuando quiera ser llamado el componente 
  selector: 'componente-uno',
// "link a la parte gráfica"
  templateUrl: './columna-uno.component.html',
// link a la parte lógica
  styleUrls: ['./columna-uno.component.css']
})

// la clase debe ser exportada para que pueda ser llamada desde otro sitio
export class ColumnaUnoComponent implements OnInit {
// constructor de la clase. Aquí se pueden pasar por parámetros tantos elementos como sean necesarios
  constructor() { }

// primer método del ciclo de vida ejecutado. Simiar al onCreate de Android
  ngOnInit(): void {
  }
}
````


# Estructura de pipes

````
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
// nombre que será utilizado cuando se quiera realizar la transformación indicada
  name: 'imagenes',
})
export class PipePersonalizado implements PipeTransform {
// método que se ejecutará para hacer la transformación
  transform(value: string, ...args: unknown[]): unknown {
// valor que se renderizará dependiendo de las consideraciones realizadas con el valué y los args
       return value;
  }
}
````


# Estructura de servicios

````
import { Injectable } from '@angular/core';
@Injectable({
  providedIn: 'root',
})
export class TecnologiasService {
    constructor() {}
}
````

# Estructura de módulos

````
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';


@NgModule({
// declaración de todos los elementos que formarán parte del módulo. 
  declarations: [
    AppComponent,
  ],
// otros módulos que son utilizados en este módulo. Por defecto usa las rutas y la búsqueda
  imports: [BrowserModule, AppRoutingModule],
// proveedores de contenido, como por ejemplo los servicios
  providers: [],
// elemento principal de la aplicación
  bootstrap: [AppComponent],
})
export class AppModule {}

````
 