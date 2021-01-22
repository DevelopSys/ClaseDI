# Ejercicio creación de componentes

- En el index.hmtl incluye los script y hojas de estilo necesarios para que fuiones bootstrap en la aplicación Angular
- Modifica el contenido del componente app-root para que solo aparezca un encabezado h1 con el texto Primer componente de angular
- En html del componente AppComponent crea un div con la clase row y dentro de este div tres más con la clase col cada uno de ellos
  - div (row)
    - div (col)
    - div (col)
    - div (col)
- Crea un componente llamado ComponenteColumnaUno donde en su html aparezca un h2 con el texto Componente Uno y un div con un alert de bootstra de tipo primary con el texto que quieras. Este componente tendrá que tener el selector componente-uno
- Crea un componente llamado ComponenteColumnaDos donde en su html aparezca un h2 con el texto Componente Dos y un div con un alert de bootstra de tipo secondary con el texto que quieras. Este componente tendrá que tener el selector componente-dos
- Crea un componente llamado ComponenteColumnaTres donde en su html aparezca un h2 con el texto Componente Tres y un div con un alert de bootstra de tipo success con el texto que queras. Este componente tendrá que tener el selector componente-tres
- Comprueba que todos los componentes se han importado de forma correcta dentro del AppModule. De no ser así importalos para que puedan ser llamados
- Dentro del html del componente principal carga cada uno de los componentes en las columnas creadas 
    - div (row)
      - div (col) --> componenteUno
      - div (col) --> componenteDos
      - div (col) --> componenteTres
