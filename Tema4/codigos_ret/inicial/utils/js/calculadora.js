let nombre = prompt("introduce tu nombre");
let operando1 = Number(prompt("introduce primer operando"));
if (!isNaN(operando1)) {
  let operando2 = Number(prompt("introduce segundo operando"));
  if (!isNaN(operando2)) {
    Swal.fire({
      title: "Operaciones",
      text: `Perfecto ${nombre} vamos a mostrar las operaciones entre ${operando1} y ${operando2}
      \nSuma: ${operando1 + operando2}
      \nResta: ${operando1 - operando2}
      \nMulti: ${operando1 * operando2}
      \nDiv: ${operando1 / operando2}`,
      icon: "success",
    });
    /* alert(
      `Perfecto ${nombre} vamos a mostrar las operaciones entre ${operando1} y ${operando2}
      \nSuma: ${operando1 + operando2}
      \nResta: ${operando1 - operando2}
      \nMulti: ${operando1 * operando2}
      \nDiv: ${operando1 / operando2}`
    ); */
  } else {
    alert("Me has introducido algo que no es un numero, terminamos el proceso");
  }
} else {
  alert("Me has introducido algo que no es un numero, terminamos el proceso");
}
