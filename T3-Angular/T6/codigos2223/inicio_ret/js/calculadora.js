let nombre = prompt("Por favor introduce tu nombre");
if (nombre || nombre.length > 0) {
  // he introducido un nombre
  let operandoUno = parseInt(prompt("Introduce el primer operador"));
  let operandoDos = parseInt(prompt("Introduce el primer operador"));

  if (!isNaN(operandoUno) && !isNaN(operandoDos)) {
    // cuando los dos operandos son numeros
    alert(`${operandoUno} + ${operandoDos} = ${operandoUno + operandoDos}`);
    alert(`${operandoUno} - ${operandoDos} = ${operandoUno - operandoDos}`);
    alert(`${operandoUno} * ${operandoDos} = ${operandoUno * operandoDos}`);
    alert(`${operandoUno} / ${operandoDos} = ${operandoUno / operandoDos}`);
    alert(`${operandoUno} % ${operandoDos} = ${operandoUno % operandoDos}`);
  } else {
    alert(`${nombre}, hay un fallo en alguno de los datos`);
  }
} else {
  alert(`fallo en el nombre`);
}
