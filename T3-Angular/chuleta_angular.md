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