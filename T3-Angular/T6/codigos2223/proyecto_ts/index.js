// any --> Object
//function funcionNormal(param1: Number, param2: Number): {};
function optativo(p1, p2, p3) {
    console.log(p1);
    console.log(p2);
    if (p3) {
        console.log(p3);
    }
}
optativo("primero", "segundo", 12);
optativo("primero", "segundo");
